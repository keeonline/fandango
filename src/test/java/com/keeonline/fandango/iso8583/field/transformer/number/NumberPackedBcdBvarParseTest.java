package com.keeonline.fandango.iso8583.field.transformer.number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TestBase;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public class NumberPackedBcdBvarParseTest extends TestBase {

	@Test
	public void testEvenLengthDataNoPadding() throws FieldTransformerException {
		primitiveSpec.addAttribute("length-min","5");		
		primitiveSpec.addAttribute("length-max","10");		
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String payload = "FFF0A1234567890FFF";
		result = transformer.parse(payload,3);
		assertEquals("0A1234567890",result.getEncoded());
		assertEquals(new BigInteger("1234567890"),result.getValue());
	}

	@Test
	public void testEvenLengthDataPaddedToMinLength() throws FieldTransformerException {
		primitiveSpec.addAttribute("length-min","5");		
		primitiveSpec.addAttribute("length-max","10");		
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String payload = "FFF05000001FFF";
		result = transformer.parse(payload,3);
		assertEquals("05000001",result.getEncoded());
		assertEquals(new BigInteger("1"),result.getValue());
	}

}
