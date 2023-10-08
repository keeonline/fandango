package com.keeonline.fandango.iso8583.field.transformer.amount;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.domain.financial.MonetaryAmount;
import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TestBase;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public class AmountPackedBcdMapTest extends TestBase {
	
//	@Test
//	public void mapWrongInputType() throws FieldTransformerException {
//		thrown.expect(ValueTypeException.class);			
//		field.addAttribute("value-regex","^[0-9a-fA-F]{4}$");
//		field.addAttribute("length","4");		
//		field.addAttribute("code-page","Cp1047");		
//		PrimitiveTransformer transformer = new AnsString(field);	
//		transformer.map(new BigInteger("0123");
//		fail("InputTypeException exception should have been thrown");
//	}
//
//	@Test
//	public void mapShortValue() throws FieldTransformerException {
//		thrown.expect(InvalidValueException.class);			
//		field.addAttribute("value-regex","^[0-9a-fA-F]{4}$");
//		field.addAttribute("length","4");		
//		field.addAttribute("code-page","Cp1047");		
//		PrimitiveTransformer mapper = new AnsString(field);	
//		mapper.map("abc");
//	}
//
//	@Test
//	public void mapLongValue() throws FieldTransformerException {
//		thrown.expect(InvalidValueException.class);			
//		field.addAttribute("value-regex","^[0-9a-fA-F]{6}$");
//		field.addAttribute("length","6");		
//		field.addAttribute("code-page","Cp1047");		
//		PrimitiveTransformer mapper = new AnsString(field);	
//		mapper.map("abcdefg");
//	}
//
//	@Test
//	public void mapNoData() throws FieldTransformerException {
//		field.addAttribute("value-regex","^\\d{0,10}$");
//		field.addAttribute("length","10");
//		field.addAttribute("code-page","Cp1047");gth
//		PrimitiveTransformer mapper = new AnsString(field);	
//		String value = "";
//		result = transformer.map(value);
//		assertEquals("40404040404040404040",result.getEncoded());
//		assertEquals(value,result.getValue());
//	}

	@Test
	public void mapDecimal2Amount() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{12}$");
		primitiveSpec.addAttribute("length","12");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		// MonetaryAmount value = new MonetaryAmount(new BigDecimal("123.9"),"GBP");
		MonetaryAmount value = new MonetaryAmount(new BigInteger("12390"),new BigInteger("826"));
		result = transformer.map(value);
		assertEquals("000000012390",result.getEncoded());
		//assertEquals(value,result.getValue());
	}

	// @Test
	// public void mapDecimal4Amount() throws FieldTransformerException {
	// 	primitiveSpec.addAttribute("value-regex","^\\d{12}$");
	// 	primitiveSpec.addAttribute("length","12");
	// 	FieldTransformer transformer = getTransformer(primitiveSpec);
	// 	// MonetaryAmount value = new MonetaryAmount(new BigDecimal("123.9"),"CLF");
	// 	MonetaryAmount value = new MonetaryAmount(new BigInteger("1239000"),new BigInteger("826"));
	// 	result = transformer.map(value);
	// 	assertEquals("000001239000",result.getEncoded());
	// 	//assertEquals(value,result.getValue());
	// }

	
}
