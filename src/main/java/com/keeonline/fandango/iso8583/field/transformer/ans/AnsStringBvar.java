package com.keeonline.fandango.iso8583.field.transformer.ans;

import com.keeonline.fandango.iso8583.field.spec.PrimitiveSpec;
import com.keeonline.fandango.iso8583.field.transformer.TransformedField;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;
import com.keeonline.fandango.iso8583.field.transformer.util.Variable;

public class AnsStringBvar extends AnsStringVariable {
	
	public AnsStringBvar(PrimitiveSpec field) throws FieldTransformerException{
		super(field);
	}

	@Override
	public TransformedField getLengthField(PrimitiveSpec field,int chars,String codePage) throws FieldTransformerException {
		return Variable.mapLengthFieldBinary(field,chars);
	}

	@Override
	public TransformedField parseLengthField(PrimitiveSpec field, String payload, int offset, String codePage) 
			throws FieldTransformerException {
		return Variable.parseLengthFieldBinary(getPrimitiveSpec(),payload,offset);	
	}

}
