package com.sebczu.perf.webflux;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

public class MockApplication {

  public static void main(String[] args) {
    WireMockConfiguration configuration = options()
        .containerThreads(10)
        .jettyAcceptors(4)
        .jettyAcceptQueueSize(100)
        .jettyHeaderBufferSize(16834)
        .asynchronousResponseEnabled(true)
        .asynchronousResponseThreads(10)
        .port(8081);
    WireMockServer wm = new WireMockServer(configuration);
    wm.start();
    wm.stubFor(get(urlEqualTo("/movie"))
        .willReturn(
            aResponse()
                .withFixedDelay(10000)
                .withHeader("Content-Type", "application/json")
                .withBody("\"Avengers\"")
        )
    );
  }

}
