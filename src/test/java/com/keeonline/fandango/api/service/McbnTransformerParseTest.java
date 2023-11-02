package com.keeonline.fandango.api.service;

import org.junit.jupiter.api.Test;

public class McbnTransformerParseTest {

    @Test
	public void testParseExceptionInvalidMessageType() {

		StringBuilder sb = new StringBuilder();
		sb.append("F0F1F0F0"); // mti
		sb.append("767F440108E1A00A"); // primary bitmap
		sb.append("F1F6F5F0F3F9F9F9F0F0F0F0F1F0F0F0F0F6"); // de2 (pan)
		sb.append("F0F0F0F0F0F0"); // de3 (proccode)
		sb.append("F0F0F0F0F0F0F0F0F1F0F0F0"); // de4
		sb.append("F0F0F0F0F0F0F0F0F1F0F0F0"); // de6
		sb.append("F1F0F3F0F1F5F1F5F4F3"); // de7
		sb.append("F6F1F0F0F0F0F0F0"); // de10
		sb.append("F0F0F0F0F0F9"); // de11
		sb.append("F1F5F1F1F2F2"); // de12
		sb.append("F1F0F3F1"); // de13
		// sb.append("F2F9F1F0"); // de14
		sb.append("F1F0F2F9"); // de14
		sb.append("F1F0F3F1"); // de15
		sb.append("F1F0F3F1"); // de16
		sb.append("F5F3F1F1"); // de18
		sb.append("F0F1F0"); // de22
		sb.append("F0F6F1F3F0F0F0F0"); // de32
		sb.append("F0F0F0F0F0F0F0F0F0F0F0F1"); // de37
		// sb.append("C1C2C3F0F1F2"); // de38
		// sb.append("F0F0"); // de39
		sb.append("E3F0F0F0F0F0F0F0"); // de41
		sb.append("C1F0F0F0F0F0F04040404040404040"); // de42
		sb.append("C140E2E3D6D9C540F0F0F0F04040404040404040404040D3D6D5C4D6D54040404040404040C7C2D7"); // de43
		sb.append("F0F0F8D9F9F2F0F3F7F2F1"); // de48
		sb.append("F8F2F6"); // de49
		sb.append("F8F2F6"); // de51
		sb.append("F0F2F2F0F0F0F1F0F0F0F0F0F0F7F0F0F8F2F6C5F140F6C1D5"); // de61
		sb.append("F0F0F9D4C3C3F0F0F0F0F0F1"); // de63
	
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
