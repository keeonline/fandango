package com.keeonline.fandango.iso8583.field.transformer.ans;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TestBase;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public class AnsStringLLLvarMapTest extends TestBase {
	
	@Test
	public void mapLengthTypeLLLNoData() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{0,10}$");
		primitiveSpec.addAttribute("length-min","0");		
		primitiveSpec.addAttribute("length-max","10");
		primitiveSpec.addAttribute("code-page","Cp1047");		
		FieldTransformer transformer = getTransformer(primitiveSpec);
		result = transformer.map("");
		assertEquals("F0F0F0",result.getEncoded());
		assertEquals("",result.getValue());
	}

}
