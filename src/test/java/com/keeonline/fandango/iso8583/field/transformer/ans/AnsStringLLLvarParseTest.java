package com.keeonline.fandango.iso8583.field.transformer.ans;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TestBase;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public class AnsStringLLLvarParseTest extends TestBase {
	
//	@Test
//	public void mapShortValue() throws FieldTransformerException {
//		thrown.expect(InvalidValueException.class);			
//		field.addAttribute("value-regex","^[0-9a-fA-F]{4}$");
//		field.addAttribute("length-min","2");		
//		field.addAttribute("length-max","4");
//		field.addAttribute("code-page","Cp1047");		
//		field.addAttribute("length-type","1B");
//		PrimitiveTransformer transformer = new AnsStringVariable(field);	
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
//		PrimitiveTransformer transformer = new AnsStringVariable(field);	
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
//		PrimitiveTransformer transformer = new AnsStringVariable(field);	
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
//		PrimitiveTransformer transformer = new AnsStringVariable(field);	
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
//		PrimitiveTransformer transformer = new AnsStringVariable(field);	
//		EncodedField result = transformer.map("");
//		assertEquals("F0F0F0",result.getEncoded());
//		assertEquals("",result.getValue());
//	}
//
	@Test
	public void parseLengthTypeLLLNoPaddingEBCDIC() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{5,10}$");
		primitiveSpec.addAttribute("length-min","5");		
		primitiveSpec.addAttribute("length-max","10");
		primitiveSpec.addAttribute("code-page","Cp1047");		
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String payload = "F0F1F0F1F2F3F4F5F6F7F8F9F0AABBCC";
		String value = "1234567890";
		result = transformer.parse(payload,0);
		assertEquals("F0F1F0F1F2F3F4F5F6F7F8F9F0",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void parseLengthTypeLLLNoPaddingASCII() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{5,10}$");
		primitiveSpec.addAttribute("length-min","5");		
		primitiveSpec.addAttribute("length-max","10");
		primitiveSpec.addAttribute("code-page","Cp1252");		
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String payload = "AABB30313031323334353637383930CCDD";
		String value = "1234567890";
		result = transformer.parse(payload,4);
		assertEquals("30313031323334353637383930",result.getEncoded());
		assertEquals(value,result.getValue());
	}

}
