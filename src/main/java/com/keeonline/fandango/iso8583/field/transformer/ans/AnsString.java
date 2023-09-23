package com.keeonline.fandango.iso8583.field.transformer.ans;

import java.io.UnsupportedEncodingException;

import com.keeonline.fandango.iso8583.field.spec.PrimitiveSpec;
import com.keeonline.fandango.iso8583.field.transformer.PrimitiveTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TransformedField;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;
import com.keeonline.fandango.iso8583.field.transformer.util.Fixed;
import com.keeonline.fandango.iso8583.field.transformer.util.Formatted;
import com.keeonline.fandango.iso8583.field.transformer.util.Text;

public class AnsString extends AnsTransformer {
	
	private int length;
	private String valueRegex;
	private String justify;
	private String padChar;
	private String codePage;
	
	public AnsString(PrimitiveSpec spec) throws FieldTransformerException {
		super(spec);
		
		// load field attributes
		length = ((Integer)checkMandatory(getIntAttribute(Fixed.LENGTH))).intValue();
		valueRegex = getStringAttribute(PrimitiveTransformer.VALUE_REGEX);
		justify = getStringAttribute(Formatted.JUSTIFY);
		padChar = getStringAttribute(Formatted.PAD_CHAR);
		codePage = ((String)checkMandatory(getStringAttribute(Text.CODE_PAGE)));
		
		Fixed.validateLength(length);

		// default attributes if necessary
		if (valueRegex == null) valueRegex = "^.{0," + length + "}$";
		if (justify == null) justify = Formatted.JUSTIFY_LEFT;
		if (padChar == null) padChar = " ";
		
		// validate arguments
		PrimitiveTransformer.validateValueRegex(valueRegex);
		Formatted.validateJustify(justify);
		Formatted.validatePadChar(padChar);
		Text.validateCodePage(codePage);				
	}

	@Override
	public TransformedField fill() throws FieldTransformerException {
		return mapOrFill("");
	}

	@Override
	public TransformedField map(Object valueObject) throws FieldTransformerException {
		return mapOrFill(valueObject);
	}
	
	private TransformedField mapOrFill(Object valueObject){		
		String value = validateMapArguments(valueObject,valueRegex);
		
		String formatted = 
				Formatted.toJustified(value.toString(),length,justify,padChar);	
		
		String encoded = null;
		try {
			encoded = Text.stringToEncoded(formatted,codePage);
		} catch (UnsupportedEncodingException e) {
			// TODO create FieldTransformerException
		}
		
		return getTransformedField(value,encoded,getFieldSpec());
	}

	@Override
	public TransformedField parse(String payload, int offset) throws FieldTransformerException {
		String encoded = validateParseArguments(payload,offset,length*2);
		String formatted = null;
		try {
			formatted = Text.encodedToString(payload.substring(offset,offset+(length*2)),codePage);
		} catch (UnsupportedEncodingException e) {
			// TODO create FieldTransformerException
		}
		
		String value = Formatted.trim(formatted,padChar);
		
		return getTransformedField(value,encoded,getFieldSpec());
	}

}
