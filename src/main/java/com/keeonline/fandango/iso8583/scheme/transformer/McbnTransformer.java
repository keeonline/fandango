package com.keeonline.fandango.iso8583.scheme.transformer;

import static java.util.Objects.nonNull;

import java.util.Map;

import com.keeonline.fandango.iso8583.message.model.MessageData;
import com.keeonline.fandango.iso8583.field.domain.financial.MonetaryAmount;
import com.keeonline.fandango.iso8583.field.spec.ComplexSpec;
import com.keeonline.fandango.iso8583.field.spec.PrimitiveSpec;
import com.keeonline.fandango.iso8583.message.transformer.MessageSpec;
import com.keeonline.fandango.iso8583.message.transformer.MessageTransformer;


public class McbnTransformer extends MessageTransformer {
	
	public McbnTransformer() {
		super();
	}

	@Override
	protected void addVersionSpecificFieldValues(MessageData messageData, Map<String, Object> fieldValues) {
        MonetaryAmount monetaryAmount = null;

        monetaryAmount = messageData.getAmountTransaction();
        if (nonNull(monetaryAmount)) {
            fieldValues.put(getFieldNamePrefix()+4, monetaryAmount.getImpliedDecimalsAmount());
            fieldValues.put(getFieldNamePrefix()+49, monetaryAmount.getBigIntegerCurrency());
        }

        monetaryAmount = messageData.getAmountCardholderBilling();
        if (nonNull(monetaryAmount)) {
            fieldValues.put(getFieldNamePrefix()+6, monetaryAmount.getImpliedDecimalsAmount());
            fieldValues.put(getFieldNamePrefix()+51, monetaryAmount.getBigIntegerCurrency());
        }  
	}

	@Override
	protected String getPrimaryBitmapFieldName() {
		return "PBM";
	}
	
	@Override
	protected String getFieldNamePrefix() {
		return "DE";
	}
	
	@Override
	protected MessageSpec getMessageSpec(){
		MessageSpec messageSpec = new MessageSpec();
		
		messageSpec.setName("mastercard-banknet-ebcdic");
		
		PrimitiveSpec primitiveSpec;
		ComplexSpec complexSpec;	
				   
		primitiveSpec = new PrimitiveSpec();		
		primitiveSpec.setName("MTI");
		primitiveSpec.setDescription("Message Type Identifier");	
		primitiveSpec.addAttribute("value-regex","^\\d{4}$");
		primitiveSpec.addAttribute("length","4");
		primitiveSpec.addAttribute("code-page","cp1047");
		primitiveSpec.setTransformer("com.keeonline.fandango.iso8583.field.transformer.ans.AnsString");
		messageSpec.setMtiFieldSpec(primitiveSpec);
		   
		primitiveSpec = new PrimitiveSpec();		
		primitiveSpec.setName("PBM");
		primitiveSpec.setDescription("Primary Bit Map");	
		primitiveSpec.addAttribute("value-regex","^[a-fA-F0-9]{16}$");
		primitiveSpec.addAttribute("length","16");
		primitiveSpec.setTransformer("com.keeonline.fandango.iso8583.field.transformer.hex.HexPacked");
		messageSpec.setPrimaryBitmapFieldSpec(primitiveSpec);
		   
		////////// MC DATA FIELD DEFINITIONS //////////
		
		primitiveSpec = new PrimitiveSpec();		
		primitiveSpec.setName("DE1");
		primitiveSpec.setDescription("Bit Map, Secondary");	
		primitiveSpec.addAttribute("value-regex","^[a-fA-F0-9]{16}$");
		primitiveSpec.addAttribute("length","16");
		primitiveSpec.setTransformer("com.keeonline.fandango.iso8583.field.transformer.hex.HexPacked");
		messageSpec.addFieldSpec(primitiveSpec);
		//...
		
		primitiveSpec = new PrimitiveSpec();		
		primitiveSpec.setName("DE2");
		primitiveSpec.setDescription("Primary Account Number (PAN)");	
		primitiveSpec.addAttribute("value-regex","^\\d{1,19}$");
		primitiveSpec.addAttribute("length-min","1");
		primitiveSpec.addAttribute("length-max","19");
		primitiveSpec.addAttribute("code-page","cp1047");
		primitiveSpec.setTransformer("com.keeonline.fandango.iso8583.field.transformer.number.NumberStringLLvar");
		messageSpec.addFieldSpec(primitiveSpec);

		complexSpec = new ComplexSpec();		
		complexSpec.setName("DE3");
		complexSpec.setDescription("Processing Code");	
		complexSpec.setTransformer("com.keeonline.fandango.iso8583.scheme.transformer.McbnProcessingCode");
		messageSpec.addFieldSpec(complexSpec);
		
		primitiveSpec = new PrimitiveSpec();		
		primitiveSpec.setName("DE4");
		primitiveSpec.setDescription("Amount, Transaction");	
		primitiveSpec.addAttribute("value-regex","^\\d{12}$");
		primitiveSpec.addAttribute("length","12");
		primitiveSpec.addAttribute("code-page","cp1047");
		primitiveSpec.setTransformer("com.keeonline.fandango.iso8583.field.transformer.number.NumberString");
		messageSpec.addFieldSpec(primitiveSpec);
		
		// ...
		
		primitiveSpec = new PrimitiveSpec();		
		primitiveSpec.setName("DE6");
		primitiveSpec.setDescription("Amount, Cardholder Billing");	
		primitiveSpec.addAttribute("value-regex","^\\d{12}$");
		primitiveSpec.addAttribute("length","12");
		primitiveSpec.addAttribute("code-page","cp1047");
		primitiveSpec.setTransformer("com.keeonline.fandango.iso8583.field.transformer.number.NumberString");
		messageSpec.addFieldSpec(primitiveSpec);
		
		primitiveSpec = new PrimitiveSpec();		
		primitiveSpec.setName("DE7");
		primitiveSpec.setDescription("Transmission Date and Time");	
		primitiveSpec.addAttribute("value-regex","^\\d{10}$");
		primitiveSpec.addAttribute("format-string","MMddHHmmss");
		primitiveSpec.addAttribute("code-page","cp1047");
		primitiveSpec.setTransformer("com.keeonline.fandango.iso8583.field.transformer.temporal.MonthDayTimeString");
		messageSpec.addFieldSpec(primitiveSpec);

		// primitiveSpec = new FieldSpec();		
		// primitiveSpec.setName("DE7");
		// primitiveSpec.setDescription("Amount, Cardholder Billing");	
		// primitiveSpec.addAttribute("value-regex","^\\d{12}$");
		// primitiveSpec.addAttribute("length","12");
		// primitiveSpec.addAttribute("code-page","cp1047");
		// primitiveSpec.setTransformer("com.keeonline.fandango.iso8583.field.transformer.number.NumberString");
		// messageSpec.addFieldSpec(primitiveSpec);
		
		// //...
		   
		primitiveSpec = new PrimitiveSpec();		
		primitiveSpec.setName("DE11");
		primitiveSpec.setDescription("System Trace Audit Number (STAN)");	
		primitiveSpec.addAttribute("value-regex","^\\d{6}$");
		primitiveSpec.addAttribute("length","6");
		primitiveSpec.addAttribute("code-page","cp1047");
		primitiveSpec.setTransformer("com.keeonline.fandango.iso8583.field.transformer.number.NumberString");
		messageSpec.addFieldSpec(primitiveSpec);
		
		primitiveSpec = new PrimitiveSpec();		
		primitiveSpec.setName("DE12");
		primitiveSpec.setDescription("Time, Local Transaction");	
		primitiveSpec.addAttribute("value-regex","^\\d{6}$");
		primitiveSpec.addAttribute("format-string","HHmmss");
		primitiveSpec.addAttribute("code-page","cp1047");
		primitiveSpec.setTransformer("com.keeonline.fandango.iso8583.field.transformer.temporal.TimeString");
		messageSpec.addFieldSpec(primitiveSpec);
		
		primitiveSpec = new PrimitiveSpec();		
		primitiveSpec.setName("DE13");
		primitiveSpec.setDescription("Date, Local Transaction");	
		primitiveSpec.addAttribute("value-regex","^\\d{4}$");
		primitiveSpec.addAttribute("format-string","MMdd");
		primitiveSpec.addAttribute("code-page","cp1047");
		primitiveSpec.setTransformer("com.keeonline.fandango.iso8583.field.transformer.temporal.DateString");
		messageSpec.addFieldSpec(primitiveSpec);
		
		primitiveSpec = new PrimitiveSpec();		
		primitiveSpec.setName("DE15");
		primitiveSpec.setDescription("Date, Settlement");	
		primitiveSpec.addAttribute("value-regex","^\\d{4}$");
		primitiveSpec.addAttribute("format-string","MMdd");
		primitiveSpec.addAttribute("code-page","cp1047");
		primitiveSpec.setTransformer("com.keeonline.fandango.iso8583.field.transformer.temporal.DateString");
		messageSpec.addFieldSpec(primitiveSpec);
		
		primitiveSpec = new PrimitiveSpec();		
		primitiveSpec.setName("DE16");
		primitiveSpec.setDescription("Date, Conversion");	
		primitiveSpec.addAttribute("value-regex","^\\d{4}$");
		primitiveSpec.addAttribute("format-string","MMdd");
		primitiveSpec.addAttribute("code-page","cp1047");
		primitiveSpec.setTransformer("com.keeonline.fandango.iso8583.field.transformer.temporal.DateString");
		messageSpec.addFieldSpec(primitiveSpec);
		
		primitiveSpec = new PrimitiveSpec();		
		primitiveSpec.setName("DE18");
		primitiveSpec.setDescription("Merchant Type");	
		primitiveSpec.addAttribute("value-regex","^\\d{4}$");
		primitiveSpec.addAttribute("length","4");
		primitiveSpec.addAttribute("code-page","cp1047");
		primitiveSpec.setTransformer("com.keeonline.fandango.iso8583.field.transformer.number.NumberString");
		messageSpec.addFieldSpec(primitiveSpec);

		// //...
		
		// primitiveSpec = new FieldSpec();		
		// primitiveSpec.setName("F20");
		// primitiveSpec.setDescription("Primary Account Number Country Code");	
		// primitiveSpec.addAttribute("value-regex","^\\d{1,6}$");
		// primitiveSpec.addAttribute("length","3");
		// primitiveSpec.addAttribute("code-page","cp1047");
		// primitiveSpec.setTransformer("com.keeonline.fandango.iso8583.field.transformer.number.NumberString");
		// primitiveSpecs.add(primitiveSpec);		   
		// //...

		complexSpec = new ComplexSpec();		
		complexSpec.setName("DE22");
		complexSpec.setDescription("Point-of-Service (POS) Entry Mode");	
		complexSpec.setTransformer("com.keeonline.fandango.iso8583.scheme.transformer.McbnPosEntryModeCode");
		messageSpec.addFieldSpec(complexSpec);
		
		//...
		
		primitiveSpec = new PrimitiveSpec();		
		primitiveSpec.setName("DE32");
		primitiveSpec.setDescription("Acquiring Institution ID Code");	
		primitiveSpec.addAttribute("value-regex","^\\d{1,6}$");
		primitiveSpec.addAttribute("length-min","1");
		primitiveSpec.addAttribute("length-max","6");
		primitiveSpec.addAttribute("code-page","cp1047");
		primitiveSpec.setTransformer("com.keeonline.fandango.iso8583.field.transformer.number.NumberStringLLvar");
		messageSpec.addFieldSpec(primitiveSpec);

		// primitiveSpec = new FieldSpec();		
		// primitiveSpec.setName("F33");
		// primitiveSpec.setDescription("Forwarding Instituion Identification Code");	
		// primitiveSpec.addAttribute("value-regex","^\\d{1,6}$");
		// primitiveSpec.addAttribute("length","8");
		// primitiveSpec.addAttribute("code-page","cp1047");
		// primitiveSpec.addAttribute("length-type","LL");
		// primitiveSpec.setTransformer("com.keeonline.fandango.iso8583.field.transformer.number.NumberString");
		// primitiveSpecs.add(primitiveSpec);		   
		// //...
		
		primitiveSpec = new PrimitiveSpec();		
		primitiveSpec.setName("DE37");
		primitiveSpec.setDescription("Retrieval Reference Number");	
		primitiveSpec.addAttribute("value-regex","^[a-zA-Z0-9]{12}$"); // this could be tightened according to MC spec
		primitiveSpec.addAttribute("length","12");
		primitiveSpec.addAttribute("code-page","cp1047");
		primitiveSpec.setTransformer("com.keeonline.fandango.iso8583.field.transformer.ans.AnsString");
		messageSpec.addFieldSpec(primitiveSpec);		   

		primitiveSpec = new PrimitiveSpec();		
		primitiveSpec.setName("DE38");
		primitiveSpec.setDescription("Authorization ID Response");	
		primitiveSpec.addAttribute("value-regex","^[a-zA-Z0-9]{6}$");
		primitiveSpec.addAttribute("length","6");
		primitiveSpec.addAttribute("code-page","cp1047");
		primitiveSpec.setTransformer("com.keeonline.fandango.iso8583.field.transformer.ans.AnsString");
		messageSpec.addFieldSpec(primitiveSpec);		   

		primitiveSpec = new PrimitiveSpec();		
		primitiveSpec.setName("DE39");
		primitiveSpec.setDescription("Response Code");	
		primitiveSpec.addAttribute("value-regex","^[a-zA-Z0-9]{2}$");
		primitiveSpec.addAttribute("length","2");
		primitiveSpec.addAttribute("code-page","cp1047");
		primitiveSpec.setTransformer("com.keeonline.fandango.iso8583.field.transformer.ans.AnsString");
		messageSpec.addFieldSpec(primitiveSpec);		   
		//...

		primitiveSpec = new PrimitiveSpec();		
		primitiveSpec.setName("DE41");
		primitiveSpec.setDescription("Card Acceptor Terminal ID");	
		primitiveSpec.addAttribute("value-regex","^[a-zA-Z0-9]{8}$");
		primitiveSpec.addAttribute("length","8");
		primitiveSpec.addAttribute("code-page","cp1047");
		primitiveSpec.setTransformer("com.keeonline.fandango.iso8583.field.transformer.ans.AnsString");
		messageSpec.addFieldSpec(primitiveSpec);		   
		
		primitiveSpec = new PrimitiveSpec();		
		primitiveSpec.setName("DE42");
		primitiveSpec.setDescription("Card Acceptor ID Code");	
		primitiveSpec.addAttribute("value-regex","^[a-zA-Z0-9]{15}$");
		primitiveSpec.addAttribute("length","15");
		primitiveSpec.addAttribute("code-page","cp1047");
		primitiveSpec.setTransformer("com.keeonline.fandango.iso8583.field.transformer.ans.AnsString");
		messageSpec.addFieldSpec(primitiveSpec);		   
		// //...


		primitiveSpec = new PrimitiveSpec();		
		primitiveSpec.setName("DE49");
		primitiveSpec.setDescription("Currency Code, Transaction");	
		primitiveSpec.addAttribute("value-regex","^\\d{3}$");
		primitiveSpec.addAttribute("length","3");
		primitiveSpec.addAttribute("code-page","cp1047");
		primitiveSpec.setTransformer("com.keeonline.fandango.iso8583.field.transformer.number.NumberString");
		messageSpec.addFieldSpec(primitiveSpec);

		primitiveSpec = new PrimitiveSpec();		
		primitiveSpec.setName("DE51");
		primitiveSpec.setDescription("Currency Code, Cardholder Billing");	
		primitiveSpec.addAttribute("value-regex","^\\d{3}$");
		primitiveSpec.addAttribute("length","3");
		primitiveSpec.addAttribute("code-page","cp1047");
		primitiveSpec.setTransformer("com.keeonline.fandango.iso8583.field.transformer.number.NumberString");
		messageSpec.addFieldSpec(primitiveSpec);

		primitiveSpec = new PrimitiveSpec();		
		primitiveSpec.setName("DE63");
		primitiveSpec.setDescription("Network Data");	
		primitiveSpec.addAttribute("value-regex","^[a-zA-Z0-9]{12}$");
		primitiveSpec.addAttribute("length-min","12");
		primitiveSpec.addAttribute("length-max","12");
		primitiveSpec.addAttribute("code-page","cp1047");
		primitiveSpec.setTransformer("com.keeonline.fandango.iso8583.field.transformer.ans.AnsStringLLLvar");
		messageSpec.addFieldSpec(primitiveSpec);
		//...
		
		// primitiveSpec = new FieldSpec();		
		// primitiveSpec.setName("F65");
		// primitiveSpec.setDescription("Bitmap, Tertiary");	
		// primitiveSpec.addAttribute("value-regex","^[a-fA-F0-9]{16}$");
		// primitiveSpec.setTransformer("com.keeonline.fandango.iso8583.field.transformer.bitmap.BitmapBinary");
		// primitiveSpecs.add(primitiveSpec);
		// //... 
		   
		// primitiveSpec = new FieldSpec();		
		// primitiveSpec.setName("F70");
		// primitiveSpec.setDescription("Network Management Information Code");	
		// primitiveSpec.addAttribute("value-regex","^\\d{1,3}$");
		// primitiveSpec.addAttribute("length","3");
		// primitiveSpec.addAttribute("code-page","cp1047");
		// primitiveSpec.setTransformer("com.keeonline.fandango.iso8583.field.transformer.numeric.NumericString");
		// primitiveSpecs.add(primitiveSpec);		   
		// //... 
		
		// primitiveSpec = new FieldSpec();		
		// primitiveSpec.setName("F94");
		// primitiveSpec.setDescription("Service Indicator");	
		// primitiveSpec.addAttribute("value-regex","^\\d{1,6}$");
		// primitiveSpec.addAttribute("length","7");
		// primitiveSpec.addAttribute("code-page","cp1047");
		// primitiveSpec.setTransformer("com.keeonline.fandango.iso8583.field.transformer.ans.AnsString");
		// primitiveSpecs.add(primitiveSpec);		   
		// //...
		
		// primitiveSpec = new FieldSpec();		
		// primitiveSpec.setName("F96");
		// primitiveSpec.setDescription("Message Security Code");	
		// primitiveSpec.addAttribute("value-regex","^\\d{1,3}$");
		// primitiveSpec.addAttribute("length","8");
		// primitiveSpec.addAttribute("code-page","cp1047");
		// primitiveSpec.setTransformer("com.keeonline.fandango.iso8583.field.transformer.numeric.NumericString");
		// primitiveSpecs.add(primitiveSpec);		   
		// //... 
		
		// primitiveSpec = new FieldSpec();		
		// primitiveSpec.setName("F127");
		// primitiveSpec.setDescription("Private Data");	
		// primitiveSpec.addAttribute("value-regex","^\\d{1,6}$");
		// primitiveSpec.addAttribute("length","103");
		// primitiveSpec.addAttribute("code-page","cp1047");
		// primitiveSpec.addAttribute("length-type","LLL");
		// primitiveSpec.setTransformer("com.keeonline.fandango.iso8583.field.transformer.ans.AnsStringLvar");
		// primitiveSpecs.add(primitiveSpec);		   
		// //...
		
		return messageSpec;		
	}

}

