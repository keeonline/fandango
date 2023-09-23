package com.keeonline.fandango.iso8583.field.transformer.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.transformer.UtilTestBase;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;
import com.keeonline.fandango.iso8583.field.transformer.util.Formatted;

public class FormattedTest extends UtilTestBase {

	@Test
	public void testJustifyAttributeLeft() throws FieldTransformerException {
		Formatted.validateJustify("left");
	}

	@Test
	public void testJustifyAttributeRight() throws FieldTransformerException {
		Formatted.validateJustify("right");
	}

	@Test
	public void testJustifyAttributeInvalid() throws FieldTransformerException {
		Formatted.validateJustify("invalid");
	}

	@Test
	public void padCharAttributeValid() throws FieldTransformerException {
		Formatted.validateJustify("0");
	}

	@Test
	public void padCharAttributeInvalid() throws FieldTransformerException {
		Formatted.validateJustify("00");
	}

	@Test
	public void testToJustifiedLeft() throws FieldTransformerException {
		String justified = Formatted.toJustified("123", 6, "left", "x");
		assertEquals("123xxx",justified);
	}

	@Test
	public void testToJustifiedRight() throws FieldTransformerException {
		String justified = Formatted.toJustified("123", 6, "right", "y");
		assertEquals("yyy123",justified);
	}

	@Test
	public void testToJustifiedNoEffect() throws FieldTransformerException {
		String justified = Formatted.toJustified("123456", 6, "left", "x");
		assertEquals("123456",justified);
		justified = Formatted.toJustified("123456", 6, "right", "y");
		assertEquals("123456",justified);
	}

}
