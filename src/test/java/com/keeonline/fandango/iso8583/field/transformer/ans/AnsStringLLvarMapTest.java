package com.keeonline.fandango.iso8583.field.transformer.ans;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TestBase;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public class AnsStringLLvarMapTest extends TestBase {
	
//	@Test
//	public void mapLengthTypeLLNoData() throws FieldTransformerException {
//		field.addAttribute("value-regex","^\\d{0,10}$");
//		field.addAttribute("length-min","0");		
//		field.addAttribute("length-max","10");
//		field.addAttribute("code-page","Cp1047");		
//		transformer = new AnsStringLLvar(field);	
//		result = transformer.map("");
//		assertEquals("F0F0",result.getEncoded());
//		assertEquals("",result.getValue());
//	}
//
	@Test
	public void mapLengthTypeLLNoPaddingEBCDIC() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{5,10}$");
		primitiveSpec.addAttribute("length-min","5");		
		primitiveSpec.addAttribute("length-max","10");
		primitiveSpec.addAttribute("code-page","Cp1047");		
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		String value = "1234567890";
		result = transformer.map(value);
		assertEquals("F1F0F1F2F3F4F5F6F7F8F9F0",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void mapLengthTypeLLNoPaddingASCII() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{5,10}$");
		primitiveSpec.addAttribute("length-min","5");		
		primitiveSpec.addAttribute("length-max","10");
		primitiveSpec.addAttribute("code-page","Cp1252");		
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		String value = "1234567890";
		result = transformer.map(value);
		assertEquals("313031323334353637383930",result.getEncoded());
		assertEquals(value,result.getValue());
	}

}
