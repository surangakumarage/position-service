package com.hcl.position.positionservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.position.positionservice.dto.PositionRequest;
import com.hcl.position.positionservice.repository.PositoinRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.containers.MySQLR2DBCDatabaseContainer;
import org.testcontainers.junit.jupiter.Container;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PositionServiceApplicationTests {

	@Container
	static MySQLContainer mysqlDBContainer = new MySQLContainer("mysql");
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private PositoinRepository positoinRepository;

	static {
		mysqlDBContainer.start();
	}

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dymDynamicPropertyRegistry) {
		dymDynamicPropertyRegistry.add("spring.data.mysql.uri", mysqlDBContainer::getJdbcUrl);
	}

	@Test
	void shouldCreateProduct() throws Exception {
		PositionRequest positionRequest = getPositionRequest();
		String productRequestString = objectMapper.writeValueAsString(positionRequest);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/position")
						.contentType(MediaType.APPLICATION_JSON)
						.content(productRequestString))
				.andExpect(status().isCreated());
		Assertions.assertEquals(1, positoinRepository.findAll().size());
	}

	private PositionRequest getPositionRequest() {
		return PositionRequest.builder()
				.instruments_id(1L)
				.portfolio_id(1L)
				.position_Name("Microsoft")
				.units(1200).build();
	}


}
