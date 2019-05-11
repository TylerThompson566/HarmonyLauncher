package com.tylert.harmony.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HarmonyConfig {

	/**
	 * Get the bean for the RestTemplate
	 * 
	 * @param builder the Rest Template Builder
	 * @return the RestTemplate
	 */
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}
