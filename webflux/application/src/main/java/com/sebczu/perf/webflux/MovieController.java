package com.sebczu.perf.webflux;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import static org.springframework.http.MediaType.APPLICATION_STREAM_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

  private final MovieRepository repository;

  @GetMapping(produces = APPLICATION_STREAM_JSON_VALUE)
  public Flux<MovieEntity> list() {
    log.info("request");
    return repository.findAll();
  }

}
