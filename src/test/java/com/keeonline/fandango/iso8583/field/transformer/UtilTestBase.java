package com.keeonline.fandango.iso8583.field.transformer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import com.google.gson.Gson;

import com.keeonline.fandango.iso8583.field.spec.PrimitiveSpec;
import com.keeonline.fandango.iso8583.field.transformer.TransformedField;

// import org.junit.Before;
// import org.junit.jupiter.api.BeforeAll;
// import org.junit.rules.ExpectedException;

 public class UtilTestBase {

	protected PrimitiveSpec primitiveSpec;
	protected TransformedField result;

//     @Rule
//     public ExpectedException thrown = ExpectedException.none();
   
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
