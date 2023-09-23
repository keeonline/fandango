package com.keeonline.fandango.iso8583.field.transformer.hex;

import java.math.BigInteger;

import com.keeonline.fandango.iso8583.field.spec.PrimitiveSpec;
import com.keeonline.fandango.iso8583.field.transformer.PrimitiveTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TransformedField;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;
import com.keeonline.fandango.iso8583.field.transformer.util.Formatted;
import com.keeonline.fandango.iso8583.field.transformer.util.Packed;
import com.keeonline.fandango.iso8583.field.transformer.util.Variable;

public class HexPackedBvar extends HexTransformer {
	
	private int lengthMin;
	private int lengthMax;
	private String lengthUnit;
	private String valueRegex;
	private String padChar;
	private String padPosition;
	
	public HexPackedBvar(PrimitiveSpec config) throws FieldTransformerException {
		super(config);

		// load field attributes
		lengthMin = ((Integer)checkMandatory(getIntAttribute(Variable.LENGTH_MIN))).intValue();
		lengthMax = ((Integer)checkMandatory(getIntAttribute(Variable.LENGTH_MAX))).intValue();

		// validate length attribute as it is used in default processing
		Variable.validateLengths(lengthMin,lengthMax);

		lengthUnit = getStringAttribute(Packed.LENGTH_UNIT);
		valueRegex = getStringAttribute(PrimitiveTransformer.VALUE_REGEX);
		padChar = getStringAttribute(Formatted.PAD_CHAR);
		padPosition = getStringAttribute(Packed.PAD_POSITION);

		// default attributes if necessary
		if (lengthUnit == null) lengthUnit = Packed.LENGTH_UNIT_NIBBLES;
		if (valueRegex == null) valueRegex = "^[a-fA-F0-9]{" + lengthMin + "," + lengthMax + "}$";
		if (padChar == null) padChar = "0";
		if (padPosition == null) padPosition = Packed.PAD_POSITION_LEADING;
		
		// validate arguments
		Packed.validateLengthUnit(lengthUnit);
		PrimitiveTransformer.validateValueRegex(valueRegex);
		Formatted.validatePadChar(padChar);
		Packed.validatePadPosition(padPosition);				
	}

	@Override
	public TransformedField fill() throws FieldTransformerException {
		return mapOrFill("");
	}

	@Override
	public TransformedField map(Object valueObject) throws FieldTransformerException {
		return mapOrFill(valueObject);
	}
	
	private TransformedField mapOrFill(Object valueObject) throws FieldTransformerException{
		if (lengthUnit.equals(Packed.LENGTH_UNIT_NIBBLES)){
			return mapNibbles(valueObject);
		}
		else {
			return mapBytes(valueObject);
		}		
	}

	private TransformedField mapBytes(Object valueObject) throws FieldTransformerException {
		// map field length portion
		int hexLength = Variable.getFieldLength(lengthMin*2,valueObject.toString());	
		TransformedField lengthField = Variable.mapLengthFieldBinary(getPrimitiveSpec(),hexLength/2);
		
		// map value portion
		String value = validateMapArguments(valueObject,valueRegex);		
		String hexString = Formatted.toJustified(value.toString(),hexLength,Formatted.JUSTIFY_RIGHT,padChar);	
		String encoded = Packed.toPacked(hexString,padPosition,padChar);		

		// concatenate encoded length field and encoded data in resultant object
		return getTransformedField(value,(lengthField.getEncoded() + encoded),getFieldSpec());
	}

	private TransformedField mapNibbles(Object valueObject) throws FieldTransformerException {
		// map field length portion
		int hexLength = Variable.getFieldLength(lengthMin,valueObject.toString());	
		TransformedField lengthField = Variable.mapLengthFieldBinary(getPrimitiveSpec(),hexLength);
		
		// map value portion
		String value = validateMapArguments(valueObject,valueRegex);		
		String hexString = Formatted.toJustified(value.toString(),hexLength,Formatted.JUSTIFY_RIGHT,padChar);	
		String encoded = Packed.toPacked(hexString,padPosition,padChar);		

		// concatenate encoded length field and encoded data in resultant object
		return getTransformedField(value,(lengthField.getEncoded() + encoded),getFieldSpec());
	}

	@Override
	public TransformedField parse(String payload, int offset) throws FieldTransformerException {
		if (lengthUnit.equals(Packed.LENGTH_UNIT_NIBBLES)){
			return parseNibbles(payload, offset);
		}
		else {
			return parseBytes(payload, offset);
		}		
	}

	private TransformedField parseBytes(String payload, int offset) throws FieldTransformerException {
		// parse length field to determine data length
		TransformedField lengthField = Variable.parseLengthFieldBinary(getPrimitiveSpec(),payload,offset);	
		int hexLength = ((BigInteger)lengthField.getValue()).intValue()*2;
		
		// parse data portion to determine value
		int adjustment = Packed.getLengthAdjustment(hexLength);		
		int dataOffset = offset+lengthField.getEncoded().length();
		String encoded = validateParseArguments(payload,dataOffset,hexLength+adjustment);
		String value = Packed.fromPacked(encoded,hexLength,padPosition,padChar);		
		
		// concatenate encoded length field and encoded data in resultant object
		return getTransformedField(value,lengthField.getEncoded() + encoded,getFieldSpec());
	}

	private TransformedField parseNibbles(String payload, int offset) throws FieldTransformerException {
		// parse length field to determine data length
		TransformedField lengthField = Variable.parseLengthFieldBinary(getPrimitiveSpec(),payload,offset);	
		int hexLength = ((BigInteger)lengthField.getValue()).intValue();
		
		// parse data portion to determine value
		int adjustment = Packed.getLengthAdjustment(hexLength);		
		int dataOffset = offset+lengthField.getEncoded().length();
		String encoded = validateParseArguments(payload,dataOffset,hexLength+adjustment);
		String value = Packed.fromPacked(encoded,hexLength,padPosition,padChar);		
		
		// concatenate encoded length field and encoded data in resultant object
		return getTransformedField(value,lengthField.getEncoded() + encoded,getFieldSpec());
	}

}
