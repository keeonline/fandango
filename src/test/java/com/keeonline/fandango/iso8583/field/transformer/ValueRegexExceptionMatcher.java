package com.keeonline.fandango.iso8583.field.transformer;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import com.keeonline.fandango.iso8583.field.transformer.exception.FieldValueException;

public class ValueRegexExceptionMatcher extends TypeSafeMatcher<FieldValueException> {

    private String value;
    private String valueRegex;

    /**
     * Constructor.
     * 
     * @param the errors that we're expecting
     */
    public ValueRegexExceptionMatcher(String value, String valueRegex) {
        this.value = value;
        this.valueRegex = valueRegex;
    }

    /**
    * Describe the error condition.
    */
    @Override
    public void describeTo(Description description) {
        description.appendText("Value=").appendValue(value).appendText("Validation Regex=").appendValue(valueRegex);
    	
    }

    /**
     * Test if the input exception matches the expected exception.
     */
	@Override
	protected boolean matchesSafely(FieldValueException exception) {
		/*this.foundErrorCode = exception.getFieldId();
        return foundErrorCode.equalsIgnoreCase(expectedErrorCode);*/
		if (exception.getValue().equalsIgnoreCase(this.value) && exception.getValueRegex().equalsIgnoreCase(this.valueRegex)) {
			return true;
		}
		return false;
	}
}