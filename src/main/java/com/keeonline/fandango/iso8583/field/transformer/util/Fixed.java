package com.keeonline.fandango.iso8583.field.transformer.util;

import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public class Fixed {

	public static final String LENGTH = "length";

	public static void validateLength(int length) throws FieldTransformerException {
		if (length <= 0) {
			// throw invalid attribute value exception
		}
	}
	
}
