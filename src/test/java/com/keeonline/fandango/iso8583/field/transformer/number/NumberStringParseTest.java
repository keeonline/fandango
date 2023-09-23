package com.keeonline.fandango.iso8583.field.transformer.number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TestBase;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public class NumberStringParseTest extends TestBase {
	
//	@Test
//	public void parsePayloadIsNull() throws FieldTransformerException {
//		thrown.expect(FieldTransformerException.class);			
//		field.addAttribute("value-regex","^\\d{10}$");
//		field.addAttribute("length","10");
//		field.addAttribute("code-page","cp1252");
//		PrimitiveTransformer transformer = new IntegerString(field);	
//		transformer.parse(null,0);
//		fail("FieldTransformerException exception should have been thrown");
//	}
//
//	@Test
//	public void parsePayloadIsEmpty() throws FieldTransformerException {
//		thrown.expect(FieldTransformerException.class);			
//		field.addAttribute("value-regex","^\\d{5}$");
//		field.addAttribute("length","5");
//		field.addAttribute("code-page","cp1252");
//		PrimitiveTransformer transformer = new IntegerString(field);	
//		transformer.parse("",0);
//		fail("FieldTransformerException exception should have been thrown");
//	}
//
//	@Test
//	public void parseOffsetLessThanZero() throws FieldTransformerException {
//		thrown.expect(FieldTransformerException.class);			
//		field.addAttribute("value-regex","^\\d{5}$");
//		field.addAttribute("length","5");
//		field.addAttribute("code-page","cp1252");
//		PrimitiveTransformer transformer = new IntegerString(field);	
//		transformer.parse("12345",-1);
//		fail("FieldTransformerException exception should have been thrown");
//	}
//
//	@Test
//	public void parsePayloadTooShort() throws FieldTransformerException {
//		thrown.expect(FieldTransformerException.class);			
//		field.addAttribute("value-regex","^\\d{4}$");
//		field.addAttribute("length","4");
//		field.addAttribute("code-page","cp1252");
//		PrimitiveTransformer transformer = new IntegerString(field);	
//		transformer.parse("12345",2);
//		fail("FieldTransformerException exception should have been thrown");
//	}
//
//	@Test
//	public void parseFieldNotWellFormed() throws FieldTransformerException {
//		thrown.expect(NotWellFormedException.class);			
//		field.addAttribute("value-regex","^\\d{10}$");
//		field.addAttribute("length","10");
//		field.addAttribute("code-page","cp1252");
//		PrimitiveTransformer transformer = new IntegerString(field);	
//		transformer.parse("2B313233343536373839",0);
//		fail("FieldRegexException exception should have been thrown");
//	}
//
//	@Test
//	public void parseBadValueValue() throws FieldTransformerException {
//		thrown.expect(FieldValueException.class);			
//		field.addAttribute("value-regex","^-([8][8]|[9][9])$");
//		field.addAttribute("length","3");		
//		field.addAttribute("code-page","cp1252");
//		field.addAttribute("sign-when","negative");
//		field.addAttribute("sign-positive","+");
//		field.addAttribute("sign-negative","-");
//		PrimitiveTransformer transformer = new IntegerString(field);	
//		result = transformer.parse("2D3838",0);
//		assertEquals("2D3838",result.getEncoded());
//		assertEquals(new BigInteger("-88"),result.getValue());
//		result = transformer.parse("2D3837",0);
//		fail("ValueRegexException exception should have been thrown");
//	}
//
//	@Test
//	public void parseNoSign() throws FieldTransformerException {
//		field.addAttribute("value-regex","^\\d{10}$");
//		field.addAttribute("length","10");
//		field.addAttribute("code-page","cp1252");
//		PrimitiveTransformer transformer = new IntegerString(field);	
//		String payload = "31323334353637383930";
//		result = transformer.parse(payload,0);
//		assertEquals(payload,result.getEncoded());
//		assertEquals(new BigInteger("1234567890"),result.getValue());
//	}
//	
//	// ASCII 2B = PLUS (+)
//	// ASCII 2D = MINUS (-)

	////////////////// SIGN LEADING TESTS ///////////////////

	@Test
	public void parseValueZero() throws FieldTransformerException {
//		field.addAttribute("value-regex","^-?\\d{1,3}$");
		primitiveSpec.addAttribute("length","3");
		primitiveSpec.addAttribute("code-page","cp1252");
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		String payload = "2B303030";
		result = transformer.parse(payload,2);
		assertEquals("303030",result.getEncoded());
		assertEquals(new BigInteger("0"),result.getValue());
	}

	@Test
	public void parseValueMoreThanZero() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{1,8}$");
		primitiveSpec.addAttribute("length","4");
		primitiveSpec.addAttribute("code-page","cp1252");
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		String payload = "2D30303938";
		result = transformer.parse(payload,2);
		assertEquals("30303938",result.getEncoded());
		assertEquals(new BigInteger("98"),result.getValue());
	}

}
