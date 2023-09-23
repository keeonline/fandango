package com.keeonline.fandango.iso8583.field.transformer.ans;

import com.keeonline.fandango.iso8583.field.spec.PrimitiveSpec;
import com.keeonline.fandango.iso8583.field.transformer.PrimitiveTransformer;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public abstract class AnsTransformer extends PrimitiveTransformer {
	
	protected AnsTransformer(PrimitiveSpec primitiveSpec) throws FieldTransformerException {
		super(primitiveSpec);		
	}
	
	protected String validateMapArguments(Object valueObject,String valueRegex) {
		if (!(valueObject instanceof String)){
//			throw new ValueTypeException((FieldTransformer)this,
//					String.class.getSimpleName(),
//					valueObject.getClass().getSimpleName());
		}

		String value = (String)valueObject;

		if (!(value.toString().matches(valueRegex))){
//			throw new FieldValueException((FieldTransformer)this,value,valueRegex);
		}
		
		return value;	
	}

}
