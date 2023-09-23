package com.keeonline.fandango.iso8583.field.transformer.number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TestBase;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;
import com.keeonline.fandango.iso8583.field.transformer.util.Fixed;

public class NumberBinaryFillTest extends TestBase {

	@Test
	public void length1Fill() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{3}$");
		primitiveSpec.addAttribute(Fixed.LENGTH,"1");
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		result = transformer.fill();
		assertEquals("00",result.getEncoded());
		assertEquals(new BigInteger("0"),result.getValue());
	}

	@Test
	public void length2Fill() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{5}$");
		primitiveSpec.addAttribute(Fixed.LENGTH,"2");
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		result = transformer.fill();
		assertEquals("0000",result.getEncoded());
		assertEquals(new BigInteger("0"),result.getValue());
	}

	@Test
	public void length4Fill() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{12}$");
		primitiveSpec.addAttribute(Fixed.LENGTH,"4");
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		result = transformer.fill();
		assertEquals("00000000",result.getEncoded());
		assertEquals(new BigInteger("0"),result.getValue());
	}

	@Test
	public void length8Fill() throws FieldTransformerException {
		primitiveSpec.addAttribute("value-regex","^\\d{20}$");
		primitiveSpec.addAttribute(Fixed.LENGTH,"8");
		FieldTransformer transformer = getTransformer(primitiveSpec);	
		result = transformer.fill();
		assertEquals("0000000000000000",result.getEncoded());
		assertEquals(new BigInteger("0"),result.getValue());
	}

}
