package com.keeonline.fandango.api.service.transformer;

import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.keeonline.fandango.iso8583.message.transformer.TransformedMessage;
import com.keeonline.fandango.api.service.McbnService;
import com.keeonline.fandango.iso8583.message.model.MessageData;

public class McbnTransformerMapTest {

    @Test
	public void go() {

		String bob = "{\"messageTypeIdentifier\":\"0100\",\"primaryAccountNumber\":5039990000100006,\"processingCode\":{\"transactionType\":0,\"accountTypeFrom\":0,\"accountTypeTo\":0},\"amountTransaction\":{\"amount\":10,\"currency\":\"GBP\"},\"amountCardholderBilling\":{\"amount\":10,\"currency\":\"GBP\"},\"transmissionDateAndTime\":{\"date\":{\"year\":2023,\"month\":11,\"day\":3},\"time\":{\"hour\":9,\"minute\":8,\"second\":42,\"nano\":0}},\"conversionRateCardholderBilling\":1.000000,\"systemTraceAuditNumber\":14,\"timeLocalTransaction\":{\"hour\":9,\"minute\":8,\"second\":42,\"nano\":0},\"dateLocalTransaction\":{\"year\":2023,\"month\":11,\"day\":3},\"dateExpiration\":{\"year\":2023,\"month\":10,\"day\":29},\"dateSettlement\":{\"year\":2023,\"month\":11,\"day\":3},\"dateConversion\":{\"year\":2023,\"month\":11,\"day\":3},\"merchantType\":5311,\"posEntryModeCode\":{\"panEntryMode\":1,\"pinEntryMode\":0},\"acquiringInstitutionIdentificationCode\":130000,\"retrievalReferenceNumber\":\"000000000003\",\"cardAcceptorTerminalIdentification\":\"T0000000\",\"cardAcceptorIdentificationCode\":\"A000000\",\"cardAcceptorNameLocation\":{\"cardAcceptorOrAtmLocation\":\"A STORE 0000\",\"cityName\":\"LONDON\",\"countryCode\":\"GBP\"},\"additionalDataPrivateUse\":\"R9203721\",\"pointOfServiceData\":\"0001000000700826E1 6AN\",\"privateUseFields\":\"MCC000003\"}";

		Gson gson = new Gson();

		MessageData messageData = gson.fromJson(
							"{\"messageTypeIdentifier\":\"0100\",\"primaryAccountNumber\":123456,\"processingCode\":{\"transactionType\":0,\"accountTypeFrom\":11,\"accountTypeTo\":22},\"amountTransaction\":{\"amount\":45.99,\"currency\":\"AUD\",\"impliedDecimalsAmount\":4599},\"amountCardholderBilling\":{\"amount\":65.99,\"currency\":\"GBP\",\"impliedDecimalsAmount\":6599},\"transmissionDateAndTime\":{\"date\":{\"year\":2023,\"month\":9,\"day\":25},\"time\":{\"hour\":13,\"minute\":1,\"second\":22,\"nano\":0}},\"conversionRateCardholderBilling\":1.000000,\"systemTraceAuditNumber\":543210,\"timeLocalTransaction\":{\"hour\":13,\"minute\":1,\"second\":22,\"nano\":0},\"dateLocalTransaction\":{\"year\":2023,\"month\":9,\"day\":7},\"dateExpiration\":{\"year\":2023,\"month\":9,\"day\":9},\"dateSettlement\":{\"year\":2023,\"month\":9,\"day\":8},\"dateConversion\":{\"year\":2023,\"month\":9,\"day\":9},\"merchantType\":5981,\"posEntryModeCode\":{\"panEntryMode\":1,\"pinEntryMode\":0},\"acquiringInstitutionIdentificationCode\":818181,\"retrievalReferenceNumber\":\"090700012345\",\"authorizationIdentificationResponse\":\"ABC012\",\"responseCode\":\"00\",\"cardAcceptorTerminalIdentification\":\"ABCDEFGH\",\"cardAcceptorIdentificationCode\":\"ABCDEFGH0123456\",\"cardAcceptorNameLocation\":{\"cardAcceptorOrAtmLocation\":\"A STORE 0000\",\"cityName\":\"LONDON\",\"countryCode\":\"GBP\"},\"additionalDataPrivateUse\":\"R9203721\",\"pointOfServiceData\":\"0001000000700826E1 6AN\",\"privateUseFields\":\"MCC123456789\"}"
							,MessageData.class		
		);

		try {
			McbnService mcbnService = new McbnService();
			mcbnService.map(messageData);
		}
		catch (Exception e) { e.printStackTrace(); }
		
	}

}
