package com.keeonline.fandango.iso8583.field.domain.financial;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Currency;

import static java.util.Objects.nonNull;

/**
 * Class for processing monetary amounts.
 * 
 * Holds both the amount value and the currency of the amount.
 * 
 */
public class MonetaryAmount {
	private BigDecimal amount;
	private Currency currency;	
	// private BigInteger impliedDecimalsAmount;
	
	/**
	 * No argument constructor.
	 */
	public MonetaryAmount() {
				System.out.println("********* HERE!!!!!");
	}
	
	/**
	 * Constructor that initialises the 'implied decimals' amount value.
	 * If a currency is subsequently set for the MonetaryAmount, this value is
	 * used to set the amount by adjusting the 'implied decimal' value by the
	 * amount of decimals used by the given currency.
	 * <br>For example, if the implied decimal amount is '123450' and the currency
	 * is set to be GBP, the amount value will be set to '1234.50' because the ISO4712
	 * standard defines 2 decimal places for the currency GBP.
	 * 
	 * @param amount Amount value.
	 * 
	 */
	// public MonetaryAmount(BigInteger amount) {
	// 	// setImpliedDecimalsAmount(amount);
	// }
	
	// /**
	//  * Constructor that initialises both the amount and currency values.
	//  * 
	//  * @param amount Amount value.
	//  * @param currency Currency of the amount.
	//  * 
	//  */
	// public MonetaryAmount(BigDecimal amount, Currency currency) {
	// 	setAmount(amount);
	// 	setCurrency(currency);
	// 	// BigDecimal impliedDecimalsBigDecimal = amount;
	// 	// for ( int i=0 ; i<currency.getDefaultFractionDigits() ; i++ ){
	// 	// 	impliedDecimalsBigDecimal = impliedDecimalsBigDecimal.multiply(BigDecimal.valueOf(10L));
	// 	// }
	// 	// setImpliedDecimalsAmount(impliedDecimalsBigDecimal.toBigInteger());
	// }
	
	public MonetaryAmount(BigInteger amount, BigInteger currencyCode) {
		setCurrency(Currencies.getInstance().getCurrency(currencyCode.intValue()));
		setAmount(new BigDecimal(amount.toString()));
		System.out.println("********* " + amount.toString() + " " + currencyCode.toString());
		for ( int i=0 ; i<currency.getDefaultFractionDigits() ; i++ ){
			this.amount = this.amount.divide(BigDecimal.valueOf(10L));
		}
		// setImpliedDecimalsAmount(amount);
	}
	
	/**
	 * Constructor that initialises both the amount and currency values.
	 * 
	 * @param amount Amount value.
	 * @param currencyCode ISO 4712 alphabetic currency code of the amount.
	 * 
	 */
	// public MonetaryAmount(BigDecimal amount, String currencyCode) {
	// 	setAmount(amount);
	// 	setCurrency(currencyCode);
	// }
	
	// /**
	//  * Constructor that initialises both the amount and currency values.
	//  * 
	//  * @param amount Amount value.
	//  * @param currencyCode ISO 4712 numeric currency code of the amount.
	//  * 
	//  */
	// public MonetaryAmount(BigDecimal amount, Integer currencyCode) {
	// 	setAmount(amount);
	// 	setCurrency(currencyCode);
	// }
	
	// /**
	//  * Constructor that initialises both the amount and currency values.
	//  * 
	//  * @param amount Amount value.
	//  * @param currencyCode ISO 4712 numeric currency code of the amount.
	//  * 
	//  */
	// public MonetaryAmount(BigDecimal amount, BigInteger currencyCode) {
	// 	setAmount(amount);
	// 	Integer code = Integer.valueOf(currencyCode.toString());
	// 	setCurrency(code);
	// }
	
	/**
	 * Gets the amount value.
	 * 
	 * @return Amount value, or null if the amount has not been set.
	 * 
	 */
	public BigDecimal getAmount() {
		return amount;
	}
	
	/**
	 * Sets the amount value.
	 * 
	 * @param amount Amount value.
	 * 
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	/**
	 * Gets the currency in which the amount is expressed.
	 * 
	 * @return Currency of amount, or null if the currency has not been set.
	 * 
	 */
	public Currency getCurrency() {
		return currency;
	}
	
	public BigInteger getBigIntegerCurrency() {
		return BigInteger.valueOf(currency.getNumericCode());
	}
	
	/**
	 * Sets the currency value.
	 * 
	 * @param currency Currency of the amount.
	 * 
	 */
	public void setCurrency(Currency currency) {
		this.currency = currency;
		refresh();
	}
	
	/**
	 * Sets the currency value.
	 * 
	 * @param currencyCode ISO 4712 alphabetic currency code of the amount.
	 * 
	 */
	public void setCurrency(String currencyCode) {
		this.currency = Currencies.getInstance().getCurrency(currencyCode);
		refresh();
	}
	
	/**
	 * Sets the currency value.
	 * 
	 * @param currencyCode ISO 4712 numeric currency code of the amount.
	 * 
	 */
	public void setCurrency(Integer currencyCode) {
		this.currency = Currencies.getInstance().getCurrency(currencyCode);
		refresh();
	}
	
	/**
	 * Gets the 'implied decimals' amount.
	 * 
	 * @return integer amount, with implied decimal place.
	 * 
	 */
	public BigInteger getImpliedDecimalsAmount() {
		// if (nonNull(impliedDecimalsAmount)) {
		// 	return impliedDecimalsAmount;
		// }


		if ((nonNull(amount)) && (nonNull(currency))) {
			BigDecimal impliedDecimalsBigDecimal = amount;
			for ( int i=0 ; i<currency.getDefaultFractionDigits() ; i++ ){
				impliedDecimalsBigDecimal = impliedDecimalsBigDecimal.multiply(BigDecimal.valueOf(10L));
			}
		    return impliedDecimalsBigDecimal.toBigInteger();
		}

		return null;
	}

	/**
	 * Sets the 'implied decimals' amount.
	 * 
	 * @param impliedDecimalsAmount amount with implied decimal place.
	 * 
	 */
	// public void setImpliedDecimalsAmount(BigInteger impliedDecimalsAmount) {
	// 	this.impliedDecimalsAmount = impliedDecimalsAmount;
	// }
	
	public boolean isPositive(){
		if (amount != null){
			if (amount.compareTo(BigDecimal.ZERO) < 0){
				return false;
			}
		}
		return true;
	}
	
	public boolean isNegative(){
		return !isPositive();
	}
	
	public void negate(){
		if ((amount != null) && (isPositive())) {
			amount = amount.negate();
		}
	}
	
	private void refresh(){
		// if (amount == null){
		// 	if ((currency != null) && (impliedDecimalsAmount != null)){
		// 		amount = new BigDecimal(impliedDecimalsAmount);
		// 		amount = amount.movePointLeft(currency.getDefaultFractionDigits());
		// 	}
		// }
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((currency == null) ? 0 : currency.getCurrencyCode().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MonetaryAmount other = (MonetaryAmount) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.getCurrencyCode().equals(other.currency.getCurrencyCode()))
			return false;
		return true;
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		if (amount != null) sb.append("amount=" + amount.toString() + " ");
		if (currency != null) sb.append("currency=" + currency.getCurrencyCode() + " ");
		// if (impliedDecimalsAmount != null) sb.append("impliedDecimalsAmount=" + impliedDecimalsAmount.toString() + " ");
		return sb.toString();
	}

	
}
