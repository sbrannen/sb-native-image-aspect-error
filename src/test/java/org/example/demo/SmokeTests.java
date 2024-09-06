package org.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.example.demo.aspect.LoggingAspect;
import org.example.demo.service.Service;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class SmokeTests {

	@Autowired
	LoggingAspect loggingAspect;

	@Autowired
	Controller controller;

	@Autowired
	Service service;

	@Test
	void accessRestEndpoint(@Autowired MockMvc mockMvc) throws Exception {
		mockMvc.perform(get("/hello"))
			.andExpect(status().isOk())
			.andExpect(content().string("Hello, World 84")); // 84 = 2 * 42

		assertThat(AopUtils.isAopProxy(this.loggingAspect)).isFalse();
		assertThat(AopUtils.isCglibProxy(this.controller)).isTrue();
		assertThat(AopUtils.isCglibProxy(this.service)).isTrue();

		assertThat(this.loggingAspect.intercepted)
			.containsExactly(
				"org.example.demo.Controller.hello",
				"org.example.demo.service.ServiceImpl.getConstant"
			);
	}

}
