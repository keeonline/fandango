package com.keeonline.fandango.iso8583.field.transformer.temporal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TestBase;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public class DateStringTest extends TestBase {
	
	@Test
	public void map() throws FieldTransformerException {
		primitiveSpec.addAttribute("format-string", "yyyyMMdd");
		primitiveSpec.addAttribute("code-page","Cp1252");
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		LocalDate value = LocalDate.of(2005,11,12);
		result = transformer.map(value);
		assertEquals("3230303531313132", result.getEncoded());
		assertEquals(value, result.getValue());
	}
	
	@Test
	public void parse() throws FieldTransformerException {
		// TODO
		// // primitiveSpec.addAttribute("format-string", "yyyyMMdd");
		// primitiveSpec.addAttribute("format-string", "MMdd");
		// primitiveSpec.addAttribute("code-page","Cp1047");
		// FieldTransformer transformer = getTransformer(primitiveSpec);
		// LocalDate value = LocalDate.of(1800,11,12);
		// result = transformer.parse("aaF1F8F0F0F1F1F1F2bb",2);
		// assertEquals("F1F8F0F0F1F1F1F2", result.getEncoded());
		// assertEquals(value, result.getValue());
	}
	
}
