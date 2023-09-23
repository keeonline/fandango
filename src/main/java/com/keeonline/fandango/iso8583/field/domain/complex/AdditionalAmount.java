package com.keeonline.fandango.iso8583.field.domain.complex;

import java.math.BigInteger;

import com.google.gson.annotations.SerializedName;

public class AdditionalAmount {
//	This is one occurrence of an additional amount that is part of up to 6 occurrences contained in Field 54
//	Each additional amount is 20 bytes long and contains 
//	a 2 byte account type, a 2 byte amount type, a 3 byte currency code, a 1 byte sign and 12 byte amount
//	The last 3 subfields are here combined into monetaryAmount
	@SerializedName("f54.1")
	private BigInteger accountType;
	@SerializedName("f54.2")
	private BigInteger amountType;
	@SerializedName("f54.3")
	private BigInteger currencyCode;
	@SerializedName("f54.4")
	private String sign;
	@SerializedName("f54.5")
	private BigInteger amount;
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append("accountType=" + accountType);
		sb.append(", amountType=" + amountType);
		sb.append(", currencyCode=" + currencyCode);
		sb.append(", sign=" + sign);
		sb.append(", amount=" + amount);
		sb.append("]");
		return sb.toString();
	}
	
	public BigInteger getAccountType() {
		return accountType;
	}
	
	public void setAccountType(BigInteger accountType) {
		this.accountType = accountType;
	}
	
	public BigInteger getAmountType() {
		return amountType;
	}
	
	public void setAmountType(BigInteger amountType) {
		this.amountType = amountType;
	}

	public BigInteger getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(BigInteger currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public BigInteger getAmount() {
		return amount;
	}

	public void setAmount(BigInteger amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((amountType == null) ? 0 : amountType.hashCode());
		result = prime * result + ((currencyCode == null) ? 0 : currencyCode.hashCode());
		result = prime * result + ((sign == null) ? 0 : sign.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AdditionalAmount))
			return false;
		AdditionalAmount other = (AdditionalAmount) obj;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (amountType == null) {
			if (other.amountType != null)
				return false;
		} else if (!amountType.equals(other.amountType))
			return false;
		if (currencyCode == null) {
			if (other.currencyCode != null)
				return false;
		} else if (!currencyCode.equals(other.currencyCode))
			return false;
		if (sign == null) {
			if (other.sign != null)
				return false;
		} else if (!sign.equals(other.sign))
			return false;
		return true;
	}
	
	
}
