package com.keeonline.fandango.iso8583.field.domain.complex;

import java.util.ArrayList;
import java.util.List;

public class AdditionalAmounts {
	
//	Additional Amounts (Field 54) consists of a one byte subfield containing the length of data following (20/40/60/80/100/120)
//	The data that follows is between 1 and 6 occurrences of AdditionalAmount
//	Each AdditionalAmount is 20 bytes long and contains 
//	a 2 byte account type, a 2 byte amount type and 16 bytes we call monetaryAmount	
//	private BigInteger lengthOfField;
	private List<AdditionalAmount> amounts;

	public List<AdditionalAmount> getAmounts() {
		if (amounts == null) {
			amounts = new ArrayList<AdditionalAmount>();
		}
		return amounts;
	}

	public void setAmounts(List<AdditionalAmount> amounts) {
		this.amounts = amounts;
	}

	public void addAmount(AdditionalAmount amount){
		if (getAmounts().size() <= 5){
			getAmounts().add(amount);
		}
	}

}
