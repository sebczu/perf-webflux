package com.sebczu.perf.webflux;

import java.util.Random;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

  private final MovieRepository repository;
  private final Random random = new Random();

  @GetMapping
  public List<MovieEntity> list() {
    log.info("request list");
    return repository.findAll();
  }

  @GetMapping("/id")
  public MovieEntity get() {
    log.info("request get");
    return repository.findById(random.nextInt(1_000_000) + 1).get();
  }
}
