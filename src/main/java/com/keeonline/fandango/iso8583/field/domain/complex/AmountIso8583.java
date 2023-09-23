package com.keeonline.fandango.iso8583.field.domain.complex;

import java.math.BigInteger;
import java.util.Currency;

import com.keeonline.fandango.iso8583.field.domain.financial.MonetaryAmount;

public class AmountIso8583 {
	BigInteger amount;
	
	public void setAmount(BigInteger amount) {
		this.amount = amount;
	}

	public MonetaryAmount toMonetaryAmount(Currency currency){
		return null;
	}

}
