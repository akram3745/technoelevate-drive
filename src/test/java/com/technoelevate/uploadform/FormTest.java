package com.technoelevate.uploadform;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.technoelevate.uploadform.dto.Form;

class FormTest {
	
	private ObjectMapper mapper;
	private String jsonString="{\"formId\":10,\"name\":\"hsddv\",\"branch\":\"hsdf\",\"contactNo\":9108074711,\"email\":\"akramash@gmail.com\",\"degree\":\"sdg\",\"stream\":\"sdg\",\"passoutYear\":2005,\"tenthPercent\":45.45,\"twelvethPercent\":45.45,\"degreePercent\":45.45,\"masterAggregatePercent\":45.45}";

	@BeforeEach
	public void setup() {
		this.mapper = new ObjectMapper();
	}

	@Test
	public void testFormSerialization() throws JsonProcessingException {
		//Form form = new Form(10, "hsddv", "hsdf", 9108074711l, "akramash@gmail.com", "sdg", "sdg", 2005, 45.45, 45.45, 45.45, 45.45);
		Form form = mapper.readValue(jsonString, Form.class);
		String valueAsString = mapper.writeValueAsString(form);
		assertEquals(jsonString, valueAsString);
	}
	public void testFormDeSerialization() throws JsonMappingException, JsonProcessingException {
		Form form = mapper.readValue(jsonString, Form.class);
		assertEquals("hsddv", form.getName());
	}

}
