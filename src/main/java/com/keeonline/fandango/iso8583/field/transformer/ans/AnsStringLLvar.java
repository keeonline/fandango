package com.keeonline.fandango.iso8583.field.transformer.ans;

import com.keeonline.fandango.iso8583.field.spec.PrimitiveSpec;
import com.keeonline.fandango.iso8583.field.transformer.TransformedField;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;
import com.keeonline.fandango.iso8583.field.transformer.util.Variable;

public class AnsStringLLvar extends AnsStringVariable {
	
	public AnsStringLLvar(PrimitiveSpec field) throws FieldTransformerException{
		super(field);
	}

	@Override
	public TransformedField getLengthField(PrimitiveSpec field,int chars, String codePage) throws FieldTransformerException {
		return Variable.mapLengthFieldLn(field,chars,codePage,2);
	}

	@Override
	public TransformedField parseLengthField(PrimitiveSpec field, String payload, int offset, String codePage) 
			throws FieldTransformerException {
		return Variable.parseLengthFieldLn(getPrimitiveSpec(),payload,offset,codePage,2);	
	}

}
