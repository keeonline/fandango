package com.keeonline.fandango.iso8583.field.transformer.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

/**
 * Utility class implementing helper methods for processing text data. 
 *
 */
public class Text {
	
	public static final String CODE_PAGE = "code-page";

	/**
	 * Determines whether the code page attribute value provided at runtime is valid.
	 * @param codePage runtime attribute value
	 * @throws FieldTransformerException
	 */
	public static void validateCodePage(String codePage) throws FieldTransformerException {
		try {
			stringToEncoded("abc",codePage);
		} catch (UnsupportedEncodingException e) {
			// TODO throw FieleTransformerException
		}		
	}

	/**
	 * Converts a UTF-8 java string value into a hex representation of it's code page encoded value (two 
	 * hex characters represents one byte)
	 * @param value UTF-8 string value for encoding
	 * @param codePage the codePage under which the string value is encoded
	 * @return hex representation of the code page encoded string
	 * @throws UnsupportedEncodingException
	 */
	public static String stringToEncoded(String value,String codePage) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		
		byte[] bytes;
		bytes = value.getBytes(codePage);
		for (byte b : bytes){
			sb.append(String.format("%02X",b));
		}
		
		return sb.toString();
	}

	/**
	 * Converts a hex string representation of character set encoded string into it's
	 * UTF-8 (native Java character set) value.
	 * @param hex hex string of encoded value (two hex characters represents one byte)
	 * @param codePage the codePage under which the string value is encoded
	 * @return UTF-8 string value of the encoded input
	 * @throws UnsupportedEncodingException
	 */
	public static String encodedToString(String hex,String codePage) throws UnsupportedEncodingException{
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
				
		return new String(bytes,codePage);
	}

}
