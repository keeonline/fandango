package com.keeonline.fandango.iso8583.field.transformer.hex;

import java.io.UnsupportedEncodingException;

import com.keeonline.fandango.iso8583.field.spec.PrimitiveSpec;
import com.keeonline.fandango.iso8583.field.transformer.PrimitiveTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TransformedField;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;
import com.keeonline.fandango.iso8583.field.transformer.util.Fixed;
import com.keeonline.fandango.iso8583.field.transformer.util.Formatted;
import com.keeonline.fandango.iso8583.field.transformer.util.Text;

public class HexString extends HexTransformer {
	
	private int length;
	private String valueRegex;
	private String codePage;

	public HexString(PrimitiveSpec field) throws FieldTransformerException {
		super(field);

		// load field attributes
		length = ((Integer)checkMandatory(getIntAttribute(Fixed.LENGTH))).intValue();
		valueRegex = getStringAttribute(PrimitiveTransformer.VALUE_REGEX);
		codePage = ((String)checkMandatory(getStringAttribute(Text.CODE_PAGE)));
		
		Fixed.validateLength(length);
		if (length % 2 != 0){
			// TODO: throw exception
		}

		// default attributes if necessary
		if (valueRegex == null) valueRegex = "^[a-fA-F0-9]{" + length + "}$";
		
		// validate arguments
		PrimitiveTransformer.validateValueRegex(valueRegex);
		Text.validateCodePage(codePage);				
	}
	
	@Override
	public TransformedField fill() throws FieldTransformerException {
		return mapValue(Formatted.toJustified("0",length,Formatted.JUSTIFY_LEFT,"0"));
	}

	@Override
	public TransformedField map(Object valueObject) throws FieldTransformerException {
		String value = validateMapArguments(valueObject,valueRegex);
		return mapValue(value);
	}

	/**
	 * The value parameter can be either case but the resultant field parameter
	 * needs to be the encoded value of the upper case only.
	 * @param value
	 * @return
	 * @throws FieldTransformerException
	 */
	private TransformedField mapValue(String value) throws FieldTransformerException {
		try {
			String field = Text.stringToEncoded(value.toUpperCase(), codePage);
			return getTransformedField(value,field,getFieldSpec());
		} catch (UnsupportedEncodingException unsupportedEncoding) {
			throw new FieldTransformerException(this, unsupportedEncoding);
		}
	}

	@Override
	public TransformedField parse(String payload, int offset) throws FieldTransformerException {
		String encoded = validateParseArguments(payload,offset,(length*2));
		String value = null;
		try {
			value = Text.encodedToString(encoded,codePage);
		} catch (UnsupportedEncodingException e) {
			// TODO create FieldTransformerException
		}		
		return getTransformedField(value,encoded,getFieldSpec());
	}

}
