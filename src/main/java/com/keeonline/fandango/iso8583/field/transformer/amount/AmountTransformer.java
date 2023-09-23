package com.keeonline.fandango.iso8583.field.transformer.amount;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.keeonline.fandango.iso8583.field.domain.financial.MonetaryAmount;
import com.keeonline.fandango.iso8583.field.spec.PrimitiveSpec;
import com.keeonline.fandango.iso8583.field.transformer.PrimitiveTransformer;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public abstract class AmountTransformer extends PrimitiveTransformer {
	
	protected AmountTransformer(PrimitiveSpec config) throws FieldTransformerException {
		super(config);		
	}
	
	protected MonetaryAmount validateMapArguments(Object valueObject, String valueRegex) {
		if (!(valueObject instanceof MonetaryAmount)){
//			throw new ValueTypeException((FieldTransformer)this,
//					String.class.getSimpleName(),
//					valueObject.getClass().getSimpleName());
		}

		MonetaryAmount value = (MonetaryAmount)valueObject;

//		if (!(value.toString().matches(valueRegex))){
//			throw new FieldValueException((FieldTransformer)this,value,valueRegex);
//		}
		
		return value;	
	}
	
	protected String format(MonetaryAmount value,int length){		
		BigDecimal bigDec = value.getAmount();
		BigInteger bigInt = bigDec.movePointRight(value.getCurrency().getDefaultFractionDigits()).toBigInteger();
		return String.format("%0" + length + "d",bigInt.intValue());		
	}


}
