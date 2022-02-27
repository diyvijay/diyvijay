package com.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = SpringBootTestApplication.class)
public class HttpRequestTest {

	@LocalServerPort
	private int localPort;
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Test
	public void testShouldReturnMessage() {
		String strObject = testRestTemplate.getForObject("http://localhost:"+localPort+"/hello", String.class);
		System.out.println(strObject);
		assertEquals("Hello World", strObject);
	}
}
