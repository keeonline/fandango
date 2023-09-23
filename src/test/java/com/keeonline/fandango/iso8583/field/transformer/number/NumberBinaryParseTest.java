package com.keeonline.fandango.iso8583.field.transformer.number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TestBase;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public class NumberBinaryParseTest extends TestBase {
	
//	@Test
//	public void parsePayloadIsNull() throws FieldTransformerException {
//		thrown.expect(FieldTransformerException.class);			
//		field.addAttribute("value-regex","^\\d{1,3}$");
//		field.addAttribute("length","1");
//		field.addAttribute("byte-order","big-endian");
//		PrimitiveTransformer transformer = new IntegerBinary(field);
//		transformer.parse(null,0);
//		fail("FieldTransformerException exception should have been thrown");
//	}
//
//	@Test
//	public void parsePayloadIsEmpty() throws FieldTransformerException {
//		thrown.expect(FieldTransformerException.class);			
//		field.addAttribute("value-regex","^\\d{1,3}$");
//		field.addAttribute("length","1");
//		field.addAttribute("byte-order","big-endian");
//		PrimitiveTransformer transformer = new IntegerBinary(field);
//		transformer.parse("",0);
//		fail("FieldTransformerException exception should have been thrown");
//	}
//
//	@Test
//	public void parseOffsetLessThanZero() throws FieldTransformerException {
//		thrown.expect(FieldTransformerException.class);			
//		field.addAttribute("value-regex","^\\d{1,3}$");
//		field.addAttribute("length","1");
//		field.addAttribute("byte-order","big-endian");
//		PrimitiveTransformer transformer = new IntegerBinary(field);
//		transformer.parse("ABCDEF",-1);
//		fail("FieldTransformerException exception should have been thrown");
//	}
//
//	@Test
//	public void parsePayloadTooShort() throws FieldTransformerException {
//		thrown.expect(FieldTransformerException.class);			
//		field.addAttribute("value-regex","^\\d{1,3}$");
//		field.addAttribute("length","1");
//		field.addAttribute("byte-order","big-endian");
//		PrimitiveTransformer transformer = new IntegerBinary(field);
//		transformer.parse("ABC",2);
//		fail("FieldTransformerException exception should have been thrown");
//	}
//
	@Test
	public void length1MaxUnsignedValueBE() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{1,3}$");
		primitiveSpec.addAttribute("length","1");
		primitiveSpec.addAttribute("byte-order","big-endian");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String payload = "00FF00";
		result = transformer.parse(payload,2);
		BigInteger value = new BigInteger("255");
		assertEquals("FF",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void length1MaxUnsignedValueLE() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{1,3}$");
		primitiveSpec.addAttribute("length","1");
		primitiveSpec.addAttribute("byte-order","little-endian");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String payload = "00FF00";
		result = transformer.parse(payload,2);
		BigInteger value = new BigInteger("255");
		assertEquals("FF",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void length1MinUnsignedValueBE() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^-?\\d{1,3}$");
		primitiveSpec.addAttribute("length","1");
		primitiveSpec.addAttribute("byte-order","big-endian");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String payload = "000000";
		result = transformer.parse(payload,2);
		BigInteger value = new BigInteger("0");
		assertEquals("00",result.getEncoded());
		assertEquals(value,result.getValue());

	}

	@Test
	public void length1MinUnsignedValueLE() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^-?\\d{1,3}$");
		primitiveSpec.addAttribute("length","1");
		primitiveSpec.addAttribute("byte-order","little-endian");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String payload = "000000";
		result = transformer.parse(payload,2);
		BigInteger value = new BigInteger("0");
		assertEquals("00",result.getEncoded());
		assertEquals(value,result.getValue());

	}

	@Test
	public void length1Value1BE() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{1,3}$");
		primitiveSpec.addAttribute("length","1");
		primitiveSpec.addAttribute("byte-order","big-endian");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String payload = "0001FF";
		result = transformer.parse(payload,2);
		BigInteger value = new BigInteger("1");
		assertEquals("01",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void length1Value1LE() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{1,3}$");
		primitiveSpec.addAttribute("length","1");
		primitiveSpec.addAttribute("byte-order","little-endian");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String payload = "0001FF";
		result = transformer.parse(payload,2);
		BigInteger value = new BigInteger("1");
		assertEquals("01",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void length2MaxUnsignedValueBE() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{1,5}$");
		primitiveSpec.addAttribute("length","2");
		primitiveSpec.addAttribute("byte-order","big-endian");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String payload = "00FFFF00";
		result = transformer.parse(payload,2);
		BigInteger value = new BigInteger("65535");
		assertEquals("FFFF",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void length2MinUnsignedValueBE() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^-?\\d{1,3}$");
		primitiveSpec.addAttribute("length","2");
		primitiveSpec.addAttribute("byte-order","big-endian");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String payload = "00000000";
		result = transformer.parse(payload,2);
		BigInteger value = new BigInteger("0");
		assertEquals("0000",result.getEncoded());
		assertEquals(value,result.getValue());

	}

	@Test
	public void length2Value1BE() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{1,5}$");
		primitiveSpec.addAttribute("length","2");
		primitiveSpec.addAttribute("byte-order","big-endian");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String payload = "000001FF";
		result = transformer.parse(payload,2);
		BigInteger value = new BigInteger("1");
		assertEquals("0001",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void length4MaxUnsignedValueBE() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{1,10}$");
		primitiveSpec.addAttribute("length","4");
		primitiveSpec.addAttribute("byte-order","big-endian");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String payload = "00FFFFFFFF00";
		result = transformer.parse(payload,2);
		BigInteger value = new BigInteger("4294967295");
		assertEquals("FFFFFFFF",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void length4MinUnsignedValueBE() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^-?\\d{1,10}$");
		primitiveSpec.addAttribute("length","4");
		primitiveSpec.addAttribute("byte-order","big-endian");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String payload = "000000000000";
		result = transformer.parse(payload,2);
		BigInteger value = new BigInteger("0");
		assertEquals("00000000",result.getEncoded());
		assertEquals(value,result.getValue());

	}

	@Test
	public void length4Value1BE() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{1,10}$");
		primitiveSpec.addAttribute("length","4");
		primitiveSpec.addAttribute("byte-order","big-endian");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String payload = "0000000001FF";
		result = transformer.parse(payload,2);
		BigInteger value = new BigInteger("1");
		assertEquals("00000001",result.getEncoded());
		assertEquals(value,result.getValue());
	}


	@Test
	public void length8MaxUnsignedValueBE() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{1,20}$");
		primitiveSpec.addAttribute("length","8");
		primitiveSpec.addAttribute("byte-order","big-endian");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String payload = "00FFFFFFFFFFFFFFFF00";
		result = transformer.parse(payload,2);
		BigInteger value = new BigInteger("18446744073709551615");
		assertEquals("FFFFFFFFFFFFFFFF",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void length8MaxUnsignedValueLE() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{1,20}$");
		primitiveSpec.addAttribute("length","8");
		primitiveSpec.addAttribute("byte-order","little-endian");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String payload = "00FFFFFFFFFFFFFFFF00";
		result = transformer.parse(payload,2);
		BigInteger value = new BigInteger("18446744073709551615");
		assertEquals("FFFFFFFFFFFFFFFF",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void length8MinUnsignedValueBE() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^-?\\d{1,20}$");
		primitiveSpec.addAttribute("length","8");
		primitiveSpec.addAttribute("byte-order","big-endian");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String payload = "00000000000000000000";
		result = transformer.parse(payload,2);
		BigInteger value = new BigInteger("0");
		assertEquals("0000000000000000",result.getEncoded());
		assertEquals(value,result.getValue());

	}

	@Test
	public void length8MinUnsignedValueLE() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^-?\\d{1,20}$");
		primitiveSpec.addAttribute("length","8");
		primitiveSpec.addAttribute("byte-order","little-endian");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String payload = "00000000000000000000";
		result = transformer.parse(payload,2);
		BigInteger value = new BigInteger("0");
		assertEquals("0000000000000000",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void length8Value1BE() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{1,20}$");
		primitiveSpec.addAttribute("length","8");
		primitiveSpec.addAttribute("byte-order","big-endian");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String payload = "000000000000000001FF";
		result = transformer.parse(payload,2);
		BigInteger value = new BigInteger("1");
		assertEquals("0000000000000001",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void length8Value1LE() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{1,20}$");
		primitiveSpec.addAttribute("length","8");
		primitiveSpec.addAttribute("byte-order","little-endian");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		String payload = "000100000000000000FF";
		result = transformer.parse(payload,2);
		BigInteger value = new BigInteger("1");
		assertEquals("0100000000000000",result.getEncoded());
		assertEquals(value,result.getValue());
	}

}
