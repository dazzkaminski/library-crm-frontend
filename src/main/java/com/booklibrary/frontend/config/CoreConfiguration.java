package com.booklibrary.frontend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CoreConfiguration implements WebMvcConfigurer {

  // TODO Front-end security

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
