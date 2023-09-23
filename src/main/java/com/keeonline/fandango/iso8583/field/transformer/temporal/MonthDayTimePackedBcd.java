package com.keeonline.fandango.iso8583.field.transformer.temporal;

import java.time.LocalDateTime;

import com.keeonline.fandango.iso8583.field.domain.temporal.MonthDayTime;
import com.keeonline.fandango.iso8583.field.spec.PrimitiveSpec;
import com.keeonline.fandango.iso8583.field.transformer.TransformedField;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;
import com.keeonline.fandango.iso8583.field.transformer.util.Packed;

public class MonthDayTimePackedBcd extends Temporal {

	public MonthDayTimePackedBcd(PrimitiveSpec field) throws FieldTransformerException{
		super(field);
	}
	
	@Override
	public TransformedField map(Object valueObject) throws FieldTransformerException {
		if(!(valueObject instanceof MonthDayTime)) {
			//throw new ValueTypeException(this, LocalDate.class.getSimpleName(), value.getClass().getSimpleName());
		}
		MonthDayTime value = (MonthDayTime) valueObject;	
		String formattedValue = value.format(getFormatter());	
		String encoded = Packed.toPacked(formattedValue,Packed.PAD_POSITION_LEADING,"0");
		return getTransformedField(value, encoded,getFieldSpec());		
	}

	@Override
	public TransformedField parse(String payload, int offset) throws FieldTransformerException {
		int adjustment = Packed.getLengthAdjustment(getLength());		
		String encoded = validateParseArguments(payload,offset,getLength()+adjustment);
		String formatted = Packed.fromPacked(encoded,getLength(),Packed.PAD_POSITION_LEADING,"0");		
		LocalDateTime value = MonthDayTime.parse(formatted,getFormatString());
		return getTransformedField(value, encoded,getFieldSpec());
	}

}
