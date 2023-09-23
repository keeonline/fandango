package com.keeonline.fandango.iso8583.field.transformer.hex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TestBase;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public class HexPackedBvarParseTest extends TestBase {
	
	@Test
	public void parseOddLength() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex", "^[0-9a-fA-F]{2}$");
		primitiveSpec.addAttribute("length-min", "2");
		primitiveSpec.addAttribute("length-max", "3");
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		String encoded = "0201";
		result = transformer.parse(encoded,0);
		assertEquals("0201", result.getEncoded());
		assertEquals("01", result.getValue());
	}

	@Test
	public void parseEvenLength() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex", "^[0-9a-fA-F]{16}$");
		primitiveSpec.addAttribute("length-min", "3");
		primitiveSpec.addAttribute("length-max", "4");
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		String encoded = "030012";
		result = transformer.parse(encoded,0);
		assertEquals("030012", result.getEncoded());
		assertEquals("012", result.getValue());
	}

	@Test
	public void parseOddByteLength() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex", "^[0-9a-fA-F]{18,22}$");
		primitiveSpec.addAttribute("length-min", "9");
		primitiveSpec.addAttribute("length-max", "11");
		primitiveSpec.addAttribute("length-unit", "bytes");
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		String encoded = "090201F1F2F3F40002FF";
		result = transformer.parse(encoded,0);
		assertEquals("090201F1F2F3F40002FF", result.getEncoded());
		assertEquals("0201F1F2F3F40002FF", result.getValue());
	}

	@Test
	public void parseEvenByteLength() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex", "^[0-9a-fA-F]{18,12}$");
		primitiveSpec.addAttribute("length-min", "9");
		primitiveSpec.addAttribute("length-max", "11");
		primitiveSpec.addAttribute("length-unit", "bytes");
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		String encoded = "0A0201F1F2F3F40002FF00";
		result = transformer.parse(encoded,0);
		assertEquals("0A0201F1F2F3F40002FF00", result.getEncoded());
		assertEquals("0201F1F2F3F40002FF00", result.getValue());
	}

}
