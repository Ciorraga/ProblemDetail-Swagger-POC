package com.pocsma.problemdetail.app.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ProblemDetailControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void shouldReturnNativeProblemDetailForBadRequest() throws Exception {
		mockMvc.perform(get("/badRequest"))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.type").doesNotExist())
				.andExpect(jsonPath("$.title").value("Bad Request"))
				.andExpect(jsonPath("$.status").value(400))
				.andExpect(jsonPath("$.detail").value("Bad request exception"));
	}
}
