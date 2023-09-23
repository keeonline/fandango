package com.keeonline.fandango.iso8583.field.transformer.ans;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TestBase;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public class AnsStringLLLvarFillTest extends TestBase{
	
	@Test
	public void testLengthTypeLLL() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\s{0,10}$");
		primitiveSpec.addAttribute("length-min","5");		
		primitiveSpec.addAttribute("length-max","10");
		primitiveSpec.addAttribute("code-page","Cp1047");		
		FieldTransformer transformer = getTransformer(primitiveSpec);
		result = transformer.fill();
		assertEquals("F0F0F54040404040",result.getEncoded());
		assertEquals("",result.getValue());
	}

}
