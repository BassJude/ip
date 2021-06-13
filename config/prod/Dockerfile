FROM openjdk:8-jdk-alpine

RUN apk update && \
    apk upgrade && \
    apk add git maven

WORKDIR /var/www/ip

RUN mkdir /code && cd /code && \
    git clone https://github.com/BassJude/ip.git . && \
    mvn package

CMD java -jar /code/target/ip-1.jar
