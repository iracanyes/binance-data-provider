package com.iracanyes.fintech.jeny.binance.data.provider.bootstrap;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ContextConfiguration(classes = BinanceDataProviderApplicationTests.class)
@TestPropertySource(properties = {"spring.cloud.vault.uri", "spring.cloud.vault.token"})
class VaultIntegrationTest {
  private final Logger LOGGER = LoggerFactory.getLogger(VaultIntegrationTest.class.getName());
  @Autowired
  private Environment environment;

  @Test
  void testVaultConnection() {
    String mySecret = environment.getProperty("vault.jeny.bnc.test_user.security.other_secret");
    assertNotNull(mySecret);
    LOGGER.info("Test user other secret : {}", mySecret);
  }
}
