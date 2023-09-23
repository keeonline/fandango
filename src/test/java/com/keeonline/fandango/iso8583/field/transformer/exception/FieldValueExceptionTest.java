package com.keeonline.fandango.iso8583.field.transformer.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.spec.PrimitiveSpec;
import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldValueException;


public class FieldValueExceptionTest {
	
	@Test
	public void testConstructor(){
		FieldTransformer transformer = mock(FieldTransformer.class); 
		FieldValueException e = new FieldValueException(transformer,"FieldValue","ValueRegex");
		assertEquals("FieldValue",e.getValue());		
		assertEquals("ValueRegex",e.getValueRegex());		
	}

	@Test
	public void testGetMessage(){
		PrimitiveSpec field = mock(PrimitiveSpec.class);
		when(field.getName()).thenReturn("Mock-Field-Name");
		when(field.getDescription()).thenReturn("Mock-Field-Description");
		FieldTransformer transformer = mock(FieldTransformer.class);
		when(transformer.getFieldSpec()).thenReturn(field);
		FieldValueException e = new FieldValueException(transformer,"FieldValue","ValueRegex");
		assertTrue(e.getMessage().matches("The field value does not meet it's validation specification\\. Transformer=.*FieldTransformer.*\\. Field name=Mock-Field-Name\\. Field description=Mock-Field-Description\\. Field value=FieldValue\\. Validation regex=ValueRegex\\."));
	}

}
