FROM openjdk:8-jdk-alpine as dynamic

RUN apk update && \
    apk upgrade && \
    apk add maven

COPY config/dev/docker-entrypoint /usr/local/bin/

ENTRYPOINT ["/usr/local/bin/docker-entrypoint"]

WORKDIR /var/www/ip
