package com.keeonline.fandango.iso8583.field.transformer.number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TestBase;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public class NumberBinaryMapTest extends TestBase {
	
	// TODO: change all validation regex so they define allowable range
//	@Test
//	public void mapWrongInputType() throws FieldTransformerException {
//		thrown.expect(ValueTypeException.class);	
//		field.addAttribute("value-regex","^\\d{4}$");
//		field.addAttribute("length","2");		
//		PrimitiveTransformer transformer = new IntegerBinary(field);	
//		transformer.map("0123");
//		fail("InputTypeException exception should have been thrown");
//	}
//
//	@Test
//	public void mapShortValue() throws FieldTransformerException {
//		thrown.expect(FieldValueException.class);			
//		field.addAttribute("value-regex","^\\d{4}$");
//		field.addAttribute("length","2");		
//		PrimitiveTransformer transformer = new IntegerBinary(field);	
//		transformer.map(new BigInteger("012");
//		fail("InputValidationException exception should have been thrown");
//	}
//
//	@Test
//	public void mapLongValue() throws FieldTransformerException {
//		thrown.expect(FieldValueException.class);
//		field.addAttribute("value-regex","^\\d{6}$");
//		field.addAttribute("length","6");
//		PrimitiveTransformer transformer = new IntegerBinary(field);	
//		transformer.map(new BigInteger("9876543");
//		fail("InputValidationException exception should have been thrown");
//	}
//
	@Test
	public void length1MaxUnsignedValueBE() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{1,3}$");
		primitiveSpec.addAttribute("length","1");
		primitiveSpec.addAttribute("byte-order","big-endian");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		BigInteger value = new BigInteger("255");
		result = transformer.map(value);
		assertEquals("FF",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void length1MaxUnsignedValueLE() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{1,3}$");
		primitiveSpec.addAttribute("length","1");
		primitiveSpec.addAttribute("byte-order","little-endian");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		BigInteger value = new BigInteger("255");
		result = transformer.map(value);
		assertEquals("FF",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void length1MinUnsignedValueBE() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^-?\\d{1,3}$");
		primitiveSpec.addAttribute("length","1");
		primitiveSpec.addAttribute("byte-order","big-endian");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		BigInteger value = new BigInteger("0");
		result = transformer.map(value);
		assertEquals("00",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void length1MinUnsignedValueLE() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^-?\\d{1,3}$");
		primitiveSpec.addAttribute("length","1");
		primitiveSpec.addAttribute("byte-order","little-endian");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		BigInteger value = new BigInteger("0");
		result = transformer.map(value);
		assertEquals("00",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void length1Value1BE() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{1,3}$");
		primitiveSpec.addAttribute("length","1");
		primitiveSpec.addAttribute("byte-order","big-endian");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		BigInteger value = new BigInteger("1");
		result = transformer.map(value);
		assertEquals("01",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void length1Value1LE() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{1,3}$");
		primitiveSpec.addAttribute("length","1");
		primitiveSpec.addAttribute("byte-order","little-endian");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		BigInteger value = new BigInteger("1");
		result = transformer.map(value);
		assertEquals("01",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void length8MaxUnsignedValueBE() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{1,20}$");
		primitiveSpec.addAttribute("length","8");
		primitiveSpec.addAttribute("byte-order","big-endian");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		BigInteger value = new BigInteger("18446744073709551615");
		result = transformer.map(value);
		assertEquals("FFFFFFFFFFFFFFFF",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void length8MaxUnsignedValueLE() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{1,20}$");
		primitiveSpec.addAttribute("length","8");
		primitiveSpec.addAttribute("byte-order","little-endian");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		BigInteger value = new BigInteger("18446744073709551615");
		result = transformer.map(value);
		assertEquals("FFFFFFFFFFFFFFFF",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void length8MinUnsignedValueBE() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^-?\\d{1,20}$");
		primitiveSpec.addAttribute("length","8");
		primitiveSpec.addAttribute("byte-order","big-endian");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		BigInteger value = new BigInteger("0");
		result = transformer.map(value);
		assertEquals("0000000000000000",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void length8MinUnsignedValueLE() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^-?\\d{1,20}$");
		primitiveSpec.addAttribute("length","8");
		primitiveSpec.addAttribute("byte-order","little-endian");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		BigInteger value = new BigInteger("0");
		result = transformer.map(value);
		assertEquals("0000000000000000",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void length8Value1BE() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{1,20}$");
		primitiveSpec.addAttribute("length","8");
		primitiveSpec.addAttribute("byte-order","big-endian");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		BigInteger value = new BigInteger("1");
		result = transformer.map(value);
		assertEquals("0000000000000001",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void length8Value1LE() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{1,20}$");
		primitiveSpec.addAttribute("length","8");
		primitiveSpec.addAttribute("byte-order","little-endian");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		BigInteger value = new BigInteger("1");
		result = transformer.map(value);
		assertEquals("0100000000000000",result.getEncoded());
		assertEquals(value,result.getValue());
	}

}
