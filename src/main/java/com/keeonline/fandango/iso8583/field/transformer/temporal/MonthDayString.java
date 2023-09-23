package com.keeonline.fandango.iso8583.field.transformer.temporal;

import java.io.UnsupportedEncodingException;
import java.time.MonthDay;

import com.keeonline.fandango.iso8583.field.spec.PrimitiveSpec;
import com.keeonline.fandango.iso8583.field.transformer.TransformedField;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;
import com.keeonline.fandango.iso8583.field.transformer.util.Text;

public class MonthDayString extends Temporal{

	private String codePage;

    public MonthDayString(PrimitiveSpec field) throws FieldTransformerException {
        super(field);
		codePage = ((String)checkMandatory(getStringAttribute(Text.CODE_PAGE)));
		Text.validateCodePage(codePage);				
    }

    @Override
    public TransformedField map(Object valueObject) throws FieldTransformerException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'map'");
    }

    @Override
    public TransformedField parse(String payload, int offset) throws FieldTransformerException {
		String encoded = validateParseArguments(payload,offset,(getLength()*2));
		String formatted = null;
		try {
			formatted = Text.encodedToString(encoded.substring(0,getLength()*2),codePage);
		} catch (UnsupportedEncodingException e) {
			// TODO create FieldTransformerException
		}		
		MonthDay value = MonthDay.parse(formatted,getFormatter());
		return getTransformedField(value, encoded,getFieldSpec());
    }


    
}
