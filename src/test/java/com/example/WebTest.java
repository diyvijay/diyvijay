package com.example;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
//@WebMvcTest
@WebMvcTest(controllers = HomeController.class)
public class WebTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private HomeService service;
	
	@Test
	public void testShouldReturnMessage() throws Exception{
	
		when(service.sayHello()).thenReturn("Hello World");
		
		mockMvc.perform(MockMvcRequestBuilders.get("/hello")).andExpect(MockMvcResultMatchers.status().is(200))
	.andExpect(MockMvcResultMatchers.content().string("Hello World"));
	
	}
}
