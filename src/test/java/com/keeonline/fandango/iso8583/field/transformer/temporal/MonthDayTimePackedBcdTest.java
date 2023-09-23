package com.keeonline.fandango.iso8583.field.transformer.temporal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TestBase;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;
import com.keeonline.fandango.iso8583.field.domain.temporal.MonthDayTime;

import java.time.LocalDateTime;
import java.time.LocalDate;


public class MonthDayTimePackedBcdTest extends TestBase {
	
	@Test
	public void mapMonthDayTime() throws FieldTransformerException {
		primitiveSpec.addAttribute("format-string", "MMddHHmmss");
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		MonthDayTime value = MonthDayTime.of(12, 01, 23, 45, 59);	
		result = transformer.map(value);
		assertEquals("1201234559", result.getEncoded());
		assertEquals(value, result.getValue());
	}
	
	
	@Test
	public void parseMonthDayTime() throws FieldTransformerException {
		primitiveSpec.addAttribute("format-string", "MMddHHmmss");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		LocalDateTime value = LocalDateTime.of(LocalDate.now().getYear(), 12, 01, 23, 45, 59);
		result = transformer.parse("xxx1201234559yyy",3);
		assertEquals("1201234559", result.getEncoded());
		assertEquals(value, result.getValue());
	}
	
}
