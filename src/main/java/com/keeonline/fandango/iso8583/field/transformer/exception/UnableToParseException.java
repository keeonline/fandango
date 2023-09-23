package com.keeonline.fandango.iso8583.field.transformer.exception;

import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;

/**
 * 
 * Exception thrown by a field transformer class parse operation when the given parameter
 * set does not allow parsing (e.g. an invalid payload offset value is provided). 
 *
 */
public class UnableToParseException extends FieldTransformerException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4075715873569229492L;
	
	private String error;

	/**
	 * Constructor
	 * @param transformer The field transformer that instantiates this object
	 * @param error The error description
	 */
	public UnableToParseException(FieldTransformer transformer, String error){
		super(transformer);
		this.error = error;
	}

	/**
	 * Gets the parsing error description
	 * @return String containing error description
	 */
	@Override
	public String getMessage(){
		return "Unable to parse payload for current field configuration. " + 
				super.getCommonText() +
				" Error=" + error + ".";
	}

}
