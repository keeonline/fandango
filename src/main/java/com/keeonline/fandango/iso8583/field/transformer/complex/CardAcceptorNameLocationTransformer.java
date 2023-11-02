package com.keeonline.fandango.iso8583.field.transformer.complex;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.keeonline.fandango.iso8583.field.domain.complex.CardAcceptorNameLocation;
import com.keeonline.fandango.iso8583.field.spec.ComplexSpec;
import com.keeonline.fandango.iso8583.field.transformer.TransformedComplex;
import com.keeonline.fandango.iso8583.field.transformer.TransformedField;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public abstract class CardAcceptorNameLocationTransformer extends ComplexFieldTransformerAbstract  {

	public CardAcceptorNameLocationTransformer(ComplexSpec fieldSpec) throws FieldTransformerException {
		super(fieldSpec,3);
	}

	@Override
	public TransformedField map(Object valueObject) throws FieldTransformerException {
		CardAcceptorNameLocation value = (CardAcceptorNameLocation)valueObject;
		
		List<TransformedField> transformedSubFields = new ArrayList<>();
		
	    transformedSubFields.add(subFieldTransformers[0].map(value.getCardAcceptorOrAtmLocation()));
	    transformedSubFields.add(subFieldTransformers[1].map(value.getCityName()));
	    transformedSubFields.add(subFieldTransformers[2].map(value.getCountryCode()));

		StringBuilder encodedField = new StringBuilder();
		for ( int i=0 ; i<3 ; i++ ) {
			encodedField.append(transformedSubFields.get(i).getEncoded());
		}
		
		return new TransformedComplex(value,encodedField.toString(),getFieldSpec(),transformedSubFields);
	}

	@Override
	public TransformedField parse(String payload, int initialOffset) throws FieldTransformerException {

		int offset = initialOffset;
		List<TransformedField> transformedSubFields = new ArrayList<>();
		StringBuilder encodedField = new StringBuilder();

		for ( int i=0 ; i<3 ; i++ ) {
			transformedSubFields.add(subFieldTransformers[i].parse(payload,offset));
			offset += transformedSubFields.get(i).getEncoded().length();
			encodedField.append(transformedSubFields.get(i).getEncoded());
		}

		CardAcceptorNameLocation value = new CardAcceptorNameLocation();
		value.setCardAcceptorOrAtmLocation((String)transformedSubFields.get(0).getValue());
		value.setCityName((String)transformedSubFields.get(1).getValue());
		value.setCountryCode((String)transformedSubFields.get(2).getValue());

		return new TransformedComplex(value,encodedField.toString(),getFieldSpec(),transformedSubFields);
	}

}