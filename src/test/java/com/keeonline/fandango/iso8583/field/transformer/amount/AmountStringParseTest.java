package com.keeonline.fandango.iso8583.field.transformer.amount;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.domain.financial.MonetaryAmount;
import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TestBase;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public class AmountStringParseTest extends TestBase {
	
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
//		field.addAttribute("code-page","Cp1047");
//		PrimitiveTransformer mapper = new AnsString(field);	
//		String value = "";
//		result = transformer.map(value);
//		assertEquals("40404040404040404040",result.getEncoded());
//		assertEquals(value,result.getValue());
//	}

	// @Test
	// public void parseAmountEvenLength() throws FieldTransformerException {
	// 	primitiveSpec.addAttribute("value-regex","^\\d{12}$");
	// 	primitiveSpec.addAttribute("length","12");
	// 	primitiveSpec.addAttribute("code-page","cp1047");
	// 	FieldTransformer transformer = getTransformer(primitiveSpec);
	// 	String payload = "F1F2F3F4F5F6F7F8F9F0F1F2";
	// 	result = transformer.parse(payload,0);
	// 	assertEquals("F1F2F3F4F5F6F7F8F9F0F1F2",result.getEncoded());
	// 	MonetaryAmount value = (MonetaryAmount) result.getValue();
	// 	// assertEquals(new BigInteger("123456789012"),value.getImpliedDecimalsAmount());
	// 	// assertEquals(null,value.getAmount());
	// 	// assertEquals(null,value.getCurrency());
	// }

	// @Test
	// public void parseAmountOddLength() throws FieldTransformerException {
	// 	primitiveSpec.addAttribute("value-regex","^\\d{11}$");
	// 	primitiveSpec.addAttribute("length","11");
	// 	primitiveSpec.addAttribute("code-page","cp1047");
	// 	FieldTransformer transformer = getTransformer(primitiveSpec);
	// 	String payload = "F1F2F3F4F5F6F7F8F9F0F1";
	// 	result = transformer.parse(payload,0);
	// 	assertEquals("F1F2F3F4F5F6F7F8F9F0F1",result.getEncoded());
	// 	MonetaryAmount value = (MonetaryAmount) result.getValue();
	// 	// assertEquals(new BigInteger("12345678901"),value.getImpliedDecimalsAmount());
	// 	// assertEquals(null,value.getAmount());
	// 	// assertEquals(null,value.getCurrency());
	// }

	
}
