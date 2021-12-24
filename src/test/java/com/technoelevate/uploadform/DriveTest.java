package com.technoelevate.uploadform;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.env.YamlPropertySourceLoader;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.technoelevate.uploadform.dto.Drive;

class DriveTest {

	private ObjectMapper mapper;
	private String jsonString="{\"driveId\":10,\"drivename\":\"akramn\",\"drivedate\":1639748294566,\"driveOwner\":\"hjhjcas\",\"forms\":null}";

	@BeforeEach
	public void setup() {
		this.mapper = new ObjectMapper();
	}

	@Test
	public void testDriveSerialization() throws JsonProcessingException {
//		Drive drive = new Drive(10, "akramn", new Date(), "hjhjcas");
		Drive drive = mapper.readValue(jsonString, Drive.class); 
		String jsao= mapper.writeValueAsString(drive);
//		System.out.println(jsao);
		assertEquals(jsonString, jsao);

	}
	@Test
	public void testDriveDeSerialization() throws JsonMappingException, JsonProcessingException {
		Drive drive = mapper.readValue(jsonString, Drive.class); 
		assertEquals("akramn", drive.getDrivename());
	}

}
