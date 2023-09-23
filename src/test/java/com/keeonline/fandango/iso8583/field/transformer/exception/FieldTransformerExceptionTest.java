package com.keeonline.fandango.iso8583.field.transformer.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.field.spec.PrimitiveSpec;
import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;
import com.keeonline.fandango.iso8583.field.transformer.number.NumberPackedBcd;


public class FieldTransformerExceptionTest {
	
	@Test
	public void testConstructorWithoutException(){
		PrimitiveSpec field = mock(PrimitiveSpec.class);
		when(field.getName()).thenReturn("Mock-Field-Name");
		when(field.getDescription()).thenReturn("Mock-Field-Description");
		FieldTransformer transformer = mock(FieldTransformer.class); 
		when(transformer.getFieldSpec()).thenReturn(field);
		FieldTransformerException e = new FieldTransformerException(transformer);
		assertTrue(e.getMessage().matches("Unspecified exception\\. Transformer=.*FieldTransformer.*\\. Field name=Mock-Field-Name. Field description=Mock-Field-Description\\."));
	}

	@Test
	public void testConstructorWithException(){
		Exception ie = new Exception("test exception");
		PrimitiveSpec field = mock(PrimitiveSpec.class);
		when(field.getName()).thenReturn("Mock-Field-Name");
		when(field.getDescription()).thenReturn("Mock-Field-Description");
		FieldTransformer transformer = mock(FieldTransformer.class); 
		when(transformer.getFieldSpec()).thenReturn(field);
		FieldTransformerException e = new FieldTransformerException(transformer,ie);
		assertTrue(e.getMessage().matches("Runtime exception \\(see inner exception for details\\)\\. Transformer=.*FieldTransformer.*\\. Field name=Mock-Field-Name\\. Field description=Mock-Field-Description\\."));
		assertEquals(ie,e.getException());
		assertEquals("test exception",e.getException().getMessage());
	}

	@Test
	public void testGetDescription(){
		PrimitiveSpec field = mock(PrimitiveSpec.class);
		when(field.getDescription()).thenReturn("Mock Field Description");
		FieldTransformer transformer = mock(FieldTransformer.class);
		when(transformer.getFieldSpec()).thenReturn(field);
		FieldTransformerException e = new FieldTransformerException(transformer);
		assertEquals("Mock Field Description",e.getFieldDescription());
	}

	@Test
	public void testGetFieldName(){
		PrimitiveSpec field = mock(PrimitiveSpec.class);
		when(field.getName()).thenReturn("Mock Field Name");
		FieldTransformer transformer = mock(FieldTransformer.class);
		when(transformer.getFieldSpec()).thenReturn(field);
		FieldTransformerException e = new FieldTransformerException(transformer);
		assertEquals("Mock Field Name",e.getFieldName());
	}

	@Test
	public void testGetTransformerField(){
		PrimitiveSpec field = mock(PrimitiveSpec.class);
		FieldTransformer transformer = mock(FieldTransformer.class);
		when(transformer.getFieldSpec()).thenReturn(field);
		FieldTransformerException e = new FieldTransformerException(transformer);
		assertTrue(field == e.getTransformerField());
	}

	@Test
	public void testGetTransformerName(){
		PrimitiveSpec field = mock(PrimitiveSpec.class);
		FieldTransformer transformer = mock(NumberPackedBcd.class);
		when(transformer.getFieldSpec()).thenReturn(field);
		FieldTransformerException e = new FieldTransformerException(transformer);
		assertTrue(e.getTransformerName().contains("NumberPackedBcd"));
	}

	@Test
	public void testGetCommonText(){
		PrimitiveSpec field = mock(PrimitiveSpec.class);
		when(field.getName()).thenReturn("Mock-Field-Name");
		when(field.getDescription()).thenReturn("Mock-Field-Description");
		FieldTransformer transformer = mock(FieldTransformer.class);
		when(transformer.getFieldSpec()).thenReturn(field);
		FieldTransformerException e = new FieldTransformerException(transformer);
		assertTrue(e.getCommonText().matches("Transformer=.*FieldTransformer.*\\. Field name=Mock-Field-Name. Field description=Mock-Field-Description\\."));
	}

}
