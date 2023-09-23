package com.keeonline.fandango.iso8583.field.transformer.util;

import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public class Formatted {

	public static final String PAD_CHAR = "pad-char";
	
	public static final String JUSTIFY = "justify";
	public static final String JUSTIFY_LEFT = "left";
	public static final String JUSTIFY_RIGHT = "right";
	
	/**
	 * Determines whether the pad character attribute value provided at runtime is valid.
	 * <br>Valid values are: any single character value
	 * @param padChar runtime attribute value
	 * @throws FieldTransformerException
	 */
	public static void validatePadChar(String padChar) throws FieldTransformerException {
		if (padChar.length() > 1){
			// throw invalid attribute value exception
		}
	}

	/**
	 * Determines whether the field justification attribute value provided at runtime is valid.
	 * <br>Valid values are: 'left' | 'right'
	 * @param justify runtime attribute value
	 * @throws FieldTransformerException
	 */
	public static void validateJustify(String justify) throws FieldTransformerException {
		if (!(justify.equals(JUSTIFY_LEFT)) || (justify.equals(JUSTIFY_RIGHT))){
			// throw invalid attribute value exception
		}
	}

	/**
	 * Justifies the given data according to the justify argument value (left or right), padding 
	 * the output to the length of paddedLength (if necessary).
	 * @param data the unjustified data value
	 * @param paddedLength the length of to which the data should be justified and padded
	 * @param justify the position to which the data should be justified
	 * @param padChar the character to be used to pad the justified data
	 * @return the justified, padded data value
	 */
	public static String toJustified(String data, int paddedLength, String justify, String padChar) {
		if (data.length() >= paddedLength) {
			return data;
		}
		
		if (justify == JUSTIFY_LEFT){
			return String.format("%-" + paddedLength + "s",data).replaceAll(" ",padChar);
		}
		else{
			return String.format("%" + paddedLength + "s",data).replaceAll(" ",padChar);
		}
	}

	public static String trim(String padded,String padChar) {
		if (padded.length() == 0){
			return padded;
		}			
		
		if (padChar.equals(" ")){
			return padded.trim();
		}
		
		int start = 0;
		while ((start < padded.length()) && (padChar.equals(String.valueOf(padded.charAt(start))))){
			start++;
		}
		
		int end = padded.length()-1;
		while ((end > 0) && (padChar.equals(String.valueOf(padded.charAt(end))))){
			end--;
		}

		return padded.substring(start,end+1);
	}

}
