package com.keeonline.fandango.iso8583.field.transformer.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.spec.PrimitiveSpec;
import com.keeonline.fandango.iso8583.field.transformer.PrimitiveTransformer;
import com.keeonline.fandango.iso8583.field.transformer.exception.ValueTypeException;

public class ValueTypeExceptionTest {
	
	@Test
	public void testConstructor(){
		PrimitiveTransformer transformer = mock(PrimitiveTransformer.class); 
		ValueTypeException e = new ValueTypeException(transformer,"Expected","Received");
		assertEquals("Expected",e.getExpected());		
		assertEquals("Received",e.getReceived());		
	}

	@Test
	public void testGetMessage(){
		PrimitiveSpec field = mock(PrimitiveSpec.class);
		when(field.getName()).thenReturn("Mock-Field-Name");
		when(field.getDescription()).thenReturn("Mock-Field-Description");
		PrimitiveTransformer transformer = mock(PrimitiveTransformer.class);
		when(transformer.getPrimitiveSpec()).thenReturn(field);
		ValueTypeException e = new ValueTypeException(transformer,"Expected","Received");
		// assertTrue(e.getMessage().matches("Value type invalid for transformation\\. Transformer=.*PrimitiveTransformer.*\\. Field name=Mock-Field-Name\\. Field description=Mock-Field-Description\\. Expected=Expected\\. Received=Received\\."));
	}

}
