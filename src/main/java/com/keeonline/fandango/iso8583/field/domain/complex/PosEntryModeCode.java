package com.keeonline.fandango.iso8583.field.domain.complex;

import java.math.BigInteger;

public class PosEntryModeCode {
	private BigInteger panEntryMode;
	private BigInteger pinEntryMode;
	
	public PosEntryModeCode() {
		super();
		panEntryMode = new BigInteger("0");
		pinEntryMode = new BigInteger("0");
	};
	
	public PosEntryModeCode(String value) {
		super();
	}
	
	public BigInteger getPanEntryMode() {
		return panEntryMode;
	}
	
	public void setPanEntryMode(BigInteger panEntryMode) {
		this.panEntryMode = panEntryMode;
	}
	
	public BigInteger getPinEntryMode() {
		return pinEntryMode;
	}
	
	public void setPinEntryMode(BigInteger pinEntryMode) {
		this.pinEntryMode = pinEntryMode;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("panEntryMode=" + panEntryMode);
		sb.append(", pinEntryMode=" + pinEntryMode);
		return sb.toString();
	}

}
