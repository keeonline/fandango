package com.keeonline.fandango.iso8583.field.transformer.number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TestBase;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;
import com.keeonline.fandango.iso8583.field.transformer.util.Fixed;
import com.keeonline.fandango.iso8583.field.transformer.util.Packed;

public class NumberPackedBcdParseTest extends TestBase {

	@Test
	public void parseNoDataPaddingNoPadToByteBoundary() throws FieldTransformerException {
		primitiveSpec.addAttribute(Fixed.LENGTH,"10");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String payload = "FFF1234567890FFF";
		BigInteger value = new BigInteger("1234567890");
		result = transformer.parse(payload,3);
		assertEquals("1234567890",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void parseNoDataPaddingWithPadToByteBoundaryLeading() throws FieldTransformerException {
		primitiveSpec.addAttribute(Fixed.LENGTH,"9");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String payload = "FFF0123456789FFF";
		BigInteger value = new BigInteger("123456789");
		result = transformer.parse(payload,3);
		assertEquals("0123456789",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void parseNoDataPaddingWithPadToByteBoundaryTrailing() throws FieldTransformerException {
		primitiveSpec.addAttribute(Fixed.LENGTH,"9");
		primitiveSpec.addAttribute(Packed.PAD_POSITION,Packed.PAD_POSITION_TRAILING);
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String payload = "FFF1234567890FFF";
		BigInteger value = new BigInteger("123456789");
		result = transformer.parse(payload,3);
		assertEquals("1234567890",result.getEncoded());
		assertEquals(value,result.getValue());
	}

}
