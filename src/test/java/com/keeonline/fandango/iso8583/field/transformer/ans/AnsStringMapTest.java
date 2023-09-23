package com.keeonline.fandango.iso8583.field.transformer.ans;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TestBase;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public class AnsStringMapTest extends TestBase {
	
//	@Test
//	public void mapWrongInputType() throws FieldTransformerException {
//		thrown.expect(ValueTypeException.class);			
//		field.addAttribute("value-regex","^[0-9a-fA-F]{4}$");
//		field.addAttribute("length","4");		
//		field.addAttribute("code-page","Cp1047");		
//		FieldTransformer transformer =  new AnsString(field);	
//		transformer.map(new BigInteger("0123");
//		fail("InputTypeException exception should have been thrown");
//	}
//
//	@Test
//	public void mapShortValue() throws FieldTransformerException {
//		thrown.expect(FieldValueException.class);			
//		field.addAttribute("value-regex","^[0-9a-fA-F]{4}$");
//		field.addAttribute("length","4");		
//		field.addAttribute("code-page","Cp1047");		
//		PrimitiveTransformer mapper = new AnsString(field);	
//		mapper.map("abc");
//	}
//
//	@Test
//	public void mapLongValue() throws FieldTransformerException {
//		thrown.expect(FieldValueException.class);			
//		field.addAttribute("value-regex","^[0-9a-fA-F]{6}$");
//		field.addAttribute("length","6");		
//		field.addAttribute("code-page","Cp1047");		
//		PrimitiveTransformer mapper = new AnsString(field);	
//		mapper.map("abcdefg");
//	}
//
//	@Test
//	public void mapNoData() throws FieldTransformerException {
//		field.addAttribute("value-regex","^\\d{0,10}$");
//		field.addAttribute("length","10");
//		field.addAttribute("code-page","Cp1047");
//		PrimitiveTransformer mapper = new AnsString(field);	
//		String value = "";
//		result = transformer.map(value);
//		assertEquals("40404040404040404040",result.getEncoded());
//		assertEquals(value,result.getValue());
//	}
//
	@Test
	public void mapNoPaddingEBCDIC() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{10}$");
		primitiveSpec.addAttribute("length","10");
		primitiveSpec.addAttribute("code-page","Cp1047");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String value = "1234567890";
		result = transformer.map(value);
		assertEquals("F1F2F3F4F5F6F7F8F9F0",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void mapNoPaddingASCII() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{10}$");
		primitiveSpec.addAttribute("length","10");
		primitiveSpec.addAttribute("code-page","Cp1252");		
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String value = "1234567890";
		result = transformer.map(value);
		assertEquals("31323334353637383930",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void mapDefaultJustifyEBCDIC() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^[a-fA-F]{1,10}$");
		primitiveSpec.addAttribute("length","10");
		primitiveSpec.addAttribute("code-page","Cp1047");		
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String value = "A";
		result = transformer.map(value);
		assertEquals("C1404040404040404040",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void mapDefaultPadJustifyRightEBCDIC() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^[a-fA-F]{1,10}$");
		primitiveSpec.addAttribute("length","10");
		primitiveSpec.addAttribute("justify","right");
		primitiveSpec.addAttribute("code-page","Cp1047");		
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String value = "A";
		result = transformer.map(value);
		assertEquals("404040404040404040C1",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void mapDefaultJustifyASCII() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^[a-fA-F]{1,10}$");
		primitiveSpec.addAttribute("length","10");
		primitiveSpec.addAttribute("code-page","Cp1252");		
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String value = "A";
		result = transformer.map(value);
		assertEquals("41202020202020202020",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void mapDefaultPadJustifyRightASCII() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^[a-fA-F]{1,10}$");
		primitiveSpec.addAttribute("length","10");
		primitiveSpec.addAttribute("justify","right");
		primitiveSpec.addAttribute("code-page","Cp1252");		
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String value = "A";
		result = transformer.map(value);
		assertEquals("20202020202020202041",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void mapPadxJustifyRightEBCDIC() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^[a-fA-F]{1,10}$");
		primitiveSpec.addAttribute("length","10");
		primitiveSpec.addAttribute("pad-char","x");
		primitiveSpec.addAttribute("justify","right");
		primitiveSpec.addAttribute("code-page","Cp1047");		
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String value = "A";
		result = transformer.map(value);
		assertEquals("A7A7A7A7A7A7A7A7A7C1",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void mapPadYJustifyLeftASCII() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^[a-fA-F]{1,10}$");
		primitiveSpec.addAttribute("length","10");
		primitiveSpec.addAttribute("pad-char","y");
		primitiveSpec.addAttribute("justify","left");
		primitiveSpec.addAttribute("code-page","Cp1252");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String value = "A";
		result = transformer.map(value);
		assertEquals("41797979797979797979",result.getEncoded());
		assertEquals(value,result.getValue());
	}
	
}
