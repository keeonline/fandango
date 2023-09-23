package com.keeonline.fandango.iso8583.field.transformer.number;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

import com.keeonline.fandango.iso8583.field.spec.PrimitiveSpec;
import com.keeonline.fandango.iso8583.field.transformer.PrimitiveTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TransformedField;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;
import com.keeonline.fandango.iso8583.field.transformer.util.Formatted;
import com.keeonline.fandango.iso8583.field.transformer.util.Text;
import com.keeonline.fandango.iso8583.field.transformer.util.Variable;

public abstract class NumberStringVariable extends NumberTransformer {
	
	private int lengthMin;
	private int lengthMax;
	private String valueRegex;
	private String padChar;
	private String codePage;
	
	private int lengthFieldLength;
	
	public NumberStringVariable(PrimitiveSpec config, int lengthFieldLength) throws FieldTransformerException {
		super(config);
		
		// load field attributes
		lengthMin = ((Integer)checkMandatory(getIntAttribute(Variable.LENGTH_MIN))).intValue();
		lengthMax = ((Integer)checkMandatory(getIntAttribute(Variable.LENGTH_MAX))).intValue();

		// validate length attribute as it is used in default processing
		Variable.validateLengths(lengthMin,lengthMax);

		valueRegex = getStringAttribute(PrimitiveTransformer.VALUE_REGEX);
		padChar = getStringAttribute(Formatted.PAD_CHAR);
		codePage = ((String)checkMandatory(getStringAttribute(Text.CODE_PAGE)));
		
		// default attributes if necessary
		if (valueRegex == null) valueRegex = "^[0-9]\\d{" + lengthMin + "," + lengthMax + "}$";
		if (padChar == null) padChar = "0";
		
		// validate arguments
		PrimitiveTransformer.validateValueRegex(valueRegex);
		Formatted.validatePadChar(padChar);
		Text.validateCodePage(codePage);
		
		this.lengthFieldLength = lengthFieldLength;
	}

	@Override
	public TransformedField fill() throws FieldTransformerException {
		return mapOrFill(new BigInteger("0"));
	}

	@Override
	public TransformedField map(Object valueObject) throws FieldTransformerException {
		return mapOrFill(valueObject);
	}
	
	private TransformedField mapOrFill(Object valueObject) throws FieldTransformerException{	
		// map field length portion
		int digits = Variable.getFieldLength(lengthMin,valueObject.toString());	
		TransformedField lengthField = Variable.mapLengthFieldLn(getPrimitiveSpec(),digits,codePage,lengthFieldLength);
		
		// map value portion
		BigInteger value = validateMapArguments(valueObject,valueRegex);		
		String digitString = Formatted.toJustified(value.toString(),digits,Formatted.JUSTIFY_RIGHT,padChar);	
		String encoded = null;
		try {
			encoded = Text.stringToEncoded(digitString,codePage);
		} catch (UnsupportedEncodingException e) {
			// TODO create FieldTransformerException
		}

		// concatenate encoded length field and encoded data in resultant object
		return getTransformedField(value,(lengthField.getEncoded() + encoded),getFieldSpec());
	}

	@Override
	public TransformedField parse(String payload, int offset) throws FieldTransformerException {
		// parse length field to determine data length
		TransformedField lengthField = Variable.parseLengthFieldLn(getPrimitiveSpec(),payload,offset,codePage,lengthFieldLength);	
		int digits = ((BigInteger)lengthField.getValue()).intValue();
		
		// parse data portion to determine value
		int dataOffset = offset+lengthField.getEncoded().length();
		String encoded = validateParseArguments(payload,dataOffset,digits*2);
		String formatted = null;
		try {
			formatted = Text.encodedToString(payload.substring(dataOffset,dataOffset+(digits*2)),codePage);
		} catch (UnsupportedEncodingException e) {
			// TODO create FieldTransformerException
		}
		
		BigInteger value = null;
		
		try {
			value = new BigInteger(formatted);
		}
		catch (NumberFormatException e){
			// convert to FieldTransformerException and throw
			e.printStackTrace();
		}
				
		// concatenate encoded length field and encoded data in resultant object
		return getTransformedField(value,lengthField.getEncoded() + encoded,getFieldSpec());
	}

}
