package com.keeonline.fandango.iso8583.field.transformer.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.transformer.UtilTestBase;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;
import com.keeonline.fandango.iso8583.field.transformer.util.Packed;

public class PackedTest extends UtilTestBase {

	@Test
	public void padPositionAttributeLeading() throws FieldTransformerException {
		Packed.validatePadPosition("leading");
	}

	@Test
	public void padPositionAttributeTrailing() throws FieldTransformerException {
		Packed.validatePadPosition("trailing");
	}

	@Test
	public void padPositionAttributeInvalid() throws FieldTransformerException {
		Packed.validatePadPosition("invalid");
	}

	@Test
	public void testGetLengthAdjustmentEven() throws FieldTransformerException {
		assertTrue(Packed.getLengthAdjustment(254) == 0);
	}

	@Test
	public void testGetLengthAdjustmentOdd() throws FieldTransformerException {
		assertTrue(Packed.getLengthAdjustment(255) == 1);
	}

	@Test
	public void testFromPackedEven() throws FieldTransformerException {
		assertEquals("1234567890123456",Packed.fromPacked("1234567890123456",16,"trailing","0"));
	}

	@Test
	public void testFromPackedOddLeadingPad() throws FieldTransformerException {
		assertEquals("123456789012345",Packed.fromPacked("0123456789012345",15,"leading","0"));
	}

	@Test
	public void testFromPackedOddTrailingPad() throws FieldTransformerException {
		assertEquals("123456789012345",Packed.fromPacked("1234567890123450",15,"trailing","0"));
	}

}
