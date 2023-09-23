package com.keeonline.fandango.iso8583.field.transformer.util;

import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

/**
 * Utility class implementing helper methods for processing packed data. 
 *
 */
public class Packed {
	
	public static final String PAD_POSITION = "pad-position";
	public static final String PAD_POSITION_LEADING = "leading";
	public static final String PAD_POSITION_TRAILING = "trailing";
	public static final String LENGTH_UNIT = "length-unit";
	public static final String LENGTH_UNIT_BYTES = "bytes";
	public static final String LENGTH_UNIT_NIBBLES = "nibbles";

	/**
	 * Determines whether the pad position attribute value provided at runtime is valid.
	 * <br>Valid values are: 'leading' | 'trailing'
	 * @param padPosition runtime attribute value
	 * @throws FieldTransformerException
	 */
	public static void validatePadPosition(String padPosition) throws FieldTransformerException {
		if (!(padPosition.equals(PAD_POSITION_LEADING)) || (padPosition.equals(PAD_POSITION_TRAILING))){
			// throw invalid attribute value exception
		}
	}

	/**
	 * Determines whether the length unit attribute value provided at runtime is valid.
	 * <br>Valid values are: 'bytes' | 'nibbles'
	 * @param lengthUnit runtime attribute value
	 * @throws FieldTransformerException
	 */
	public static void validateLengthUnit(String lengthUnit) throws FieldTransformerException {
		if (!(lengthUnit.equals(LENGTH_UNIT_BYTES)) || (lengthUnit.equals(LENGTH_UNIT_NIBBLES))){
			// throw invalid attribute value exception
		}
	}

	/**
	 * Pads packed data values to align to a byte boundary. If the data value already aligns to a byte 
	 * boundary, it's value is returned unchanged.
	 * @param data the data value prior to byte boundary alignment
	 * @param padPosition attribute value indicating whether to pad the leading or trailing nibble
	 * @param padChar the value to assign to the pad nibble
	 * @return packed value aligned to a byte boundary if the data value is not byte boundary aligned, otherwise
	 * the unchanged data value
	 */
	public static String toPacked(String data,String padPosition, String padChar) {
		if ((data.length() % 2) == 0) {
			return data;
		}
		
		if (padPosition.equals(PAD_POSITION_LEADING)) {
			return (padChar + data);
		}
		else {
			return(data + padChar);
		}
	}

	/**
	 * Retrieves a data value from a byte aligned packed field. If the data value is byte aligned, the
	 * returned value if the same as the packed value.
	 * @param packed data padded to a byte boundary (if necessary)
	 * @param length the length of the data portion of the packed field
	 * @param padPosition attribute value indicating whether to pad the leading or trailing nibble
	 * @param padChar the value to assign to the pad nibble
	 * @return the data portion of the (potentially padded) packed field
	 */
	public static String fromPacked(String packed,int length,String padPosition,String padChar) {
		if ((length % 2) == 0) {
			return packed;
		}
		
		if (padPosition.equals(PAD_POSITION_LEADING)) {
			return packed.substring(1,packed.length());
		}
		else {
			return(packed.substring(0,length));
		}
	}

	/**
	 * Gets the number of nibbles to be padded to align packed data to a byte boundary.
	 * @param length the data length
	 * @return the number of nibbles to be padded (0 or 1)
	 */
	public static int getLengthAdjustment(int length) {
		return length % 2;
	}

}
