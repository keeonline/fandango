package com.keeonline.fandango.iso8583.field.transformer.temporal;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;

import com.keeonline.fandango.iso8583.field.domain.temporal.MonthDayTime;
import com.keeonline.fandango.iso8583.field.spec.PrimitiveSpec;
import com.keeonline.fandango.iso8583.field.transformer.TransformedField;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;
import com.keeonline.fandango.iso8583.field.transformer.util.Text;

public class MonthDayTimeString extends Temporal {

	private String codePage;

	public MonthDayTimeString(PrimitiveSpec field) throws FieldTransformerException{
		super(field);
		
		codePage = ((String)checkMandatory(getStringAttribute(Text.CODE_PAGE)));
		
		Text.validateCodePage(codePage);				
	}
	
	@Override
	public TransformedField map(Object valueObject) throws FieldTransformerException {
		if(!(valueObject instanceof LocalDateTime)) {
			//throw new ValueTypeException(this, MonthDayTime.class.getSimpleName(), value.getClass().getSimpleName());
		}
		LocalDateTime value = (LocalDateTime) valueObject;	
		String formatted = value.format(getFormatter());	
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
		String encoded = validateParseArguments(payload,offset,(getLength()*2));
		String formatted = null;
		try {
			formatted = Text.encodedToString(encoded.substring(0,getLength()*2),codePage);
		} catch (UnsupportedEncodingException e) {
			// TODO create FieldTransformerException
		}		
		LocalDateTime value = null;
		value = MonthDayTime.parse(formatted,getFormatString());
		return getTransformedField(value, encoded,getFieldSpec());
	}

}
