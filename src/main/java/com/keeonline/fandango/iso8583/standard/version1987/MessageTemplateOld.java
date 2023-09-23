package com.keeonline.fandango.iso8583.standard.version1987;

import java.math.BigInteger;

import com.google.gson.annotations.SerializedName;

public class MessageTemplateOld extends com.keeonline.fandango.iso8583.standard.common.MessageTemplateOld {

	@SerializedName("f4")
	private BigInteger amountTransaction;
	@SerializedName("f49")
	private BigInteger currencyCodeTransaction;

	@Override
	protected void setStandardSpecificFieldByNumber(Object field, int fieldNumber) {
		if ((fieldNumber > 0) && (fieldNumber < 193)) {

			switch (fieldNumber)
			{		

				case Fields.AMOUNT_TRANSACTION:
					setAmountTransaction((BigInteger) field); return; 

				// transaction amount currency code

			}			
		}
	}

	@Override
	protected Object getStandardSpecificFieldByNumber(int fieldNumber) {
		if ((fieldNumber > 0) && (fieldNumber < 193)) {

			switch (fieldNumber)
			{		
				case Fields.AMOUNT_TRANSACTION:
					return getAmountTransaction();
				case Fields.CURRENCY_CODE_TRANSACTION:
					return getCurrencyCodeTransaction();
			}
		
		}

		return null;
	}
	
	// F4
	public BigInteger getAmountTransaction() {
		return amountTransaction;
	}

	public void setAmountTransaction(BigInteger amountTransaction) {
		this.amountTransaction = amountTransaction;
		bitmaps.setFieldPresent(Fields.AMOUNT_TRANSACTION);
	}

	public boolean hasAmountTransaction() {
		return (amountTransaction != null);
	}
	
	// F49
	public BigInteger getCurrencyCodeTransaction() {
		return currencyCodeTransaction;
	}

	public boolean hasCurrencyCodeTransaction() {
		return (currencyCodeTransaction != null);
	}

    // @Override
    // public void setFieldByNumber(Object field,int fieldNumber) {
	// 	if ((fieldNumber > 0) && (fieldNumber < 193)) {

	// 		switch (fieldNumber)
	// 		{		
	// 		case Fields.CURRENCY_CODE_TRANSACTION:
	// 			setCurrencyCodeTransaction((BigInteger) field); return; 
    //         default:
    //             setFieldByNumber(field, fieldNumber); return;
	// 		}
		
	// 	}
	// }

    public void setCurrencyCodeTransaction(BigInteger currencyCodeTransaction) {
		this.currencyCodeTransaction = currencyCodeTransaction;
		bitmaps.setFieldPresent(Fields.CURRENCY_CODE_TRANSACTION);
	}

}
