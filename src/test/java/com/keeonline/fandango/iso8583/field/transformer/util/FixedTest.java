package com.keeonline.fandango.iso8583.field.transformer.util;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.transformer.UtilTestBase;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;
import com.keeonline.fandango.iso8583.field.transformer.util.Fixed;

public class FixedTest extends UtilTestBase {

	@Test
	public void testLengthLessThanZero() throws FieldTransformerException {
		Fixed.validateLength(-1);
	}

	@Test
	public void testLengthZero() throws FieldTransformerException {
		Fixed.validateLength(0);
	}

	@Test
	public void testLengthGreaterThanZero() throws FieldTransformerException {
		Fixed.validateLength(1);
	}

}
