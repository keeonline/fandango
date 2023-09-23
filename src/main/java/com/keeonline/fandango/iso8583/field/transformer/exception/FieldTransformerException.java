package com.keeonline.fandango.iso8583.field.transformer.exception;

import com.keeonline.fandango.iso8583.field.spec.FieldSpec;
import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;

/**
 * 
 * Base class for all exceptions thrown by classes that implement the FieldTransformer
 * interface.
 *
 */
public class FieldTransformerException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3729528028960728942L;

	private FieldTransformer transformer;
	private Exception exception;

	/**
	 * Constructor used by derived exception classes
	 * @param transformer Field configuration used by the transformer when the exception was thrown
	 */
	public FieldTransformerException(FieldTransformer transformer){
		this.transformer = transformer;
	}

	/**
	 * Constructor used when runtime exceptions are caught
	 * @param transformer Field configuration used by the transformer when the exception was thrown
	 * @param exception Inner exception caught during transformer processing
	 */
	public FieldTransformerException(FieldTransformer transformer,Exception exception){
		this.transformer = transformer;
		this.exception = exception;
	}

	/**
	 * Gets the message detailing the exception
	 * @return message string for exception
	 */
	public String getMessage(){
		if (exception == null) {
			return "Unspecified exception. " + getCommonText();
		}
		else {
			return "Runtime exception (see inner exception for details). " + getCommonText();
		}
	}

	/**
	 * Gets the configuration of the field that the transformer was processing
	 * @return Field configuration used by the transformer when the exception was thrown
	 */
	public FieldSpec getTransformerField(){
		return transformer.getFieldSpec();
	}

	/**
	 * Gets the transformer name that threw the exception
	 * @return Class name of the transformer the threw the exception
	 */
	public String getTransformerName() {
		return transformer.getClass().getSimpleName();
	}

	/**
	 * Gets the description of the field being processed
	 * @return Description of field being transformed when the exception was thrown
	 */
	public String getFieldDescription() {
		return transformer.getFieldSpec().getDescription();
	}

	/**
	 * Gets the name of the field being processed
	 * @return Name of field being transformed when the exception was thrown
	 */
	public String getFieldName() {
		return transformer.getFieldSpec().getName();
	}

	/**
	 * Gets the base message text for the exception
	 * @return Base message text for exception
	 */
	public String getCommonText() {
		return "Transformer=" + getTransformerName() + ". Field name=" + getFieldName() + ". Field description=" + getFieldDescription() + ".";
	}

	public Exception getException() {
		return exception;
	}

}
