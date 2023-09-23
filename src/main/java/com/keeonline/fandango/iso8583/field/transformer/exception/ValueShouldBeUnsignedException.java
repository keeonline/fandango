package com.keeonline.fandango.iso8583.field.transformer.exception;

import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;

public class ValueShouldBeUnsignedException extends FieldTransformerException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4075715873569229492L;
	
	private String field;
	private String fieldRegex;
	
	// TODO: improve exception content

	public ValueShouldBeUnsignedException(FieldTransformer mapper,String field,String fieldRegex){
		super(mapper);
		this.field = field;
		this.fieldRegex = fieldRegex;
	}

	@Override
	public String getMessage(){
		return "Field is well-formed but should be unsigned for given value. " +
				super.getCommonText() +
				" Field Content =" + field + "." +
				" Field Regex=" + fieldRegex;
	}

	public String getValue() {
		return field;
	}

	public String getValueRegex() {
		return field;
	}
	
}
