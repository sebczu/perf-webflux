package com.sebczu.perf.webflux;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class WebmvcApplicationTest {

  @Autowired
  protected MockMvc mockMvc;

  @Test
  public void measureResponseTime() throws Exception {
    mockMvc.perform(get("/movies"))
        .andExpect(status().isOk());

    log.info("end request");
  }
}
