package com.joe.pizzamessagegeneratorservice;

import com.joe.pizzamessagegeneratorservice.resources.PizzaResource;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@WebMvcTest(value = PizzaResource.class)
class PizzaMessageGeneratorServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getPizzaMessage() throws Exception {
		String uri = "/pizzaMessage/pizza";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				uri).accept(MediaType.APPLICATION_JSON_VALUE);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		int status = result.getResponse().getStatus();
		assertEquals(200, status);
		String content = result.getResponse().getContentAsString();
		assertTrue(content.contains("\"quantity\":1"));
	}

}
