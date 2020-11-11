package com.sebczu.perf.webflux;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

@Slf4j
@SpringBootTest
@AutoConfigureWebTestClient
public class WebfluxApplicationTest {

  private String URL = "/movies";

  @Autowired
  private WebTestClient webClient;

  @Test
  public void test() {
    Flux<MovieEntity> result = webClient.get()
        .uri(URL)
        .exchange()
        .expectStatus().isOk()
        .returnResult(MovieEntity.class)
        .getResponseBody();

    result.log()
        .subscribe();
  }

}
