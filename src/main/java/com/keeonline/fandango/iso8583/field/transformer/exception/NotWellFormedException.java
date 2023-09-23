package com.keeonline.fandango.iso8583.field.transformer.exception;

import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;

/**
 * Exception thrown by a field transformer class parsing operation when the field
 * content does not match the field characteristics defined in the field attribute
 * set. <br>The field characteristics are interpreted at run-time by field transformers
 * to dynamically generate a regular expression against which the field content is
 * matched. This exception is raised if the field contents do not match the generated 
 * regex.
 */
public class NotWellFormedException extends FieldTransformerException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4075715873569229492L;
	
	private String fieldContent;
	private String fieldRegex;

	/**
	 * Constructor
	 * @param transformer transformer The field transformer that instantiates this object
	 * @param fieldContent A string representing the field contents derived during parsing
	 * @param fieldRegex A generated regular expression used to determine that the field value was invalid
	 */
	public NotWellFormedException(FieldTransformer transformer,String fieldContent,String fieldRegex){
		super(transformer);
		this.fieldContent = fieldContent;
		this.fieldRegex = fieldRegex;
	}

	/**
	 * Gets the error description
	 * @return String containing error description
	 */
	@Override
	public String getMessage(){
		return "Field is not well-formed. " +
				super.getCommonText() +
				" Field Content =" + fieldContent + "." +
				" Field Regex=" + fieldRegex;
	}

	/** 
	 * Gets the value of the field
	 * @return The value of the field that failed validation
	 */
	public String getFieldContent() {
		return fieldContent;
	}

	/**
	 * The regular expression that determined the field to be invalid
	 * @return Field regex
	 */
	public String getFieldRegex() {
		return fieldRegex;
	}
	
}
