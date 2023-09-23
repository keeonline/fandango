package com.keeonline.fandango.iso8583.field.transformer;

import java.lang.reflect.Constructor;

import com.keeonline.fandango.iso8583.field.spec.ComplexSpec;
import com.keeonline.fandango.iso8583.field.spec.FieldSpec;
import com.keeonline.fandango.iso8583.field.spec.PrimitiveSpec;

public class FieldTransformerFactory {
    
	@SuppressWarnings("unchecked")
	public static FieldTransformer getTransformer(FieldSpec fieldSpec){
		FieldTransformer result = null;

		try {
			Constructor<?> con = null;
			if (fieldSpec instanceof PrimitiveSpec) {
				Class<? extends FieldTransformer> cl = (Class<? extends FieldTransformer>) Class.forName(fieldSpec.getTransformer());
				con = cl.getConstructor(PrimitiveSpec.class);
			}
			if (fieldSpec instanceof ComplexSpec) {
				Class<? extends FieldTransformer> cl = (Class<? extends FieldTransformer>) Class.forName(fieldSpec.getTransformer());
				con = cl.getConstructor(ComplexSpec.class);
			}
			result = (FieldTransformer) con.newInstance(fieldSpec);
		} catch (Exception e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
	
}
