package com.keeonline.fandango.iso8583.field.transformer.number;

import com.keeonline.fandango.iso8583.field.spec.PrimitiveSpec;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public class NumberStringLLLvar extends NumberStringVariable {
	
	public NumberStringLLLvar(PrimitiveSpec field) throws FieldTransformerException{
		super(field,3);
	}

}
