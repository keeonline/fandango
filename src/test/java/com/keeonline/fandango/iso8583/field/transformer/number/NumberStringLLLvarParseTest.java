package com.keeonline.fandango.iso8583.field.transformer.number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TestBase;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public class NumberStringLLLvarParseTest extends TestBase {
	
	@Test
	public void parseMaxLength() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{0,10}$");
		primitiveSpec.addAttribute("length-min","1");		
		primitiveSpec.addAttribute("length-max","10");
		primitiveSpec.addAttribute("code-page","Cp1047");		
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		result = transformer.parse("FFFFFFF0F1F0F1F2F3F4F5F6F7F8F9F0FFFFFF",6);
		assertEquals("F0F1F0F1F2F3F4F5F6F7F8F9F0",result.getEncoded());
		assertEquals(new BigInteger("1234567890"),result.getValue());
	}

	@Test
	public void mapPadToMinLength() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{1,10}$");
		primitiveSpec.addAttribute("length-min","7");		
		primitiveSpec.addAttribute("length-max","10");
		primitiveSpec.addAttribute("code-page","Cp1252");		
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		result = transformer.parse("FFFFFF30303730303030303037FFFFFF",6);
		assertEquals("30303730303030303037",result.getEncoded());
		assertEquals(new BigInteger("7"),result.getValue());
	}

	@Test
	public void mapPadToMidLength() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{1,10}$");
		primitiveSpec.addAttribute("length-min","6");		
		primitiveSpec.addAttribute("length-max","10");
		primitiveSpec.addAttribute("code-page","Cp1252");		
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		result = transformer.parse("FFFFFF3030383030303030303038FFFFFF",6);
		assertEquals("3030383030303030303038",result.getEncoded());
		assertEquals(new BigInteger("8"),result.getValue());
	}

}
