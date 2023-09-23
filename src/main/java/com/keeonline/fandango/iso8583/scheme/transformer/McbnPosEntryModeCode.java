package com.keeonline.fandango.iso8583.scheme.transformer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.keeonline.fandango.iso8583.field.spec.ComplexSpec;
import com.keeonline.fandango.iso8583.field.spec.FieldSpec;
import com.keeonline.fandango.iso8583.field.spec.PrimitiveSpec;
import com.keeonline.fandango.iso8583.field.transformer.complex.PosEntryModeCodeTransformer;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public class McbnPosEntryModeCode extends PosEntryModeCodeTransformer {

	public McbnPosEntryModeCode(ComplexSpec fieldSpec) throws FieldTransformerException {
		super(fieldSpec);
	}
	
	@Override
	protected Collection<FieldSpec> getSubFieldSpecs() {

		List<FieldSpec> subFieldSpecs = new ArrayList<>();
		PrimitiveSpec primitiveSpec;

		primitiveSpec = new PrimitiveSpec();		
		primitiveSpec.setName("DE22.1");
		primitiveSpec.setDescription("POS Terminal PAN Entry Mode");	
		primitiveSpec.addAttribute("value-regex","^\\d{2}$");
		primitiveSpec.addAttribute("length","2");
		primitiveSpec.addAttribute("code-page","cp1047");
		primitiveSpec.setTransformer("com.keeonline.fandango.iso8583.field.transformer.number.NumberString");
		subFieldSpecs.add(primitiveSpec);

		primitiveSpec = new PrimitiveSpec();		
		primitiveSpec.setName("DE22.2");
		primitiveSpec.setDescription("POS Terminal PIN Entry Mode");	
		primitiveSpec.addAttribute("value-regex","^\\d{1}$");
		primitiveSpec.addAttribute("length","1");
		primitiveSpec.addAttribute("code-page","cp1047");
		primitiveSpec.setTransformer("com.keeonline.fandango.iso8583.field.transformer.number.NumberString");
		subFieldSpecs.add(primitiveSpec);

		return subFieldSpecs;
	}
    
}
