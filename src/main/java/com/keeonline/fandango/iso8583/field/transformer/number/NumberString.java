package com.keeonline.fandango.iso8583.field.transformer.number;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

import com.keeonline.fandango.iso8583.field.spec.PrimitiveSpec;
import com.keeonline.fandango.iso8583.field.transformer.PrimitiveTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TransformedField;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;
import com.keeonline.fandango.iso8583.field.transformer.util.Fixed;
import com.keeonline.fandango.iso8583.field.transformer.util.Formatted;
import com.keeonline.fandango.iso8583.field.transformer.util.Text;

public class NumberString extends NumberTransformer {
	
	private int length;
	private String valueRegex;
	private String padChar;
	private String codePage;
	
	public NumberString(PrimitiveSpec config) throws FieldTransformerException {
		super(config);
		
		// load field attributes
		length = ((Integer)checkMandatory(getIntAttribute(Fixed.LENGTH))).intValue();
		valueRegex = getStringAttribute(PrimitiveTransformer.VALUE_REGEX);
		padChar = getStringAttribute(Formatted.PAD_CHAR);
		codePage = ((String)checkMandatory(getStringAttribute(Text.CODE_PAGE)));
		
		Fixed.validateLength(length);

		// default attributes if necessary
		if (valueRegex == null) valueRegex = "^[0-9]\\d{" + length + "}$";
		if (padChar == null) padChar = "0";
		
		// validate arguments
		PrimitiveTransformer.validateValueRegex(valueRegex);
		Formatted.validatePadChar(padChar);
		Text.validateCodePage(codePage);				
	}

	@Override
	public TransformedField fill() throws FieldTransformerException {
		return mapOrFill(new BigInteger("0"));
	}

	@Override
	public TransformedField map(Object valueObject) throws FieldTransformerException {
		return mapOrFill(valueObject);
	}
	
	private TransformedField mapOrFill(Object valueObject){		
		BigInteger value = validateMapArguments(valueObject,valueRegex);
		
		String formatted = 
			Formatted.toJustified(value.toString(),length,Formatted.JUSTIFY_RIGHT,padChar);	
		
		String encoded = null;
		try {
			encoded = Text.stringToEncoded(formatted,codePage);
		} catch (UnsupportedEncodingException e) {
			// TODO create FieldTransformerException
		}
		
		return getTransformedField(value,encoded,getFieldSpec());
	}

	@Override
	public TransformedField parse(String payload, int offset) throws FieldTransformerException {
		String encoded = validateParseArguments(payload,offset,length*2);
		String formatted = null;
		try {
			formatted = Text.encodedToString(payload.substring(offset,offset+(length*2)),codePage);
		} catch (UnsupportedEncodingException e) {
			// TODO create FieldTransformerException
		}
		
		BigInteger value = null;
		
		try {
			value = new BigInteger(formatted);
		}
		catch (NumberFormatException e){
			// convert to FieldTransformerException and throw
			e.printStackTrace();
		}
		
		return getTransformedField(value,encoded,getFieldSpec());
	}

}
