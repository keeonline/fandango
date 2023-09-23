package com.keeonline.fandango.iso8583.field.transformer.number;

import java.math.BigInteger;

import com.keeonline.fandango.iso8583.field.spec.PrimitiveSpec;
import com.keeonline.fandango.iso8583.field.transformer.PrimitiveTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TransformedField;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;
import com.keeonline.fandango.iso8583.field.transformer.util.Formatted;
import com.keeonline.fandango.iso8583.field.transformer.util.Packed;
import com.keeonline.fandango.iso8583.field.transformer.util.Variable;

public class NumberPackedBcdBvar extends NumberTransformer {
	
	private int lengthMin;
	private int lengthMax;
	private String valueRegex;
	private String padChar;
	private String padPosition;
	
	public NumberPackedBcdBvar(PrimitiveSpec config) throws FieldTransformerException {
		super(config);

		// load field attributes
		lengthMin = ((Integer)checkMandatory(getIntAttribute(Variable.LENGTH_MIN))).intValue();
		lengthMax = ((Integer)checkMandatory(getIntAttribute(Variable.LENGTH_MAX))).intValue();

		// validate length attribute as it is used in default processing
		Variable.validateLengths(lengthMin,lengthMax);

		valueRegex = getStringAttribute(PrimitiveTransformer.VALUE_REGEX);
		padChar = getStringAttribute(Formatted.PAD_CHAR);
		padPosition = getStringAttribute(Packed.PAD_POSITION);

		// default attributes if necessary
		if (valueRegex == null) valueRegex = "^[0-9]\\d{" + lengthMin + "," + lengthMax + "}$";
		if (padChar == null) padChar = "0";
		if (padPosition == null) padPosition = Packed.PAD_POSITION_LEADING;
		
		// validate arguments
		PrimitiveTransformer.validateValueRegex(valueRegex);
		Formatted.validatePadChar(padChar);
		Packed.validatePadPosition(padPosition);				
	}

	@Override
	public TransformedField fill() throws FieldTransformerException {
		return mapOrFill(new BigInteger("0"));
	}

	@Override
	public TransformedField map(Object valueObject) throws FieldTransformerException {
		return mapOrFill(valueObject);
	}
	
	private TransformedField mapOrFill(Object valueObject) throws FieldTransformerException{	
		// map field length portion
		int digits = Variable.getFieldLength(lengthMin,valueObject.toString());	
		TransformedField lengthField = Variable.mapLengthFieldBinary(getPrimitiveSpec(),digits);
		
		// map value portion
		BigInteger value = validateMapArguments(valueObject,valueRegex);		
		String digitString = Formatted.toJustified(value.toString(),digits,Formatted.JUSTIFY_RIGHT,padChar);	
		String encoded = Packed.toPacked(digitString,padPosition,padChar);		

		// concatenate encoded length field and encoded data in resultant object
		return getTransformedField(value,(lengthField.getEncoded() + encoded),getFieldSpec());
	}

	@Override
	public TransformedField parse(String payload, int offset) throws FieldTransformerException {
		// parse length field to determine data length
		TransformedField lengthField = Variable.parseLengthFieldBinary(getPrimitiveSpec(),payload,offset);	
		int digits = ((BigInteger)lengthField.getValue()).intValue();
		
		// parse data portion to determine value
		int adjustment = Packed.getLengthAdjustment(digits);		
		int dataOffset = offset+lengthField.getEncoded().length();
		String encoded = validateParseArguments(payload,dataOffset,digits+adjustment);
		String digitString = Packed.fromPacked(encoded,digits,padPosition,padChar);		
		BigInteger value = null;		
		try {
			value = new BigInteger(digitString);
		}
		catch (NumberFormatException e){
			// convert to FieldTransformerException and throw
		}		
		
		// concatenate encoded length field and encoded data in resultant object
		return getTransformedField(value,lengthField.getEncoded() + encoded,getFieldSpec());
	}

}
