package com.keeonline.fandango.iso8583.field.domain.complex;

import java.math.BigInteger;

import com.google.gson.annotations.SerializedName;

public class SecurityRelatedControlInformation {
	@SerializedName("f53.1")
	private BigInteger pinSecurityTypeCode;
	@SerializedName("f53.2")
	private BigInteger pinEncryptionTypeCode;
	@SerializedName("f53.3")
	private BigInteger pinBlockFormatCode;
	@SerializedName("f53.4")
	private BigInteger pinKeyIndex;
	@SerializedName("f53.5")
	private BigInteger reserved1;
	@SerializedName("f53.6")
	private BigInteger reserved2;

	public SecurityRelatedControlInformation() {
		super();
		pinSecurityTypeCode = new BigInteger("0");
		pinEncryptionTypeCode = new BigInteger("0");
		pinBlockFormatCode = new BigInteger("0");
		pinKeyIndex = new BigInteger("0");
		reserved1 = new BigInteger("0");
		reserved2 = new BigInteger("0");
	}
	
	public BigInteger getPinSecurityTypeCode() {
		return pinSecurityTypeCode;
	}
	
	public void setPinSecurityTypeCode(BigInteger pinSecurityTypeCode) {
		this.pinSecurityTypeCode = pinSecurityTypeCode;
	}
	
	public BigInteger getPinEncryptionTypeCode() {
		return pinEncryptionTypeCode;
	}
	
	public void setPinEncryptionTypeCode(BigInteger pinEncryptionTypeCode) {
		this.pinEncryptionTypeCode = pinEncryptionTypeCode;
	}
	
	public BigInteger getPinBlockFormatCode() {
		return pinBlockFormatCode;
	}
	
	public void setPinBlockFormatCode(BigInteger pinBlockFormatCode) {
		this.pinBlockFormatCode = pinBlockFormatCode;
	}
	
	public BigInteger getPinKeyIndex() {
		return pinKeyIndex;
	}
	
	public void setPinKeyIndex(BigInteger pinKeyIndex) {
		this.pinKeyIndex = pinKeyIndex;
	}
	
	public BigInteger getReserved1() {
		return reserved1;
	}
	
	public void setReserved1(BigInteger reserved1) {
		this.reserved1 = reserved1;
	}
	
	public BigInteger getReserved2() {
		return reserved2;
	}
	
	public void setReserved2(BigInteger reserved2) {
		this.reserved2 = reserved2;
	}
	
}
