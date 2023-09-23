package com.keeonline.fandango.iso8583.standard.common;

import java.math.BigInteger;

public class FieldBitmap {

	protected BigInteger bitmap;
	
	private int lengthInBits;
	private int lengthInNibbles;
	
	/**
	 * Constructor
	 * @param lengthInBits The number of bits in the bitmap 
	 */	
	public FieldBitmap(int lengthInBits) {
		this.lengthInBits = lengthInBits;
		this.lengthInNibbles = lengthInBits/4;
		bitmap = new BigInteger("0");
	}

	/**
	 * Sets the value of the bitmap
	 * @param hex A hex string representation of the bitmap.
	 */
	public void setBitmap(String hex) {
		bitmap = new BigInteger(hex,16);
	}

	/** 
	 * Calculates the bit index from the given field number.
	 * @param fieldNumber The number of the field for which the bit index should be calculated.
	 * @return The index of the bit corresponding to the given field.
	 */
	protected int getBitIndex(int fieldNumber){
		return lengthInBits-fieldNumber;
	}

	/** 
	 * Sets the bit corresponding to the given field number.
	 * 
	 * @param fieldNumber the number of the field for which the corresponding bit is switched on
	 */
	public void setFieldPresent(int fieldNumber) {
		bitmap = bitmap.setBit(getBitIndex(fieldNumber));
	}

	/**
	 * Indicates whether or not the given field is present (i.e. the bit corresponding 
	 * to the given field number is set).
	 * @param fieldNumber the number of the field for which the bit setting should be checked
	 * @return true if the corresponding bit is on, otherwise false
	 */
	public boolean fieldIsPresent(int fieldNumber){
		return bitmap.testBit(lengthInBits-fieldNumber);
	}

	/**
	 * Returns a hex representation of the field bitmap.
	 * @return A hex string of 6 characters representing the bit pattern comprising the field bitmap.
	 */
	public String getBitmap() {
		return String.format("%0"+lengthInNibbles+"x",bitmap).substring(0,lengthInNibbles);
	}

	public int getLengthInBits() {
		return lengthInBits;
	}

	public int getLengthInNibbles() {
		return lengthInNibbles;
	}

	@Override
	public String toString() {
		return getBitmap();
	}

	/**
	 * Indicated if more bits to the right of the given field number are set.
	 * @param fieldNumber The field number after which bit positions are checked.
	 * @return true if any bits from fieldNumber+1 to 192 (inclusive) are set, false if no more bits are set.
	 */
	public boolean moreFields(int fieldNumber) {
		return (bitmap.getLowestSetBit() < getBitIndex(fieldNumber));
	}

	/**
	 * Returns the number of the field that corresponds to the next bit set after the bit corresponding to 
	 * the given fieldNumber.
	 * @param fieldNumber The field number after which bit positions are checked.
	 * @return The field number of the field corresponding to the next set bit, -1 if no more bits are set.
	 */
	public int nextField(int fieldNumber) {
		int i = (getBitIndex(fieldNumber)-1);
		while (i >= 0) {
			if (bitmap.testBit(i)) {
				return (getLengthInBits()-i);
			}
			else {
				i--;
			}
		}
		return i;
	}
	
	public BigInteger getBitmapValue() {
		return bitmap;
	}

	
	public BigInteger and(BigInteger other){
		return bitmap.and(other);
	}

	/**
	 * Determines if all fields set in the  mask are present in this bitmap
	 * @param mask mask against which the bitmap is compared
	 * @return true if all bits in the mask are set on in this bitmap, otherwise false
	 */
	public boolean allFieldsPresent(BigInteger mask) {
		if (bitmap.and(mask).equals(mask)) {
			return true;
		}
		return false;
	}

}
