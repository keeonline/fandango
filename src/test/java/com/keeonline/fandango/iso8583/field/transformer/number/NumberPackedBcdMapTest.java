package com.keeonline.fandango.iso8583.field.transformer.number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TestBase;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;
import com.keeonline.fandango.iso8583.field.transformer.util.Fixed;
import com.keeonline.fandango.iso8583.field.transformer.util.Packed;

public class NumberPackedBcdMapTest extends TestBase {

	@Test
	public void mapNoDataPaddingNoPadToByteBoundary() throws FieldTransformerException {
//		field.addAttribute(PrimitiveTransformerNew.VALUE_REGEX,"^\\d{10}$");
		primitiveSpec.addAttribute(Fixed.LENGTH,"10");
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		BigInteger value = new BigInteger("1234567890");
		result = transformer.map(value);
		assertEquals("1234567890",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void mapNoDataPaddingWithPadToByteBoundaryLeft() throws FieldTransformerException {
//		field.addAttribute(PrimitiveTransformerNew.VALUE_REGEX,"^\\d{9}$");
		primitiveSpec.addAttribute(Fixed.LENGTH,"9");
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		BigInteger value = new BigInteger("123456789");
		result = transformer.map(value);
		assertEquals("0123456789",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void mapNoDataPaddingWithPadToByteBoundaryRight() throws FieldTransformerException {
//		field.addAttribute(PrimitiveTransformerNew.VALUE_REGEX,"^\\d{9}$");
		primitiveSpec.addAttribute(Fixed.LENGTH,"9");
		primitiveSpec.addAttribute(Packed.PAD_POSITION,Packed.PAD_POSITION_TRAILING);
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		BigInteger value = new BigInteger("123456789");
		result = transformer.map(value);
		assertEquals("1234567890",result.getEncoded());
		assertEquals(value,result.getValue());
	}

}
