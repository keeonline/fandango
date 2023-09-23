package com.keeonline.fandango.iso8583.field.transformer.temporal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TestBase;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;
import com.keeonline.fandango.iso8583.field.domain.temporal.MonthDayTime;

import java.time.LocalDateTime;
import java.time.LocalDate;

public class MonthDayTimeStringTest extends TestBase {
	
	@Test
	public void mapMonthDayTime() throws FieldTransformerException {
		// primitiveSpec.addAttribute("format-string", "MMddHHmmss");
		// primitiveSpec.addAttribute("code-page", "cp1252");
		// FieldTransformer transformer = getTransformer(primitiveSpec);	
		// LocalDateTime value = LocalDateTime.of(1800, 12, 01, 23, 45, 59);
		// result = transformer.map(value);
		// assertEquals("31323031323334353539", result.getEncoded());
		// assertEquals(value, result.getValue());
	}
	
	
	@Test
	public void parseMonthDayTime() throws FieldTransformerException {
		primitiveSpec.addAttribute("format-string", "MMddHHmmss");
		primitiveSpec.addAttribute("code-page", "cp1047");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		LocalDateTime value = LocalDateTime.of(LocalDate.now().getYear(), 12, 01, 23, 45, 59);
		result = transformer.parse("F0F0F0F1F2F0F1F2F3F4F5F5F9F0F0F0",6);		
		assertEquals("F1F2F0F1F2F3F4F5F5F9", result.getEncoded());
		assertEquals(value, result.getValue());
	}
	
}
