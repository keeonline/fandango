package com.keeonline.fandango.iso8583.field.transformer.ans;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

import com.keeonline.fandango.iso8583.field.spec.PrimitiveSpec;
import com.keeonline.fandango.iso8583.field.transformer.PrimitiveTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TransformedField;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;
import com.keeonline.fandango.iso8583.field.transformer.util.Formatted;
import com.keeonline.fandango.iso8583.field.transformer.util.Text;
import com.keeonline.fandango.iso8583.field.transformer.util.Variable;

public abstract class AnsStringVariable extends AnsTransformer {
	
	private int lengthMin;
	private int lengthMax;
	private String valueRegex;
	private String justify;
	private String padChar;
	private String codePage;
	
	public AnsStringVariable(PrimitiveSpec config) throws FieldTransformerException {
		super(config);
		
		// load field attributes
		lengthMin = ((Integer)checkMandatory(getIntAttribute(Variable.LENGTH_MIN))).intValue();
		lengthMax = ((Integer)checkMandatory(getIntAttribute(Variable.LENGTH_MAX))).intValue();

		// validate length attribute as it is used in default processing
		Variable.validateLengths(lengthMin,lengthMax);

		valueRegex = getStringAttribute(PrimitiveTransformer.VALUE_REGEX);
		justify = getStringAttribute(Formatted.JUSTIFY);
		padChar = getStringAttribute(Formatted.PAD_CHAR);
		codePage = ((String)checkMandatory(getStringAttribute(Text.CODE_PAGE)));
		
		// default attributes if necessary
		if (valueRegex == null) valueRegex = "^[0-9]\\d{" + lengthMin + "," + lengthMax + "}$";
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
	
	private TransformedField mapOrFill(Object valueObject) throws FieldTransformerException{	
		// map field length portion
		int chars = Variable.getFieldLength(lengthMin,valueObject.toString());	
		TransformedField lengthField = getLengthField(getPrimitiveSpec(),chars,codePage);
		
		// map value portion
		String value = validateMapArguments(valueObject,valueRegex);		
		String charString = Formatted.toJustified(value.toString(),chars,justify,padChar);	
		String encoded = null;
		try {
			encoded = Text.stringToEncoded(charString,codePage);
		} catch (UnsupportedEncodingException e) {
			// TODO create FieldTransformerException
		}

		// concatenate encoded length field and encoded data in resultant object
		return getTransformedField(value,(lengthField.getEncoded() + encoded),getFieldSpec());
	}

	public abstract TransformedField getLengthField(PrimitiveSpec field, int chars, String codePage)
			 throws FieldTransformerException ;

	public abstract TransformedField parseLengthField(PrimitiveSpec field,String payload,int offset,String codePage)
			 throws FieldTransformerException ;	

	@Override
	public TransformedField parse(String payload, int offset) throws FieldTransformerException {
		// parse length field to determine data length
		TransformedField lengthField = parseLengthField(getPrimitiveSpec(),payload,offset,codePage);	
		int chars = ((BigInteger)lengthField.getValue()).intValue();
		
		// parse data portion to determine value
		int dataOffset = offset+lengthField.getEncoded().length();
		String encoded = validateParseArguments(payload,dataOffset,chars*2);
		String formatted = null;
		try {
			formatted = Text.encodedToString(encoded,codePage);
		} catch (UnsupportedEncodingException e) {
			// TODO create FieldTransformerException
		}		
		String value = Formatted.trim(formatted,padChar);

		// concatenate encoded length field and encoded data in resultant object
		return getTransformedField(value,lengthField.getEncoded() + encoded, getFieldSpec());
	}

}
