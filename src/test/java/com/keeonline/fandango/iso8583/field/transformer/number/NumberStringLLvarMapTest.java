package com.keeonline.fandango.iso8583.field.transformer.number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TestBase;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public class NumberStringLLvarMapTest extends TestBase {
	
	@Test
	public void mapNoPadding() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{0,10}$");
		primitiveSpec.addAttribute("length-min","1");		
		primitiveSpec.addAttribute("length-max","10");
		primitiveSpec.addAttribute("code-page","Cp1047");		
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		BigInteger value = new BigInteger("1234567890");
		result = transformer.map(value);
		assertEquals("F1F0F1F2F3F4F5F6F7F8F9F0",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void mapPadToMinLength() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{1,10}$");
		primitiveSpec.addAttribute("length-min","7");		
		primitiveSpec.addAttribute("length-max","10");
		primitiveSpec.addAttribute("code-page","Cp1252");		
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		BigInteger value = new BigInteger("7");
		result = transformer.map(value);
		assertEquals("303730303030303037",result.getEncoded());
		assertEquals(value,result.getValue());
	}

}
