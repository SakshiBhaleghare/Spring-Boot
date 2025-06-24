package com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.Controller.WelcomeController;
import com.Service.WelcomeService;

@WebMvcTest(controllers = WelcomeController.class)
public class WelcomeControllerTest {

	// it is used to send httprequest to restApi
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private WelcomeService ws;

	@Test
	public void TestGetMsgMethod() throws Exception {

		when(ws.getMsgInService()).thenReturn("Service Call");

		// 1. Generating mock request using MockMvcRequestBuilders
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/welcome");

		// 2. Perfoming request on rest Api and getting response using MockMvc
		MockHttpServletResponse response = mockMvc.perform(builder).andReturn().getResponse();

		// 3. getting status code from response
		int status = response.getStatus();

		response.getContentAsString();

		// 4. checking actual response with ecpected response
		assertEquals(200, status);

	}

}
