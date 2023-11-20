package com.iracanyes.fintech.jeny.binance.data.provider.bootstrap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultTemplate;

import java.util.Objects;

@Configuration
public class VaultConfiguration {
  private final Environment env;

  public VaultConfiguration(Environment env) {
    this.env = env;
  }

  @Bean
  public VaultTemplate getVaultTemplate(){
    return new VaultTemplate(
      new VaultEndpoint(),
      new TokenAuthentication(Objects.requireNonNull(env.getProperty("spring.cloud.vault.token")))
    );
  }
}
