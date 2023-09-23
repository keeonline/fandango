package com.keeonline.fandango.iso8583.field.transformer.number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TestBase;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public class NumberPackedBcdBvarFillTest extends TestBase {

	@Test
	public void padToMinLength() throws FieldTransformerException {
		primitiveSpec.addAttribute("length-min","5");		
		primitiveSpec.addAttribute("length-max","10");		
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		result = transformer.fill();
		assertEquals("05000000",result.getEncoded());
		assertEquals(new BigInteger("0"),result.getValue());
	}

}
