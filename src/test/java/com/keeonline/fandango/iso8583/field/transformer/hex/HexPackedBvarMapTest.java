package com.keeonline.fandango.iso8583.field.transformer.hex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TestBase;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public class HexPackedBvarMapTest extends TestBase {
	
	@Test
	public void testLengthEven() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex", "^[0-9a-fA-F]{2,3}$");
		primitiveSpec.addAttribute("length-min", "2");
		primitiveSpec.addAttribute("length-max", "3");
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		result = transformer.map("01");
		assertEquals("0201", result.getEncoded());
		assertEquals("01", result.getValue());
	}

	@Test
	public void testLengthOdd() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex", "^[0-9a-fA-F]{3,6}$");
		primitiveSpec.addAttribute("length-min", "3");
		primitiveSpec.addAttribute("length-max", "6");
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		result = transformer.map("012");
		assertEquals("030012", result.getEncoded());
		assertEquals("012", result.getValue());
	}
	
	@Test
	public void testOddByteLength() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex", "^[0-9a-fA-F]{18,22}$");
		primitiveSpec.addAttribute("length-min", "9");
		primitiveSpec.addAttribute("length-max", "11");
		primitiveSpec.addAttribute("length-unit", "bytes");
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		result = transformer.map("0201F1F2F3F40002FF");
		assertEquals("090201F1F2F3F40002FF", result.getEncoded());
		assertEquals("0201F1F2F3F40002FF", result.getValue());
	}

	@Test
	public void testEvenByteLength() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex", "^[0-9a-fA-F]{18,22}$");
		primitiveSpec.addAttribute("length-min", "9");
		primitiveSpec.addAttribute("length-max", "11");
		primitiveSpec.addAttribute("length-unit", "bytes");
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		result = transformer.map("0201F1F2F3F40002FF00");
		assertEquals("0A0201F1F2F3F40002FF00", result.getEncoded());
		assertEquals("0201F1F2F3F40002FF00", result.getValue());
	}


}
