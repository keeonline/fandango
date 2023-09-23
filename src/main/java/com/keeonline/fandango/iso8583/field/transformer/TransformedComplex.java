package com.keeonline.fandango.iso8583.field.transformer;

import java.util.ArrayList;
import java.util.List;

import com.keeonline.fandango.iso8583.field.spec.FieldSpec;

public class TransformedComplex extends TransformedField {

	private List<TransformedField> transformedFields;

	public TransformedComplex(Object value, String encoded, FieldSpec fieldSpec, List<TransformedField> subFields){
        super(value,encoded,fieldSpec);
		transformedFields = subFields;
	}

    public TransformedComplex(){
        super();
		transformedFields = new ArrayList<TransformedField>();
	}

    public void setTransformedFields(List<TransformedField> transformedFields) {
        this.transformedFields = transformedFields;
    }

	public List<TransformedField> getTransformedFields() {
        return transformedFields;
    }

    @Override
    public String report() {
		StringBuilder sb = new StringBuilder();

        sb.append(super.report());

        for (TransformedField transformedField : transformedFields) {
            sb.append(transformedField.report("        "));
        }

        return sb.toString();
    }

}
