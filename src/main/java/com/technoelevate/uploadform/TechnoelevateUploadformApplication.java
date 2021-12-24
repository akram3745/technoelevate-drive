package com.technoelevate.uploadform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TechnoelevateUploadformApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechnoelevateUploadformApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
	return	new RestTemplate();
	}

}
