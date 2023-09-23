package com.keeonline.fandango.iso8583.field.transformer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import com.google.gson.Gson;

import com.keeonline.fandango.iso8583.field.spec.PrimitiveSpec;
import com.keeonline.fandango.iso8583.field.transformer.TransformedField;

import com.keeonline.fandango.iso8583.field.transformer.amount.AmountPackedBcd;
import com.keeonline.fandango.iso8583.field.transformer.amount.AmountString;
import com.keeonline.fandango.iso8583.field.transformer.ans.AnsString;
import com.keeonline.fandango.iso8583.field.transformer.ans.AnsStringBvar;
import com.keeonline.fandango.iso8583.field.transformer.ans.AnsStringLLLvar;
import com.keeonline.fandango.iso8583.field.transformer.ans.AnsStringLLvar;
import com.keeonline.fandango.iso8583.field.transformer.hex.HexPacked;
import com.keeonline.fandango.iso8583.field.transformer.hex.HexPackedBvar;
import com.keeonline.fandango.iso8583.field.transformer.hex.HexString;
import com.keeonline.fandango.iso8583.field.transformer.number.NumberBinary;
import com.keeonline.fandango.iso8583.field.transformer.number.NumberPackedBcd;
import com.keeonline.fandango.iso8583.field.transformer.number.NumberPackedBcdBvar;
import com.keeonline.fandango.iso8583.field.transformer.number.NumberString;
import com.keeonline.fandango.iso8583.field.transformer.number.NumberStringLLLvar;
import com.keeonline.fandango.iso8583.field.transformer.number.NumberStringLLvar;
import com.keeonline.fandango.iso8583.field.transformer.temporal.DatePackedBcd;
import com.keeonline.fandango.iso8583.field.transformer.temporal.DateString;
import com.keeonline.fandango.iso8583.field.transformer.temporal.MonthDayTimePackedBcd;
import com.keeonline.fandango.iso8583.field.transformer.temporal.MonthDayTimeString;


// import org.junit.Before;
// import org.junit.jupiter.api.BeforeAll;
// import org.junit.rules.ExpectedException;

public abstract class TestBase {

	private final FieldType fieldType;

	protected PrimitiveSpec primitiveSpec;
	protected TransformedField result;

//     @Rule
//     public ExpectedException thrown = ExpectedException.none();

	protected TestBase() {
		String classUnderTest = this.getClass().getSimpleName();
		classUnderTest = classUnderTest.replace("Map", "");
		classUnderTest = classUnderTest.replace("Parse", "");
		classUnderTest = classUnderTest.replace("Fill", "");
		classUnderTest = classUnderTest.replace("Test", "");
		this.fieldType = FieldType.valueOf(classUnderTest);
	}

	@BeforeEach
	public void beforeTest(){
		// primitiveSpec = new PrimitiveSpec(fieldType.name());
		primitiveSpec = new PrimitiveSpec();
		primitiveSpec.setDescription(fieldType.name() + " field");
		primitiveSpec.setName("junittest");
	}
		
	@AfterEach
	public void afterTest(){
		System.out.println(new Gson().toJson(result));
	}

	public FieldTransformer getTransformer(PrimitiveSpec fieldSpec) {
        try {
            switch (fieldType) {
                case AnsString:
                    return new AnsString(fieldSpec);
                case AnsStringBvar:
                    return new AnsStringBvar(fieldSpec);
                case AnsStringLLvar:
                    return new AnsStringLLvar(fieldSpec);
                case AnsStringLLLvar:
                    return new AnsStringLLLvar(fieldSpec);
                case HexPackedBvar:
                    return new HexPackedBvar(fieldSpec);
                case HexPacked:
                    return new HexPacked(fieldSpec);
                case HexString:
                    return new HexString(fieldSpec);
                case NumberBinary:
                    return new NumberBinary(fieldSpec);
                case NumberPackedBcd:
                    return new NumberPackedBcd(fieldSpec);
                case NumberPackedBcdBvar:
                    return new NumberPackedBcdBvar(fieldSpec);
                case NumberStringLLLvar:
                    return new NumberStringLLLvar(fieldSpec);
                case NumberStringLLvar:
                    return new NumberStringLLvar(fieldSpec);
                case NumberString:
                    return new NumberString(fieldSpec);
                case AmountPackedBcd:
                    return new AmountPackedBcd(fieldSpec);
                case AmountString:
                    return new AmountString(fieldSpec);
                case DatePackedBcd:
                    return new DatePackedBcd(fieldSpec);
                case DateString:
                    return new DateString(fieldSpec);
                case MonthDayTimePackedBcd:
                    return new MonthDayTimePackedBcd(fieldSpec);
                case MonthDayTimeString:
                    return new MonthDayTimeString(fieldSpec);
                default:
                    return null;
            }
        }
        catch (Exception e) {
            return null;
        }
    }

}
