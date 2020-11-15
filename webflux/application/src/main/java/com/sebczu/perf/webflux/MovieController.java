package com.sebczu.perf.webflux;

import java.util.Random;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_STREAM_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

  private final MovieRepository repository;
  private final WebClient mockClient;
  private final Random random = new Random();

  @GetMapping(produces = APPLICATION_STREAM_JSON_VALUE)
  public Flux<MovieEntity> list() {
    log.info("request list");
    return repository.findAll();
  }

  @GetMapping(value = "/id")
  public Mono<MovieEntity> get() {
    log.info("request get");
    return repository.findById(random.nextInt(1_000_000) + 1);
  }

  @GetMapping(value = "/mock")
  public Mono<String> mock() {
    log.info("request mock");
    return mockClient.get()
        .uri("/movie")
        .retrieve()
        .bodyToMono(String.class);
  }

}
