package com.keeonline.fandango.iso8583.field.transformer.complex;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.keeonline.fandango.iso8583.field.domain.complex.PosEntryModeCode;
import com.keeonline.fandango.iso8583.field.spec.ComplexSpec;
import com.keeonline.fandango.iso8583.field.transformer.TransformedComplex;
import com.keeonline.fandango.iso8583.field.transformer.TransformedField;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public abstract class PosEntryModeCodeTransformer extends ComplexFieldTransformerAbstract {
    
	public PosEntryModeCodeTransformer(ComplexSpec fieldSpec) throws FieldTransformerException {
		super(fieldSpec,2);
	}

	@Override
	public TransformedField map(Object valueObject) throws FieldTransformerException {
		PosEntryModeCode value = (PosEntryModeCode)valueObject;
		
		List<TransformedField> transformedSubFields = new ArrayList<>();
		
	    transformedSubFields.add(subFieldTransformers[0].map(value.getPanEntryMode()));
	    transformedSubFields.add(subFieldTransformers[1].map(value.getPinEntryMode()));

		StringBuilder encodedField = new StringBuilder();
		for ( int i=0 ; i<2 ; i++ ) {
			encodedField.append(transformedSubFields.get(i).getEncoded());
		}
		
		return new TransformedComplex(value,encodedField.toString(),getFieldSpec(),transformedSubFields);
	}

	@Override
	public TransformedField parse(String payload, int initialOffset) throws FieldTransformerException {

		int offset = initialOffset;
		List<TransformedField> transformedSubFields = new ArrayList<>();
		StringBuilder encodedField = new StringBuilder();

		for ( int i=0 ; i<2 ; i++ ) {
			transformedSubFields.add(subFieldTransformers[i].parse(payload,offset));
			offset += transformedSubFields.get(i).getEncoded().length();
			encodedField.append(transformedSubFields.get(i).getEncoded());
		}

		PosEntryModeCode value = new PosEntryModeCode();
		value.setPanEntryMode((BigInteger)transformedSubFields.get(0).getValue());
		value.setPinEntryMode((BigInteger)transformedSubFields.get(1).getValue());

		return new TransformedComplex(value,encodedField.toString(),getFieldSpec(),transformedSubFields);
	}

}
