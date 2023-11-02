package com.keeonline.fandango.iso8583.scheme.transformer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.keeonline.fandango.iso8583.field.spec.ComplexSpec;
import com.keeonline.fandango.iso8583.field.spec.FieldSpec;
import com.keeonline.fandango.iso8583.field.spec.PrimitiveSpec;
import com.keeonline.fandango.iso8583.field.transformer.complex.CardAcceptorNameLocationTransformer;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public class McbnCardAcceptorNameLocation extends CardAcceptorNameLocationTransformer {

	public McbnCardAcceptorNameLocation(ComplexSpec fieldSpec) throws FieldTransformerException {
		super(fieldSpec);
	}
	
	@Override
	protected Collection<FieldSpec> getSubFieldSpecs() {

		List<FieldSpec> subFieldSpecs = new ArrayList<>();
		PrimitiveSpec primitiveSpec;

		primitiveSpec = new PrimitiveSpec();		
		primitiveSpec.setName("DE43.1");
		primitiveSpec.setDescription("ATM Owning Institution or Terminal/Merchant Address or Both");	
		primitiveSpec.addAttribute("value-regex","^[a-zA-Z0-9 ]{1,22}$");
		primitiveSpec.addAttribute("length","23");
		primitiveSpec.addAttribute("code-page","cp1047");
		primitiveSpec.setTransformer("com.keeonline.fandango.iso8583.field.transformer.ans.AnsString");
		subFieldSpecs.add(primitiveSpec);	

		primitiveSpec = new PrimitiveSpec();		
		primitiveSpec.setName("DE43.2");
		primitiveSpec.setDescription("ATM or Merchant Location City");	
		primitiveSpec.addAttribute("value-regex","^[a-zA-Z0-9 ]{1,13}$");
		primitiveSpec.addAttribute("length","14");
		primitiveSpec.addAttribute("code-page","cp1047");
		primitiveSpec.setTransformer("com.keeonline.fandango.iso8583.field.transformer.ans.AnsString");
		subFieldSpecs.add(primitiveSpec);	

		primitiveSpec = new PrimitiveSpec();		
		primitiveSpec.setName("DE43.3");
		primitiveSpec.setDescription("ATM or Merchant State, Province, or Country Code Location");	
		primitiveSpec.addAttribute("value-regex","^[a-zA-Z]{3}$");
		primitiveSpec.addAttribute("length","3");
		primitiveSpec.addAttribute("justify","right");
		primitiveSpec.addAttribute("code-page","cp1047");
		primitiveSpec.setTransformer("com.keeonline.fandango.iso8583.field.transformer.ans.AnsString");
		subFieldSpecs.add(primitiveSpec);	

		return subFieldSpecs;
	}
    
}
