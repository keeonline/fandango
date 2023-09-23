package com.keeonline.fandango.iso8583.field.domain.financial;

import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * Singleton wrapper class for the Java 8 java.util.Currency class.
 * 
 * It exists purely to enable the user to access currency information using the
 * numeric ISO 4712 numeric currency code (a facility that is not implemented in
 * java.util.Currency).
 * 
 */
public class Currencies {

	private static Currencies instance;
	
	private Map<Integer,Currency> currencies;
	
	private Currencies() {
		currencies = new HashMap<Integer,Currency>();
		Set<Currency> currencySet = Currency.getAvailableCurrencies();
		for (Currency currency : currencySet) {
			currencies.put(currency.getNumericCode(), currency);
		}
	}
	
	/**
	 * Gets the singleton instance of the Currencies class.
	 * 
	 * @return Currencies singleton
	 * 
	 */
	public synchronized static Currencies getInstance() {
		if (instance == null) {
			instance = new Currencies();
		}
		return instance;
	}
	
	/**
	 * Gets the currency object for the given locale.
	 * 
	 * @param locale Locale for which the currency object should be obtained.
	 * 
	 * @return Locale if known, otherwise null.
	 * 
	 */
	public Currency getCurrency(Locale locale) {
		try {
			return Currency.getInstance(locale);
		}
		catch (Exception e) {
			return null;
		}
	}

	/**
	 * Gets the currency object for the given ISO 4712 alphabetic currency code.
	 * 
	 * @param currencyCode ISO 4712 code for which the currency object should be obtained.
	 * 
	 * @return Currency object for currency code if known, otherwise null.
	 * 
	 */
	public Currency getCurrency(String currencyCode){
		
		try {
			return Currency.getInstance(currencyCode);
		}
		catch (Exception e) {
			return null;
		}
	}

	/**
	 * Gets the currency object for the given ISO 4712 numeric currency code.
	 * 
	 * @param currencyCode ISO 4712 code for which the currency object should be obtained.
	 * 
	 * @return Currency object for currency code if known, otherwise null.
	 * 
	 */
	public Currency getCurrency(Integer currencyCode){
		return currencies.get(currencyCode);
	}
	
	// TODO: create unit tests

}
