package com.keeonline.fandango.iso8583.field.transformer.number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TestBase;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public class NumberPackedBcdBvarMapTest extends TestBase {

	@Test
	public void testNoPadding() throws FieldTransformerException {
		primitiveSpec.addAttribute("length-min","5");		
		primitiveSpec.addAttribute("length-max","10");		
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		BigInteger value = new BigInteger("1234567890");
		result = transformer.map(value);
		assertEquals("0A1234567890",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void testOddLengthDefaultPadPosition() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{1,10}$");
		primitiveSpec.addAttribute("length-min","5");		
		primitiveSpec.addAttribute("length-max","10");		
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		BigInteger value = new BigInteger("9");
		result = transformer.map(value);
		assertEquals("05000009",result.getEncoded());
		assertEquals(value,result.getValue());
	}


}
