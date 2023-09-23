package com.keeonline.fandango.api.service;

import org.junit.jupiter.api.Test;

import com.keeonline.fandango.iso8583.message.transformer.TransformedMessage;
import com.keeonline.fandango.api.service.McbnService;

public class McbnTransformerParseTest {

    @Test
	public void testParseExceptionInvalidMessageType() {

		StringBuilder sb = new StringBuilder();
		sb.append("F0F1F0F0"); // mti
		sb.append("763B44010EC0A002"); // primary bitmap
		sb.append("F0F6F1F2F3F4F5F6"); // de2 (pan)
		sb.append("F0F0F1F1F2F2"); // de3 (proccode)
		sb.append("F0F0F0F0F0F0F0F0F4F5F9F9"); // de4
		sb.append("F0F0F0F0F0F0F0F0F6F5F9F9"); // de6
		sb.append("F0F9F2F5F1F3F0F1F2F2"); // de7
		sb.append("F5F4F3F2F1F0"); // de11
		sb.append("F1F3F0F1F2F2"); // de12
		sb.append("F0F9F0F7"); // de13
		sb.append("F0F9F0F8"); // de15
		sb.append("F0F9F0F9"); // de16
		sb.append("F5F9F8F1"); // de18
		sb.append("F0F1F0"); // de22
		sb.append("F0F6F8F1F8F1F8F1"); // de32
		sb.append("F0F9F0F7F0F0F0F1F2F3F4F5"); // de37
		sb.append("C1C2C3F0F1F2"); // de38
		sb.append("F0F0"); // de39
		sb.append("C1C2C3C4C5C6C7C8"); // de41
		sb.append("C1C2C3C4C5C6C7C8F0F1F2F3F4F5F6"); // de42
		sb.append("F0F3F6"); // de49
		sb.append("F8F2F6"); // de51
		sb.append("F0F1F2D4C3C3F1F2F3F4F5F6F7F8F9"); // de63
		
		String payload = sb.toString();

		// McbnTransformer mcbn = new McbnTransformer();
		// TransformedMessage transformedMcbn = null;

		// try {
		// 	transformedMcbn = mcbn.parse(payload);
		// }
		// catch (Exception e) { e.printStackTrace(); }

		// System.out.println(transformedMcbn.report());	

		try {
			McbnService mcbnService = new McbnService();
			mcbnService.parse(payload);
		}
		catch (Exception e) { e.printStackTrace(); }
		
	}

}
