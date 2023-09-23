package com.keeonline.fandango.iso8583.field.domain.complex;

import java.math.BigInteger;

public class ProcessingCode {

	private BigInteger transactionType;

	private BigInteger accountTypeFrom;

	private BigInteger accountTypeTo;
	
	public ProcessingCode() {
		super();
		transactionType = new BigInteger("0");
		accountTypeFrom = new BigInteger("0");
		accountTypeTo = new BigInteger("0");
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("transactionType=" + transactionType);
		sb.append(", accountTypeFrom=" + accountTypeFrom);
		sb.append(", accountTypeTo=" + accountTypeTo);
		return sb.toString();
	}

	public BigInteger getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(BigInteger transactionType) {
		this.transactionType = transactionType;
	}

	public BigInteger getAccountTypeFrom() {
		return accountTypeFrom;
	}

	public void setAccountTypeFrom(BigInteger accountTypeFrom) {
		this.accountTypeFrom = accountTypeFrom;
	}

	public BigInteger getAccountTypeTo() {
		return accountTypeTo;
	}

	public void setAccountTypeTo(BigInteger accountTypeTo) {
		this.accountTypeTo = accountTypeTo;
	}
	
}
