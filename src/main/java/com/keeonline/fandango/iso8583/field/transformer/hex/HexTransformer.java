package com.keeonline.fandango.iso8583.field.transformer.hex;

import com.keeonline.fandango.iso8583.field.spec.PrimitiveSpec;
import com.keeonline.fandango.iso8583.field.transformer.PrimitiveTransformer;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldValueException;

public abstract class HexTransformer extends PrimitiveTransformer {
	
	public HexTransformer(PrimitiveSpec field) throws FieldTransformerException {
		super(field);
	}

	protected String validateMapArguments(Object valueObject,String valueRegex) throws FieldTransformerException {
		if (!(valueObject instanceof String)){
//			throw new ValueTypeException((FieldTransformer)this,
//					String.class.getSimpleName(),
//					valueObject.getClass().getSimpleName());
		}

		String s = (String)valueObject;
		
		if (!(s.matches(valueRegex))){
			throw new FieldValueException((PrimitiveTransformer)this,s,valueRegex);
		}
		return s;
	}

}
