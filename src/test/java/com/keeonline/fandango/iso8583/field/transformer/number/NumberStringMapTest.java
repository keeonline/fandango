package com.keeonline.fandango.iso8583.field.transformer.number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TestBase;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public class NumberStringMapTest extends TestBase {

//	@Test
//	public void mapWrongInputType() throws FieldTransformerException {
//		thrown.expect(ValueTypeException.class);			
//		//field.addAttribute("value-regex","^\\d{4}$");
//		field.addAttribute("length","4");		
//		field.addAttribute("code-page","cp1047");
//		PrimitiveTransformer transformer = new IntegerString(field);	
//		transformer.map("0123");
//		fail("InputTypeException exception should have been thrown");
//	}
//
//	@Test
//	public void mapShortValue() throws FieldTransformerException {
//		thrown.expect(FieldValueException.class);			
//		//field.addAttribute("value-regex","^\\d{4}$");
//		field.addAttribute("length","4");		
//		field.addAttribute("code-page","cp1047");
//		PrimitiveTransformer transformer = new IntegerString(field);	
//		transformer.map(new BigInteger("012");
//		fail("InputValidationException exception should have been thrown");
//	}
//
//	@Test
//	public void mapLongValue() throws FieldTransformerException {
//		thrown.expect(FieldValueException.class);
//		field.addAttribute("value-regex","^\\d{6}$");
//		field.addAttribute("length","6");
//		PrimitiveTransformer transformer = new IntegerString(field);	
//		transformer.map(new BigInteger("9876543");
//		fail("InputValidationException exception should have been thrown");
//	}
//
	@Test
	public void mapNoPaddingEBCDIC() throws FieldTransformerException {
		//field.addAttribute("value-regex","^\\d{10}$");
		primitiveSpec.addAttribute("length","10");
		primitiveSpec.addAttribute("code-page","Cp1047");
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		BigInteger value = new BigInteger("1234567890");
		result = transformer.map(value);
		assertEquals("F1F2F3F4F5F6F7F8F9F0",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void mapNoPaddingASCII() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{10}$");
		primitiveSpec.addAttribute("length","10");
		primitiveSpec.addAttribute("code-page","Cp1252");
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		BigInteger value = new BigInteger("1234567890");
		result = transformer.map(value);
		assertEquals("31323334353637383930",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void mapPaddedEBCDIC() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{1,10}$");
		primitiveSpec.addAttribute("length","10");
		primitiveSpec.addAttribute("code-page","Cp1047");
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		BigInteger value = new BigInteger("9");
		result = transformer.map(value);
		assertEquals("F0F0F0F0F0F0F0F0F0F9",result.getEncoded());
		assertEquals(value,result.getValue());
	}

	@Test
	public void mapPaddedASCII() throws FieldTransformerException {
//		field.addAttribute("value-regex","^\\d{1,10}$");
		primitiveSpec.addAttribute("length","10");
		primitiveSpec.addAttribute("justify","left");
		primitiveSpec.addAttribute("code-page","Cp1252");
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		BigInteger value = new BigInteger("9");
		result = transformer.map(value);
		assertEquals("30303030303030303039",result.getEncoded());
		assertEquals(value,result.getValue());
	}
	

	@Test
	public void mapPad5() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{1,10}$");
		primitiveSpec.addAttribute("length","10");
		primitiveSpec.addAttribute("pad-char","5");
		primitiveSpec.addAttribute("justify","right");
		primitiveSpec.addAttribute("code-page","Cp1252");
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		BigInteger value = new BigInteger("9");
		result = transformer.map(value);
		assertEquals("35353535353535353539",result.getEncoded());
		assertEquals(value,result.getValue());
	}

}
