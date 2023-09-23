package com.keeonline.fandango.iso8583.field.transformer.complex;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.keeonline.fandango.iso8583.field.spec.ComplexSpec;
import com.keeonline.fandango.iso8583.field.spec.FieldSpec;
import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;
import com.keeonline.fandango.iso8583.field.transformer.FieldTransformerAbstract;
import com.keeonline.fandango.iso8583.field.transformer.FieldTransformerFactory;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public abstract class ComplexFieldTransformerAbstract extends FieldTransformerAbstract {
    
	protected Map<String,FieldSpec> subFieldSpecs;
	protected FieldTransformer [] subFieldTransformers;
	
	protected abstract Collection<FieldSpec> getSubFieldSpecs();

	public ComplexFieldTransformerAbstract(ComplexSpec fieldSpec, int numberOfSubfields) throws FieldTransformerException {
		super(fieldSpec);

		Collection<FieldSpec> subFieldSpecCollection = getSubFieldSpecs();

		subFieldSpecs = new HashMap<>();
		for (FieldSpec subFieldSpec : subFieldSpecCollection) {
			subFieldSpecs.put(subFieldSpec.getName(), subFieldSpec);
		} 
		this.subFieldTransformers = new FieldTransformer[numberOfSubfields];
		for (int i=0 ; i<numberOfSubfields ; i++){
			subFieldTransformers[i] = getSubFieldTransformer(i+1);
		}
	}

    protected FieldTransformer getSubFieldTransformer(int subFieldNumber){
		FieldTransformer result = null;

		String subFieldName = getFieldSpec().getName()+"."+Integer.toString(subFieldNumber);

		if (subFieldSpecs.containsKey(subFieldName)) {
			FieldSpec fieldSpec = subFieldSpecs.get(subFieldName);
			result = FieldTransformerFactory.getTransformer(fieldSpec);
		}

		return result;
	}

}
