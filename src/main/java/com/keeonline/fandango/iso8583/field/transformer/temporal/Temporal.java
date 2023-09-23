package com.keeonline.fandango.iso8583.field.transformer.temporal;

import java.time.format.DateTimeFormatter;

import com.keeonline.fandango.iso8583.field.spec.PrimitiveSpec;
import com.keeonline.fandango.iso8583.field.transformer.PrimitiveTransformer;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public abstract class Temporal extends PrimitiveTransformer {
	
	public static final String FORMAT_STRING = "format-string";
	
	private String formatString;
	
	public Temporal(PrimitiveSpec field) throws FieldTransformerException {
		super(field);
		
		formatString = ((String)checkMandatory(getStringAttribute(FORMAT_STRING)));
	}
	
	protected int getLength(){
		return formatString.length();
	}

	protected DateTimeFormatter getFormatter(){
		return DateTimeFormatter.ofPattern(formatString);
	}
	
	protected String getFormatString(){
		return formatString;
	}
	
}
