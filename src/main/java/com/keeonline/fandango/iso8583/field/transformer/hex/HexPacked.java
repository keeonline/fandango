package com.keeonline.fandango.iso8583.field.transformer.hex;

import com.keeonline.fandango.iso8583.field.spec.PrimitiveSpec;
import com.keeonline.fandango.iso8583.field.transformer.PrimitiveTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TransformedField;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;
import com.keeonline.fandango.iso8583.field.transformer.util.Fixed;
import com.keeonline.fandango.iso8583.field.transformer.util.Formatted;

public class HexPacked extends HexTransformer {

	private int length;
	private String valueRegex;

	public HexPacked(PrimitiveSpec field) throws FieldTransformerException {
		super(field);

		// load field attributes
		Integer lengthInteger = (Integer)checkMandatory(getIntAttribute(Fixed.LENGTH));	
		length = lengthInteger.intValue();	
		Fixed.validateLength(length);
		if (!lengthInteger.toString().matches("^(2|4|8|16)$")) {
			// TODO: throw exception
		}
		
		valueRegex = getStringAttribute(PrimitiveTransformer.VALUE_REGEX);
		
		// default attributes if necessary
		if (valueRegex == null) valueRegex = "^[a-fA-F0-9]{" + length + "}$";
		
		// validate arguments
		PrimitiveTransformer.validateValueRegex(valueRegex);
	}

	@Override
	public TransformedField fill() throws FieldTransformerException {
		return mapValue(Formatted.toJustified("0",length,Formatted.JUSTIFY_LEFT,"0"));
	}

	@Override
	public TransformedField map(Object valueObject) throws FieldTransformerException {
		return mapValue(valueObject);
	}

	private TransformedField mapValue(Object valueObject) throws FieldTransformerException {
		String value = validateMapArguments(valueObject,valueRegex);
		String encoded = value.toUpperCase();
		return getTransformedField(valueObject,encoded,getFieldSpec());		
	}

	@Override
	public TransformedField parse(String payload, int offset) throws FieldTransformerException {
		String encoded = validateParseArguments(payload,offset,length);
		if (!(encoded.matches(valueRegex))){
			//throw new FieldValueException((FieldTransformer)this,encoded,valueRegex);
		}
		// because field is binary the hex rendering of the payload is the same value as the validated input
		return getTransformedField(encoded,encoded,getFieldSpec());
	}

}
