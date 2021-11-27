package com.operato.barcodereaderapiservice;

import com.operato.barcodereaderapiservice.data.BarcodeReaderCoord;
import com.operato.barcodereaderapiservice.data.BarcodeReaderCoordSet;
import com.operato.barcodereaderapiservice.data.BarcodeReaderData;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.google.gson.Gson;

import static org.assertj.core.api.Assertions.assertThat;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBootJerseyExampleApplicationTests {

	private static final String BASE_API_URL = "/api";

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void testWhenGetThenReturnSuccess() {
		ResponseEntity<String> entity = this.restTemplate.getForEntity(BASE_API_URL, String.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	void testWhenPostThenReturnSuccess() {
		BarcodeReaderData barcodeReader = new BarcodeReaderData();
		List<String> testList = new ArrayList<String>();
		testList.add("test1");
		testList.add("test2");

		BarcodeReaderCoordSet coordSet = new BarcodeReaderCoordSet(new BarcodeReaderCoord(0, 0),
				new BarcodeReaderCoord(0, 10), new BarcodeReaderCoord(10, 0), new BarcodeReaderCoord(10, 10));

		List<BarcodeReaderCoordSet> listCoordSet = new ArrayList<BarcodeReaderCoordSet>();
		listCoordSet.add(coordSet);

		barcodeReader.setTexts(testList);
		barcodeReader.setBoundaries(listCoordSet);

		String barcodeReaderJson = new Gson().toJson(barcodeReader);

		JSONParser parser = new JSONParser();
		JSONObject resultObject = new JSONObject();
		try {
			Object barcodeReaderObj = parser.parse(barcodeReaderJson);
			resultObject = (JSONObject) barcodeReaderObj;
		} catch (ParseException ex) {

		}

		ResponseEntity<JSONObject> entity = this.restTemplate.postForEntity(BASE_API_URL, resultObject,
				JSONObject.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

}
