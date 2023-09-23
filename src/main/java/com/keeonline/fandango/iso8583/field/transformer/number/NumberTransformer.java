package com.keeonline.fandango.iso8583.field.transformer.number;

import java.math.BigInteger;

import com.keeonline.fandango.iso8583.field.spec.PrimitiveSpec;
import com.keeonline.fandango.iso8583.field.transformer.PrimitiveTransformer;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public abstract class NumberTransformer extends PrimitiveTransformer {
	
	protected NumberTransformer(PrimitiveSpec config) throws FieldTransformerException {
		super(config);		
	}
	
	protected BigInteger validateMapArguments(Object valueObject,String valueRegex) {
		if (!(valueObject instanceof BigInteger)){
//			throw new ValueTypeException((FieldTransformer)this,
//					String.class.getSimpleName(),
//					valueObject.getClass().getSimpleName());
		}

		BigInteger value = (BigInteger)valueObject;

		if (!(value.toString().matches(valueRegex))){
//			throw new FieldValueException((FieldTransformer)this,value,valueRegex);
		}
		
		return value;	
	}
	

}
