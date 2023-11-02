package com.keeonline.fandango.iso8583.field.transformer.amount;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;

import com.keeonline.fandango.iso8583.field.spec.PrimitiveSpec;
import com.keeonline.fandango.iso8583.field.transformer.PrimitiveTransformer;
import com.keeonline.fandango.iso8583.field.transformer.TransformedField;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;
import com.keeonline.fandango.iso8583.field.transformer.util.Fixed;
import com.keeonline.fandango.iso8583.field.transformer.util.Formatted;
import com.keeonline.fandango.iso8583.field.transformer.util.Text;

public class ConversionRate extends PrimitiveTransformer{
    
	private int length;
	private String valueRegex;
	private String padChar;
	private String codePage;
	
	public ConversionRate(PrimitiveSpec config) throws FieldTransformerException {
		super(config);
		
		// load field attributes
		length = ((Integer)checkMandatory(getIntAttribute(Fixed.LENGTH))).intValue();
		valueRegex = getStringAttribute(PrimitiveTransformer.VALUE_REGEX);
		padChar = getStringAttribute(Formatted.PAD_CHAR);
		codePage = ((String)checkMandatory(getStringAttribute(Text.CODE_PAGE)));
		
		Fixed.validateLength(length);

		// default attributes if necessary
		if (valueRegex == null) valueRegex = "^[\\.0-9]{1,8}$";
		if (padChar == null) padChar = "0";
		
		// validate arguments
		PrimitiveTransformer.validateValueRegex(valueRegex);
		Formatted.validatePadChar(padChar);
	}

	@Override
	public TransformedField fill() throws FieldTransformerException {
		return null;
	}

	@Override
	public TransformedField map(Object valueObject) throws FieldTransformerException {
		return mapOrFill(valueObject);
	}
	
	private TransformedField mapOrFill(Object valueObject){		
		BigDecimal value = validateMapArguments(valueObject,valueRegex);
        int scale = value.scale();
        BigInteger amount = value.unscaledValue();
        String formatted =  String.format("%1d%07d", scale, amount);

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
        BigDecimal value = null;
    	try {
    		String formatted = Text.encodedToString(encoded,codePage);
            int scale = Integer.valueOf(formatted.substring(0,1));
            value = new BigDecimal(formatted.substring(1,length));
            value = value.movePointLeft(scale);
    	} catch (UnsupportedEncodingException e) {
    		// TODO create FieldTransformerException
    	}
        return getTransformedField(value,encoded,getFieldSpec());
    }

    private BigDecimal validateMapArguments(Object valueObject, String valueRegex) {
		if (!(valueObject instanceof BigDecimal)){
//			throw new ValueTypeException((FieldTransformer)this,
//					String.class.getSimpleName(),
//					valueObject.getClass().getSimpleName());
		}

		BigDecimal value = (BigDecimal)valueObject;

//		if (!(value.toString().matches(valueRegex))){
//			throw new FieldValueException((FieldTransformer)this,value,valueRegex);
//		}
		
		return value;	
	}
	

}
