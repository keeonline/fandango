package com.keeonline.fandango.iso8583.field.transformer.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;
import com.keeonline.fandango.iso8583.field.transformer.exception.NotWellFormedException;

public class NotWellFormedExceptionTest {
	
	@Test
	public void testConstructor(){
		FieldTransformer transformer = mock(FieldTransformer.class); 
		NotWellFormedException e = new NotWellFormedException(transformer,"FieldContent","FieldRegex");
		assertEquals("FieldContent",e.getFieldContent());		
		assertEquals("FieldRegex",e.getFieldRegex());		
	}

//	@Test
//	public void testGetMessage(){
//		Field field = mock(Field.class);
//		when(field.getName()).thenReturn("Mock-Field-Name");
//		when(field.getDescription()).thenReturn("Mock-Field-Description");
//		FieldTransformerNew transformer = mock(FieldTransformerNew.class);
//		when(transformer.getField()).thenReturn(field);
//		NotWellFormedException e = new NotWellFormedException(transformer,"FieldContent","FieldRegex");
//		assertTrue(e.getMessage().matches("Value type invalid for transformation\\. Transformer=.*FieldTransformer.*\\. Field name=Mock-Field-Name\\. Field description=Mock-Field-Description\\. Expected=Expected\\. Received=Received\\.");
//	}

}
