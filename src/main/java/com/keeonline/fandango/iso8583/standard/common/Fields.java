package com.keeonline.fandango.iso8583.standard.common;

public interface Fields {
	
	public static final String FIELD_NAME_PREFIX = "F";
	
	public static final String MESSAGE_TYPE_INDICATOR_DESC = "Message Type Indicator";
	public static final String MESSAGE_TYPE_INDICATOR_NAME = "MTI";
	
	public static final String BITMAP_PRIMARY_DESC = "Bitmap, Primary";
	public static final String BITMAP_PRIMARY_NAME = "BMP";
	
	
	public static final int BITMAP_SECONDARY = 1;
	public static final String BITMAP_SECONDARY_DESC = "Bitmap, Secondary";
	public static final String BITMAP_SECONDARY_NAME = "F1";
	
	public static final int PRIMARY_ACCOUNT_NUMBER = 2;
	public static final String PRIMARY_ACCOUNT_NUMBER_DESC = "Primary Account Number";
	public static final String PRIMARY_ACCOUNT_NUMBER_NAME = "F2";
	
	public static final int PROCESSING_CODE = 3;
	public static final String PROCESSING_CODE_DESC = "Processing Code";
	public static final String PROCESSING_CODE_NAME = "F3";

	public static final int AMOUNT_SETTLEMENT = 5;
	
	public static final int AMOUNT_CARDHOLDER_BILLING = 6;
	public static final String AMOUNT_CARDHOLDER_BILLING_DESC = "Amount, Cardholder Billing";
	public static final String AMOUNT_CARDHOLDER_BILLING_NAME = "F6";

	public static final int TRANSMISSION_DATE_AND_TIME = 7;
	public static final String TRANSMISSION_DATE_AND_TIME_DESC = "Transmission Date and Time";
	public static final String TRANSMISSION_DATE_AND_TIME_NAME = "F7";

	public static final int CONVERSION_RATE_SETTLEMENT = 9;

	public static final int CONVERSION_RATE_CARDHOLDER_BILLING = 10;
	public static final String CONVERSION_RATE_CARDHOLDER_BILLING_DESC = "Conversion Rate, Cardholder Billing";
	public static final String CONVERSION_RATE_CARDHOLDER_BILLING_NAME = "F1O";

	public static final int SYSTEM_TRACE_AUDIT_NUMBER = 11;
	public static final String SYSTEM_TRACE_AUDIT_NUMBER_DESC = "System Trace Audit Number";
	public static final String SYSTEM_TRACE_AUDIT_NUMBER_NAME = "F11";

	public static final int TIME_LOCAL_TRANSACTION = 12;
	public static final String TIME_LOCAL_TRANSACTION_DESC = "Time, Local Transaction";
	public static final String TIME_LOCAL_TRANSACTION_NAME = "F12";

	public static final int DATE_LOCAL_TRANSACTION = 13;
	public static final String DATE_LOCAL_TRANSACTION_DESC = "Date, Local Transaction";
	public static final String DATE_LOCAL_TRANSACTION_NAME = "F13";

	public static final int DATE_EXPIRATION = 14;
	public static final String DATE_EXPIRATION_DESC = "Date, Expiration";
	public static final String DATE_EXPIRATION_NAME = "F14";

	public static final int DATE_SETTLEMENT = 15;
	public static final int DATE_CONVERSION = 16;
	
	public static final int MERCHANT_TYPE = 18;
	public static final String MERCHANT_TYPE_DESC = "Merchant Type";
	public static final String MERCHANT_TYPE_NAME = "F18";
	
	public static final int ACQUIRING_INSTITUTION_COUNTRY_CODE = 19;
	public static final String ACQUIRING_INSTITUTION_COUNTRY_CODE_DESC = "Acquiring Institution Country Code";
	public static final String ACQUIRING_INSTITUTION_COUNTRY_CODE_NAME = "F19";
	
	public static final int PAN_EXTENDED_COUNTRY_CODE = 20;
	public static final String PAN_EXTENDED_COUNTRY_CODE_DESC = "PAN Extended, Country Code";
	public static final String PAN_EXTENDED_COUNTRY_CODE_NAME = "F20";
	
	public static final int POINT_OF_SERVICE_ENTRY_MODE_CODE = 22;
	public static final String POINT_OF_SERVICE_ENTRY_MODE_CODE_DESC = "Point-of-Service Entry Mode Code";
	public static final String POINT_OF_SERVICE_ENTRY_MODE_CODE_NAME = "F22";
	
	public static final int CARD_SEQUENCE_NUMBER = 23;
	public static final String CARD_SEQUENCE_NUMBER_DESC = "Card Sequence Number";
	public static final String CARD_SEQUENCE_NUMBER_NAME = "F23";
	
	public static final int POINT_OF_SERVICE_CONDITION_CODE = 25;
	public static final String POINT_OF_SERVICE_CONDITION_CODE_DESC = "Point-of-Service Condition Code";
	public static final String POINT_OF_SERVICE_CONDITION_CODE_NAME = "F25";

	public static final int POINT_OF_SERVICE_PIN_CAPTURE_CODE = 26;
	public static final String POINT_OF_SERVICE_PIN_CAPTURE_CODE_DESC = "Point-of-Service PIN Capture Code";
	public static final String POINT_OF_SERVICE_PIN_CAPTURE_CODE_NAME = "F26";
	
	public static final int AMOUNT_TRANSACTION_FEE = 28;
	public static final String AMOUNT_TRANSACTION_FEE_DESC = "Amount, Transaction Fee";
	public static final String AMOUNT_TRANSACTION_FEE_NAME = "F28";
	
	public static final int ACQUIRING_INSTITUTION_IDENTIFICATION_CODE = 32;
	public static final String ACQUIRING_INSTITUTION_IDENTIFICATION_CODE_DESC = "Acquiring Institution Identification Code";
	public static final String ACQUIRING_INSTITUTION_IDENTIFICATION_CODE_NAME = "F32";
	
	public static final int FORWARDING_INSTITUTION_IDENTIFICATION_CODE = 33;
	public static final String FORWARDING_INSTITUTION_IDENTIFICATION_CODE_DESC = "Forwarding Institution Identification Code";
	public static final String FORWARDING_INSTITUTION_IDENTIFICATION_CODE_NAME = "F33";
	



	public static final int TRACK_2_DATA = 35;
	public static final String TRACK_2_DATA_DESC = "Track 2 Data";
	public static final String TRACK_2_DATA_NAME = "F35";
	

	public static final int RETRIEVAL_REFERENCE_NUMBER = 37;
	public static final String RETRIEVAL_REFERENCE_NUMBER_DESC = "Retrieval Reference Number";
	public static final String RETRIEVAL_REFERENCE_NUMBER_NAME = "F37";
	
	public static final int AUTHORIZATION_IDENTIFICATION_RESPONSE = 38;
	public static final String AUTHORIZATION_IDENTIFICATION_RESPONSE_DESC = "Authorization Identification Response";
	public static final String AUTHORIZATION_IDENTIFICATION_RESPONSE_NAME = "F38";
	
	public static final int RESPONSE_CODE = 39;
	public static final String RESPONSE_CODE_DESC = "Response Code";
	public static final String RESPONSE_CODE_NAME = "F39";
	

	public static final int CARD_ACCEPTOR_TERMINAL_IDENTIFICATION = 41;
	public static final String CARD_ACCEPTOR_TERMINAL_IDENTIFICATION_DESC = "Card Acceptor Terminal Identification";
	public static final String CARD_ACCEPTOR_TERMINAL_IDENTIFICATION_NAME = "F41";

	public static final int CARD_ACCEPTOR_IDENTIFICATION_CODE = 42;
	public static final String CARD_ACCEPTOR_IDENTIFICATION_CODE_DESC = "Card Acceptor Identification Code";
	public static final String CARD_ACCEPTOR_IDENTIFICATION_CODE_NAME = "F42";
	
	public static final int CARD_ACCEPTOR_NAME_LOCATION = 43;
	public static final String CARD_ACCEPTOR_NAME_LOCATION_DESC = "Card Acceptor Name Location";
	public static final String CARD_ACCEPTOR_NAME_LOCATION_NAME = "F43";
	
	public static final int ADDITIONAL_RESPONSE_DATA = 44;
	public static final String ADDITIONAL_RESPONSE_DATA_DESC = "Additional Response Data";
	public static final String ADDITIONAL_RESPONSE_DATA_NAME = "F44";
	
	public static final int TRACK_1_DATA = 45;
	public static final String TRACK_1_DATA_DESC = "Track 1 Data";
	public static final String TRACK_1_DATA_NAME = "F45";

	public static final int AMOUNT_FEES = 46;

	public static final int ADDITIONAL_DATA_PRIVATE = 48;
	public static final String ADDITIONAL_DATA_PRIVATE_DESC = "Additional Data, Private";
	public static final String ADDITIONAL_DATA_PRIVATE_NAME = "F48";
	
	public static final int CURRENCY_CODE_SETTLEMENT = 50;
	public static final int CURRENCY_CODE_CARDHOLDER_BILLING = 51;
	public static final String CURRENCY_CODE_CARDHOLDER_BILLING_DESC = "Currency Code, Cardholder Billing";
	public static final String CURRENCY_CODE_CARDHOLDER_BILLING_NAME = "F51";

	public static final int PIN_DATA = 52;
	public static final String PIN_DATA_DESC = "Personal Identification Number (PIN) Data";
	public static final String PIN_DATA_NAME = "F52";

	public static final int SECURITY_RELATED_CONTROL_INFORMATION = 53;
	public static final String SECURITY_RELATED_CONTROL_INFORMATION_DESC = "Security-Related Control Information";
	public static final String SECURITY_RELATED_CONTROL_INFORMATION_NAME = "F53";

	public static final int ADDITIONAL_AMOUNTS = 54;
	public static final String ADDITIONAL_AMOUNTS_DESC = "Additional Amounts";
	public static final String ADDITIONAL_AMOUNTS_NAME = "F54";

	public static final int INTEGRATED_CIRCUIT_CARD_RELATED_DATA = 55;
	public static final String INTEGRATED_CIRCUIT_CARD_RELATED_DATA_DESC = "Integrated Circuit Card (ICC)-Related Data";
	public static final String INTEGRATED_CIRCUIT_CARD_RELATED_DATA_NAME = "F55";


	public static final int NATIONAL_POINT_OF_SERVICE_GEOGRAPHIC_DATA = 59;
	public static final String NATIONAL_POINT_OF_SERVICE_GEOGRAPHIC_DATA_DESC = "National Point-of-Service Geographic Data";
	public static final String NATIONAL_POINT_OF_SERVICE_GEOGRAPHIC_DATA_NAME = "F59";

	// public static final int ADDITIONAL_POS_INFORMATION = 60;
	// public static final String ADDITIONAL_POS_INFORMATION_DESC = "Additional POS Information";
	// public static final String ADDITIONAL_POS_INFORMATION_NAME = "F60";

	// public static final int OTHER_AMOUNTS = 61;
	// public static final String OTHER_AMOUNTS_DESC = "Other Amounts";
	// public static final String OTHER_AMOUNTS_NAME = "F61";

	public static final int POINT_OF_SERVICE_DATA = 61;
	public static final String POINT_OF_SERVICE_DATA_DESC = "Additional POS Information";
	public static final String POINT_OF_SERVICE_DATA_NAME = "F61";

	public static final int CUSTOM_PAYMENT_SERVICE_FIELDS = 62;
	public static final String CUSTOM_PAYMENT_SERVICE_FIELDS_DESC = "Custom Payment Service Fields";
	public static final String CUSTOM_PAYMENT_SERVICE_FIELDS_NAME = "F62";

	public static final int PRIVATE_USE_FIELDS = 63;
	public static final String PRIVATE_USE_FIELDS_DESC = "Private Use Fields";
	public static final String PRIVATE_USE_FIELDS_NAME = "F63";


	public static final int BITMAP_TERTIARY = 65;
	public static final String BITMAP_TERTIARY_DESC = "Bitmap, Tertiary";
	public static final String BITMAP_TERTIARY_NAME = "F65";
	
	public static final int SETTLEMENT_CODE = 66;

	public static final int RECEIVING_INSTITUTION_COUNTRY_CODE = 68;	
	public static final int SETTLEMENT_INSTITUTION_COUNTRY_CODE = 69;
	
	public static final int NETWORK_MANAGEMENT_INFORMATION_CODE = 70;
	public static final String NETWORK_MANAGEMENT_INFORMATION_CODE_DESC = "Network Management Information Code";
	public static final String NETWORK_MANAGEMENT_INFORMATION_CODE_NAME = "F70";
	

	public static final int DATE_ACTION = 73;	
	public static final int CREDITS_NUMBER = 74;	
	public static final int CREDITS_REVERSAL_NUMBER = 75;	
	public static final int DEBITS_NUMBER = 76;	
	public static final int DEBITS_REVERSAL_NUMBER = 77;
	
	public static final int CREDITS_AMOUNT = 86;	
	public static final int CREDITS_REVERSAL_AMOUNT = 87;
	public static final int DEBITS_AMOUNT = 88;
	
	public static final int DEBITS_REVERSAL_AMOUNT = 89;
	public static final int ORIGINAL_DATA_ELEMENTS = 90;
	public static final int FILE_UPDATE_CODE = 91;
	public static final int FILE_SECURITY_CODE = 92;
	
	public static final int REPLACEMENT_AMOUNTS = 95;
	public static final int MESSAGE_SECURITY_CODE = 96;
	public static final int AMOUNT_NET_SETTLEMENT = 97;
	
	public static final int SETTLEMENT_INSTITUTION_IDENTIFICATION_CODE = 99;
	public static final int RECEIVING_INSTITUTION_IDENTIFICATION_CODE = 100;
	public static final int FILE_NAME = 101;
	
	public static final int ACCOUNT_IDENTIFICATION_1 = 102;
	public static final String ACCOUNT_IDENTIFICATION_1_DESC = "Account Identification 1";
	public static final String ACCOUNT_IDENTIFICATION_1_NAME = "F102";
	
	public static final int ACCOUNT_IDENTIFICATION_2 = 103;
	public static final String ACCOUNT_IDENTIFICATION_2_DESC = "Account Identification 2";
	public static final String ACCOUNT_IDENTIFICATION_3_NAME = "F103";
		
	public static final int TRANSACTION_SPECIFIC_DATA = 104;
	public static final String TRANSACTION_SPECIFIC_DATA_DESC = "Transaction Specific Data";
	public static final String TRANSACTION_SPECIFIC_DATA_NAME = "F104";
	
	public static final int DOUBLE_LENGTH_DES_KEY = 105;
	public static final String DOUBLE_LENGTH_DES_KEY_DESC = "Double Length Des Key";
	public static final String DOUBLE_LENGTH_DES_KEY_NAME = "F105";
	

	public static final int ADDITIONAL_TRACE_DATA = 115;
	public static final String ADDITIONAL_TRACE_DATA_DESC = "Additional Trace Data";
	public static final String ADDITIONAL_TRACE_DATA_NAME = "F115";

	public static final int CARD_ISSUER_REFERENCE_DATA = 116;
	public static final String CARD_ISSUER_REFERENCE_DATA_DESC = "Card Issuer Reference Data";
	public static final String CARD_ISSUER_REFERENCE_DATA_NAME = "F116";
	
	public static final int NATIONAL_USE = 117;
	public static final String NATIONAL_USE_DESC = "National Use";
	public static final String NATIONAL_USE_NAME = "F117";
	
	public static final int INTRA_COUNTRY_DATA = 118;
	public static final String INTRA_COUNTRY_DATA_DESC = "Intra Country Data";
	public static final String INTRA_COUNTRY_DATA_NAME = "F118";
	
	public static final int SETTLEMENT_SERVICE_DATA = 119;
	public static final String SETTLEMENT_SERVICE_DATA_DESC = "Settlement Service Data";
	public static final String SETTLEMENT_SERVICE_DATA_NAME = "F119";
	

	public static final int ISSUING_INSTITUTION_IDENTIFICATION_CODE = 121;
	public static final String ISSUING_INSTITUTION_IDENTIFICATION_CODE_DESC = "Issuing Institution Identification Code";
	public static final String ISSUING_INSTITUTION_IDENTIFICATION_CODE_NAME = "F121";
	

	public static final int VERIFICATION_DATA = 123;
	public static final String VERIFICATION_DATA_DESC = "Verification Data";
	public static final String VERIFICATION_DATA_NAME = "F123";
	

	public static final int SUPPORTING_INFORMATION = 125;
	public static final String SUPPORTING_INFORMATION_DESC = "Supporting Information";
	public static final String SUPPORTING_INFORMATION_NAME = "F125";
	
	public static final int SCHEME_PRIVATE_USE = 126;
	public static final String SCHEME_PRIVATE_USE_DESC = "Scheme Private Use";
	public static final String SCHEME_PRIVATE_USE_NAME = "F126";
	
	public static final int FILE_MAINTENANCE = 127;
	public static final String FILE_MAINTENANCE_DESC = "File Maintenance";
	public static final String FILE_MAINTENANCE_NAME = "F127";
	

	public static final int TERMINAL_CAPABILITY_PROFILE = 130;
	public static final String TERMINAL_CAPABILITY_PROFILE_DESC = "Terminal Capability Profile";
	public static final String TERMINAL_CAPABILITY_PROFILE_NAME = "F130";
	
	public static final int TERMINAL_VERIFICATION_RESULTS = 131;
	public static final String TERMINAL_VERIFICATION_RESULTS_DESC = "Terminal Verification Results";
	public static final String TERMINAL_VERIFICATION_RESULTS_NAME = "F131";
	
	public static final int UNPREDICTABLE_NUMBER = 132;
	public static final String UNPREDICTABLE_NUMBER_DESC = "Unpredictable Number";
	public static final String UNPREDICTABLE_NUMBER_NAME = "F132";
	
	public static final int TERMINAL_SERIAL_NUMBER = 133;
	public static final String TERMINAL_SERIAL_NUMBER_DESC = "Terminal Serial Number";
	public static final String TERMINAL_SERIAL_NUMBER_NAME = "F133";
		
	public static final int ISSUER_APPLICATION_DATA = 134;
	public static final String ISSUER_APPLICATION_DATA_DESC = "Issuer Application Data";
	public static final String ISSUER_APPLICATION_DATA_NAME = "F134";
	
	public static final int ISSUER_DISCRETIONARY_DATA = 135;
	public static final String ISSUER_DISCRETIONARY_DATA_DESC = "Issuer Discretionary Data";
	public static final String ISSUER_DISCRETIONARY_DATA_NAME = "F135";
		
	public static final int CRYPTOGRAM = 136;	
	public static final int APPLICATION_TRANSACTION_COUNTER = 137;
	public static final int APPLICATION_INTERCHANGE_PROFILE = 138;
	public static final int ARPC_RESPONSE_CRYPTOGRAM_AND_CODE = 139;
	public static final int ISSUER_AUTHENTICATION_DATA = 140;
	
	public static final int ISSUER_SCRIPT = 142;
	public static final int ISSUER_SCRIPT_RESULTS = 143;
	public static final int ISSUER_TRANSACTION_TYPE = 144;
	public static final int TERMINAL_COUNTRY_CODE = 145;
	public static final int TERMINAL_TRANSACTION_DATE = 146;
	public static final int CRYPTOGRAM_AMOUNT = 147;
	public static final int CRYPTOGRAM_CURRENCY_CODE = 148;
	public static final int CRYPTOGRAM_CASHBACK_AMOUNT = 149;

	public static final int SECONDARY_PIN_BLOCK = 152;
	
}
