package com.keeonline.fandango.iso8583.standard.common;

import java.math.BigInteger;

/**
 * 
 * This class provides methods to manipulate and report on the bitmap fields
 * of an ISO8583 message.<br>
 * There are up to 192 fields in an ISO8583 message, each field being numbered from 
 * 1 to 192 (inclusive).<br>
 * One bit per field is present in the ISO8583 bitmaps, with the required 192 bits
 * comprising 3 64-bit bitmaps, namely the primary, secondary and tertiary bitmaps.<br>
 * The bit positions in the primary bitmap indicate the presence or absence of the 
 * corresponding fields 1-64 (bit positions are from left to right in the bitmap).<br>
 * The bit positions in the secondary bitmap indicate the presence or absence of the 
 * corresponding fields 65-128 and those in the tertiary bitmap correspond to fields
 * 129-192.<br>
 * A bit value of 1 indicates that the corresponding field is present in the message. A
 * value of 0 indicates that it is absent.
 * The 1st bit of the primary bitmap (i.e. the bit corresponding to field 1) indicates
 * whether or not the secondary bitmap is present in the message. The 1st bit of the 
 * secondary bitmap (i.e. the bit corresponding to field 65) indicates
 * whether or not the tertiary bitmap is present in the message. 
 *
 */
public class MessageBitmaps extends FieldBitmap {
	/**
	 * Constructor
	 * @param lengthInBits The number of bits in the bitmap 
	 */	
	public MessageBitmaps(int lengthInBits) {
		super(lengthInBits);
	}

	/**
	 * Constructor
	 * @param primary hex string representation of primary bitmap
	 * @param secondary hex string representation of secondary bitmap
	 * @param tertiary hex string representation of tertiary bitmap
	 */
	public MessageBitmaps(String primary,String secondary,String tertiary) {
		super((primary.length()+secondary.length()+tertiary.length())*4);
	}

	/** 
	 * Sets the bit corresponding to the given field number.
	 * 
	 * @param fieldNumber the number of the field for which the corresponding bit is switched on
	 */
	@Override
	public void setFieldPresent(int fieldNumber) {
		if (fieldNumber < 65) {
			bitmap = bitmap.setBit(getBitIndex(fieldNumber));
		}
		else if (fieldNumber < 129 ) {
			bitmap = bitmap.setBit(getBitIndex(Fields.BITMAP_SECONDARY));
		}
		else {
			bitmap = bitmap.setBit(getBitIndex(Fields.BITMAP_TERTIARY));
		}
	}

	/**
	 * Returns a hex representation of the 64-bit primary bitmap.
	 * @return A hex string of 16 characters representing the bit pattern comprising the primary bitmap.
	 */
	public String getPrimary() {
		return String.format("%0"+getLengthInNibbles()+"x",bitmap).substring(0,16);
	}

	/**
	 * Returns a hex representation of the 64-bit secondary bitmap.
	 * @return A hex string of 16 characters representing the bit pattern comprising the secondary bitmap.
	 */
	public String getSecondary() {
		return String.format("%0"+getLengthInNibbles()+"x",bitmap).substring(16,32);
	}

	/**
	 * Returns a hex representation of the 64-bit tertiary bitmap.
	 * @return A hex string of 16 characters representing the bit pattern comprising the tertiary bitmap.
	 */
	public String getTertiary() {
		return String.format("%0"+getLengthInNibbles()+"x",bitmap).substring(32,48);
	}

	/**
	 * Sets the value of the primary bitmap
	 * @param hex A 16 character hex string representation of the field bits in the primary bitmap.
	 */
	public void setPrimary(String hex) {
		BigInteger primary = new BigInteger(hex,16);
		bitmap = bitmap.add(primary.shiftLeft(128));
	}

	/**
	 * Sets the value of the secondary bitmap
	 * @param hex A 16 character hex string representation of the field bits in the secondary bitmap.
	 */
	public void setSecondary(String hex) {
		BigInteger primary = new BigInteger(hex,16);
		bitmap = bitmap.add(primary.shiftLeft(64));
	}

	/**
	 * Sets the value of the tertiary bitmap
	 * @param hex A 16 character hex string representation of the field bits in the tertiary bitmap.
	 */
	public void setTertiary(String hex) {
		BigInteger primary = new BigInteger(hex,16);
		bitmap = bitmap.add(primary);
	}

	public boolean containsSecondaryFields() {
		return !(getSecondary().equals("0000000000000000"));
	}

	public boolean containsTertiaryFields() {
		return !(getTertiary().equals("0000000000000000"));
	}

}
