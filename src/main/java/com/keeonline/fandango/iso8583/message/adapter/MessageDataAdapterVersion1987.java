package com.keeonline.fandango.iso8583.message.adapter;

import static java.util.Objects.nonNull;

import java.math.BigInteger;

import com.keeonline.fandango.iso8583.field.domain.financial.MonetaryAmount;
import com.keeonline.fandango.iso8583.field.transformer.TransformedField;
import com.keeonline.fandango.iso8583.message.model.MessageData;
import com.keeonline.fandango.iso8583.message.transformer.TransformedMessage;
import com.keeonline.fandango.iso8583.standard.common.MessageBitmaps;
import com.keeonline.fandango.iso8583.standard.version1987.Fields;

public class MessageDataAdapterVersion1987 extends MessageDataAdapter {

    // private MessageData messageData;

    public MessageDataAdapterVersion1987(String fieldNamePrefix) {
        super(fieldNamePrefix);
    }

    @Override
    public MessageBitmaps getMessageBitMaps(MessageData messageData) {
        MessageBitmaps bitmaps = super.getMessageBitMaps(messageData);

        if (nonNull(messageData.getAmountTransaction())){
            bitmaps.setFieldPresent(4);
            bitmaps.setFieldPresent(49);
        }

        if (nonNull(messageData.getAmountTransaction())){
            bitmaps.setFieldPresent(6);
            bitmaps.setFieldPresent(51);
        }

        return bitmaps;
    }

    @Override
	public MessageData messageDataFromTransformedMessage(TransformedMessage transformedMessage){
        MessageData messageData = new MessageData();
        messageData.setMessageTypeIdentifier(transformedMessage.getFieldByName(Fields.MESSAGE_TYPE_INDICATOR_NAME).getValue().toString());

        for ( int i=1 ; i<193 ; i++ ){
            TransformedField transformedField = transformedMessage.getFieldByName(getFieldNamePrefix()+i);
            if (transformedField != null) {
                Object value = transformedField.getValue();
                if (value != null) {
                    setFieldByNumber(messageData, value, i);
                }
            }
        }

        setVersion1987Amounts(messageData,transformedMessage);

        return messageData;
    }

	@Override
	public Object getStandardSpecificFieldByNumber(MessageData messageData, int fieldNumber){
		if ((fieldNumber > 0) && (fieldNumber < 193)) {
			
			switch (fieldNumber)
			{		
				case Fields.AMOUNT_TRANSACTION:
					return messageData.getAmountTransaction();
			}

		}

		return null;
	}

    private void setVersion1987Amounts(MessageData messageData, TransformedMessage transformedMessage) {
        messageData.setAmountTransaction(
            getMonetaryAmountField(transformedMessage.getFieldByName(getFieldNamePrefix()+4),transformedMessage.getFieldByName(getFieldNamePrefix()+49)));
        messageData.setAmountCardholderBilling(
            getMonetaryAmountField(transformedMessage.getFieldByName(getFieldNamePrefix()+6),transformedMessage.getFieldByName(getFieldNamePrefix()+51)));
            
    }

    private MonetaryAmount getMonetaryAmountField(TransformedField amountField, TransformedField currencyField) {
        MonetaryAmount result = null;
        if ((amountField != null) && (currencyField != null)) {
            result = new MonetaryAmount((BigInteger) amountField.getValue(), (BigInteger) currencyField.getValue());
        }
        return result;
    }

}
