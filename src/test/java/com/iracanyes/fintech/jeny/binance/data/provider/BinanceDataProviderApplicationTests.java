package com.iracanyes.fintech.jeny.binance.data.provider;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ContextConfiguration(classes = BinanceDataProviderApplication.class)
class BinanceDataProviderApplicationTests {
  //@Autowired
  //ApplicationContext ctx;

  @Test
  void contextLoads() {
    ApplicationContext ctx = new AnnotationConfigApplicationContext();
    assertThat(true).isTrue();
  }

}
