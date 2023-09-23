package com.keeonline.fandango.iso8583.field.transformer.number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TestBase;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;
import com.keeonline.fandango.iso8583.field.transformer.util.Fixed;
import com.keeonline.fandango.iso8583.field.transformer.util.Formatted;

public class NumberPackedBcdFillTest extends TestBase {

	@Test
	public void testFillDefaultPadChar() throws FieldTransformerException {
//		field.addAttribute(PrimitiveTransformerNew.VALUE_REGEX,"^\\d{10}$");
		primitiveSpec.addAttribute(Fixed.LENGTH,"10");
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		result = transformer.fill();
		assertEquals("0000000000",result.getEncoded());
		assertEquals(new BigInteger("0"),result.getValue());
	}

	@Test
	public void testFillNonDefaultPadChar() throws FieldTransformerException {
//		field.addAttribute(PrimitiveTransformerNew.VALUE_REGEX,"^\\d{10}$");
		primitiveSpec.addAttribute(Fixed.LENGTH,"10");
		primitiveSpec.addAttribute(Formatted.PAD_CHAR,"9");
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		result = transformer.fill();
		assertEquals("0000000000",result.getEncoded());
		assertEquals(new BigInteger("0"),result.getValue());
		// TODO: decide if we want fill to always fill with zero??
	}

}
