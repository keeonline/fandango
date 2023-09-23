package com.keeonline.fandango.iso8583.field.transformer.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.transformer.UtilTestBase;
import com.keeonline.fandango.iso8583.field.transformer.util.Text;

public class TextTest extends UtilTestBase {

	@Test
	public void testStringToEncodedEbcdic() throws UnsupportedEncodingException {
		assertEquals("F1F2F3F4F5F6",Text.stringToEncoded("123456","cp1047"));
	}

	@Test
	public void testStringToEncodedAscii() throws UnsupportedEncodingException {
		assertEquals("313233343536",Text.stringToEncoded("123456","cp1252"));
	}

	@Test
	public void testEncodedToStringEbcdic() throws UnsupportedEncodingException {
		assertEquals("123456",Text.encodedToString("F1F2F3F4F5F6","cp1047"));
	}

	@Test
	public void testEncodedToStringAscii() throws UnsupportedEncodingException {
		assertEquals("123456",Text.encodedToString("313233343536","cp1252"));
	}

}
