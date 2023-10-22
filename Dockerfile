FROM alpine:3.18

ADD build/libs/fandango-0.0.1-SNAPSHOT.jar /usr/app/fandango.jar

RUN apk --update add openjdk11-jre \
    && chmod +x /usr/app/fandango.jar

EXPOSE 8080/tcp

ENTRYPOINT ["java", "-jar", "/usr/app/fandango.jar"]