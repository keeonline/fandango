package com.keeonline.fandango.iso8583.field.transformer.util;

import java.math.BigInteger;

import com.keeonline.fandango.iso8583.field.spec.PrimitiveSpec;
import com.keeonline.fandango.iso8583.field.transformer.FieldTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TransformedField;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;
import com.keeonline.fandango.iso8583.field.transformer.number.NumberBinary;
import com.keeonline.fandango.iso8583.field.transformer.number.NumberString;

public class Variable {

	public static final String LENGTH_MIN = "length-min";
	public static final String LENGTH_MAX = "length-max";

	public static int getFieldLength(int lengthMin,String valueString) {
		if (valueString.length() < lengthMin){
			return lengthMin;
		}
		else {
			return valueString.length();
		}
	}

	public static void validateLengths(int lengthMin, int lengthMax) {
		if (lengthMin <= 0){
			// TODO: throw exception
		}
		if (lengthMax <= 0){
			// TODO: throw exception
		}
		if (lengthMax < lengthMin){
			// TODO: throw exception
		}		
	}

	public static TransformedField mapLengthFieldBinary(PrimitiveSpec field, int length) throws FieldTransformerException  {
		PrimitiveSpec lengthField = Fields.createField(field.getName() + "-Length","Length field for " + field.getName());	
		FieldTransformer transformer;
		lengthField.addAttribute("value-regex","^\\d{1,3}$");
		lengthField.addAttribute(Fixed.LENGTH,"1");
		transformer = new NumberBinary(lengthField);	
		return transformer.map(new BigInteger(Integer.toString(length)));
	}
		
	public static TransformedField parseLengthFieldBinary(PrimitiveSpec field,String payload,int offset) throws FieldTransformerException {		
		PrimitiveSpec lengthField = Fields.createField(field.getName() + "-Length","Length field for " + field.getName());	
		FieldTransformer transformer;			
		lengthField.addAttribute("value-regex","^\\d{1,3}$");
		lengthField.addAttribute(Fixed.LENGTH,"1");
		transformer = new NumberBinary(lengthField);	
		return transformer.parse(payload,offset);
	}		

	public static TransformedField mapLengthFieldLn(PrimitiveSpec field,int dataLength,String codePage,int lengthFieldLength) 
			throws FieldTransformerException {
		FieldTransformer transformer = createLengthFieldLnTransformer(field,codePage,lengthFieldLength);
		return transformer.map(BigInteger.valueOf(dataLength));
	}
		
	public static TransformedField parseLengthFieldLn(PrimitiveSpec field,String payload,int offset,String codePage,int lengthFieldLength) 
			throws FieldTransformerException {
		FieldTransformer transformer = createLengthFieldLnTransformer(field,codePage,lengthFieldLength);
		return transformer.parse(payload,offset);
	}
		
	private static FieldTransformer createLengthFieldLnTransformer(PrimitiveSpec field,String codePage,int lengthFieldLength) 
			throws FieldTransformerException {
		PrimitiveSpec lengthField = Fields.createField(field.getName() + "-Length","Length field for " + field.getName());			   
		lengthField.addAttribute("value-regex","^\\d{1," + lengthFieldLength + "}$");
		lengthField.addAttribute("length",String.valueOf(lengthFieldLength));
		lengthField.addAttribute("code-page",codePage);
		return new NumberString(lengthField);	
	}

}
