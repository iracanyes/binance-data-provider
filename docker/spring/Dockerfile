# See docs: https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#container-images.dockerfiles
FROM eclipse-temurin:17-jre-alpine AS builder

RUN mkdir /app

WORKDIR app

# Copy the jar app
ARG JAR_FILE=./libs/*.jar
COPY ${JAR_FILE} /app/binance-data-provider.jar

# Copy the jar app
#COPY ./target/binance-data-provider-${BINANCE_API_VERSION}.jar /app/binance-data-provider.jar

RUN java -Djarmode=layertools -jar binance-data-provider.jar extract

FROM eclipse-temurin:17-jre




ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]

FROM hashicorp/vault:1.15 AS vault-agent

RUN mkdir /app
WORKDIR app

COPY --from=builder app/dependencies/ ./
COPY --from=builder app/spring-boot-loader/ ./
COPY --from=builder app/snapshot-dependencies/ ./
COPY --from=builder app/binance-data-provider/ ./

# Configuration de l'agent Vault.

COPY ./docker/vault/client/config/config.local.hcl /vault/config/config.hcl
ENV VAULT_ADDR=http://$VAULT_ADDR:8200

# Lancement de l'agent Vault et de l'application Spring Boot.
#CMD ["sh", "-c", "vault agent -config=/vault/config/config.hcl -ca-cert /vault/tls/ca.crt & java -jar /app/binance-data-provider.jar"]
CMD ["sh", "-c", "vault agent -config=/vault/config/config.hcl -ca-cert /vault/tls/ca.crt & java org.springframework.boot.loader.JarLauncher"]


