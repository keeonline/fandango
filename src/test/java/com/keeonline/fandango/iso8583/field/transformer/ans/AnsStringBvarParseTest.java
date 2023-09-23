package com.keeonline.fandango.iso8583.field.transformer.ans;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.transformer.TestBase;
import com.keeonline.fandango.iso8583.field.transformer.ans.AnsStringBvar;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;

public class AnsStringBvarParseTest extends TestBase{
	
//	@Test
//	public void mapShortValue() throws FieldTransformerException {
//		thrown.expect(InvalidValueException.class);			
//		field.addAttribute("value-regex","^[0-9a-fA-F]{4}$");
//		field.addAttribute("length-min","2");		
//		field.addAttribute("length-max","4");
//		field.addAttribute("code-page","Cp1047");		
//		field.addAttribute("length-type","1B");
//		FieldTransformer transformer =  new AnsStringVariable(field);	
//		transformer.map("abc");
//	}
//
//	@Test
//	public void mapLongValue() throws FieldTransformerException {
//		thrown.expect(InvalidValueException.class);			
//		field.addAttribute("value-regex","^[0-9a-fA-F]{6}$");
//		field.addAttribute("length-min","2");		
//		field.addAttribute("length-max","6");
//		field.addAttribute("code-page","Cp1047");		
//		field.addAttribute("length-type","1B");
//		FieldTransformer transformer =  new AnsStringVariable(field);	
//		transformer.map("abcdefg");
//	}
//
//	@Test
//	public void mapLengthType1BNoData() throws FieldTransformerException {
//		field.addAttribute("value-regex","^\\d{0,10}$");
//		field.addAttribute("length-min","0");		
//		field.addAttribute("length-max","10");
//		field.addAttribute("code-page","Cp1047");		
//		field.addAttribute("length-type","1B");
//		FieldTransformer transformer =  new AnsStringVariable(field);	
//		EncodedField result = transformer.map("");
//		assertEquals("00",result.getEncoded());
//		assertEquals("",result.getValue());
//	}
//
//	@Test
//	public void mapLengthTypeLLNoData() throws FieldTransformerException {
//		field.addAttribute("value-regex","^\\d{0,10}$");
//		field.addAttribute("length-min","0");		
//		field.addAttribute("length-max","10");
//		field.addAttribute("code-page","Cp1047");		
//		field.addAttribute("length-type","LL");
//		FieldTransformer transformer =  new AnsStringVariable(field);	
//		EncodedField result = transformer.map("");
//		assertEquals("F0F0",result.getEncoded());
//		assertEquals("",result.getValue());
//	}
//
//	@Test
//	public void mapLengthTypeLLLNoData() throws FieldTransformerException {
//		field.addAttribute("value-regex","^\\d{0,10}$");
//		field.addAttribute("length-min","0");		
//		field.addAttribute("length-max","10");
//		field.addAttribute("code-page","Cp1047");		
//		field.addAttribute("length-type","LLL");
//		FieldTransformer transformer =  new AnsStringVariable(field);	
//		EncodedField result = transformer.map("");
//		assertEquals("F0F0F0",result.getEncoded());
//		assertEquals("",result.getValue());
//	}
//
	@Test
	public void parseLengthType1BNoPaddingEBCDIC() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{5,10}$");
		primitiveSpec.addAttribute("length-min","5");		
		primitiveSpec.addAttribute("length-max","10");
		primitiveSpec.addAttribute("code-page","Cp1047");		
		FieldTransformer transformer =  new AnsStringBvar(primitiveSpec);	
		String payload = "0AF1F2F3F4F5F6F7F8F9F0AABBCC";
		String value = "1234567890";
		result = transformer.parse(payload,0);
		assertEquals("0AF1F2F3F4F5F6F7F8F9F0",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void parseLengthType1BNoPaddingASCII() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{5,10}$");
		primitiveSpec.addAttribute("length-min","5");		
		primitiveSpec.addAttribute("length-max","10");
		primitiveSpec.addAttribute("code-page","Cp1252");		
		FieldTransformer transformer =  new AnsStringBvar(primitiveSpec);	
		String payload = "0A31323334353637383930AABBCC";
		String value = "1234567890";
		result = transformer.parse(payload,0);
		assertEquals("0A31323334353637383930",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void parseLengthType1BDefaultJustifyEBCDIC() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^[a-fA-F]{1,10}$");
		primitiveSpec.addAttribute("length-min","10");		
		primitiveSpec.addAttribute("length-max","10");
		primitiveSpec.addAttribute("code-page","Cp1047");		
		FieldTransformer transformer =  new AnsStringBvar(primitiveSpec);	
		String payload = "0AC1404040404040404040CCDD";
		String value = "A";
		result = transformer.parse(payload,0);
		assertEquals("0AC1404040404040404040",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void parseLengthType1BDefaultPadJustifyRightEBCDIC() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^[a-fA-F]{1,10}$");
		primitiveSpec.addAttribute("length-min","10");		
		primitiveSpec.addAttribute("length-max","10");
		primitiveSpec.addAttribute("code-page","Cp1047");		
		primitiveSpec.addAttribute("justify","right");		
		FieldTransformer transformer = new AnsStringBvar(primitiveSpec);
		String payload = "0A404040404040404040C1CCDD";
		String value = "A";
		result = transformer.parse(payload,0);
		assertEquals("0A404040404040404040C1",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void parseLengthType1BDefaultJustifyASCII() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^[a-fA-F]{1,10}$");
		primitiveSpec.addAttribute("length-min","10");		
		primitiveSpec.addAttribute("length-max","10");
		primitiveSpec.addAttribute("code-page","Cp1252");		
		FieldTransformer transformer =  new AnsStringBvar(primitiveSpec);	
		String payload = "0A41202020202020202020CCDD";
		String value = "A";
		result = transformer.parse(payload,0);
		assertEquals("0A41202020202020202020",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void parseLengthType1BDefaultPadJustifyRightASCII() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^[a-fA-F]{1,10}$");
		primitiveSpec.addAttribute("length-min","10");		
		primitiveSpec.addAttribute("length-max","10");
		primitiveSpec.addAttribute("justify","right");
		primitiveSpec.addAttribute("code-page","Cp1252");		
		FieldTransformer transformer =  new AnsStringBvar(primitiveSpec);	
		String payload = "0A20202020202020202041CCDD";
		String value = "A";
		result = transformer.parse(payload,0);
		assertEquals("0A20202020202020202041",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void parseLengthType1BPadxJustifyRightEBCDIC() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^[a-fA-F]{1,10}$");
		primitiveSpec.addAttribute("length-min","10");		
		primitiveSpec.addAttribute("length-max","10");
		primitiveSpec.addAttribute("justify","right");
		primitiveSpec.addAttribute("pad-char","x");
		primitiveSpec.addAttribute("code-page","Cp1047");		
		FieldTransformer transformer =  new AnsStringBvar(primitiveSpec);	
		String payload = "0AA7A7A7A7A7A7A7A7A7C1CCDD";
		String value = "A";
		result = transformer.parse(payload,0);
		assertEquals("0AA7A7A7A7A7A7A7A7A7C1",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void parsepLengthType1BPadyJustifyLeftASCII() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^[a-fA-F]{1,10}$");
		primitiveSpec.addAttribute("length-min","10");		
		primitiveSpec.addAttribute("length-max","10");
		primitiveSpec.addAttribute("justify","left");
		primitiveSpec.addAttribute("pad-char","y");
		primitiveSpec.addAttribute("code-page","Cp1252");		
		FieldTransformer transformer =  new AnsStringBvar(primitiveSpec);	
		String payload = "0A41797979797979797979CCDD";
		String value = "A";
		result = transformer.parse(payload,0);
		assertEquals("0A41797979797979797979",result.getEncoded());
		assertEquals(value,result.getValue());
	}
		
}
