package com.sebczu.perf.webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebmvcConfiguration {

  @Bean
  public RestTemplate mockClient() {
    return new RestTemplate();
  }

}
