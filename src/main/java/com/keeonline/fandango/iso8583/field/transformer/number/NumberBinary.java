package com.keeonline.fandango.iso8583.field.transformer.number;

import java.math.BigInteger;

import com.keeonline.fandango.iso8583.field.spec.PrimitiveSpec;
import com.keeonline.fandango.iso8583.field.transformer.PrimitiveTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TransformedField;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;
import com.keeonline.fandango.iso8583.field.transformer.util.Binary;
import com.keeonline.fandango.iso8583.field.transformer.util.Fixed;
import com.keeonline.fandango.iso8583.field.transformer.util.Formatted;


public class NumberBinary extends NumberTransformer {
	
	private int length;
	private String valueRegex;
	private String byteOrder;
	
	public NumberBinary(PrimitiveSpec config) throws FieldTransformerException {
		super(config);
		
		// load and validate field attributes	
		Integer lengthInteger = (Integer)checkMandatory(getIntAttribute(Fixed.LENGTH));	
		length = lengthInteger.intValue();	
		Fixed.validateLength(length);
		if (!lengthInteger.toString().matches("^(1|2|4|8)$")) {
			// TODO: throw exception
		}
		
		valueRegex = (String)checkMandatory(getStringAttribute(PrimitiveTransformer.VALUE_REGEX));
		PrimitiveTransformer.validateValueRegex(valueRegex);
		
		this.byteOrder = getStringAttribute(Binary.BYTE_ORDER);
		if (byteOrder == null)	byteOrder = Binary.BYTE_ORDER_DEFAULT;		
		Binary.validateByteOrder(byteOrder);
	}

	@Override
	public TransformedField fill() throws FieldTransformerException {
		return mapValue(new BigInteger("0"));
	}

	@Override
	public TransformedField map(Object valueObject) throws FieldTransformerException {
		return mapValue(valueObject);
	}

	private TransformedField mapValue(Object valueObject) throws FieldTransformerException {
		BigInteger value = validateMapArguments(valueObject,valueRegex);
		
		byte [] bytes = value.toByteArray();
		
		if (bytes.length > length){
			// trim leading bytes to size
			int extra = bytes.length-length;
			byte [] trimmed = new byte [length];
			for (int i=0 ; i < length ; i++){
				trimmed[i] = bytes[i+extra];
			}
			bytes = trimmed;
		}
			
		if ((byteOrder != null) && (byteOrder.equals(Binary.LITTLE_ENDIAN))){
			bytes = Binary.reverseBytes(bytes);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (byte b : bytes){
			sb.append(String.format("%02X",b));
		}
		
		String padded = null;
		
		if ((byteOrder != null) && (byteOrder.equals(Binary.BIG_ENDIAN))){
			padded = Formatted.toJustified(sb.toString(),length*2,Formatted.JUSTIFY_RIGHT,"0");
		}
		else
		{
			padded = Formatted.toJustified(sb.toString(),length*2,Formatted.JUSTIFY_LEFT,"0");
		}
		 	
		return getTransformedField(value,padded,getFieldSpec());
	}

	@Override
	public TransformedField parse(String payload, int offset) throws FieldTransformerException {
		validateParseArguments(payload,offset,(length*2));
		
		String encoded = payload.substring(offset,offset+(length*2));
		
		// validate characters in encoded string
		String fieldRegex = new String("^[0-9a-fA-F]{" + encoded.length() + "}$");	
		if (!encoded.matches(fieldRegex)) {
//			throw new NotWellFormedException((FieldTransformer)this,encoded,fieldRegex);
		}
				
		// convert hex chars to byte values
		byte[] bytes = Binary.hexStringToByteArray(encoded);
		
		// reverse byte order if needed (java types are big-endian)
		if ((byteOrder != null) && (byteOrder.equals(Binary.LITTLE_ENDIAN))){
			bytes = Binary.reverseBytes(bytes);
		}
		
		// to ensure value is treated as unsigned (i.e. bit 0 is not interpretted as a sign bit),
		// prefix a zero byte onto the array.
		// e.g. an array of FF FF is -1 in twos compliment
		// but and array of 00 FF FF is 255 in twos compliment		
		byte[] prefixed = new byte[bytes.length+1];
		prefixed[0] = 0;
		for (int i=0 ; i < bytes.length ; i++){
			prefixed[i+1] = bytes[i];
		}
		
		BigInteger value = new BigInteger(prefixed);
		
		return getTransformedField(value,encoded,getFieldSpec());
	}

}
