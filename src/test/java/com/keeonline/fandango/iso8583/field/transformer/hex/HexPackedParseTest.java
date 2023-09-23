package com.keeonline.fandango.iso8583.field.transformer.hex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TestBase;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public class HexPackedParseTest extends TestBase {
	
	@Test
	public void parseLength2() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex", "^[0-9a-fA-F]{2}$");
		primitiveSpec.addAttribute("length", "2");
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		String encoded = "01";
		result = transformer.parse(encoded,0);
		assertEquals("01", result.getEncoded());
		assertEquals("01", result.getValue());
	}

	@Test
	public void parseLength16() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex", "^[0-9a-fA-F]{16}$");
		primitiveSpec.addAttribute("length", "16");
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		String encoded = "0123456789ABCDEF";
		result = transformer.parse(encoded,0);
		assertEquals("0123456789ABCDEF", result.getEncoded());
		assertEquals("0123456789ABCDEF", result.getValue());
	}

}
