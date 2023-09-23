package com.keeonline.fandango.iso8583.field.transformer.hex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TestBase;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public class HexPackedFillTest extends TestBase {
	
	@Test
	public void mapLength2() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex", "^[0-9a-fA-F]{2}$");
		primitiveSpec.addAttribute("length", "2");
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		result = transformer.fill();
		assertEquals("00", result.getEncoded());
		assertEquals("00", result.getValue());
	}

	@Test
	public void mapLength16() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex", "^[0-9a-fA-F]{16}$");
		primitiveSpec.addAttribute("length", "16");
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		result = transformer.fill();
		assertEquals("0000000000000000", result.getEncoded());
		assertEquals("0000000000000000", result.getValue());
	}

}
