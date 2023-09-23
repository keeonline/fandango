package com.keeonline.fandango.iso8583.field.transformer.util;


import com.keeonline.fandango.iso8583.field.spec.PrimitiveSpec;

public class Fields {

	public static PrimitiveSpec createField(String name, String description){
		PrimitiveSpec field = new PrimitiveSpec();
		field.setDescription(name);
		field.setName(description);
		return field;
    }
	    
}
