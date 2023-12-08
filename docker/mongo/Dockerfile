FROM mongo:latest
#LABEL authors="iracanyes"
#LABEL maintainer="iracanyes"

COPY docker/mongo/tls/mongodb.keyfile /opt/mongo/tls/mongodb.keyfile
RUN chown mongodb:mongodb /opt/mongo/tls/mongodb.keyfile && chmod 600 /opt/mongo/tls/mongodb.keyfile

#CMD ["mongod", "--bind_ip_all", "--replSet rs0", "--config", "/opt/mongo/conf/mongod.conf", "--auth", "--keyFile=/opt/mongo/tls/mongodb.keyfile"]