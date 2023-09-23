package com.keeonline.fandango.iso8583.field.transformer;

import java.math.BigInteger;
import java.util.Map;
import java.util.regex.Pattern;

import com.keeonline.fandango.iso8583.field.spec.FieldSpec;
import com.keeonline.fandango.iso8583.field.spec.PrimitiveSpec;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;
import com.keeonline.fandango.iso8583.field.transformer.exception.UnableToParseException;

public abstract class PrimitiveTransformer extends FieldTransformerAbstract {
	
	public static final String VALUE_REGEX = "value-regex";
	private final Map<String,String> attributes;
	private int parseOffset;
	
	protected PrimitiveTransformer(PrimitiveSpec primitiveSpec) throws FieldTransformerException {
		super(primitiveSpec);
		this.attributes = primitiveSpec.getAttributes();
	}
	
	public PrimitiveTransformer() {
		super();
		this.attributes = null;
    }

	protected TransformedField getTransformedField(Object value,String encoded,FieldSpec fieldSpec){
		return new TransformedField(value,encoded,fieldSpec);
	}

	// public abstract TransformedPrimitive map(Object valueObject) throws FieldTransformerException;
	
	// public abstract TransformedPrimitive parse(String payload, int offset) throws FieldTransformerException;

	public PrimitiveSpec getPrimitiveSpec() {
		return (PrimitiveSpec)getFieldSpec();
	}

	protected String getStringAttribute(String key){
		return attributes.get(key);
	}

	protected int getIntAttribute(String key){
		return new BigInteger(attributes.get(key)).intValue();
	}

	protected Object checkMandatory(Object attributeValue) {
		if (attributeValue == null){
			// throw mandatory attribute missing exception
			return null;
		}
		else {
			return attributeValue;
		}
	}

	protected static void validateValueRegex(String valueRegex) throws FieldTransformerException {
		try {
			Pattern.compile(valueRegex);
		}
		catch (Exception e) {
			// throw invalid attribute value exception
		}
	}
	
	protected Map<String,String> getAttributes() {
		return attributes;
	}
	
	protected int getParseOffset() {
		return parseOffset;
	}
	
	protected String validateParseArguments(String payload, int offset, int requiredLength) throws FieldTransformerException{
		if (payload == null){
			throw new UnableToParseException(this,"Payload is null");
		}
		if (payload.isEmpty()){
			throw new UnableToParseException(this,"Payload is empty");
		}
		if (offset < 0){
			throw new UnableToParseException(this,"Offset must be equal to or greater than zero (value is " + offset + ")");
		}
		
		String leftToParse = payload.substring(offset);
		
		if ((requiredLength) > leftToParse.length()){
			throw new UnableToParseException(this,"Payload is length insufficient to support parsing (payload=" + payload + ", offset=" + offset + ", required length=" + requiredLength  + ", payload to parse=" + leftToParse +  ")");
		}
		
		return payload.substring(offset,offset+requiredLength);
	}

}


