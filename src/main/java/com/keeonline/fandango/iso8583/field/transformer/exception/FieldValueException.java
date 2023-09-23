package com.keeonline.fandango.iso8583.field.transformer.exception;

import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;

/**
 * Exception thrown by a field transformer class when parsing or mapping when the 
 * data value does not conform to the validation regular expression that is configured
 * for the field.
 */
public class FieldValueException extends FieldTransformerException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4075715873569229492L;
	
	private String value;
	private String valueRegex;

	/**
	 * Constructor
	 * @param transformer transformer The field transformer that instantiates this object
	 * @param value Data value of the field
	 * @param valueRegex Validation regular expression used to determine that the field value was invalid
	 */
	public FieldValueException(FieldTransformer transformer,String value,String valueRegex){
		super(transformer);
		this.value = value;
		this.valueRegex = valueRegex;
	}

	/**
	 * Gets the error description
	 * @return String containing error description
	 */
	@Override
	public String getMessage(){
		return "The field value does not meet it's validation specification. " +
				super.getCommonText() +
				" Field value=" + value + "." +
				" Validation regex=" + valueRegex + ".";
	}

	/** 
	 * Gets the data value of the field
	 * @return The value of the data that failed validation
	 */
	public String getValue() {
		return value;
	}

	/**
	 * The validation regular expression that determined the field to be invalid
	 * @return Validation regex
	 */
	public String getValueRegex() {
		return valueRegex;
	}
	
}
