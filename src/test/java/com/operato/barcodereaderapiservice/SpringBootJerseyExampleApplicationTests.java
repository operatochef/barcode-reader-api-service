package com.operato.barcodereaderapiservice;

import com.operato.barcodereaderapiservice.data.BarcodeReaderRequestBody;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

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
		BarcodeReaderRequestBody reqBody = new BarcodeReaderRequestBody();

		String base64Image = "";
		try {
			base64Image = new String(Files.readAllBytes(Paths.get("./assets/images/encoded-20211129065430.txt")));
		} catch (IOException ex) {
			throw new Error("IOException");
		}

		reqBody.setImageType("jpeg");
		reqBody.setImageData(base64Image);

		ResponseEntity<BarcodeReaderRequestBody> entity = this.restTemplate.postForEntity(BASE_API_URL, reqBody,
				BarcodeReaderRequestBody.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

}
