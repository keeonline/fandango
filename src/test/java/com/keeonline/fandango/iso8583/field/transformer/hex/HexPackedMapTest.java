package com.keeonline.fandango.iso8583.field.transformer.hex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TestBase;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public class HexPackedMapTest extends TestBase {
	
	@Test
	public void mapLength2() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex", "^[0-9a-fA-F]{2}$");
		primitiveSpec.addAttribute("length", "2");
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		String encoded = "01";
		result = transformer.map(encoded);
		assertEquals("01", result.getEncoded());
		assertEquals("01", result.getValue());
	}

	@Test
	public void mapLength16() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex", "^[0-9a-fA-F]{16}$");
		primitiveSpec.addAttribute("length", "16");
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		String encoded = "0123456789ABCDEF";
		result = transformer.map(encoded);
		assertEquals("0123456789ABCDEF", result.getEncoded());
		assertEquals("0123456789ABCDEF", result.getValue());
	}

}
