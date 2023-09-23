package com.keeonline.fandango.iso8583.field.transformer;

import java.math.BigInteger;

import com.keeonline.fandango.iso8583.field.spec.FieldSpec;

public class TransformedField {
	
	protected Object value;
	protected String encoded;
	protected FieldSpec fieldSpec;

	public TransformedField(){
        super();
	}

	public TransformedField(Object value, String encoded, FieldSpec fieldSpec){
		this.value = value;
		this.encoded = encoded;
		this.fieldSpec = fieldSpec;
	}

	public FieldSpec getFieldSpec() {
		return fieldSpec;
	}

	public void setFieldSpec(FieldSpec fieldSpec) {
		this.fieldSpec = fieldSpec;
	}

	public Object getValue() {
		return value;
	}
	
	public String getEncoded() {
		return encoded;
	}
	
	public BigInteger getEncodedByteLength(){
		return BigInteger.valueOf((encoded.length()/2));
	}

	public String getName() {
		return fieldSpec.getName();
	}

	public String getDescription() {
		return fieldSpec.getDescription();
	}

	public String report() {
		return report("");
	}

	public String report(String prefix) {
		StringBuilder sb = new StringBuilder();

		sb.append(prefix + "Name and description: " + getFieldSpec().getName()	+ " - " + getFieldSpec().getDescription() + '\n');
		sb.append(prefix + "Field value: " + value.toString() + '\n');
		sb.append(prefix + "Encoded byte length of field: " + getEncodedByteLength() + '\n');
		sb.append(prefix + "Encoded field: " + encoded + '\n');
		sb.append('\n');   // TODO: change to platform independent newline handling
		
		return sb.toString();
	}

}
