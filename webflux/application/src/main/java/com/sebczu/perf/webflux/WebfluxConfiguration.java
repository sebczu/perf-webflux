package com.sebczu.perf.webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebfluxConfiguration {

  @Bean
  public WebClient mockClient() {
    return WebClient.create("http://localhost:8081");
  }

}
