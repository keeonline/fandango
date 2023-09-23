package com.keeonline.fandango.iso8583.field.transformer.number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TestBase;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public class NumberStringLLLvarFillTest extends TestBase {

	@Test
	public void padToMinLength() throws FieldTransformerException {
		primitiveSpec.addAttribute("length-min","5");		
		primitiveSpec.addAttribute("length-max","10");		
		primitiveSpec.addAttribute("code-page","cp1252");		
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		result = transformer.fill();
		assertEquals("3030353030303030",result.getEncoded());
		assertEquals(new BigInteger("0"),result.getValue());
	}

}
