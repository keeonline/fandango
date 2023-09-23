package com.keeonline.fandango.iso8583.field.transformer.temporal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TestBase;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public class DatePackedBcdTest extends TestBase {
	
	// MKcomment: there are a variety of date formats that ISO8583 uses...
	// "MMdd" as in test 'testDateFormat' is used in F13 (date, local transaction).
	// F14 (date, expiration) requires a 'format-string' attribute of "yyMM" (I think - best check)
	// as although it too is a date field, it comprises only the 2 digit year number and 2-digit month.
	// Have a scan of the 'date' fields in the Visa tech spec to get coverage of different date
	// formats and add tests accordingly.
	
	/**
	 * Tests the positive outcome of a well formatted BCD date.
	 * @throws FieldTransformerException
	 */
	@Test
	public void map() throws FieldTransformerException {
		primitiveSpec.addAttribute("format-string", "yyyyMMdd");
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		LocalDate value = LocalDate.of(2005,11,12);
		result = transformer.map(value);
		assertEquals("20051112", result.getEncoded());
		assertEquals(value, result.getValue());
	}
	
	@Test
	public void parse() throws FieldTransformerException {
		primitiveSpec.addAttribute("format-string", "yyyyMMdd");
		FieldTransformer transformer = getTransformer(primitiveSpec);
		result = transformer.parse("FF20051112FF",2);
		assertEquals("20051112", result.getEncoded());
		assertEquals(LocalDate.of(2005,11,12), result.getValue());
	}
	
	/**
	 * Tests the wrong format string input pattern.
	 * @throws FieldTransformerException
	 */
//	@Test(expected=DateTimeException.class)
//	public void testWrongFormatString() throws FieldTransformerException {
//		//exception.expect(DateTimeException.class);
//		field.addAttribute("format-string", "MMDD");
//		PrimitiveTransformer transformer = new DatePackedBcd(field);	
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
//		LocalDate value = LocalDate.parse("2005-Nov-12", formatter);
//		
//		transformer.map(value);
//	}
//	
//	/**
//	 * Tests wrong DateTime parser format.
//	 * @throws FieldTransformerException
//	 */
//	@Test(expected=DateTimeParseException.class)
//	public void testWrongDateTimeFormat() throws FieldTransformerException {
//		field.addAttribute("format-string", "MMdd");
//		PrimitiveTransformer transformer = new DatePackedBcd(field);	
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-DD");
//		LocalDate value = LocalDate.parse("2005-Nov-12", formatter);
//		
//		transformer.map(value);
//	}
//	
//	/**
//	 * Tests wrong LocalDate parser format.
//	 * @throws FieldTransformerException
//	 */
//	@Test(expected=DateTimeParseException.class)
//	public void testWrongLocalDateFormat() throws FieldTransformerException {
//		field.addAttribute("format-string", "MMdd");
//		PrimitiveTransformer transformer = new DatePackedBcd(field);	
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-DD");
//		LocalDate value = LocalDate.parse("2005-November-12", formatter);
//		
//		transformer.map(value);
//	}
//	
//	/**
//	 * Tests the correct exception is thrown when parsing a non LocalDate instance.
//	 * @throws FieldTransformerException
//	 */
//	@Test(expected=ValueTypeException.class)
//	public void testNotInstanceOfLocalDate() throws FieldTransformerException {
//		field.addAttribute("format-string", "MMdd");
//		PrimitiveTransformer transformer = new DatePackedBcd(field);	
//		Object value = new Object();
//		
//		transformer.map(value);
//	}

}
