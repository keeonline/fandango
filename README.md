# fandango


http://localhost:8080/v2/api-docs


http://localhost:8080/swagger-ui


approve:
curl -X POST "http://localhost:8080/fandango/mcbn/ebcdic/requests" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"payload\": \"F0F1F0F0767F440108E1A00AF1F6F5F0F3F9F9F9F0F0F0F0F1F0F0F0F0F6F0F0F0F0F0F0F0F0F0F0F0F0F0F0F1F0F0F0F0F0F0F0F0F0F0F0F1F0F0F0F1F0F3F0F1F5F1F5F4F3F6F1F0F0F0F0F0F0F0F0F0F0F0F9F1F5F1F1F2F2F1F0F3F1F1F0F2F9F1F0F3F1F1F0F3F1F5F3F1F1F0F1F0F0F6F1F3F0F0F0F0F0F0F0F0F0F0F0F0F0F0F0F1E3F0F0F0F0F0F0F0C1F0F0F0F0F0F04040404040404040C140E2E3D6D9C540F0F0F0F04040404040404040404040D3D6D5C4D6D54040404040404040C7C2D7F0F0F8D9F9F2F0F3F7F2F1F8F2F6F8F2F6F0F2F2F0F0F0F1F0F0F0F0F0F0F7F0F0F8F2F6C5F140F6C1D5F0F0F9D4C3C3F0F0F0F0F0F1\"}"

decline:
curl -X POST "http://localhost:8080/fandango/mcbn/ebcdic/requests" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"payload\": \"F0F1F0F0767F440108E1A00AF1F6F5F0F3F9F9F9F0F0F0F0F1F0F0F0F0F6F0F0F0F0F0F0F0F0F0F0F0F0F0F0F1F5F0F0F0F0F0F0F0F0F0F0F1F0F0F0F1F0F3F0F1F5F1F5F4F3F6F1F0F0F0F0F0F0F0F0F0F0F0F9F1F5F1F1F2F2F1F0F3F1F1F0F2F9F1F0F3F1F1F0F3F1F5F3F1F1F0F1F0F0F6F1F3F0F0F0F0F0F0F0F0F0F0F0F0F0F0F0F1E3F0F0F0F0F0F0F0C1F0F0F0F0F0F04040404040404040C140E2E3D6D9C540F0F0F0F04040404040404040404040D3D6D5C4D6D54040404040404040C7C2D7F0F0F8D9F9F2F0F3F7F2F1F8F2F6F8F2F6F0F2F2F0F0F0F1F0F0F0F0F0F0F7F0F0F8F2F6C5F140F6C1D5F0F0F9D4C3C3F0F0F0F0F0F1\"}"




vt message hex:
F0F1F0F0767F440108E1A00AF1F6F5F0F3F9F9F9F0F0F0F0F1F0F0F0F0F6F0F0F0F0F0F0F0F0F0F0F0F0F0F0F1F0F0F0F0F0F0F0F0F0F0F0F1F0F0F0F1F0F3F0F1F5F1F5F4F3F6F1F0F0F0F0F0F0F0F0F0F0F1F3F1F5F1F5F4F3F1F0F3F0F2F9F1F0F1F0F3F0F1F0F3F0F5F3F1F1F0F1F0F0F6F1F3F0F0F0F0F0F0F0F0F0F0F0F0F0F0F0F5E3F0F0F0F0F0F0F0C1F0F0F0F0F0F04040404040404040C140E2E3D6D9C540F0F0F0F04040404040404040404040D3D6D5C4D6D54040404040404040C7C2D7F0F0F8D9F9F2F0F3F7F2F1F8F2F6F8F2F6F0F2F2F0F0F0F1F0F0F0F0F0F0F7F0F0F8F2F6C5F140F6C1D5F0F0F9D4C3C3F0F0F0F0F0F5

F0F1F0F0   // mti
767F440108E1A00A    // pbm
F1F6F5F0F3F9F9F9F0F0F0F0F1F0F0F0F0F6     // de2
F0F0F0F0F0F0   // de3
F0F0F0F0F0F0F0F0F1F0F0F0   // de4
F0F0F0F0F0F0F0F0F1F0F0F0   // de6
F1F0F3F0F1F5F1F5F4F3  // de7
F6F1F0F0F0F0F0F0   // de10
F0F0F0F0F1F3  // de11
F1F5F1F5F4F3  // de12
F1F0F3F0  // de13
F2F9F1F0  // de14
F1F0F3F0  // de15
F1F0F3F0  // de16
F5F3F1F1  // de18
F0F1F0  // de22
F0F6F1F3F0F0F0F0  // de32
F0F0F0F0F0F0F0F0F0F0F0F5 // de37
E3F0F0F0F0F0F0F0  //de41
C1F0F0F0F0F0F04040404040404040 // de42
C140E2E3D6D9C540F0F0F0F04040404040404040404040D3D6D5C4D6D54040404040404040C7C2D7 // de43
F0F0F8D9F9F2F0F3F7F2F1  // de48
F8F2F6  // de49
F8F2F6  // de51
F0F2F2F0F0F0F1F0F0F0F0F0F0F7F0F0F8F2F6C5F140F6C1D5 // de62
F0F0F9D4C3C3F0F0F0F0F0F5   // de63

test


curl -X POST "http://localhost:8080/fandango/mcbn/ebcdic/requests" -H "accept: */*" -H "Content-Type: application/json" -d "{\"messageTypeIdentifier\":\"0100\",\"primaryAccountNumber\":5039990000100006,\"processingCode\":{\"transactionType\":0,\"accountTypeFrom\":0,\"accountTypeTo\":0},\"amountTransaction\":{\"amount\":10,\"currency\":\"GBP\"},\"amountCardholderBilling\":{\"amount\":10,\"currency\":\"GBP\"},\"transmissionDateAndTime\":{\"date\":{\"year\":2023,\"month\":10,\"day\":30},\"time\":{\"hour\":15,\"minute\":15,\"second\":43,\"nano\":0}},\"conversionRateCardholderBilling\":1.000000,\"systemTraceAuditNumber\":9,\"timeLocalTransaction\":{\"hour\":15,\"minute\":11,\"second\":22,\"nano\":0},\"dateLocalTransaction\":{\"year\":2023,\"month\":10,\"day\":31},\"dateExpiration\":{\"year\":2023,\"month\":10,\"day\":29},\"dateSettlement\":{\"year\":2023,\"month\":10,\"day\":31},\"dateConversion\":{\"year\":2023,\"month\":10,\"day\":31},\"merchantType\":5311,\"posEntryModeCode\":{\"panEntryMode\":1,\"pinEntryMode\":0},\"acquiringInstitutionIdentificationCode\":130000,\"retrievalReferenceNumber\":\"000000000001\",\"cardAcceptorTerminalIdentification\":\"T0000000\",\"cardAcceptorIdentificationCode\":\"A000000\",\"cardAcceptorNameLocation\":{\"cardAcceptorOrAtmLocation\":\"A STORE 0000\",\"cityName\":\"LONDON\",\"countryCode\":\"GBP\"},\"additionalDataPrivateUse\":\"R9203721\",\"pointOfServiceData\":\"0001000000700826E1 6AN\",\"privateUseFields\":\"MCC000001\"}"





approve:

curl -v -X POST "http://localhost:80/payments/requests" -H "accept: */*" -H "Content-Type: application/json" -d "{\"messageTypeIdentifier\":\"0100\",\"primaryAccountNumber\":5039990000100006,\"processingCode\":{\"transactionType\":0,\"accountTypeFrom\":0,\"accountTypeTo\":0},\"amountTransaction\":{\"amount\":10,\"currency\":\"GBP\"},\"amountCardholderBilling\":{\"amount\":10,\"currency\":\"GBP\"},\"transmissionDateAndTime\":{\"date\":{\"year\":2023,\"month\":10,\"day\":30},\"time\":{\"hour\":15,\"minute\":15,\"second\":43,\"nano\":0}},\"conversionRateCardholderBilling\":1.000000,\"systemTraceAuditNumber\":9,\"timeLocalTransaction\":{\"hour\":15,\"minute\":11,\"second\":22,\"nano\":0},\"dateLocalTransaction\":{\"year\":2023,\"month\":10,\"day\":31},\"dateExpiration\":{\"year\":2023,\"month\":10,\"day\":29},\"dateSettlement\":{\"year\":2023,\"month\":10,\"day\":31},\"dateConversion\":{\"year\":2023,\"month\":10,\"day\":31},\"merchantType\":5311,\"posEntryModeCode\":{\"panEntryMode\":1,\"pinEntryMode\":0},\"acquiringInstitutionIdentificationCode\":130000,\"retrievalReferenceNumber\":\"000000000001\",\"cardAcceptorTerminalIdentification\":\"T0000000\",\"cardAcceptorIdentificationCode\":\"A000000\",\"cardAcceptorNameLocation\":{\"cardAcceptorOrAtmLocation\":\"A STORE 0000\",\"cityName\":\"LONDON\",\"countryCode\":\"GBP\"},\"additionalDataPrivateUse\":\"R9203721\",\"pointOfServiceData\":\"0001000000700826E1 6AN\",\"privateUseFields\":\"MCC000001\"}"



decline: 

curl -v -X POST "http://localhost:80/payments/requests" -H "accept: */*" -H "Content-Type: application/json" -d "{\"messageTypeIdentifier\":\"0100\",\"primaryAccountNumber\":5039990000100006,\"processingCode\":{\"transactionType\":0,\"accountTypeFrom\":0,\"accountTypeTo\":0},\"amountTransaction\":{\"amount\":15,\"currency\":\"GBP\"},\"amountCardholderBilling\":{\"amount\":15,\"currency\":\"GBP\"},\"transmissionDateAndTime\":{\"date\":{\"year\":2023,\"month\":10,\"day\":30},\"time\":{\"hour\":15,\"minute\":15,\"second\":43,\"nano\":0}},\"conversionRateCardholderBilling\":1.000000,\"systemTraceAuditNumber\":9,\"timeLocalTransaction\":{\"hour\":15,\"minute\":11,\"second\":22,\"nano\":0},\"dateLocalTransaction\":{\"year\":2023,\"month\":10,\"day\":31},\"dateExpiration\":{\"year\":2023,\"month\":10,\"day\":29},\"dateSettlement\":{\"year\":2023,\"month\":10,\"day\":31},\"dateConversion\":{\"year\":2023,\"month\":10,\"day\":31},\"merchantType\":5311,\"posEntryModeCode\":{\"panEntryMode\":1,\"pinEntryMode\":0},\"acquiringInstitutionIdentificationCode\":130000,\"retrievalReferenceNumber\":\"000000000001\",\"cardAcceptorTerminalIdentification\":\"T0000000\",\"cardAcceptorIdentificationCode\":\"A000000\",\"cardAcceptorNameLocation\":{\"cardAcceptorOrAtmLocation\":\"A STORE 0000\",\"cityName\":\"LONDON\",\"countryCode\":\"GBP\"},\"additionalDataPrivateUse\":\"R9203721\",\"pointOfServiceData\":\"0001000000700826E1 6AN\",\"privateUseFields\":\"MCC000001\"}"



commit 64a768f35f works
