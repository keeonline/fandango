package com.keeonline.fandango.iso8583.field.transformer.exception;

import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;

/**
 * 
 * Exception thrown by field transformer classes when the value object passed to a map
 * operation invalid for the transformer type.<br> For example, passing a value argument of 
 * type BigInteger to a string transformer's map method would result in an object of this 
 * exception class being thrown by the transformer.
 *
 */
public class ValueTypeException extends FieldTransformerException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4075715873569229492L;
	
	private String expected;
	private String received;

	/**
	 * Constructor
	 * @param transformer The field transformer that instantiates this object
	 * @param expected The expected value object type
	 * @param received The received value object type
	 */
	public ValueTypeException(FieldTransformer transformer, String expected, String received){
		super(transformer);
		this.expected = expected;
		this.received = received;
	}

	/**
	 * Gets the message text for this exception
	 * @return The message text
	 */
	@Override
	public String getMessage(){
		return "Value type invalid for transformation. " + 
				super.getCommonText() +
				" Expected=" + expected + "." +
				" Received=" + received + ".";
	}

	/**
	 * Gets the expected value object type
	 * @return the simple class name of the expected value object type
	 */
	public String getExpected() {
		return expected;
	}

	/** 
	 * Gets the received value object type
	 * @return the simple class name of the received value object type
	 */
	public String getReceived() {
		return received;
	}
	
}
