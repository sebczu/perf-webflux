package com.sebczu.perf.webflux;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MovieRepository extends ReactiveCrudRepository<MovieEntity, Integer> {
}
