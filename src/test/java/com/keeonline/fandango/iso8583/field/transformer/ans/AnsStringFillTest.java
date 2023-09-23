package com.keeonline.fandango.iso8583.field.transformer.ans;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TestBase;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public class AnsStringFillTest extends TestBase {
	
	@Test
	public void testFillEBCDIC() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^[a-zA-Z\\s]{0,10}$");
		primitiveSpec.addAttribute("length","10");
		primitiveSpec.addAttribute("code-page","Cp1047");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		result = transformer.fill();
		String expected = "";
		assertEquals("40404040404040404040",result.getEncoded());
		assertEquals(expected,result.getValue());
	}

	@Test
	public void testFillASCII() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^[a-zA-Z\\s]{0,4}$");
		primitiveSpec.addAttribute("length","4");
		primitiveSpec.addAttribute("code-page","Cp1252");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		result = transformer.fill();
		String expected = "";
		assertEquals("20202020",result.getEncoded());
		assertEquals(expected,result.getValue());
	}

}
