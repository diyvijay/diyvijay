package com.example;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= SpringBootTestApplication.class)
public class SmokeHelloControllerTest {

	@Autowired
	private HomeController homeController;
	
	@Test
	public void testApplicationLoad() {
		assertNotNull("HomeController is not null", homeController);
	}
	
}
