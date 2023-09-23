package com.keeonline.fandango.iso8583.field.transformer.util;

import java.math.BigInteger;

import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public class Binary {

	public static final String BYTE_ORDER = "byte-order";
	
	public static final String BIG_ENDIAN = "big-endian";
	public static final String LITTLE_ENDIAN = "little-endian";
	
	public static final String BYTE_ORDER_DEFAULT = BIG_ENDIAN;
	
	/**
	 * Determines whether the byte order attribute value provided at runtime is valid.
	 * <br>Valid values are: any single character value
	 * @param padChar runtime attribute value
	 * @throws FieldTransformerException
	 */
	public static void validateByteOrder(String byteOrder) throws FieldTransformerException {
		if (!(byteOrder.equals(BIG_ENDIAN)) || (byteOrder.equals(LITTLE_ENDIAN))){
			// throw invalid attribute value exception
		}
	}

	public static byte[] reverseBytes(byte[] bytes) {
		byte [] result = new byte [bytes.length];
		for (int i=0 ; i< bytes.length ; i++){
			result[(bytes.length-1)-i] = bytes[i];
		}
		return result;
	}
	
	public static byte[] hexStringToByteArray(String hex){
		int hexLength = hex.length();
		int arrayLength;
		
		if ((hexLength % 2) != 0){
			hex = "0" + hex;
		}

		arrayLength = hexLength/2;
		
		// Java has no unsigned data types to handle values with the top bit set.
		byte[] bytes = new byte[arrayLength];
		short[] shorts = new short[arrayLength];
		
		for ( int i=0 ; i < arrayLength ; i++ ){
			String str = hex.substring(i*2,(i*2)+2);
			shorts[i] = new BigInteger(str,16).shortValueExact();
			bytes[i] = (byte)shorts[i];			
		}
				
		return bytes;
	}

}
