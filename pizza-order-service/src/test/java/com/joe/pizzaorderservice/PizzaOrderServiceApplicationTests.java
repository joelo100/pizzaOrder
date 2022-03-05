package com.joe.pizzaorderservice;

import com.joe.pizzaorderservice.repository.PizzaOrderRepository;
import com.joe.pizzaorderservice.resources.OrderResource;
import com.joe.pizzaorderservice.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value = OrderResource.class)
class PizzaOrderServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PizzaOrderRepository orderRepository;

	@MockBean
	private OrderService orderService;

	@Test
	public void submitPizzaOrder() throws Exception {
		String uri = "/pizzaOrder/orderSubmit";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
				uri).accept(MediaType.APPLICATION_JSON_VALUE);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		int status = result.getResponse().getStatus();
		assertEquals(200, status);

	}

}
