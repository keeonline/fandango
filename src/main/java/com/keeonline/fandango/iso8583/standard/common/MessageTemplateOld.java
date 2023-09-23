package com.keeonline.fandango.iso8583.standard.common;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.keeonline.fandango.iso8583.field.domain.complex.AdditionalAmounts;
import com.keeonline.fandango.iso8583.field.domain.complex.AdditionalDataPrivate;
import com.keeonline.fandango.iso8583.field.domain.complex.ArpcResponseCryptogramAndCode;
import com.keeonline.fandango.iso8583.field.domain.complex.CardAcceptorNameLocation;
import com.keeonline.fandango.iso8583.field.domain.complex.CardIssuerReferenceData;
import com.keeonline.fandango.iso8583.field.domain.complex.FileMaintenance;
import com.keeonline.fandango.iso8583.field.domain.complex.IntegratedCircuitCardRelatedData;
import com.keeonline.fandango.iso8583.field.domain.complex.IntraCountryData;
import com.keeonline.fandango.iso8583.field.domain.complex.IssuerApplicationData;
import com.keeonline.fandango.iso8583.field.domain.complex.IssuerAuthenticationData;
import com.keeonline.fandango.iso8583.field.domain.complex.IssuerDiscretionaryData;
import com.keeonline.fandango.iso8583.field.domain.complex.IssuerScript;
import com.keeonline.fandango.iso8583.field.domain.complex.IssuerScriptResults;
import com.keeonline.fandango.iso8583.field.domain.complex.NationalPointOfServiceGeographicData;
import com.keeonline.fandango.iso8583.field.domain.complex.NationalUse;
import com.keeonline.fandango.iso8583.field.domain.complex.OriginalDataElements;
import com.keeonline.fandango.iso8583.field.domain.complex.OtherAmounts;
import com.keeonline.fandango.iso8583.field.domain.complex.PosEntryModeCode;
import com.keeonline.fandango.iso8583.field.domain.complex.ProcessingCode;
import com.keeonline.fandango.iso8583.field.domain.complex.ReplacementAmounts;
import com.keeonline.fandango.iso8583.field.domain.complex.SchemePrivateUse;
import com.keeonline.fandango.iso8583.field.domain.complex.SecurityRelatedControlInformation;
import com.keeonline.fandango.iso8583.field.domain.complex.SupportingInformation;
import com.keeonline.fandango.iso8583.field.domain.complex.Track1Data;
import com.keeonline.fandango.iso8583.field.domain.complex.Track2Data;
import com.keeonline.fandango.iso8583.field.domain.complex.TransactionSpecificData;
import com.keeonline.fandango.iso8583.field.domain.complex.VerificationData;
import com.keeonline.fandango.iso8583.field.domain.temporal.MonthDayTime;

/**
 * This is a domain class and is the Data Transfer Object (DTO) that defines the 
 * data that comprises an ISO8583 message. It does not reflect the physical 
 * format of any given implementation, but provides setters, getters and 
 * utility methods for use with all card schemes and host systems that employ 
 * ISO8583 messaging.
 */

public abstract class MessageTemplateOld {
	
	// @SerializedName("mti")  
	private String messageTypeIdentifier;

	
	// @SerializedName("bmp") 
	private String bitmapPrimary;

	// @SerializedName("f1")
	private String bitmapSecondary;
	// @SerializedName("f2") 
	private BigInteger primaryAccountNumber;
	@SerializedName("f3")
	private ProcessingCode processingCode;
	@SerializedName("f5")
	private BigInteger amountSettlement;
	@SerializedName("f6") 
	private BigInteger amountCardholderBilling;
	// @SerializedName("f7")
	private MonthDayTime transmissionDateAndTime;
	// f8 not used
	@SerializedName("f9")
	private BigDecimal conversionRateSettlement;
	@SerializedName("f10") // yes
	private BigDecimal conversionRateCardholderBilling;
	@SerializedName("f11")
	private BigInteger systemTraceAuditNumber;
	@SerializedName("f12")
	private LocalTime timeLocalTransaction;
	@SerializedName("f13")
	private LocalDate dateLocalTransaction;
	@SerializedName("f14")
	private LocalDate dateExpiration;
	@SerializedName("f15")
	private LocalDate dateSettlement;
	@SerializedName("f16")
	private LocalDate dateConversion;
	// f17 not used
	@SerializedName("f18")
	private BigInteger merchantType;
	@SerializedName("f19")
	private BigInteger acquiringInstitutionCountryCode;
	@SerializedName("f20")
	private BigInteger panExtendedCountryCode;
	// f21 not used
	@SerializedName("f22")
	private PosEntryModeCode posEntryModeCode;
	@SerializedName("f23")
	private BigInteger cardSequenceNumber;
	// f24 not used
	@SerializedName("f25")
	private BigInteger posConditionCode;
	@SerializedName("f26")
	private BigInteger posPinCaptureCode;
	// f27 not used
	@SerializedName("f28")
	private BigDecimal amountTransactionFee;
	// f29 not used
	// f30 not used
	// f31 not used
	@SerializedName("f32")
	private BigInteger acquiringInstitutionIdentificationCode;
	@SerializedName("f33")
	private BigInteger forwardingInstitutionIdentificationCode;
	// f34 not used
	@SerializedName("f35")
	private Track2Data track2Data;
	// f36 not used
	@SerializedName("f37")
	private String retrievalReferenceNumber;
	@SerializedName("f38")
	private String authorizationIdentificationResponse;
	@SerializedName("f39")
	private String responseCode;
	// f40 not used
	@SerializedName("f41")
	private String cardAcceptorTerminalIdentification;
	@SerializedName("f42")
	private String cardAcceptorIdentificationCode;
	@SerializedName("f43") // yes
	private CardAcceptorNameLocation cardAcceptorNameLocation;
	@SerializedName("f44")
//	private AdditionalResponseData additionalResponseData;
	private String additionalResponseData;
	@SerializedName("f45")
	private Track1Data track1Data;
	@SerializedName("f46")
	private BigDecimal amountFees;
	// f47 not used
	@SerializedName("f48") // yes
	private AdditionalDataPrivate additionalDataPrivate;
	@SerializedName("f50")
	private BigInteger currencyCodeSettlement;
	@SerializedName("f51")
	private BigInteger currencyCodeCardholderBilling;
	@SerializedName("f52")
	private String pinData;
	@SerializedName("f53")
	private SecurityRelatedControlInformation securityRelatedControlInformation;
	@SerializedName("f54")
	private AdditionalAmounts additionalAmounts;
	@SerializedName("f55")
	private IntegratedCircuitCardRelatedData integratedCircuitCardRelatedData;
	// f56 not used      // yes
	// f57 not used
	// f58 not used
	@SerializedName("f59")
	private NationalPointOfServiceGeographicData nationalPointOfServiceGeograhicData;
	// TODO: in Link and MasterCard, F60 is the Advice/Reversal reason code - need to review field name
	@SerializedName("f60")
//	private AdditionalPosInformation additionalPosInformation;
	private String additionalPosInformation;
	@SerializedName("f61")  // yes
	private OtherAmounts otherAmounts;
	@SerializedName("f62")
//	private CustomPaymentServiceFields customPaymentServiceFields;
	private String customPaymentServiceFields;
	@SerializedName("f63")
	private String privateUseFields;
//	private ProprietaryLvar privateUseFields;
	// f64 not used
	@SerializedName("f65")
	private String bitmapTertiary;
	@SerializedName("f66")
	private BigInteger settlementCode;
	@SerializedName("f68")
	private BigInteger receivingInstitutionCountryCode;
	@SerializedName("f69")
	private BigInteger settlementInstitutionCountryCode;
	@SerializedName("f70")
	private BigInteger networkManagementInformationCode;
	@SerializedName("f73")
	private LocalDate dateAction;
	@SerializedName("f74")
	private BigInteger creditsNumber;
	@SerializedName("f75")
	private BigInteger creditsReversalNumber;
	@SerializedName("f76")
	private BigInteger debitsNumber;
	@SerializedName("f77")
	private BigInteger debitsReversalNumber;
	@SerializedName("f86")
	private BigInteger creditsAmount;
	@SerializedName("f87")
	private BigInteger creditsReversalAmount;
	@SerializedName("f88")
	private BigInteger debitsAmount;
	@SerializedName("f89")
	private BigInteger debitsReversalAmount;
	@SerializedName("f90")
	private OriginalDataElements originalDataElements;
	@SerializedName("f91")
	private String fileUpdateCode;
	@SerializedName("f92")
	private String fileSecurityCode;
	@SerializedName("f95")
	private ReplacementAmounts replacementAmounts;
	@SerializedName("f96")
	private String messageSecurityCode;
	@SerializedName("f97")
	private BigInteger amountNetSettlement;
	// f98 not used
	@SerializedName("f99")
	private BigInteger settlementInstitutionIdentificationCode;
	@SerializedName("f100")
	private BigInteger receivingInstitutionIdentificationCode;
	@SerializedName("f101")
	private String fileName;
	@SerializedName("f102")
	private String accountIdentification1;
	@SerializedName("f103")
	private String accountIdentification2;	
	@SerializedName("f104")
	private TransactionSpecificData transactionSpecificData;
	@SerializedName("f105")
	private String doubleLengthDesKey;
	// f106 not used
	// f107 not used
	// f108 not used
	// f109 not used
	// f110 not used
	// f111 not used
	// f112 not used
	// f113 not used
	// f114 not used
	@SerializedName("f115")
	private String additionalTraceData;
	@SerializedName("f116")
	private CardIssuerReferenceData cardIssuerReferenceData;
	@SerializedName("f117")
	private NationalUse nationalUse;
	@SerializedName("f118")
	private IntraCountryData intraCountryData;
	@SerializedName("f119")
	private String settlementServiceData;
	// f120 not used
	@SerializedName("f121")
	private String issuingInstitutionIdentificationCode;
	@SerializedName("f123")
	private VerificationData verificationData;
	// f124 not used
	@SerializedName("f125")
	private SupportingInformation supportingInformation;
	@SerializedName("f126")
	private SchemePrivateUse schemePrivateUse;
	@SerializedName("f127")
	private FileMaintenance fileMaintenance;
	// f128 not used
	// f129 not used
	@SerializedName("f130")
	private String terminalCapabilityProfile;
	@SerializedName("f131")
	private String terminalVerificationResults;
	@SerializedName("f132")
	private String unpredictableNumber;
	@SerializedName("f133")
	private String terminalSerialNumber;
	@SerializedName("f134")
	private IssuerApplicationData issuerApplicationData;
	@SerializedName("f135")
	private IssuerDiscretionaryData issuerDiscretionaryData;
	@SerializedName("f136")
	private String cryptogram;
	@SerializedName("f137")
	private BigInteger applicationTransactionCounter;
	@SerializedName("f138")
	private String applicationInterchangeProfile;
	@SerializedName("f139")
	private ArpcResponseCryptogramAndCode arpcResponseCryptogramAndCode;
	@SerializedName("f140")
	private IssuerAuthenticationData issuerAuthenticationData;
	// f141 not used
	@SerializedName("f142")
	private IssuerScript issuerScript;
	@SerializedName("f143")
	private IssuerScriptResults issuerScriptResults;
	@SerializedName("f144")
	private BigInteger issuerTransactionType;
	@SerializedName("f145")
	private BigInteger terminalCountryCode;
	@SerializedName("f146")
	private LocalDate terminalTransactionDate;
	// TODO: check data type - it may have to be a hex string
	@SerializedName("f147")
	private BigInteger cryptogramAmount;
	// TODO check data type - end
	@SerializedName("f148")
	private BigInteger cryptogramCurrencyCode;
	// TODO: check data type - it may have to be a hex string
	@SerializedName("f149")
	private BigInteger cryptogramCashbackAmount;
	// TODO check data type - end
	@SerializedName("f152")
	private String secondaryPinBlock;


	protected transient MessageBitmaps bitmaps;

	public MessageTemplateOld(){
		this.bitmaps = new MessageBitmaps(192);
	}
	
	protected abstract void setStandardSpecificFieldByNumber(Object field,int fieldNumber);

	public void setFieldByNumber(Object field,int fieldNumber) {
		if ((fieldNumber > 0) && (fieldNumber < 193)) {

			switch (fieldNumber)
			{		

//TODO: Add arguments and uncomment fields as they come into use
//			case Iso8583Fields.BITMAP_SECONDARY:
//				setBitmapSecondary(); return; 
			case Fields.PRIMARY_ACCOUNT_NUMBER:
				setPrimaryAccountNumber((BigInteger) field); return; 
			case Fields.PROCESSING_CODE:
				setProcessingCode((ProcessingCode) field); return; 
//			case Iso8583Fields.AMOUNT_CARDHOLDER_BILLING:
//				setAmountCardholderBilling(); return; 
			case Fields.TRANSMISSION_DATE_AND_TIME:
				setTransmissionDateAndTime((MonthDayTime) field); return; 
//			case Iso8583Fields.CONVERSION_RATE_SETTLEMENT:
//				setConversionRateSettlement(); return; 
//			case Iso8583Fields.CONVERSION_RATE_CARDHOLDER_BILLING:
//				setConversionRateCardholderBilling(); return; 
			case Fields.SYSTEM_TRACE_AUDIT_NUMBER:
				setSystemTraceAuditNumber((BigInteger) field); return; 
//			case Iso8583Fields.TIME_LOCAL_TRANSACTION:
//				setTimeLocalTransaction(); return; 
//			case Iso8583Fields.DATE_LOCAL_TRANSACTION:
//				setDateLocalTransaction(); return; 
//			case Iso8583Fields.DATE_EXPIRATION:
//				setDateExpiration(); return; 
//			case Iso8583Fields.DATE_SETTLEMENT:
//				setDateSettlement(); return; 
//			case Iso8583Fields.DATE_CONVERSION:
//				setDateConversion(); return; 
//			case Iso8583Fields.MERCHANT_TYPE:
//				setMerchantType(); return; 
//			case Iso8583Fields.ACQUIRING_INSTITUTION_COUNTRY_CODE:
//				setAcquiringInstitutionCountryCode(); return; 
//			case Iso8583Fields.PAN_EXTENDED_COUNTRY_CODE:
//				setPanExtendedCountryCode(); return; 
			case Fields.POINT_OF_SERVICE_ENTRY_MODE_CODE:
				setPosEntryModeCode((PosEntryModeCode) field); return; 
//			case Iso8583Fields.CARD_SEQUENCE_NUMBER:
//				setCardSequenceNumber(); return; 
//			case Iso8583Fields.POINT_OF_SERVICE_CONDITION_CODE:
//				setPosConditionCode(); return; 
//			case Iso8583Fields.POINT_OF_SERVICE_PIN_CAPTURE_CODE:
//				setPosPinCaptureCode(); return; 
//			case Iso8583Fields.AMOUNT_TRANSACTION_FEE:
//				setAmountTransactionFee(); return; 
//			case Iso8583Fields.ACQUIRING_INSTITUTION_IDENTIFICATION_CODE:
//				setAcquiringInstitutionIdentificationCode(); return; 
//			case Iso8583Fields.FORWARDING_INSTITUTION_IDENTIFICATION_CODE:
//				setForwardingInstitutionIdentificationCode(); return; 
//			case Iso8583Fields.TRACK_2_DATA: 
//				setTrack2Data(); return; 
			case Fields.RETRIEVAL_REFERENCE_NUMBER:
				setRetrievalReferenceNumber((String) field); return; 
//			case Iso8583Fields.AUTHORIZATION_IDENTIFICATION_RESPONSE:
//				setAuthorizationIdentificationResponse(); return; 
			case Fields.RESPONSE_CODE:
				setResponseCode((String) field); return; 
//			case Iso8583Fields.CARD_ACCEPTOR_TERMINAL_IDENTIFICATION:
//				setCardAcceptorTerminalIdentification(); return; 
//			case Iso8583Fields.CARD_ACCEPTOR_IDENTIFICATION_CODE:
//				setCardAcceptorIdentificationCode(); return; 
//			case Iso8583Fields.CARD_ACCEPTOR_NAME_LOCATION:
//				setCardAcceptorNameLocation(); return; 
			case Fields.ADDITIONAL_RESPONSE_DATA:
				setAdditionalResponseData((String) field); return; 
//			case Iso8583Fields.TRACK_1_DATA: 
//				setTrack1Data(); return; 
//			case Iso8583Fields.AMOUNT_FEES:
//				setAmountFees(); return; 
//			case Iso8583Fields.ADDITIONAL_DATA_PRIVATE:
//				setAdditionalDataPrivate(); return; 
//			case Iso8583Fields.CURRENCY_CODE_TRANSACTION:
//				setCurrencyCodeTransaction(); return; 
//			case Iso8583Fields.CURRENCY_CODE_SETTLEMENT:
//				setCurrencyCodeSettlement(); return; 
//			case Iso8583Fields.CURRENCY_CODE_CARDHOLDER_BILLING:
//				setCurrencyCodeCardholderBilling(); return; 
//			case Iso8583Fields.PIN_DATA:
//				setPinData(); return; 
			case Fields.SECURITY_RELATED_CONTROL_INFORMATION:
				setSecurityRelatedControlInformation((SecurityRelatedControlInformation)field); return; 
			case Fields.ADDITIONAL_AMOUNTS:
				setAdditionalAmounts((AdditionalAmounts)field); return; 
//			case Iso8583Fields.INTEGRATED_CIRCUIT_CARD_RELATED_DATA:
//				setIntegratedCircuitCardRelatedData(); return; 
//			case Iso8583Fields.NATIONAL_POINT_OF_SERVICE_GEOGRAPHIC_DATA:
//				setNationalPointOfServiceGeograhicData(); return; 
			case Fields.ADDITIONAL_POS_INFORMATION:
				setAdditionalPosInformation((String)field); return; 
//			case Iso8583Fields.OTHER_AMOUNTS:
//				setOtherAmounts(); return; 
			case Fields.CUSTOM_PAYMENT_SERVICE_FIELDS:
				setCustomPaymentServiceFields((String) field); return; 
			case Fields.PRIVATE_USE_FIELDS:
				setPrivateUseFields((String) field); return;
//			case Iso8583Fields.BITMAP_TERTIARY:
//				setBitmapTertiary(); return; 
//			case Iso8583Fields.SETTLEMENT_CODE:
//				setSettlementCode(); return; 
//			case Iso8583Fields.RECEIVING_INSTITUTION_COUNTRY_CODE:
//				setReceivingInstitutionCountryCode(); return; 
//			case Iso8583Fields.SETTLEMENT_INSTITUTION_COUNTRY_CODE:
//				setSettlementInstitutionCountryCode(); return;  
			case Fields.NETWORK_MANAGEMENT_INFORMATION_CODE:
				setNetworkManagementInformationCode((BigInteger) field); return; 
//			case Iso8583Fields.DATE_ACTION:
//				setDateAction(); return; 
//			case Iso8583Fields.CREDITS_NUMBER:
//				setCreditsNumber(); return; 	
//			case Iso8583Fields.CREDITS_REVERSAL_NUMBER:
//				setCreditsReversalNumber();	return;  
//			case Iso8583Fields.DEBITS_NUMBER:
//				setDebitsNumber(); return; 	
//			case Iso8583Fields.DEBITS_REVERSAL_NUMBER:
//				setDebitsReversalNumber(); return; 	
//			case Iso8583Fields.CREDITS_AMOUNT:
//				setCreditsAmount(); return; 	
//			case Iso8583Fields.CREDITS_REVERSAL_AMOUNT:
//				setCreditsReversalAmount(); return; 	
//			case Iso8583Fields.DEBITS_AMOUNT:
//				setDebitsAmount(); return; 	
//			case Iso8583Fields.DEBITS_REVERSAL_AMOUNT:
//				setDebitsReversalAmount(); return; 	
//			case Iso8583Fields.ORIGINAL_DATA_ELEMENTS:
//				setOriginalDataElements(); return; 	
//			case Iso8583Fields.FILE_UPDATE_CODE:
//				setFileUpdateCode(); return; 
//			case Iso8583Fields.FILE_SECURITY_CODE:
//				setFileSecurityCode(); return; 	
//			case Iso8583Fields.REPLACEMENT_AMOUNTS:
//				setReplacementAmounts(); return; 	
//			case Iso8583Fields.MESSAGE_SECURITY_CODE:
//				setMessageSecurityCode(); return; 
//			case Iso8583Fields.AMOUNT_NET_SETTLEMENT:
//				setAmountNetSettlement(); return; 	
//			case Iso8583Fields.SETTLEMENT_INSTITUTION_IDENTIFICATION_CODE:
//				setSettlementInstitutionIdentificationCode(); return; 	
//			case Iso8583Fields.RECEIVING_INSTITUTION_IDENTIFICATION_CODE:
//				setReceivingInstitutionIdentificationCode(); return; 
//			case Iso8583Fields.FILE_NAME:
//				setFileName(); return; 	
			case Fields.ACCOUNT_IDENTIFICATION_1:
				setAccountIdentification1((String) field); return; 
//			case Iso8583Fields.ACCOUNT_IDENTIFICATION_2:
//				setAccountIdentification2(); return;
//			case Iso8583Fields.TRANSACTION_SPECIFIC_DATA:
//				setTransactionSpecificData(); return;
//			case Iso8583Fields.DOUBLE_LENGTH_DES_KEY:
//				setDoubleLengthDesKey(); return;
//			case Iso8583Fields.ADDITIONAL_TRACE_DATA:
//				setAdditionalTraceData(); return;
//			case Iso8583Fields.CARD_ISSUER_REFERENCE_DATA:
//				setCardIssuerReferenceData(); return;
//			case Iso8583Fields.NATIONAL_USE:
//				setNationalUse(); return;
//			case Iso8583Fields.INTRA_COUNTRY_DATA:
//				setIntraCountryData(); return;
//			case Iso8583Fields.SETTLEMENT_SERVICE_DATA:
//				setSettlementServiceData(); return;	
//			case Iso8583Fields.ISSUING_INSTITUTION_IDENTIFICATION_CODE:
//				setIssuingInstitutionIdentificationCode(); return;
//			case Iso8583Fields.VERIFICATION_DATA:
//				setVerificationData(); return;
//			case Iso8583Fields.SUPPORTING_INFORMATION:
//				setSupportingInformation(); return;	
//			case Iso8583Fields.SCHEME_PRIVATE_USE:
//				setSchemePrivateUse(); return;	
//			case Iso8583Fields.FILE_MAINTENANCE:
//				setFileMaintenance(); return;	
//			case Iso8583Fields.TERMINAL_CAPABILITY_PROFILE:
//				setTerminalCapabilityProfile(); return;	
//			case Iso8583Fields.TERMINAL_VERIFICATION_RESULTS:
//				setTerminalVerificationResults(); return;
//			case Iso8583Fields.UNPREDICTABLE_NUMBER:
//				setUnpredictableNumber(); return;	
//			case Iso8583Fields.TERMINAL_SERIAL_NUMBER:
//				setTerminalSerialNumber(); return;	
//			case Iso8583Fields.ISSUER_APPLICATION_DATA:
//				setIssuerApplicationData(); return;
//			case Iso8583Fields.ISSUER_DISCRETIONARY_DATA:
//				setIssuerDiscretionaryData(); return;	
//			case Iso8583Fields.CRYPTOGRAM:
//				setCryptogram(); return;	
//			case Iso8583Fields.APPLICATION_TRANSACTION_COUNTER:
//				setApplicationTransactionCounter();	return;	
//			case Iso8583Fields.APPLICATION_INTERCHANGE_PROFILE:
//				setApplicationInterchangeProfile(); return;
//			case Iso8583Fields.ARPC_RESPONSE_CRYPTOGRAM_AND_CODE:
//				setArpcResponseCryptogramAndCode(); return;
//			case Iso8583Fields.ISSUER_AUTHENTICATION_DATA:
//				setIssuerAuthenticationData(); return;
//			case Iso8583Fields.ISSUER_SCRIPT:
//				setIssuerScript(); return;
//			case Iso8583Fields.ISSUER_SCRIPT_RESULTS:
//				setIssuerScriptResults(); return;
//			case Iso8583Fields.ISSUER_TRANSACTION_TYPE:
//				setIssuerTransactionType(); return;
//			case Iso8583Fields.TERMINAL_COUNTRY_CODE:
//				setTerminalCountryCode(); return;
//			case Iso8583Fields.TERMINAL_TRANSACTION_DATE:
//				setTerminalTransactionDate(); return;
//			case Iso8583Fields.CRYPTOGRAM_AMOUNT:
//				setCryptogramAmount(); return;
//			case Iso8583Fields.CRYPTOGRAM_CURRENCY_CODE:
//				setCryptogramCurrencyCode(); return;
//			case Iso8583Fields.CRYPTOGRAM_CASHBACK_AMOUNT:
//				setCryptogramCashbackAmount(); return;
//			case Iso8583Fields.SECONDARY_PIN_BLOCK:
//				setSecondaryPinBlock(); return;				

			}
		
		}
		
	}

	protected abstract Object getStandardSpecificFieldByNumber(int fieldNumber);

	public Object getFieldByNumber(int fieldNumber){
		if ((fieldNumber > 0) && (fieldNumber < 193)) {
			
			switch (fieldNumber)
			{		
			case Fields.BITMAP_SECONDARY:
				return getBitmapSecondary();
			case Fields.PRIMARY_ACCOUNT_NUMBER:
				return getPrimaryAccountNumber();
			case Fields.PROCESSING_CODE:
				return getProcessingCode();
			case Fields.AMOUNT_SETTLEMENT:
				return getAmountSettlement();
			case Fields.AMOUNT_CARDHOLDER_BILLING:
				return getAmountCardholderBilling();
			case Fields.TRANSMISSION_DATE_AND_TIME:
				return getTransmissionDateAndTime();
			case Fields.CONVERSION_RATE_SETTLEMENT:
				return getConversionRateSettlement();
			case Fields.CONVERSION_RATE_CARDHOLDER_BILLING:
				return getConversionRateCardholderBilling();
			case Fields.SYSTEM_TRACE_AUDIT_NUMBER:
				return getSystemTraceAuditNumber();
			case Fields.TIME_LOCAL_TRANSACTION:
				return getTimeLocalTransaction();
			case Fields.DATE_LOCAL_TRANSACTION:
				return getDateLocalTransaction();
			case Fields.DATE_EXPIRATION:
				return getDateExpiration();
			case Fields.DATE_SETTLEMENT:
				return getDateSettlement();
			case Fields.DATE_CONVERSION:
				return getDateConversion();
			case Fields.MERCHANT_TYPE:
				return getMerchantType();
			case Fields.ACQUIRING_INSTITUTION_COUNTRY_CODE:
				return getAcquiringInstitutionCountryCode();
			case Fields.PAN_EXTENDED_COUNTRY_CODE:
				return getPanExtendedCountryCode();
			case Fields.POINT_OF_SERVICE_ENTRY_MODE_CODE:
				return getPosEntryModeCode();
			case Fields.CARD_SEQUENCE_NUMBER:
				return getCardSequenceNumber();
			case Fields.POINT_OF_SERVICE_CONDITION_CODE:
				return getPosConditionCode();
			case Fields.POINT_OF_SERVICE_PIN_CAPTURE_CODE:
				return getPosPinCaptureCode();
			case Fields.AMOUNT_TRANSACTION_FEE:
				return getAmountTransactionFee();
			case Fields.ACQUIRING_INSTITUTION_IDENTIFICATION_CODE:
				return getAcquiringInstitutionIdentificationCode();
			case Fields.FORWARDING_INSTITUTION_IDENTIFICATION_CODE:
				return getForwardingInstitutionIdentificationCode();
			case Fields.TRACK_2_DATA:
				return getTrack2Data();
			case Fields.RETRIEVAL_REFERENCE_NUMBER:
				return getRetrievalReferenceNumber();
			case Fields.AUTHORIZATION_IDENTIFICATION_RESPONSE:
				return getAuthorizationIdentificationResponse();
			case Fields.RESPONSE_CODE:
				return getResponseCode();
			case Fields.CARD_ACCEPTOR_TERMINAL_IDENTIFICATION:
				return getCardAcceptorTerminalIdentification();
			case Fields.CARD_ACCEPTOR_IDENTIFICATION_CODE:
				return getCardAcceptorIdentificationCode();
			case Fields.CARD_ACCEPTOR_NAME_LOCATION:
				return getCardAcceptorNameLocation();
			case Fields.ADDITIONAL_RESPONSE_DATA:
				return getAdditionalResponseData();
			case Fields.TRACK_1_DATA:
				return getTrack1Data();
			case Fields.AMOUNT_FEES:
				return getAmountFees();
			case Fields.ADDITIONAL_DATA_PRIVATE:
				return getAdditionalDataPrivate();
			case Fields.CURRENCY_CODE_SETTLEMENT:
				return getCurrencyCodeSettlement();
			case Fields.CURRENCY_CODE_CARDHOLDER_BILLING:
				return getCurrencyCodeCardholderBilling();
			case Fields.PIN_DATA:
				return getPinData();
			case Fields.SECURITY_RELATED_CONTROL_INFORMATION:
				return getSecurityRelatedControlInformation();
			case Fields.ADDITIONAL_AMOUNTS:
				return getAdditionalAmounts();
			case Fields.INTEGRATED_CIRCUIT_CARD_RELATED_DATA:
				return getIntegratedCircuitCardRelatedData();
			case Fields.NATIONAL_POINT_OF_SERVICE_GEOGRAPHIC_DATA:
				return getNationalPointOfServiceGeograhicData();
			case Fields.ADDITIONAL_POS_INFORMATION:
				return getAdditionalPosInformation();
			case Fields.OTHER_AMOUNTS:
				return getOtherAmounts();
			case Fields.CUSTOM_PAYMENT_SERVICE_FIELDS:
				return getCustomPaymentServiceFields();
			case Fields.PRIVATE_USE_FIELDS:
				return getPrivateUseFields();
			case Fields.BITMAP_TERTIARY:
				return getBitmapTertiary();
			case Fields.SETTLEMENT_CODE:
				return getSettlementCode();
			case Fields.RECEIVING_INSTITUTION_COUNTRY_CODE:
				return getReceivingInstitutionCountryCode();
			case Fields.SETTLEMENT_INSTITUTION_COUNTRY_CODE:
				return getSettlementInstitutionCountryCode();
			case Fields.NETWORK_MANAGEMENT_INFORMATION_CODE:
				return getNetworkManagementInformationCode();
			case Fields.DATE_ACTION:
				return getDateAction();
			case Fields.CREDITS_NUMBER:
				return getCreditsNumber();	
			case Fields.CREDITS_REVERSAL_NUMBER:
				return getCreditsReversalNumber();	
			case Fields.DEBITS_NUMBER:
				return getDebitsNumber();	
			case Fields.DEBITS_REVERSAL_NUMBER:
				return getDebitsReversalNumber();	
			case Fields.CREDITS_AMOUNT:
				return getCreditsAmount();	
			case Fields.CREDITS_REVERSAL_AMOUNT:
				return getCreditsReversalAmount();	
			case Fields.DEBITS_AMOUNT:
				return getDebitsAmount();	
			case Fields.DEBITS_REVERSAL_AMOUNT:
				return getDebitsReversalAmount();	
			case Fields.ORIGINAL_DATA_ELEMENTS:
				return getOriginalDataElements();	
			case Fields.FILE_UPDATE_CODE:
				return getFileUpdateCode();
			case Fields.FILE_SECURITY_CODE:
				return getFileSecurityCode();	
			case Fields.REPLACEMENT_AMOUNTS:
				return getReplacementAmounts();	
			case Fields.MESSAGE_SECURITY_CODE:
				return getMessageSecurityCode();
			case Fields.AMOUNT_NET_SETTLEMENT:
				return getAmountNetSettlement();	
			case Fields.SETTLEMENT_INSTITUTION_IDENTIFICATION_CODE:
				return getSettlementInstitutionIdentificationCode();	
			case Fields.RECEIVING_INSTITUTION_IDENTIFICATION_CODE:
				return getReceivingInstitutionIdentificationCode();
			case Fields.FILE_NAME:
				return getFileName();	
			case Fields.ACCOUNT_IDENTIFICATION_1:
				return getAccountIdentification1();
			case Fields.ACCOUNT_IDENTIFICATION_2:
				return getAccountIdentification2();
			case Fields.TRANSACTION_SPECIFIC_DATA:
				return getTransactionSpecificData();
			case Fields.DOUBLE_LENGTH_DES_KEY:
				return getDoubleLengthDesKey();
			case Fields.ADDITIONAL_TRACE_DATA:
				return getAdditionalTraceData();
			case Fields.CARD_ISSUER_REFERENCE_DATA:
				return getCardIssuerReferenceData();
			case Fields.NATIONAL_USE:
				return getNationalUse();
			case Fields.INTRA_COUNTRY_DATA:
				return getIntraCountryData();
			case Fields.SETTLEMENT_SERVICE_DATA:
				return getSettlementServiceData();	
			case Fields.ISSUING_INSTITUTION_IDENTIFICATION_CODE:
				return getIssuingInstitutionIdentificationCode();
			case Fields.VERIFICATION_DATA:
				return getVerificationData();
			case Fields.SUPPORTING_INFORMATION:
				return getSupportingInformation();	
			case Fields.SCHEME_PRIVATE_USE:
				return getSchemePrivateUse();	
			case Fields.FILE_MAINTENANCE:
				return getFileMaintenance();	
			case Fields.TERMINAL_CAPABILITY_PROFILE:
				return getTerminalCapabilityProfile();	
			case Fields.TERMINAL_VERIFICATION_RESULTS:
				return getTerminalVerificationResults();
			case Fields.UNPREDICTABLE_NUMBER:
				return getUnpredictableNumber();	
			case Fields.TERMINAL_SERIAL_NUMBER:
				return getTerminalSerialNumber();	
			case Fields.ISSUER_APPLICATION_DATA:
				return getIssuerApplicationData();
			case Fields.ISSUER_DISCRETIONARY_DATA:
				return getIssuerDiscretionaryData();	
			case Fields.CRYPTOGRAM:
				return getCryptogram();	
			case Fields.APPLICATION_TRANSACTION_COUNTER:
				return getApplicationTransactionCounter();		
			case Fields.APPLICATION_INTERCHANGE_PROFILE:
				return getApplicationInterchangeProfile();
			case Fields.ARPC_RESPONSE_CRYPTOGRAM_AND_CODE:
				return getArpcResponseCryptogramAndCode();
			case Fields.ISSUER_AUTHENTICATION_DATA:
				return getIssuerAuthenticationData();
			case Fields.ISSUER_SCRIPT:
				return getIssuerScript();
			case Fields.ISSUER_SCRIPT_RESULTS:
				return getIssuerScriptResults();
			case Fields.ISSUER_TRANSACTION_TYPE:
				return getIssuerTransactionType();
			case Fields.TERMINAL_COUNTRY_CODE:
				return getTerminalCountryCode();
			case Fields.TERMINAL_TRANSACTION_DATE:
				return getTerminalTransactionDate();
			case Fields.CRYPTOGRAM_AMOUNT:
				return getCryptogramAmount();
			case Fields.CRYPTOGRAM_CURRENCY_CODE:
				return getCryptogramCurrencyCode();
			case Fields.CRYPTOGRAM_CASHBACK_AMOUNT:
				return getCryptogramCashbackAmount();
			case Fields.SECONDARY_PIN_BLOCK:
				return getSecondaryPinBlock();
			}
		
		}

		return getStandardSpecificFieldByNumber(fieldNumber);
	}
	
	protected void copyFields(MessageTemplateOld dto) {
		int current = 0;
		
		while (dto.getBitmaps().moreFields(current)) {
			current = dto.getBitmaps().nextField(current);
			this.setFieldByNumber(dto.getFieldByNumber(current),current);
		}	
	}
	
	@Override
	public String toString(){
		return toJsonString();
	}
	
	/**
	 * Returns the object as a JSON string.
	 * 
	 * @return JSON string representation of object
	 */
	public String toJsonString(){
		if (hasBitmapSecondary()){
			bitmapSecondary = bitmaps.getSecondary();
		}
		
		if (hasBitmapTertiary()){
			bitmapTertiary = bitmaps.getTertiary();
		}
		
		Gson gson = new Gson();
		return gson.toJson(this);
	}

	/**
	 * Returns a value that indicates if the message field corresponding 
	 * to the supplied ISO8583 field number is present in the current
	 * message
	 * 
	 * @param fieldNumber ISO8583 field number of the field being tested
	 * @return true if field is present, otherwise false
	 */
	public boolean hasField(int fieldNumber){
		return false;
	}
	
	
	public MessageBitmaps getBitmaps(){
		return bitmaps;
	}	

	protected void setBitmaps(MessageBitmaps bitmaps){
		this.bitmaps = bitmaps;
	}	

	public String getMessageTypeIdentifier() {
		return messageTypeIdentifier;
	}

	public void setMessageTypeIdentifier(String messageTypeIdentifier) {
		this.messageTypeIdentifier = messageTypeIdentifier;
	}

	public String getBitmapPrimary() {
		return bitmaps.getPrimary();
	}
	
	// F1
	public String getBitmapSecondary() {
		return bitmaps.getSecondary();
	}
	
	/**
	 * Returns true if the secondary bitmap field is present in the DTO.
	 *
	 * @return true if the secondary bitmap field is present, otherwise false
	 */
	public boolean hasBitmapSecondary() {
		return bitmaps.fieldIsPresent(Fields.BITMAP_SECONDARY);
	}

	// F2
	public BigInteger getPrimaryAccountNumber() {
		return primaryAccountNumber;
	}

	public void setPrimaryAccountNumber(BigInteger primaryAccountNumber) {
		this.primaryAccountNumber = primaryAccountNumber;
		bitmaps.setFieldPresent(Fields.PRIMARY_ACCOUNT_NUMBER);
	}

	public boolean hasPrimaryAccountNumber() {
		return (primaryAccountNumber != null);
	}
	
	//F3
	public ProcessingCode getProcessingCode() {
		return processingCode;
	}

	public void setProcessingCode(ProcessingCode processingCode) {
		this.processingCode = processingCode;
		bitmaps.setFieldPresent(Fields.PROCESSING_CODE);
	}

	public boolean hasProcessingCode() {
		return (processingCode != null);
	}
	
	// F5
	public BigInteger getAmountSettlement() {
		return amountSettlement;
	}

	public void setAmountSettlement(BigInteger amountSettlement) {
		this.amountSettlement = amountSettlement;
		bitmaps.setFieldPresent(Fields.AMOUNT_SETTLEMENT);
	}

	public boolean hasAmountSettlement() {
		return (amountSettlement != null);
	}
	
	// F6
	public BigInteger getAmountCardholderBilling() {
		return amountCardholderBilling;
	}
	
	public void setAmountCardholderBilling(BigInteger amountCardholderBilling) {
		this.amountCardholderBilling = amountCardholderBilling;
		bitmaps.setFieldPresent(Fields.AMOUNT_CARDHOLDER_BILLING);
	}

	public boolean hasAmountCardholderBilling() {
		return (amountCardholderBilling != null);
	}
	// F7
	public MonthDayTime getTransmissionDateAndTime() {
		return transmissionDateAndTime;
	}

	public void setTransmissionDateAndTime(MonthDayTime transmissionDateAndTime) {
		this.transmissionDateAndTime = transmissionDateAndTime;
		bitmaps.setFieldPresent(Fields.TRANSMISSION_DATE_AND_TIME);
	}

	public boolean hasTransmissionDateAndTime() {
		return (transmissionDateAndTime != null);
	}
	
	// F8 not used
	
	// F9
	public BigDecimal getConversionRateSettlement() {
		return conversionRateSettlement;
	}

	public void setConversionRateSettlement(BigDecimal conversionRateSettlement) {
		this.conversionRateSettlement = conversionRateSettlement;
		bitmaps.setFieldPresent(Fields.CONVERSION_RATE_SETTLEMENT);
	}
	
	public boolean hasConversionRateSettlement() {
		return (conversionRateSettlement != null);
	}
	
	// F10
	public BigDecimal getConversionRateCardholderBilling() {
		return conversionRateCardholderBilling;
	}

	public void setConversionRateCardholderBilling(BigDecimal conversionRateCardholderBilling) {
		this.conversionRateCardholderBilling = conversionRateCardholderBilling;
		bitmaps.setFieldPresent(Fields.CONVERSION_RATE_CARDHOLDER_BILLING);
	}

	public boolean hasConversionRateCardholderBilling() {
		return (conversionRateCardholderBilling != null);
	}
	
	// F11
	public BigInteger getSystemTraceAuditNumber() {
		return systemTraceAuditNumber;
	}

	public void setSystemTraceAuditNumber(BigInteger systemTraceAuditNumber) {
		this.systemTraceAuditNumber = systemTraceAuditNumber;
		bitmaps.setFieldPresent(Fields.SYSTEM_TRACE_AUDIT_NUMBER);
	}

	public boolean hasSystemTraceAuditNumber() {
		return (systemTraceAuditNumber != null);
	}
	
	// F12
	public LocalTime getTimeLocalTransaction() {
		return timeLocalTransaction;
	}

	public void setTimeLocalTransaction(LocalTime timeLocalTransaction) {
		this.timeLocalTransaction = timeLocalTransaction;
		bitmaps.setFieldPresent(Fields.TIME_LOCAL_TRANSACTION);
	}

	public boolean hasTimeLocalTransaction() {
		return (timeLocalTransaction != null);
	}
	
	// F13
	public LocalDate getDateLocalTransaction() {
		return dateLocalTransaction;
	}

	public void setDateLocalTransaction(LocalDate dateLocalTransaction) {
		this.dateLocalTransaction = dateLocalTransaction;
		bitmaps.setFieldPresent(Fields.DATE_LOCAL_TRANSACTION);
	}

	public boolean hasDateLocalTransaction() {
		return (dateLocalTransaction != null);
	}
	
	// F14
	public LocalDate getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(LocalDate dateExpiration) {
		this.dateExpiration = dateExpiration;
		bitmaps.setFieldPresent(Fields.DATE_EXPIRATION);
	}

	public boolean hasDateExpiration() {
		return (dateExpiration != null);
	}
	
	// F15
	public LocalDate getDateSettlement() {
		return dateSettlement;
	}

	public void setDateSettlement(LocalDate dateSettlement) {
		this.dateSettlement = dateSettlement;
		bitmaps.setFieldPresent(Fields.DATE_SETTLEMENT);
	}

	public boolean hasDateSettlement() {
		return (dateSettlement != null);
	}
	
	// F16
	public LocalDate getDateConversion() {
		return dateConversion;
	}

	public void setDateConversion(LocalDate dateConversion) {
		this.dateConversion = dateConversion;
		bitmaps.setFieldPresent(Fields.DATE_CONVERSION);
	}
	
	public boolean hasDateConversion() {
		return (dateConversion != null);
	}
	
	// F17 not used
	
	// F18
	public BigInteger getMerchantType() {
		return merchantType;
	}

	public void setMerchantType(BigInteger merchantType) {
		this.merchantType = merchantType;
		bitmaps.setFieldPresent(Fields.MERCHANT_TYPE);
	}

	public boolean hasMerchantType() {
		return (merchantType != null);
	}
	
	// F19
	public BigInteger getAcquiringInstitutionCountryCode() {
		return acquiringInstitutionCountryCode;
	}

	public void setAcquiringInstitutionCountryCode(BigInteger acquiringInstitutionCountryCode) {
		this.acquiringInstitutionCountryCode = acquiringInstitutionCountryCode;
		bitmaps.setFieldPresent(Fields.ACQUIRING_INSTITUTION_COUNTRY_CODE);
	}

	public boolean hasAcquiringInstitutionCountryCode() {
		return (acquiringInstitutionCountryCode != null);
	}
	
	// F20
	public BigInteger getPanExtendedCountryCode() {
		return panExtendedCountryCode;
	}

	public void setPanExtendedCountryCode(BigInteger panExtendedCountryCode) {
		this.panExtendedCountryCode = panExtendedCountryCode;
		bitmaps.setFieldPresent(Fields.PAN_EXTENDED_COUNTRY_CODE);
	}

	public boolean hasPanExtendedCountryCode() {
		return (panExtendedCountryCode != null);
	}
	
	// F21 not used
	
	// F22
	public PosEntryModeCode getPosEntryModeCode() {
		return posEntryModeCode;
	}

	public void setPosEntryModeCode(PosEntryModeCode posEntryModeCode) {
		this.posEntryModeCode = posEntryModeCode;
		bitmaps.setFieldPresent(Fields.POINT_OF_SERVICE_ENTRY_MODE_CODE);
	}

	public boolean hasPosEntryModeCode() {
		return (posEntryModeCode != null);
	}
	// F23
	public BigInteger getCardSequenceNumber() {
		return cardSequenceNumber;
	}

	public void setCardSequenceNumber(BigInteger cardSequenceNumber) {
		this.cardSequenceNumber = cardSequenceNumber;
		bitmaps.setFieldPresent(Fields.CARD_SEQUENCE_NUMBER);
	}

	public boolean hasCardSequenceNumber() {
		return (cardSequenceNumber != null);
	}
	
	// F24 not used
	
	// F25
	public void setPosConditionCode(BigInteger posConditionCode) {
		this.posConditionCode = posConditionCode;
		bitmaps.setFieldPresent(Fields.POINT_OF_SERVICE_CONDITION_CODE);
	}

	public BigInteger getPosConditionCode() {
		return posConditionCode;
	}

	public boolean hasPosConditionCode() {
		return (posConditionCode != null);
	}
	
	// F26
	public void setPosPinCaptureCode(BigInteger posPinCaptureCode) {
		this.posPinCaptureCode = posPinCaptureCode;
		bitmaps.setFieldPresent(Fields.POINT_OF_SERVICE_PIN_CAPTURE_CODE);
	}

	public Object getPosPinCaptureCode() {
		return posPinCaptureCode;
	}

	public boolean hasPosPinCaptureCode() {
		return (posPinCaptureCode != null);
	}
	
	// F27 not used
	
	// F28
	public BigDecimal getAmountTransactionFee() {
		return amountTransactionFee;
	}

	public void setAmountTransactionFee(BigDecimal amountTransactionFee) {
		this.amountTransactionFee = amountTransactionFee;
		bitmaps.setFieldPresent(Fields.AMOUNT_TRANSACTION_FEE);
	}

	public boolean hasAmountTransactionFee() {
		return (amountTransactionFee != null);
	}
	
	// F29 to 31 not used
	
	// F32
	public BigInteger getAcquiringInstitutionIdentificationCode() {
		return acquiringInstitutionIdentificationCode;
	}

	public void setAcquiringInstitutionIdentificationCode(BigInteger acquiringInstitutionIdentificationCode) {
		this.acquiringInstitutionIdentificationCode = acquiringInstitutionIdentificationCode;
		bitmaps.setFieldPresent(Fields.ACQUIRING_INSTITUTION_IDENTIFICATION_CODE);
	}

	public boolean hasAcquiringInstitutionIdentificationCode() {
		return (acquiringInstitutionIdentificationCode != null);
	}
	
	// F33
	public BigInteger getForwardingInstitutionIdentificationCode() {
		return forwardingInstitutionIdentificationCode;
	}

	public void setForwardingInstitutionIdentificationCode(BigInteger forwardingInstitutionIdentificationCode) {
		this.forwardingInstitutionIdentificationCode = forwardingInstitutionIdentificationCode;
		bitmaps.setFieldPresent(Fields.FORWARDING_INSTITUTION_IDENTIFICATION_CODE);
	}

	public boolean hasForwardingInstitutionIdentificationCode() {
		return (forwardingInstitutionIdentificationCode != null);
	}
	
	// F34 not used
	
	// F35
	public Track2Data getTrack2Data() {
		return track2Data;
	}

	public void setTrack2Data(Track2Data track2Data) {
		this.track2Data = track2Data;
		bitmaps.setFieldPresent(Fields.TRACK_2_DATA);
	}

	public boolean hasTrack2Data() {
		return (track2Data != null);
	}
	
	// F36 not used
	
	// F37
	public void setRetrievalReferenceNumber(String retrievalReferenceNumber) {
		this.retrievalReferenceNumber = retrievalReferenceNumber;
		bitmaps.setFieldPresent(Fields.RETRIEVAL_REFERENCE_NUMBER);
	}

	public String getRetrievalReferenceNumber() {
		return retrievalReferenceNumber;
	}

	public boolean hasRetrievalReferenceNumber() {
		return (retrievalReferenceNumber != null);
	}
	
	// F38
	public String getAuthorizationIdentificationResponse() {
		return authorizationIdentificationResponse;
	}

	public boolean hasAuthorizationIdentificationResponse() {
		return (authorizationIdentificationResponse != null);
	}

	public void setAuthorizationIdentificationResponse(String authorizationIdentificationResponse) {
		this.authorizationIdentificationResponse = authorizationIdentificationResponse;
		bitmaps.setFieldPresent(Fields.AUTHORIZATION_IDENTIFICATION_RESPONSE);
	}
	
	// F39
	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
		bitmaps.setFieldPresent(Fields.RESPONSE_CODE);
	}

	public boolean hasResponseCode() {
		return (responseCode != null);
	}
	
	// F40 not used
	
	// F41
	public String getCardAcceptorTerminalIdentification() {
		return cardAcceptorTerminalIdentification;
	}

	public void setCardAcceptorTerminalIdentification(String cardAcceptorTerminalIdentification) {
		this.cardAcceptorTerminalIdentification = cardAcceptorTerminalIdentification;
		bitmaps.setFieldPresent(Fields.CARD_ACCEPTOR_TERMINAL_IDENTIFICATION);
	}
	
	public boolean hasCardAcceptorTerminalIdentification() {
		return (cardAcceptorTerminalIdentification != null);
	}
	
	// F42
	public String getCardAcceptorIdentificationCode() {
		return cardAcceptorIdentificationCode;
	}

	public void setCardAcceptorIdentificationCode(String cardAcceptorIdentificationCode) {
		this.cardAcceptorIdentificationCode = cardAcceptorIdentificationCode;
		bitmaps.setFieldPresent(Fields.CARD_ACCEPTOR_IDENTIFICATION_CODE);
	}

	public boolean hasCardAcceptorIdentificationCode() {
		return (cardAcceptorIdentificationCode != null);
	}
	
	// F43
	public CardAcceptorNameLocation getCardAcceptorNameLocation() {
		return cardAcceptorNameLocation;
	}

	public void setCardAcceptorNameLocation(CardAcceptorNameLocation cardAcceptorNameLocation) {
		this.cardAcceptorNameLocation = cardAcceptorNameLocation;
		bitmaps.setFieldPresent(Fields.CARD_ACCEPTOR_NAME_LOCATION);
	}

	public boolean hasCardAcceptorNameLocation() {
		return (cardAcceptorNameLocation != null);
	}
	
	// F44
	public String getAdditionalResponseData() {
		return additionalResponseData;
	}

	public void setAdditionalResponseData(String additionalResponseData) {
		this.additionalResponseData = additionalResponseData;
		bitmaps.setFieldPresent(Fields.ADDITIONAL_RESPONSE_DATA);
	}

	public boolean hasAdditionalResponseData() {
		return (additionalResponseData != null);
	}
	
	// F45
	public Track1Data getTrack1Data() {
		return track1Data;
	}

	public void setTrack1Data(Track1Data track1Data) {
		this.track1Data = track1Data;
		bitmaps.setFieldPresent(Fields.TRACK_1_DATA);
	}

	public boolean hasTrack1Data() {
		return (track1Data != null);
	}
	
	// F46
	public BigDecimal getAmountFees() {
		return amountFees;
	}

	public void setAmountFees(BigDecimal amountFees) {
		this.amountFees = amountFees;
		bitmaps.setFieldPresent(Fields.AMOUNT_FEES);
	}

	public boolean hasAmountFees() {
		return (amountFees != null);
	}
	
    // F47 not used
	
	// F48
	public AdditionalDataPrivate getAdditionalDataPrivate() {
		return additionalDataPrivate;
	}

	public void setAdditionalDataPrivate(AdditionalDataPrivate additionalDataPrivate) {
		this.additionalDataPrivate = additionalDataPrivate;
		bitmaps.setFieldPresent(Fields.ADDITIONAL_DATA_PRIVATE);
	}

	public boolean hasAdditionalDataPrivate() {
		return (additionalDataPrivate != null);
	}
	
	// F50
	public BigInteger getCurrencyCodeSettlement() {
		return currencyCodeSettlement;
	}

	public void setCurrencyCodeSettlement(BigInteger currencyCodeSettlement) {
		this.currencyCodeSettlement = currencyCodeSettlement;
		bitmaps.setFieldPresent(Fields.CURRENCY_CODE_SETTLEMENT);
	}

	public boolean hasCurrencyCodeSettlement() {
		return (currencyCodeSettlement != null);
	}
	
	// F51
	public BigInteger getCurrencyCodeCardholderBilling() {
		return currencyCodeCardholderBilling;
	}

	public void setCurrencyCodeCardholderBilling(BigInteger currencyCodeCardholderBilling) {
		this.currencyCodeCardholderBilling = currencyCodeCardholderBilling;
		bitmaps.setFieldPresent(Fields.CURRENCY_CODE_CARDHOLDER_BILLING);
	}

	public boolean hasCurrencyCodeCardholderBilling() {
		return (currencyCodeCardholderBilling != null);
	}
	
	// F52
	public String getPinData() {
		return pinData;
	}

	public void setPinData(String pinData) {
		this.pinData = pinData;
		bitmaps.setFieldPresent(Fields.PIN_DATA);
	}

	public boolean hasPinData() {
		return (pinData != null);
	}
	
	// F53
	public SecurityRelatedControlInformation getSecurityRelatedControlInformation() {
		return securityRelatedControlInformation;
	}

	public void setSecurityRelatedControlInformation(SecurityRelatedControlInformation securityRelatedControlInformation) {
		this.securityRelatedControlInformation = securityRelatedControlInformation;
		bitmaps.setFieldPresent(Fields.SECURITY_RELATED_CONTROL_INFORMATION);
	}

	public boolean hasSecurityRelatedControlInformation() {
		return (securityRelatedControlInformation != null);
	}
	
	// F54
	public AdditionalAmounts getAdditionalAmounts() {
		return additionalAmounts;
	}

	public void setAdditionalAmounts(AdditionalAmounts additionalAmounts) {
		this.additionalAmounts = additionalAmounts;
		bitmaps.setFieldPresent(Fields.ADDITIONAL_AMOUNTS);
	}

	public boolean hasAdditionalAmounts() {
		return (additionalAmounts != null);
	}
	
	// F55
	public IntegratedCircuitCardRelatedData getIntegratedCircuitCardRelatedData() {
		return integratedCircuitCardRelatedData;
	}

	public void setIntegratedCircuitCardRelatedData(IntegratedCircuitCardRelatedData integratedCircuitCardRelatedData) {
		this.integratedCircuitCardRelatedData = integratedCircuitCardRelatedData;
		bitmaps.setFieldPresent(Fields.INTEGRATED_CIRCUIT_CARD_RELATED_DATA);
	}

	public boolean hasIntegratedCircuitCardRelatedData() {
		return (integratedCircuitCardRelatedData != null);
	}
	
	// F56 to 58 not used
	
	// F59
	public NationalPointOfServiceGeographicData getNationalPointOfServiceGeograhicData() {
		return nationalPointOfServiceGeograhicData;
	}

	public void setNationalPointOfServiceGeograhicData(NationalPointOfServiceGeographicData nationalPointOfServiceGeograhicData) {
		this.nationalPointOfServiceGeograhicData = nationalPointOfServiceGeograhicData;
		bitmaps.setFieldPresent(Fields.NATIONAL_POINT_OF_SERVICE_GEOGRAPHIC_DATA);
	}

	public boolean hasNationalPointOfServiceGeograhicData() {
		return (nationalPointOfServiceGeograhicData != null);
	}
	
	// F60
	public String getAdditionalPosInformation() {
		return additionalPosInformation;
	}

	public void setAdditionalPosInformation(String additionalPosInformation) {
		this.additionalPosInformation = additionalPosInformation;
		bitmaps.setFieldPresent(Fields.ADDITIONAL_POS_INFORMATION);
	}

	public boolean hasAdditionalPosInformation() {
		return (additionalPosInformation != null);
	}
	
	// F61
	public OtherAmounts getOtherAmounts() {
		return otherAmounts;
	}

	public void setOtherAmounts(OtherAmounts otherAmounts) {
		this.otherAmounts = otherAmounts;
		bitmaps.setFieldPresent(Fields.OTHER_AMOUNTS);
	}

	public boolean hasOtherAmounts() {
		return (otherAmounts != null);
	}
	
	// F62
	public String getCustomPaymentServiceFields() {
		return customPaymentServiceFields;
	}

	public void setCustomPaymentServiceFields(String customPaymentServiceFields) {
		this.customPaymentServiceFields = customPaymentServiceFields;
		bitmaps.setFieldPresent(Fields.CUSTOM_PAYMENT_SERVICE_FIELDS);
	}

	public boolean hasCustomPaymentServiceFields() {
		return (customPaymentServiceFields != null);
	}
	
	// F63
	public String getPrivateUseFields() {
		return privateUseFields;
	}

	public void setPrivateUseFields(String privateUseFields) {
		this.privateUseFields = privateUseFields;
		bitmaps.setFieldPresent(Fields.PRIVATE_USE_FIELDS);
	}

	public boolean hasPrivateUseFields() {
		return (privateUseFields != null);
	}
	
	// F64 not used
	
	// F65
	public String getBitmapTertiary() {
		return bitmaps.getTertiary();
	}
	
	/**
	 * Returns true if the tertiary bitmap field is present in the DTO.
	 *
	 * @return true the tertiary bitmap field is present, otherwise false
	 */
	public boolean hasBitmapTertiary() {
	  return bitmaps.fieldIsPresent(Fields.BITMAP_TERTIARY);
	}
	
	// F66	
	public BigInteger getSettlementCode() {
		return settlementCode;
	}

	public void setSettlementCode(BigInteger settlementCode) {
		this.settlementCode = settlementCode;
		bitmaps.setFieldPresent(Fields.SETTLEMENT_CODE);
	}

	public boolean hasSettlementCode() {
		return (settlementCode != null);
	}
	
	// F67 not used
	
	// F68
	public BigInteger getReceivingInstitutionCountryCode() {
		return receivingInstitutionCountryCode;
	}

	public void setReceivingInstitutionCountryCode(BigInteger receivingInstitutionCountryCode) {
		this.receivingInstitutionCountryCode = receivingInstitutionCountryCode;
		bitmaps.setFieldPresent(Fields.RECEIVING_INSTITUTION_COUNTRY_CODE);
	}

	public boolean hasReceivingInstitutionCountryCode() {
		return (receivingInstitutionCountryCode != null);
	}
	
	// F69
	public BigInteger getSettlementInstitutionCountryCode() {
		return settlementInstitutionCountryCode;
	}

	public void setSettlementInstitutionCountryCode(BigInteger settlementInstitutionCountryCode) {
		this.settlementInstitutionCountryCode = settlementInstitutionCountryCode;
		bitmaps.setFieldPresent(Fields.SETTLEMENT_INSTITUTION_COUNTRY_CODE);
	}

	public boolean hasSettlementInstitutionCountryCode() {
		return (settlementInstitutionCountryCode != null);
	}
	
	// F70
	public BigInteger getNetworkManagementInformationCode() {
		return networkManagementInformationCode;
	}

	public void setNetworkManagementInformationCode(BigInteger networkManagementInformationCode) {
		this.networkManagementInformationCode = networkManagementInformationCode;
		bitmaps.setFieldPresent(Fields.NETWORK_MANAGEMENT_INFORMATION_CODE);
	}

	public boolean hasNetworkManagementInformationCode() {
		return (networkManagementInformationCode != null);
	}
	
	// F71 F72 not used
	
	// F73	
	public LocalDate getDateAction() {
		return dateAction;
	}

	public void setDateAction(LocalDate dateAction) {
		this.dateAction = dateAction;
		bitmaps.setFieldPresent(Fields.DATE_ACTION);
	}

	public boolean hasDateAction() {
		return (dateAction != null);
	}
	
	// F74
	public BigInteger getCreditsNumber() {
		return creditsNumber;
	}

	public void setCreditsNumber(BigInteger creditsNumber) {
		this.creditsNumber = creditsNumber;
		bitmaps.setFieldPresent(Fields.CREDITS_NUMBER);
	}

	public boolean hasCreditsNumber() {
		return (creditsNumber != null);
	}
	
	// F75
	public BigInteger getCreditsReversalNumber() {
		return creditsReversalNumber;
	}

	public void setCreditsReversalNumber(BigInteger creditsReversalNumber) {
		this.creditsReversalNumber = creditsReversalNumber;
		bitmaps.setFieldPresent(Fields.CREDITS_REVERSAL_NUMBER);
	}

	public boolean hasCreditsReversalNumber() {
		return (creditsReversalNumber != null);
	}
	
	// F76
	public BigInteger getDebitsNumber() {
		return debitsNumber;
	}

	public void setDebitsNumber(BigInteger debitsNumber) {
		this.debitsNumber = debitsNumber;
		bitmaps.setFieldPresent(Fields.DEBITS_NUMBER);
	}

	public boolean hasDebitsNumber() {
		return (debitsNumber != null);
	}
	
	// F77
	public BigInteger getDebitsReversalNumber() {
		return debitsReversalNumber;
	}

	public void setDebitsReversalNumber(BigInteger debitsReversalNumber) {
		this.debitsReversalNumber = debitsReversalNumber;
		bitmaps.setFieldPresent(Fields.DEBITS_REVERSAL_NUMBER);
	}

	public boolean hasDebitsReversalNumber() {
		return (debitsReversalNumber != null);
	}
	
	// F78 to 85 not used
	
	// F86
	public BigInteger getCreditsAmount() {
		return creditsAmount;
	}

	public void setCreditsAmount(BigInteger creditsAmount) {
		this.creditsAmount = creditsAmount;
		bitmaps.setFieldPresent(Fields.CREDITS_AMOUNT);
	}

	public boolean hasCreditsAmount() {
		return (creditsAmount != null);
	}
	
	// F87
	public BigInteger getCreditsReversalAmount() {
		return creditsReversalAmount;
	}

	public void setCreditsReversalAmount(BigInteger creditsReversalAmount) {
		this.creditsReversalAmount = creditsReversalAmount;
		bitmaps.setFieldPresent(Fields.CREDITS_REVERSAL_AMOUNT);
	}

	public boolean hasCreditsReversalAmount() {
		return (creditsReversalAmount != null);
	}
	
	// F88
	public BigInteger getDebitsAmount() {
		return debitsAmount;
	}

	public void setDebitsAmount(BigInteger debitsAmount) {
		this.debitsAmount = debitsAmount;
		bitmaps.setFieldPresent(Fields.DEBITS_AMOUNT);
	}

	public boolean hasDebitsAmount() {
		return (debitsAmount != null);
	}
	
	// F89
	public BigInteger getDebitsReversalAmount() {
		return debitsReversalAmount;
	}

	public void setDebitsReversalAmount(BigInteger debitsReversalAmount) {
		this.debitsReversalAmount = debitsReversalAmount;
		bitmaps.setFieldPresent(Fields.DEBITS_REVERSAL_AMOUNT);
	}

	public boolean hasDebitsReversalAmount() {
		return (debitsReversalAmount != null);
	}
	
	// F90
	public OriginalDataElements getOriginalDataElements() {
		return originalDataElements;
	}

	public void setOriginalDataElements(OriginalDataElements originalDataElements) {
		this.originalDataElements = originalDataElements;
		bitmaps.setFieldPresent(Fields.ORIGINAL_DATA_ELEMENTS);
	}

	public boolean hasOriginalDataElements() {
		return (originalDataElements != null);
	}
	
	// F91
	public String getFileUpdateCode() {
		return fileUpdateCode;
	}

	public void setFileUpdateCode(String fileUpdateCode) {
		this.fileUpdateCode = fileUpdateCode;
		bitmaps.setFieldPresent(Fields.FILE_UPDATE_CODE);
	}

	public boolean hasFileUpdateCode() {
		return (fileUpdateCode != null);
	}
	
	// F92
	public String getFileSecurityCode() {
		return fileSecurityCode;
	}

	public void setFileSecurityCode(String fileSecurityCode) {
		this.fileSecurityCode = fileSecurityCode;
		bitmaps.setFieldPresent(Fields.FILE_SECURITY_CODE);
	}

	public boolean hasFileSecurityCode() {
		return (fileSecurityCode != null);
	}
	
	// F93 and 94 not used
	
	// F95
	public ReplacementAmounts getReplacementAmounts() {
		return replacementAmounts;
	}

	public void setReplacementAmounts(ReplacementAmounts replacementAmounts) {
		this.replacementAmounts = replacementAmounts;
		bitmaps.setFieldPresent(Fields.REPLACEMENT_AMOUNTS);
	}

	public boolean hasReplacementAmounts() {
		return (replacementAmounts != null);
	}
	
	// F96
	public String getMessageSecurityCode() {
		return messageSecurityCode;
	}

	public void setMessageSecurityCode(String messageSecurityCode) {
		this.messageSecurityCode = messageSecurityCode;
		bitmaps.setFieldPresent(Fields.MESSAGE_SECURITY_CODE);
	}

	public boolean hasMessageSecurityCode() {
		return (messageSecurityCode != null);
	}
	
	// F97
	public BigInteger getAmountNetSettlement() {
		return amountNetSettlement;
	}

	public void setAmountNetSettlement(BigInteger amountNetSettlement) {
		this.amountNetSettlement = amountNetSettlement;
		bitmaps.setFieldPresent(Fields.AMOUNT_NET_SETTLEMENT);
	}

	public boolean hasAmountNetSettlement() {
		return (amountNetSettlement != null);
	}
	
	// F98 not used
	
	// F99
	public BigInteger getSettlementInstitutionIdentificationCode() {
		return settlementInstitutionIdentificationCode;
	}

	public void setSettlementInstitutionIdentificationCode(BigInteger settlementInstitutionIdentificationCode) {
		this.settlementInstitutionIdentificationCode = settlementInstitutionIdentificationCode;
		bitmaps.setFieldPresent(Fields.SETTLEMENT_INSTITUTION_IDENTIFICATION_CODE);
	}

	public boolean hasSettlementInstitutionIdentificationCode() {
		return (settlementInstitutionIdentificationCode != null);
	}
	
	// F100
	public BigInteger getReceivingInstitutionIdentificationCode() {
		return receivingInstitutionIdentificationCode;
	}

	public void setReceivingInstitutionIdentificationCode(BigInteger receivingInstitutionIdentificationCode) {
		this.receivingInstitutionIdentificationCode = receivingInstitutionIdentificationCode;
		bitmaps.setFieldPresent(Fields.RECEIVING_INSTITUTION_IDENTIFICATION_CODE);
	}

	public boolean hasReceivingInstitutionIdentificationCode() {
		return (receivingInstitutionIdentificationCode != null);
	}
	
	// F101
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName; 
		bitmaps.setFieldPresent(Fields.FILE_NAME);
	}

	public boolean hasFileName() {
		return (fileName != null);
	}
	
	// F102
	public String getAccountIdentification1() {
		return accountIdentification1;
	}

	public void setAccountIdentification1(String accountIdentification1) {
		this.accountIdentification1 = accountIdentification1;
		bitmaps.setFieldPresent(Fields.ACCOUNT_IDENTIFICATION_1);
	}

	public boolean hasAccountIdentification1() {
		return (accountIdentification1 != null);
	}
	
	// F103
	public String getAccountIdentification2() {
		return accountIdentification2;
	}

	public void setAccountIdentification2(String accountIdentification2) {
		this.accountIdentification2 = accountIdentification2;
		bitmaps.setFieldPresent(Fields.ACCOUNT_IDENTIFICATION_2);
	}

	public boolean hasAccountIdentification2() {
		return (accountIdentification2 != null);
	}

	// F104
	public TransactionSpecificData getTransactionSpecificData() {
		return transactionSpecificData;
	}

	public void setTransactionSpecificData(TransactionSpecificData transactionSpecificData) {
		this.transactionSpecificData = transactionSpecificData; 
		bitmaps.setFieldPresent(Fields.TRANSACTION_SPECIFIC_DATA);
	}

	public boolean hasTransactionSpecificData() {
		return (transactionSpecificData != null);
	}
	
	// F105
	public String getDoubleLengthDesKey() {
		return doubleLengthDesKey;
	}

	public void setDoubleLengthDesKey(String doubleLengthDesKey) {
		this.doubleLengthDesKey = doubleLengthDesKey; 
		bitmaps.setFieldPresent(Fields.DOUBLE_LENGTH_DES_KEY);
	}

	public boolean hasDoubleLengthDesKey() {
		return (doubleLengthDesKey != null);
	}
	
	// f106 not used
	// f107 not used
	// f108 not used
	// f109 not used
	// f110 not used
	// f111 not used
	// f112 not used
	// f113 not used
	// f114 not used
	
	// F115
	public String getAdditionalTraceData() {
		return additionalTraceData;
	}

	public void setAdditionalTraceData(String additionalTraceData) {
		this.additionalTraceData = additionalTraceData; 
		bitmaps.setFieldPresent(Fields.ADDITIONAL_TRACE_DATA);
	}

	public boolean hasAdditionalTraceData() {
		return (additionalTraceData != null);
	}
	
	// F116
	public CardIssuerReferenceData getCardIssuerReferenceData() {
		return cardIssuerReferenceData;
	}

	public void setCardIssuerReferenceData(CardIssuerReferenceData cardIssuerReferenceData) {
		this.cardIssuerReferenceData = cardIssuerReferenceData; 
		bitmaps.setFieldPresent(Fields.CARD_ISSUER_REFERENCE_DATA);
	}

	public boolean hasCardIssuerReferenceData() {
		return (cardIssuerReferenceData != null);
	}
	
	// F117
	public NationalUse getNationalUse() {
		return nationalUse;
	}

	public void setNationalUse(NationalUse nationalUse) {
		this.nationalUse = nationalUse; 
		bitmaps.setFieldPresent(Fields.NATIONAL_USE);
	}

	public boolean hasNationalUse() {
		return (nationalUse != null);
	}
	
	// F118
	public IntraCountryData getIntraCountryData() {
		return intraCountryData;
	}

	public void setIntraCountryData(IntraCountryData intraCountryData) {
		this.intraCountryData = intraCountryData; 
		bitmaps.setFieldPresent(Fields.INTRA_COUNTRY_DATA);
	}

	public boolean hasIntraCountryData() {
		return (intraCountryData != null);
	}
	
	// F119
	public String getSettlementServiceData() {
		return settlementServiceData;
	}

	public void setSettlementServiceData(String settlementServiceData) {
		this.settlementServiceData = settlementServiceData;
		bitmaps.setFieldPresent(Fields.SETTLEMENT_SERVICE_DATA);
	}
	
	public boolean hasSettlementServiceData() {
		return (settlementServiceData != null);
	}
	
	// f120 not used
	
	// F121
	public String getIssuingInstitutionIdentificationCode() {
		return issuingInstitutionIdentificationCode;
	}

	public void setIssuingInstitutionIdentificationCode(String issuingInstitutionIdentificationCode) {
		this.issuingInstitutionIdentificationCode = issuingInstitutionIdentificationCode;
		bitmaps.setFieldPresent(Fields.ISSUING_INSTITUTION_IDENTIFICATION_CODE);
	}
	
	public boolean hasIssuingInstitutionIdentificationCode() {
		return (issuingInstitutionIdentificationCode != null);
	}
	
	// F122 not used
	
	// F123
	public VerificationData getVerificationData() {
		return verificationData;
	}

	public void setVerificationData(VerificationData verificationData) {
		this.verificationData = verificationData; 
		bitmaps.setFieldPresent(Fields.VERIFICATION_DATA);
	}

	public boolean hasVerificationData() {
		return (verificationData != null);
	}
	
	// f124 not used
	
	// F125
	public SupportingInformation getSupportingInformation() {
		return supportingInformation;
	}

	public void setSupportingInformation(SupportingInformation supportingInformation) {
		this.supportingInformation = supportingInformation; 
		bitmaps.setFieldPresent(Fields.SUPPORTING_INFORMATION);
	}

	public boolean hasSupportingInformation() {
		return (supportingInformation != null);
	}
	
	// F126
	public SchemePrivateUse getSchemePrivateUse() {
		return schemePrivateUse;
	}

	public void setSchemePrivateUse(SchemePrivateUse schemePrivateUse) {
		this.schemePrivateUse = schemePrivateUse; 
		bitmaps.setFieldPresent(Fields.SCHEME_PRIVATE_USE);
	}

	public boolean hasSchemePrivateUse() {
		return (schemePrivateUse != null);
	}
	
	// F127
	public FileMaintenance getFileMaintenance() {
		return fileMaintenance;
	}

	public void setFileMaintenance(FileMaintenance fileMaintenance) {
		this.fileMaintenance = fileMaintenance; 
		bitmaps.setFieldPresent(Fields.FILE_MAINTENANCE);
	}

	public boolean hasFileMaintenance() {
		return (fileMaintenance != null);
	}
	
	// f128 not used
	// f129 not used
	
	// F130
	public String getTerminalCapabilityProfile() {
		return terminalCapabilityProfile;
	}

	public void setTerminalCapabilityProfile(String terminalCapabilityProfile) {
		this.terminalCapabilityProfile = terminalCapabilityProfile; 
		bitmaps.setFieldPresent(Fields.TERMINAL_CAPABILITY_PROFILE);
	}

	public boolean hasTerminalCapabilityProfile() {
		return (terminalCapabilityProfile != null);
	}
	
	// F131
	public String getTerminalVerificationResults() {
		return terminalVerificationResults;
	}

	public void setTerminalVerificationResults(String terminalVerificationResults) {
		this.terminalVerificationResults = terminalVerificationResults; 
		bitmaps.setFieldPresent(Fields.TERMINAL_VERIFICATION_RESULTS);
	}

	public boolean hasTerminalVerificationResults() {
		return (terminalVerificationResults != null);
	}
	
	// F132
	public String getUnpredictableNumber() {
		return unpredictableNumber;
	}

	public void setUnpredictableNumber(String unpredictableNumber) {
		this.unpredictableNumber = unpredictableNumber; 
		bitmaps.setFieldPresent(Fields.UNPREDICTABLE_NUMBER);
	}

	public boolean hasUnpredictableNumber() {
		return (unpredictableNumber != null);
	}
	
	// F133
	public String getTerminalSerialNumber() {
		return terminalSerialNumber;
	}

	public void setTerminalSerialNumber(String terminalSerialNumber) {
		this.terminalSerialNumber = terminalSerialNumber;
		bitmaps.setFieldPresent(Fields.TERMINAL_SERIAL_NUMBER);
	}
	
	public boolean hasTerminalSerialNumber() {
		return (terminalSerialNumber != null);
	}
	
	// F134
	public IssuerApplicationData getIssuerApplicationData() {
		return issuerApplicationData;
	}

	public void setIssuerApplicationData(IssuerApplicationData issuerApplicationData) {
		this.issuerApplicationData = issuerApplicationData;
		bitmaps.setFieldPresent(Fields.ISSUER_APPLICATION_DATA);
	}

	public boolean hasIssuerApplicationData() {
		return (issuerApplicationData != null);
	}

	// F135
	public IssuerDiscretionaryData getIssuerDiscretionaryData() {
		return issuerDiscretionaryData;
	}

	public void setIssuerDiscretionaryData(IssuerDiscretionaryData issuerDiscretionaryData) {
		this.issuerDiscretionaryData = issuerDiscretionaryData;
		bitmaps.setFieldPresent(Fields.ISSUER_DISCRETIONARY_DATA);
	}

	public boolean hasIssuerDiscretionaryData() {
		return (issuerDiscretionaryData != null);
	}

	// F136
	public String getCryptogram() {
		return cryptogram;
	}

	public void setCryptogram(String cryptogram) {
		this.cryptogram = cryptogram;
		bitmaps.setFieldPresent(Fields.CRYPTOGRAM);
	}

	public boolean hasCryptogram() {
		return (cryptogram != null);
	}

	// F137
	public BigInteger getApplicationTransactionCounter() {
		return applicationTransactionCounter;
	}

	public void setApplicationTransactionCounter(BigInteger applicationTransactionCounter) {
		this.applicationTransactionCounter = applicationTransactionCounter;
		bitmaps.setFieldPresent(Fields.APPLICATION_TRANSACTION_COUNTER);
	}

	public boolean hasApplicationTransactionCounter() {
		return (applicationTransactionCounter != null);
	}

	// F138
	public String getApplicationInterchangeProfile() {
		return applicationInterchangeProfile;
	}

	public void setApplicationInterchangeProfile(String applicationInterchangeProfile) {
		this.applicationInterchangeProfile = applicationInterchangeProfile;
		bitmaps.setFieldPresent(Fields.APPLICATION_INTERCHANGE_PROFILE);
	}

	public boolean hasApplicationInterchangeProfile() {
		return (applicationInterchangeProfile != null);
	}

	// F139
	public ArpcResponseCryptogramAndCode getArpcResponseCryptogramAndCode() {
		return arpcResponseCryptogramAndCode;
	}

	public void setArpcResponseCryptogramAndCode(ArpcResponseCryptogramAndCode arpcResponseCryptogramAndCode) {
		this.arpcResponseCryptogramAndCode = arpcResponseCryptogramAndCode;
		bitmaps.setFieldPresent(Fields.ARPC_RESPONSE_CRYPTOGRAM_AND_CODE);
	}

	public boolean hasArpcResponseCryptogramAndCode() {
		return (arpcResponseCryptogramAndCode != null);
	}

	// F140
	public IssuerAuthenticationData getIssuerAuthenticationData() {
		return issuerAuthenticationData;
	}

	public void setIssuerAuthenticationData(IssuerAuthenticationData issuerAuthenticationData) {
		this.issuerAuthenticationData = issuerAuthenticationData;
		bitmaps.setFieldPresent(Fields.ISSUER_AUTHENTICATION_DATA);
	}

	public boolean hasIssuerAuthenticationData() {
		return (issuerAuthenticationData != null);
	}
	
	// F141 not used
	
	// F142
	public IssuerScript getIssuerScript() {
		return issuerScript;
	}

	public void setIssuerScript(IssuerScript issuerScript) {
		this.issuerScript = issuerScript;
		bitmaps.setFieldPresent(Fields.ISSUER_SCRIPT);
	}

	public boolean hasIssuerScript() {
		return (issuerScript != null);
	}

	// F143
	public IssuerScriptResults getIssuerScriptResults() {
		return issuerScriptResults;
	}

	public void setIssuerScriptResults(IssuerScriptResults issuerScriptResults) {
		this.issuerScriptResults = issuerScriptResults;
		bitmaps.setFieldPresent(Fields.ISSUER_SCRIPT_RESULTS);
	}

	public boolean hasIssuerScriptResults() {
		return (issuerScriptResults != null);
	}

	// F144
	public BigInteger getIssuerTransactionType() {
		return issuerTransactionType;
	}

	public void setIssuerTransactionType(BigInteger issuerTransactionType) {
		this.issuerTransactionType = issuerTransactionType;
		bitmaps.setFieldPresent(Fields.ISSUER_TRANSACTION_TYPE);
	}

	public boolean hasIssuerTransactionType() {
		return (issuerTransactionType != null);
	}

	// F145
	public BigInteger getTerminalCountryCode() {
		return terminalCountryCode;
	}

	public void setTerminalCountryCode(BigInteger terminalCountryCode) {
		this.terminalCountryCode = terminalCountryCode;
		bitmaps.setFieldPresent(Fields.TERMINAL_COUNTRY_CODE);
	}

	public boolean hasTerminalCountryCode() {
		return (terminalCountryCode != null);
	}

	// F146
	public LocalDate getTerminalTransactionDate() {
		return terminalTransactionDate;
	}

	public void setTerminalTransactionDate(LocalDate terminalTransactionDate) {
		this.terminalTransactionDate = terminalTransactionDate;
		bitmaps.setFieldPresent(Fields.TERMINAL_TRANSACTION_DATE);
	}

	public boolean hasTerminalTransactionDate() {
		return (terminalTransactionDate != null);
	}

	// F147
	public BigInteger getCryptogramAmount() {
		return cryptogramAmount;
	}

	public void setCryptogramAmount(BigInteger cryptogramAmount) {
		this.cryptogramAmount = cryptogramAmount;
		bitmaps.setFieldPresent(Fields.CRYPTOGRAM_AMOUNT);
	}

	public boolean hasCryptogramAmount() {
		return (cryptogramAmount != null);
	}

	// F148
	public BigInteger getCryptogramCurrencyCode() {
		return cryptogramCurrencyCode;
	}

	public void setCryptogramCurrencyCode(BigInteger cryptogramCurrencyCode) {
		this.cryptogramCurrencyCode = cryptogramCurrencyCode;
		bitmaps.setFieldPresent(Fields.CRYPTOGRAM_CURRENCY_CODE);
	}

	public boolean hasCryptogramCurrencyCode() {
		return (cryptogramCurrencyCode != null);
	}

	// F149
	public BigInteger getCryptogramCashbackAmount() {
		return cryptogramCashbackAmount;
	}

	public void setCryptogramCashbackAmount(BigInteger cryptogramCashbackAmount) {
		this.cryptogramCashbackAmount = cryptogramCashbackAmount;
		bitmaps.setFieldPresent(Fields.CRYPTOGRAM_CASHBACK_AMOUNT);
	}

	public boolean hasCryptogramCashbackAmount() {
		return (cryptogramCashbackAmount != null);
	}
	
	// F150 and F151 not used
	
	// F152
	public String getSecondaryPinBlock() {
		return secondaryPinBlock;
	}

	public void setSecondaryPinBlock(String secondaryPinBlock) {
		this.secondaryPinBlock = secondaryPinBlock;
		bitmaps.setFieldPresent(Fields.SECONDARY_PIN_BLOCK);
	}

	public boolean hasSecondaryPinBlock() {
		return (secondaryPinBlock != null);
	}

}
