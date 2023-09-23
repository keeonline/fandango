package com.keeonline.fandango.iso8583.field.transformer.exception;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.spec.PrimitiveSpec;
import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;
import com.keeonline.fandango.iso8583.field.transformer.exception.UnableToParseException;

public class UnableToParseExceptionTest {
	
	@Test
	public void testGetMessage(){
		PrimitiveSpec field = mock(PrimitiveSpec.class);
		when(field.getName()).thenReturn("Mock-Field-Name");
		when(field.getDescription()).thenReturn("Mock-Field-Description");
		FieldTransformer transformer = mock(FieldTransformer.class);
		when(transformer.getFieldSpec()).thenReturn(field);
		UnableToParseException e = new UnableToParseException(transformer,"Error description");
		assertTrue(e.getMessage().matches("Unable to parse payload for current field configuration\\. Transformer=.*FieldTransformer.*\\. Field name=Mock-Field-Name\\. Field description=Mock-Field-Description\\. Error=Error description\\."));
	}

}
