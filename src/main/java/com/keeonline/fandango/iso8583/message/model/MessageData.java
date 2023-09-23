package com.keeonline.fandango.iso8583.message.model;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.keeonline.fandango.iso8583.field.domain.complex.PosEntryModeCode;
import com.keeonline.fandango.iso8583.field.domain.complex.ProcessingCode;
import com.keeonline.fandango.iso8583.field.domain.financial.MonetaryAmount;

public class MessageData {
    
	private String messageTypeIdentifier;

    private BigInteger primaryAccountNumber;

    private ProcessingCode processingCode;

    private MonetaryAmount amountTransaction;

	private MonetaryAmount amountCardholderBilling;

    private LocalDateTime transmissionDateAndTime;

    private BigInteger systemTraceAuditNumber;

    private LocalTime timeLocalTransaction;

    private LocalDate dateLocalTransaction;

	private LocalDate dateExpiration;

    private LocalDate dateSettlement;

	private LocalDate dateConversion;
    
    private BigInteger merchantType;

    private PosEntryModeCode posEntryModeCode;

    private BigInteger acquiringInstitutionIdentificationCode;

    private String retrievalReferenceNumber;

	private String authorizationIdentificationResponse;

    private String responseCode;

    private String cardAcceptorTerminalIdentification;

    private String cardAcceptorIdentificationCode;

    private String privateUseFields;


    public String getMessageTypeIdentifier() {
        return messageTypeIdentifier;
    }

    public void setMessageTypeIdentifier(String messageTypeIdentifier) {
        this.messageTypeIdentifier = messageTypeIdentifier;
    }

    public BigInteger getPrimaryAccountNumber() {
        return primaryAccountNumber;
    }

    public void setPrimaryAccountNumber(BigInteger primaryAccountNumber) {
        this.primaryAccountNumber = primaryAccountNumber;
    }

    public ProcessingCode getProcessingCode() {
        return processingCode;
    }

    public void setProcessingCode(ProcessingCode processingCode) {
        this.processingCode = processingCode;
    }

    public MonetaryAmount getAmountTransaction() {
        return amountTransaction;
    }

    public void setAmountTransaction(MonetaryAmount amountTransaction) {
        this.amountTransaction = amountTransaction;
    }

    public MonetaryAmount getAmountCardholderBilling() {
        return amountCardholderBilling;
    }

    public void setAmountCardholderBilling(MonetaryAmount amountCardholderBilling) {
        this.amountCardholderBilling = amountCardholderBilling;
    }

    public LocalDateTime getTransmissionDateAndTime() {
        return transmissionDateAndTime;
    }

    public void setTransmissionDateAndTime(LocalDateTime transmissionDateAndTime) {
        this.transmissionDateAndTime = transmissionDateAndTime;
    }

    public BigInteger getSystemTraceAuditNumber() {
        return systemTraceAuditNumber;
    }

    public void setSystemTraceAuditNumber(BigInteger systemTraceAuditNumber) {
        this.systemTraceAuditNumber = systemTraceAuditNumber;
    }

    public LocalTime getTimeLocalTransaction() {
        return timeLocalTransaction;
    }

    public void setTimeLocalTransaction(LocalTime timeLocalTransaction) {
        this.timeLocalTransaction = timeLocalTransaction;
    }

    public LocalDate getDateLocalTransaction() {
        return dateLocalTransaction;
    }

    public void setDateLocalTransaction(LocalDate dateLocalTransaction) {
        this.dateLocalTransaction = dateLocalTransaction;
    }

    public BigInteger getMerchantType() {
        return merchantType;
    }

    public void setMerchantType(BigInteger merchantType) {
        this.merchantType = merchantType;
    }
    
    public PosEntryModeCode getPosEntryModeCode() {
        return posEntryModeCode;
    }

    public void setPosEntryModeCode(PosEntryModeCode posEntryModeCode) {
        this.posEntryModeCode = posEntryModeCode;
    }

    public BigInteger getAcquiringInstitutionIdentificationCode() {
        return acquiringInstitutionIdentificationCode;
    }

    public void setAcquiringInstitutionIdentificationCode(BigInteger acquiringInstitutionIdentificationCode) {
        this.acquiringInstitutionIdentificationCode = acquiringInstitutionIdentificationCode;
    }

    public String getRetrievalReferenceNumber() {
        return retrievalReferenceNumber;
    }

    public void setRetrievalReferenceNumber(String retrievalReferenceNumber) {
        this.retrievalReferenceNumber = retrievalReferenceNumber;
    }

    public String getAuthorizationIdentificationResponse() {
        return authorizationIdentificationResponse;
    }

    public void setAuthorizationIdentificationResponse(String authorizationIdentificationResponse) {
        this.authorizationIdentificationResponse = authorizationIdentificationResponse;
    }

	public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getCardAcceptorTerminalIdentification() {
        return cardAcceptorTerminalIdentification;
    }

    public void setCardAcceptorTerminalIdentification(String cardAcceptorTerminalIdentification) {
        this.cardAcceptorTerminalIdentification = cardAcceptorTerminalIdentification;
    }

    public String getCardAcceptorIdentificationCode() {
        return cardAcceptorIdentificationCode;
    }

    public void setCardAcceptorIdentificationCode(String cardAcceptorIdentificationCode) {
        this.cardAcceptorIdentificationCode = cardAcceptorIdentificationCode;
    }

    public String getPrivateUseFields() {
        return privateUseFields;
    }

    public void setPrivateUseFields(String privateUseFields) {
        this.privateUseFields = privateUseFields;
    }

    public LocalDate getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(LocalDate dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

	public LocalDate getDateSettlement() {
        return dateSettlement;
    }

    public void setDateSettlement(LocalDate dateSettlement) {
        this.dateSettlement = dateSettlement;
    }

    public LocalDate getDateConversion() {
        return dateConversion;
    }

    public void setDateConversion(LocalDate dateConversion) {
        this.dateConversion = dateConversion;
    }

}
