package com.keeonline.fandango.iso8583.field.transformer.ans;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TestBase;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public class AnsStringParseTest extends TestBase {
	
//	@Test
//	public void parseShortValue() throws FieldTransformerException {
//		thrown.expect(FieldTransformerException.class);			
//		field.addAttribute("value-regex","^[0-9a-fA-F]{4}$");
//		field.addAttribute("length","4");		
//		field.addAttribute("code-page","Cp1047");		
//		FieldTransformer transformer =  new AnsString(field);	
//		transformer.parse("abc",0);
//	}
//
//	@Test
//	public void parseNoData() throws FieldTransformerException {
//		field.addAttribute("value-regex","^\\d{0,10}$");
//		field.addAttribute("length","10");
//		field.addAttribute("code-page","Cp1047");
//		FieldTransformer transformer =  new AnsString(field);	
//		String value = "";
//		EncodedField result = transformer.parse(value);
//		assertEquals("40404040404040404040",result.getEncoded());
//		assertEquals(value,result.getValue());
//	}
//
	@Test
	public void parseNoPaddingEBCDIC() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{10}$");
		primitiveSpec.addAttribute("length","10");
		primitiveSpec.addAttribute("code-page","Cp1047");
		// FieldTransformer transformer = getTransformer(primitiveSpec);
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String payload = "F1F2F3F4F5F6F7F8F9F0";
		String value = "1234567890";
		result = transformer.parse(payload,0);
		assertEquals(payload,result.getEncoded());
		assertEquals(value,result.getValue());
		assertEquals(BigInteger.valueOf(10L),result.getEncodedByteLength());
	}

	@Test
	public void parseNoPaddingASCII() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{10}$");
		primitiveSpec.addAttribute("length","10");
		primitiveSpec.addAttribute("code-page","Cp1252");		
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String payload = "31323334353637383930";
		String value = "1234567890";
		result = transformer.parse(payload,0);
		assertEquals(payload,result.getEncoded());
		assertEquals(value,result.getValue());
		assertEquals(BigInteger.valueOf(10L),result.getEncodedByteLength());
	}

	@Test
	public void parseAllDefaultsASCII() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^[a-fA-F]{1,10}$");
		primitiveSpec.addAttribute("length","10");
		primitiveSpec.addAttribute("code-page","Cp1252");		
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String payload = "41202020202020202020";
		String value = "A";
		result = transformer.parse(payload,0);
		assertEquals(payload,result.getEncoded());
		assertEquals(value,result.getValue());
		assertEquals(BigInteger.valueOf(10L),result.getEncodedByteLength());
	}

	@Test
	public void parseAllDefaultsEBCDIC() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^[a-fA-F]{1,10}$");
		primitiveSpec.addAttribute("length","10");
		primitiveSpec.addAttribute("code-page","Cp1047");		
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String payload = "C1404040404040404040";
		String value = "A";
		result = transformer.parse(payload,0);
		assertEquals(payload,result.getEncoded());
		assertEquals(value,result.getValue());
		assertEquals(BigInteger.valueOf(10L),result.getEncodedByteLength());
	}

	@Test
	public void parsePadDefaultPadJustifyRightEBCDIC() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^[a-fA-F]{1,10}$");
		primitiveSpec.addAttribute("length","10");
		primitiveSpec.addAttribute("justify","right");
		primitiveSpec.addAttribute("code-page","Cp1047");		
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String payload = "404040404040404040C1";
		String value = "A";
		result = transformer.parse(payload,0);
		assertEquals(payload,result.getEncoded());
		assertEquals(value,result.getValue());
		assertEquals(BigInteger.valueOf(10L),result.getEncodedByteLength());
	}

	@Test
	public void parsePadDefaultJustifyASCII() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^[a-fA-F]{1,10}$");
		primitiveSpec.addAttribute("length","10");
		primitiveSpec.addAttribute("code-page","Cp1252");		
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String payload = "41202020202020202020";
		String value = "A";
		result = transformer.parse(payload,0);
		assertEquals(payload,result.getEncoded());
		assertEquals(value,result.getValue());
		assertEquals(BigInteger.valueOf(10L),result.getEncodedByteLength());
	}

	@Test
	public void parseDefaultPadJustifyRightASCII() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^[a-fA-F]{1,10}$");
		primitiveSpec.addAttribute("length","10");
		primitiveSpec.addAttribute("justify","right");
		primitiveSpec.addAttribute("code-page","Cp1252");		
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String payload = "20202020202020202041";
		String value = "A";
		result = transformer.parse(payload,0);
		assertEquals(payload,result.getEncoded());
		assertEquals(value,result.getValue());
		assertEquals(BigInteger.valueOf(10L),result.getEncodedByteLength());
	}

	@Test
	public void parsePadCharJustifyRightEBCDIC() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^[a-fA-F]{1,10}$");
		primitiveSpec.addAttribute("length","10");
		primitiveSpec.addAttribute("pad-char","x");
		primitiveSpec.addAttribute("justify","right");
		primitiveSpec.addAttribute("code-page","Cp1047");		
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String payload = "A7A7A7A7A7A7A7A7A7C1";
		String value = "A";
		result = transformer.parse(payload,0);
		assertEquals(payload,result.getEncoded());
		assertEquals(value,result.getValue());
		assertEquals(BigInteger.valueOf(10L),result.getEncodedByteLength());
	}

	@Test
	public void parsePadCharJustifyLeftASCII() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^[a-fA-F]{1,10}$");
		primitiveSpec.addAttribute("length","10");
		primitiveSpec.addAttribute("pad-char","y");
		primitiveSpec.addAttribute("justify","left");
		primitiveSpec.addAttribute("code-page","Cp1252");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String payload = "41797979797979797979";
		String value = "A";
		result = transformer.parse(payload,0);
		assertEquals(payload,result.getEncoded());
		assertEquals(value,result.getValue());
		assertEquals(BigInteger.valueOf(10L),result.getEncodedByteLength());
	}
	
}
