package com.keeonline.fandango.iso8583.message.adapter;

import static java.util.Objects.nonNull;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import java.math.BigDecimal;
import com.keeonline.fandango.iso8583.message.model.MessageData;
import com.keeonline.fandango.iso8583.field.domain.complex.CardAcceptorNameLocation;
import com.keeonline.fandango.iso8583.field.domain.complex.PosEntryModeCode;
import com.keeonline.fandango.iso8583.field.domain.complex.ProcessingCode;
import com.keeonline.fandango.iso8583.message.transformer.TransformedMessage;
import com.keeonline.fandango.iso8583.standard.common.Fields;
import com.keeonline.fandango.iso8583.standard.common.MessageBitmaps;

public abstract class MessageDataAdapter {

    private String fieldNamePrefix;

	public MessageDataAdapter(String fieldNamePrefix) {
        this.fieldNamePrefix = fieldNamePrefix;
    }

	public abstract MessageData messageDataFromTransformedMessage(TransformedMessage transformedMessage);

	public abstract Object getStandardSpecificFieldByNumber(MessageData messageData, int fieldNumber);

    public String getFieldNamePrefix() {
		return fieldNamePrefix;
	}

	public MessageBitmaps getMessageBitMaps(MessageData messageData) {
		MessageBitmaps bitmaps = new MessageBitmaps(192);
		Object fieldValue = null;

		for ( int i = 1 ; i<193 ; i++ ) {
			fieldValue = getFieldByNumber(messageData, i);
			if (nonNull(fieldValue)) {
				bitmaps.setFieldPresent(i);
			}
		}

		return bitmaps;
	}

	protected void setFieldByNumber(MessageData messageData, Object field,int fieldNumber) {
		if ((fieldNumber > 0) && (fieldNumber < 193)) {

			switch (fieldNumber)
			{		

//TODO: Add arguments and uncomment fields as they come into use
//			case Iso8583Fields.BITMAP_SECONDARY:
//				setBitmapSecondary(); return; 
			case Fields.PRIMARY_ACCOUNT_NUMBER:
				messageData.setPrimaryAccountNumber((BigInteger) field); return; 
			case Fields.PROCESSING_CODE:
				messageData.setProcessingCode((ProcessingCode) field); return; 
//			case Iso8583Fields.AMOUNT_CARDHOLDER_BILLING:
//				setAmountCardholderBilling(); return; 
			case Fields.TRANSMISSION_DATE_AND_TIME:
				messageData.setTransmissionDateAndTime((LocalDateTime) field); return; 
//			case Iso8583Fields.CONVERSION_RATE_SETTLEMENT:
//				setConversionRateSettlement(); return; 
			case Fields.CONVERSION_RATE_CARDHOLDER_BILLING:
				messageData.setConversionRateCardholderBilling((BigDecimal) field); return; 
			case Fields.SYSTEM_TRACE_AUDIT_NUMBER:
				messageData.setSystemTraceAuditNumber((BigInteger) field); return; 
			case Fields.TIME_LOCAL_TRANSACTION:
				messageData.setTimeLocalTransaction((LocalTime) field); return; 
			case Fields.DATE_LOCAL_TRANSACTION:
				messageData.setDateLocalTransaction((LocalDate) field); return; 
			case Fields.DATE_EXPIRATION:
				messageData.setDateExpiration((LocalDate) field); return; 
			case Fields.DATE_SETTLEMENT:
				messageData.setDateSettlement((LocalDate) field); return; 
			case Fields.DATE_CONVERSION:
				messageData.setDateConversion((LocalDate) field); return; 
			case Fields.MERCHANT_TYPE:
				messageData.setMerchantType((BigInteger) field); return; 
//			case Iso8583Fields.ACQUIRING_INSTITUTION_COUNTRY_CODE:
//				setAcquiringInstitutionCountryCode(); return; 
//			case Iso8583Fields.PAN_EXTENDED_COUNTRY_CODE:
//				setPanExtendedCountryCode(); return; 
			case Fields.POINT_OF_SERVICE_ENTRY_MODE_CODE:
				messageData.setPosEntryModeCode((PosEntryModeCode) field); return; 
//			case Iso8583Fields.CARD_SEQUENCE_NUMBER:
//				setCardSequenceNumber(); return; 
//			case Iso8583Fields.POINT_OF_SERVICE_CONDITION_CODE:
//				setPosConditionCode(); return; 
//			case Iso8583Fields.POINT_OF_SERVICE_PIN_CAPTURE_CODE:
//				setPosPinCaptureCode(); return; 
//			case Iso8583Fields.AMOUNT_TRANSACTION_FEE:
//				setAmountTransactionFee(); return; 
			case Fields.ACQUIRING_INSTITUTION_IDENTIFICATION_CODE:
				messageData.setAcquiringInstitutionIdentificationCode((BigInteger) field); return; 
//			case Iso8583Fields.FORWARDING_INSTITUTION_IDENTIFICATION_CODE:
//				setForwardingInstitutionIdentificationCode(); return; 
//			case Iso8583Fields.TRACK_2_DATA: 
//				setTrack2Data(); return; 
			case Fields.RETRIEVAL_REFERENCE_NUMBER:
				messageData.setRetrievalReferenceNumber((String) field); return; 
			case Fields.AUTHORIZATION_IDENTIFICATION_RESPONSE:
				messageData.setAuthorizationIdentificationResponse((String) field); return; 
			case Fields.RESPONSE_CODE:
				messageData.setResponseCode((String) field); return; 
			case Fields.CARD_ACCEPTOR_TERMINAL_IDENTIFICATION:
				messageData.setCardAcceptorTerminalIdentification((String) field); return; 
			case Fields.CARD_ACCEPTOR_IDENTIFICATION_CODE:
				messageData.setCardAcceptorIdentificationCode((String) field); return; 
			case Fields.CARD_ACCEPTOR_NAME_LOCATION:
				messageData.setCardAcceptorNameLocation((CardAcceptorNameLocation) field); return; 
//			case Fields.ADDITIONAL_RESPONSE_DATA:
//				setAdditionalResponseData((String) field); return; 
//			case Iso8583Fields.TRACK_1_DATA: 
//				setTrack1Data(); return; 
//			case Iso8583Fields.AMOUNT_FEES:
//				setAmountFees(); return; 
			case Fields.ADDITIONAL_DATA_PRIVATE:
				messageData.setAdditionalDataPrivateUse((String) field); return; 
//			case Iso8583Fields.CURRENCY_CODE_TRANSACTION:
//				setCurrencyCodeTransaction(); return; 
//			case Iso8583Fields.CURRENCY_CODE_SETTLEMENT:
//				setCurrencyCodeSettlement(); return; 
//			case Iso8583Fields.CURRENCY_CODE_CARDHOLDER_BILLING:
//				setCurrencyCodeCardholderBilling(); return; 
//			case Iso8583Fields.PIN_DATA:
//				setPinData(); return; 
//			case Fields.SECURITY_RELATED_CONTROL_INFORMATION:
//				setSecurityRelatedControlInformation((SecurityRelatedControlInformation)field); return; 
//			case Fields.ADDITIONAL_AMOUNTS:
//				setAdditionalAmounts((AdditionalAmounts)field); return; 
//			case Iso8583Fields.INTEGRATED_CIRCUIT_CARD_RELATED_DATA:
//				setIntegratedCircuitCardRelatedData(); return; 
//			case Iso8583Fields.NATIONAL_POINT_OF_SERVICE_GEOGRAPHIC_DATA:
//				setNationalPointOfServiceGeograhicData(); return; 
			case Fields.POINT_OF_SERVICE_DATA:
				messageData.setPointOfServiceData((String) field); return; 
//			case Iso8583Fields.OTHER_AMOUNTS:
//				setOtherAmounts(); return; 
//			case Fields.CUSTOM_PAYMENT_SERVICE_FIELDS:
//				setCustomPaymentServiceFields((String) field); return; 
			case Fields.PRIVATE_USE_FIELDS:
				messageData.setPrivateUseFields((String) field); return;
//			case Iso8583Fields.BITMAP_TERTIARY:
//				setBitmapTertiary(); return; 
//			case Iso8583Fields.SETTLEMENT_CODE:
//				setSettlementCode(); return; 
//			case Iso8583Fields.RECEIVING_INSTITUTION_COUNTRY_CODE:
//				setReceivingInstitutionCountryCode(); return; 
//			case Iso8583Fields.SETTLEMENT_INSTITUTION_COUNTRY_CODE:
//				setSettlementInstitutionCountryCode(); return;  
//			case Fields.NETWORK_MANAGEMENT_INFORMATION_CODE:
//				setNetworkManagementInformationCode((BigInteger) field); return; 
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
//			case Fields.ACCOUNT_IDENTIFICATION_1:
//				setAccountIdentification1((String) field); return; 
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

	// this method only get fields that are with one to one with fields in the DTO. 
	public Object getFieldByNumber(MessageData messageData, int fieldNumber){
		if ((fieldNumber > 0) && (fieldNumber < 193)) {
			
			switch (fieldNumber)
			{		
				case Fields.PRIMARY_ACCOUNT_NUMBER:
					return messageData.getPrimaryAccountNumber();
				case Fields.PROCESSING_CODE:
					return messageData.getProcessingCode();
				// case Fields.AMOUNT_SETTLEMENT:
				// 	return messageData.getAmountSettlement();
				// case Fields.AMOUNT_CARDHOLDER_BILLING:
				// 	return messageData.getAmountCardholderBilling();
				case Fields.TRANSMISSION_DATE_AND_TIME:
					return messageData.getTransmissionDateAndTime();
				// case Fields.CONVERSION_RATE_SETTLEMENT:
				// 	return messageData.getConversionRateSettlement();
				case Fields.CONVERSION_RATE_CARDHOLDER_BILLING:
					return messageData.getConversionRateCardholderBilling();
				case Fields.SYSTEM_TRACE_AUDIT_NUMBER:
					return messageData.getSystemTraceAuditNumber();
				case Fields.TIME_LOCAL_TRANSACTION:
					return messageData.getTimeLocalTransaction();
				case Fields.DATE_LOCAL_TRANSACTION:
					return messageData.getDateLocalTransaction();
				case Fields.DATE_EXPIRATION:
					return messageData.getDateExpiration();
				case Fields.DATE_SETTLEMENT:
					return messageData.getDateSettlement();
				case Fields.DATE_CONVERSION:
					return messageData.getDateConversion();
				case Fields.MERCHANT_TYPE:
					return messageData.getMerchantType();
				// case Fields.ACQUIRING_INSTITUTION_COUNTRY_CODE:
				// 	return messageData.getAcquiringInstitutionCountryCode();
				// case Fields.PAN_EXTENDED_COUNTRY_CODE:
				// 	return messageData.getPanExtendedCountryCode();
				case Fields.POINT_OF_SERVICE_ENTRY_MODE_CODE:
					return messageData.getPosEntryModeCode();
				// case Fields.CARD_SEQUENCE_NUMBER:
				// 	return messageData.getCardSequenceNumber();
				// case Fields.POINT_OF_SERVICE_CONDITION_CODE:
				// 	return messageData.getPosConditionCode();
				// case Fields.POINT_OF_SERVICE_PIN_CAPTURE_CODE:
				// 	return messageData.getPosPinCaptureCode();
				// case Fields.AMOUNT_TRANSACTION_FEE:
				// 	return messageData.getAmountTransactionFee();
				case Fields.ACQUIRING_INSTITUTION_IDENTIFICATION_CODE:
					return messageData.getAcquiringInstitutionIdentificationCode();
				// case Fields.FORWARDING_INSTITUTION_IDENTIFICATION_CODE:
				// 	return messageData.getForwardingInstitutionIdentificationCode();
				// case Fields.TRACK_2_DATA:
				// 	return messageData.getTrack2Data();
				case Fields.RETRIEVAL_REFERENCE_NUMBER:
					return messageData.getRetrievalReferenceNumber();
				case Fields.AUTHORIZATION_IDENTIFICATION_RESPONSE:
					return messageData.getAuthorizationIdentificationResponse();
				case Fields.RESPONSE_CODE:
					return messageData.getResponseCode();
				case Fields.CARD_ACCEPTOR_TERMINAL_IDENTIFICATION:
					return messageData.getCardAcceptorTerminalIdentification();
				case Fields.CARD_ACCEPTOR_IDENTIFICATION_CODE:
					return messageData.getCardAcceptorIdentificationCode();
				case Fields.CARD_ACCEPTOR_NAME_LOCATION:
					return messageData.getCardAcceptorNameLocation();
				// case Fields.ADDITIONAL_RESPONSE_DATA:
				// 	return messageData.getAdditionalResponseData();
				// case Fields.TRACK_1_DATA:
				// 	return messageData.getTrack1Data();
				// case Fields.AMOUNT_FEES:
				// 	return messageData.getAmountFees();
				case Fields.ADDITIONAL_DATA_PRIVATE:
					return messageData.getAdditionalDataPrivateUse();
				// case Fields.CURRENCY_CODE_SETTLEMENT:
				// 	return messageData.getCurrencyCodeSettlement();
				// case Fields.CURRENCY_CODE_CARDHOLDER_BILLING:
				// 	return messageData.getCurrencyCodeCardholderBilling();
				// case Fields.PIN_DATA:
				// 	return messageData.getPinData();
				// case Fields.SECURITY_RELATED_CONTROL_INFORMATION:
				// 	return messageData.getSecurityRelatedControlInformation();
				// case Fields.ADDITIONAL_AMOUNTS:
				// 	return messageData.getAdditionalAmounts();
				// case Fields.INTEGRATED_CIRCUIT_CARD_RELATED_DATA:
				// 	return messageData.getIntegratedCircuitCardRelatedData();
				// case Fields.NATIONAL_POINT_OF_SERVICE_GEOGRAPHIC_DATA:
				// 	return messageData.getNationalPointOfServiceGeograhicData();
				case Fields.POINT_OF_SERVICE_DATA:
					return messageData.getPointOfServiceData();
				// case Fields.OTHER_AMOUNTS:
				// 	return messageData.getOtherAmounts();
				// case Fields.CUSTOM_PAYMENT_SERVICE_FIELDS:
				// 	return messageData.getCustomPaymentServiceFields();
				case Fields.PRIVATE_USE_FIELDS:
					return messageData.getPrivateUseFields();
				// case Fields.BITMAP_TERTIARY:
				// 	return messageData.getBitmapTertiary();
				// case Fields.SETTLEMENT_CODE:
				// 	return messageData.getSettlementCode();
				// case Fields.RECEIVING_INSTITUTION_COUNTRY_CODE:
				// 	return messageData.getReceivingInstitutionCountryCode();
				// case Fields.SETTLEMENT_INSTITUTION_COUNTRY_CODE:
				// 	return messageData.getSettlementInstitutionCountryCode();
				// case Fields.NETWORK_MANAGEMENT_INFORMATION_CODE:
				// 	return messageData.getNetworkManagementInformationCode();
				// case Fields.DATE_ACTION:
				// 	return messageData.getDateAction();
				// case Fields.CREDITS_NUMBER:
				// 	return messageData.getCreditsNumber();	
				// case Fields.CREDITS_REVERSAL_NUMBER:
				// 	return messageData.getCreditsReversalNumber();	
				// case Fields.DEBITS_NUMBER:
				// 	return messageData.getDebitsNumber();	
				// case Fields.DEBITS_REVERSAL_NUMBER:
				// 	return messageData.getDebitsReversalNumber();	
				// case Fields.CREDITS_AMOUNT:
				// 	return messageData.getCreditsAmount();	
				// case Fields.CREDITS_REVERSAL_AMOUNT:
				// 	return messageData.getCreditsReversalAmount();	
				// case Fields.DEBITS_AMOUNT:
				// 	return messageData.getDebitsAmount();	
				// case Fields.DEBITS_REVERSAL_AMOUNT:
				// 	return messageData.getDebitsReversalAmount();	
				// case Fields.ORIGINAL_DATA_ELEMENTS:
				// 	return messageData.getOriginalDataElements();	
				// case Fields.FILE_UPDATE_CODE:
				// 	return messageData.getFileUpdateCode();
				// case Fields.FILE_SECURITY_CODE:
				// 	return messageData.getFileSecurityCode();	
				// case Fields.REPLACEMENT_AMOUNTS:
				// 	return messageData.getReplacementAmounts();	
				// case Fields.MESSAGE_SECURITY_CODE:
				// 	return messageData.getMessageSecurityCode();
				// case Fields.AMOUNT_NET_SETTLEMENT:
				// 	return messageData.getAmountNetSettlement();	
				// case Fields.SETTLEMENT_INSTITUTION_IDENTIFICATION_CODE:
				// 	return messageData.getSettlementInstitutionIdentificationCode();	
				// case Fields.RECEIVING_INSTITUTION_IDENTIFICATION_CODE:
				// 	return messageData.getReceivingInstitutionIdentificationCode();
				// case Fields.FILE_NAME:
				// 	return messageData.getFileName();	
				// case Fields.ACCOUNT_IDENTIFICATION_1:
				// 	return messageData.getAccountIdentification1();
				// case Fields.ACCOUNT_IDENTIFICATION_2:
				// 	return messageData.getAccountIdentification2();
				// case Fields.TRANSACTION_SPECIFIC_DATA:
				// 	return messageData.getTransactionSpecificData();
				// case Fields.DOUBLE_LENGTH_DES_KEY:
				// 	return messageData.getDoubleLengthDesKey();
				// case Fields.ADDITIONAL_TRACE_DATA:
				// 	return messageData.getAdditionalTraceData();
				// case Fields.CARD_ISSUER_REFERENCE_DATA:
				// 	return messageData.getCardIssuerReferenceData();
				// case Fields.NATIONAL_USE:
				// 	return messageData.getNationalUse();
				// case Fields.INTRA_COUNTRY_DATA:
				// 	return messageData.getIntraCountryData();
				// case Fields.SETTLEMENT_SERVICE_DATA:
				// 	return messageData.getSettlementServiceData();	
				// case Fields.ISSUING_INSTITUTION_IDENTIFICATION_CODE:
				// 	return messageData.getIssuingInstitutionIdentificationCode();
				// case Fields.VERIFICATION_DATA:
				// 	return messageData.getVerificationData();
				// case Fields.SUPPORTING_INFORMATION:
				// 	return messageData.getSupportingInformation();	
				// case Fields.SCHEME_PRIVATE_USE:
				// 	return messageData.getSchemePrivateUse();	
				// case Fields.FILE_MAINTENANCE:
				// 	return messageData.getFileMaintenance();	
				// case Fields.TERMINAL_CAPABILITY_PROFILE:
				// 	return messageData.getTerminalCapabilityProfile();	
				// case Fields.TERMINAL_VERIFICATION_RESULTS:
				// 	return messageData.getTerminalVerificationResults();
				// case Fields.UNPREDICTABLE_NUMBER:
				// 	return messageData.getUnpredictableNumber();	
				// case Fields.TERMINAL_SERIAL_NUMBER:
				// 	return messageData.getTerminalSerialNumber();	
				// case Fields.ISSUER_APPLICATION_DATA:
				// 	return messageData.getIssuerApplicationData();
				// case Fields.ISSUER_DISCRETIONARY_DATA:
				// 	return messageData.getIssuerDiscretionaryData();	
				// case Fields.CRYPTOGRAM:
				// 	return messageData.getCryptogram();	
				// case Fields.APPLICATION_TRANSACTION_COUNTER:
				// 	return messageData.getApplicationTransactionCounter();		
				// case Fields.APPLICATION_INTERCHANGE_PROFILE:
				// 	return messageData.getApplicationInterchangeProfile();
				// case Fields.ARPC_RESPONSE_CRYPTOGRAM_AND_CODE:
				// 	return messageData.getArpcResponseCryptogramAndCode();
				// case Fields.ISSUER_AUTHENTICATION_DATA:
				// 	return messageData.getIssuerAuthenticationData();
				// case Fields.ISSUER_SCRIPT:
				// 	return messageData.getIssuerScript();
				// case Fields.ISSUER_SCRIPT_RESULTS:
				// 	return messageData.getIssuerScriptResults();
				// case Fields.ISSUER_TRANSACTION_TYPE:
				// 	return messageData.getIssuerTransactionType();
				// case Fields.TERMINAL_COUNTRY_CODE:
				// 	return messageData.getTerminalCountryCode();
				// case Fields.TERMINAL_TRANSACTION_DATE:
				// 	return messageData.getTerminalTransactionDate();
				// case Fields.CRYPTOGRAM_AMOUNT:
				// 	return messageData.getCryptogramAmount();
				// case Fields.CRYPTOGRAM_CURRENCY_CODE:
				// 	return messageData.getCryptogramCurrencyCode();
				// case Fields.CRYPTOGRAM_CASHBACK_AMOUNT:
				// 	return messageData.getCryptogramCashbackAmount();
				// case Fields.SECONDARY_PIN_BLOCK:
				// 	return messageData.getSecondaryPinBlock();
			}
		
		}

		return null;
	}

}
