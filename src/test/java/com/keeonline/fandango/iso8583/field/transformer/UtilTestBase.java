package com.keeonline.fandango.iso8583.field.transformer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import com.google.gson.Gson;
import com.keeonline.fandango.iso8583.field.spec.PrimitiveSpec;

 public class UtilTestBase {

	protected PrimitiveSpec primitiveSpec;
	protected TransformedField result;

	@BeforeEach
	public void beforeTest(){
		primitiveSpec = new PrimitiveSpec();
		primitiveSpec.setDescription("xx");
		primitiveSpec.setName("junittest");
	}
		
	@AfterEach
	public void afterTest(){
		System.out.println(new Gson().toJson(result));
	}
	
}
