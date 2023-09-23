package com.keeonline.fandango.iso8583.message.transformer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.keeonline.fandango.iso8583.field.transformer.TransformedField;

/**
 * Stores a list of fields that comprise a message.
 * The order of fields in the list denote the order that they appear in the message.
 *  
 */
public class TransformedMessage {
	private Object value;
	private List<TransformedField> transformedFields;
	private Map<String,TransformedField> transformedFieldsMap;
	private BigInteger nextByteOffset;

	/**
	 * No arguments constructor for class
	 * 
	 */
	public TransformedMessage(){
		transformedFields = new ArrayList<TransformedField>();
		transformedFieldsMap = new HashMap<>();
		nextByteOffset = new BigInteger("0");
	}

	/**
	 * Returns the length of the encoded data (the encoded data is a concatenation
	 * of the encoded elements of all fields in the data list).
	 * 
	 * @return length of the encoded data in bytes
	 */
	public java.math.BigInteger getEncodedByteLength() {
		return nextByteOffset;
	}

	/**
	 * Returns a hexadecimal string representation of the encoded data. Two characters
	 * represent one byte in the returned string (i.e. each character represents a half
	 * byte (nibble)).
	 * 
	 * @return hexadecimal string representation of encoded data
	 */
	public String getEncoded(){
		StringBuilder sb = new StringBuilder();
		for (TransformedField field : transformedFields){
			sb.append(field.getEncoded());
		}
		return sb.toString();
	}

	/**
	 * Returns the list of TransformedField objects that comprise the transformed data.
	 * The order of fields in the list is the same as their order of appearance in the
	 * encoded payload.
	 * 
	 * @return list of fields comprising the data
	 */
	public List<TransformedField> getTransformedFields() {
		return transformedFields;
	}
	
	/**
	 * Returns the TransformedField objects that represents the named field.
	 * 
	 * @return Transformed object of the named field if the named field is present, otherwise null
	 */
	public TransformedField getFieldByName(String name) {
		if (transformedFieldsMap.containsKey(name)){
			return transformedFieldsMap.get(name);
		}
		return null;
	}
	
	/**
	 * Adds a field to the data list.
	 * 
	 * @param transformedField field to be added.
	 */
	public void addField(TransformedField transformedField){
		transformedFields.add(transformedField);
		transformedFieldsMap.put(transformedField.getName(), transformedField);
		nextByteOffset = nextByteOffset.add(transformedField.getEncodedByteLength());		
	}

	/**
	 * Adds the content of one TransformedData object to the contents of 
	 * this object.
	 * <p>Fields are appended to the fields contained in this object.
	 * 
	 * @param data object containing the data to be appended
	 */
	public void addData(TransformedMessage data) {
		transformedFields.addAll(data.getTransformedFields());
		nextByteOffset = nextByteOffset.add(data.getEncodedByteLength());	
	}

	/**
	 * Generates a report of the content of this object
	 * 
	 * @return a report of the object state
	 */
	public String report() {
		StringBuilder sb = new StringBuilder();
				
		sb.append("Encoded byte length of data: " + getEncodedByteLength() + '\n');
		sb.append("Endoded data: " + getEncoded().toString() + '\n');
		sb.append('\n');

		for (TransformedField field : transformedFields){
			sb.append(field.report());
		}
		
		sb.append('\n');
//		sb.append("Value POJO: " + getValue().toString() + '\n');		
		
		return sb.toString();
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
}
