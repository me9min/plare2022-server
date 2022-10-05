package org.amel.plare.qna.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.amel.plare.qna.TestHelper;
import org.amel.plare.qna.domain.QnaVO;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class QnaServiceTest {
	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private TestHelper testHelper;

	@Test
	@DisplayName("list qna")
	public void listQna() throws Exception {
		ResponseEntity<QnaVO[]> responseEntity = restTemplate.exchange("/qna/list", HttpMethod.GET,
				testHelper.getRequestHeaders(), QnaVO[].class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(MediaType.APPLICATION_JSON_UTF8, responseEntity.getHeaders().getContentType());

	}
}
