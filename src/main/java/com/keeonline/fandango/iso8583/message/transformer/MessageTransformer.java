package com.keeonline.fandango.iso8583.message.transformer;

import static java.util.Objects.nonNull;

import java.util.HashMap;
import java.util.Map;

import com.keeonline.fandango.iso8583.message.model.MessageData;
import com.keeonline.fandango.iso8583.field.spec.FieldSpec;
import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;
import com.keeonline.fandango.iso8583.field.transformer.FieldTransformerFactory;
import com.keeonline.fandango.iso8583.field.transformer.TransformedField;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;
import com.keeonline.fandango.iso8583.message.adapter.MessageDataAdapter;
import com.keeonline.fandango.iso8583.standard.common.MessageBitmaps;
import com.keeonline.fandango.iso8583.standard.version1987.Fields;



/**
 * This class implements transformation of an Iso8583 message from it's physical
 * encoded format into an Iso8583Dto object (parsing) and from an Iso8583Dto object
 * into it's physical encoded format (mapping).
 * <p>***TODO*** REVISIT THIS...A FieldTransformerFactory class must be supplied to define the characteristics of the
 * FieldTransformer implementations for a given card scheme.</p>
 * <p>Inclusion of bitmap fields 1 and 65 in the output is dependent on the value of the 'includeBitmaps'
 * switch that can be provided upon mapping and parsing. This because card schemes such as Visa do not
 * conform to the ISO8583 standard, placing the secondary and tertiary bitmap fields in the header 
 * prefix, rather than in the message body. </p>
 */

public abstract class MessageTransformer {

	MessageSpec messageSpec;

	FieldSpec mtiFieldSpec;
	private FieldTransformer mtiFieldtransformer;

	FieldSpec primaryBitmapFieldSpec;
	private FieldTransformer primaryBitmapFieldTransformer;

	private Map<String,FieldSpec> fieldSpecMap;
	private FieldTransformer [] fieldTransformers;

	protected abstract MessageSpec getMessageSpec();
	protected abstract String getPrimaryBitmapFieldName();
	protected abstract String getFieldNamePrefix();

	protected abstract void addVersionSpecificFieldValues(MessageData messageDto, Map<String,Object> fieldValues);

	/**
	 * No argument constructor
	 */
	public MessageTransformer() {

		this.messageSpec = getMessageSpec();

		this.mtiFieldSpec = messageSpec.getMtiFieldSpec();
		this.mtiFieldtransformer = FieldTransformerFactory.getTransformer(mtiFieldSpec);

		this.primaryBitmapFieldSpec = messageSpec.getPrimaryBitmapFieldSpec();
		this.primaryBitmapFieldTransformer = FieldTransformerFactory.getTransformer(primaryBitmapFieldSpec);

		fieldSpecMap = new HashMap<>();
		for (FieldSpec fieldSpec : messageSpec.getFieldSpecs()) {
			fieldSpecMap.put(fieldSpec.getName(), fieldSpec);
		} 
		this.fieldTransformers = new FieldTransformer[192];
		for (int i=0 ; i<192 ; i++){
			fieldTransformers[i] = getFieldTransformer(i+1);
		}
	}

	public TransformedMessage map(MessageData messageDto, MessageDataAdapter adapter) throws FieldTransformerException{
		TransformedMessage transformedMessage = new TransformedMessage();	
		MessageBitmaps messageBitmaps = adapter.getMessageBitMaps(messageDto);

		Map<String,Object> fieldValues = new HashMap<>();

        // add the field values of 1 to 1 fields from messageDto into transformed field values
        for ( int i=1 ; i<193 ; i++ ){
            Object value = adapter.getFieldByNumber(messageDto,i);
            if (nonNull(value)) {
                fieldValues.put(getFieldNamePrefix()+i, value);
            }
        }

        // add the value of composite messageDto fields (e.g. monetary amounts) into transformed field values
        addVersionSpecificFieldValues(messageDto, fieldValues);

        // set the bitmap field values based on presence of transformed field values
        fieldValues.put(Fields.BITMAP_PRIMARY_NAME, messageBitmaps.getPrimary());
        if (messageBitmaps.containsSecondaryFields()) {
            fieldValues.put(getFieldNamePrefix()+1, messageBitmaps.getSecondary());
        }
        if (messageBitmaps.containsTertiaryFields()) {
            fieldValues.put(getFieldNamePrefix()+65, messageBitmaps.getTertiary());
        }

		transformedMessage.addField(mtiFieldtransformer.map(messageDto.getMessageTypeIdentifier()));
		transformedMessage.addField(primaryBitmapFieldTransformer.map(messageBitmaps.getPrimary()));

		Object fieldValue = null;

		for ( int i=1 ; i<193 ; i++ ) {
			if (nonNull(fieldTransformers[i-1])) {
				fieldValue = fieldValues.get(adapter.getFieldNamePrefix()+i);
				if (nonNull(fieldValue)) {
					TransformedField transformedField = fieldTransformers[i-1].map(fieldValue);
					transformedMessage.addField(transformedField);			
				}
			}
		}

		return transformedMessage;
	}

	public TransformedMessage parse(String payload) throws FieldTransformerException{

		TransformedMessage transformedMessage = new TransformedMessage();	
		int offset = 0;
		
		offset = addTransformedField(transformedMessage, mtiFieldtransformer, payload, offset);
		
		offset = addTransformedField(transformedMessage, primaryBitmapFieldTransformer, payload, offset);

		MessageBitmaps messageBitmaps = new MessageBitmaps(192);
		messageBitmaps.setPrimary((String)transformedMessage.getFieldByName(getPrimaryBitmapFieldName()).getValue());

		int current = 0;

		while (messageBitmaps.moreFields(current)) {
			current = messageBitmaps.nextField(current);
			
			offset = addTransformedField(transformedMessage,fieldTransformers[current-1],payload,offset);
			if (current == Fields.BITMAP_SECONDARY) {
				messageBitmaps.setSecondary((String)transformedMessage.getFieldByName(getFieldNamePrefix()+Integer.toString(current-1)).getValue());
			} 
			else if ( current == Fields.BITMAP_TERTIARY) {
				messageBitmaps.setSecondary((String)transformedMessage.getFieldByName(getPrimaryBitmapFieldName()).getValue());
			}
		}

		return transformedMessage;
	}



	

	
	private FieldTransformer getFieldTransformer(int fieldNumber){
		FieldTransformer result = null;

		String fieldName = getFieldNamePrefix()+Integer.toString(fieldNumber);

		if (fieldSpecMap.containsKey(fieldName)) {
			FieldSpec fieldSpec = fieldSpecMap.get(fieldName);
			result = FieldTransformerFactory.getTransformer(fieldSpec);
		}

		return result;
	}
	
	protected int addTransformedField(TransformedMessage transformedMessage,FieldTransformer fieldTransformer,String payload,int offset) throws FieldTransformerException {
		TransformedField transformedField = fieldTransformer.parse(payload,offset);
		transformedMessage.addField(transformedField);
		return (offset+transformedField.getEncoded().length());
	}
	
	protected FieldTransformer getBitmapSecondaryTransformer() {
		return fieldTransformers[Fields.BITMAP_SECONDARY-1];
	}

	protected FieldTransformer getBitmapTertiaryTransformer() {
		return fieldTransformers[Fields.BITMAP_TERTIARY-1];
	}

}