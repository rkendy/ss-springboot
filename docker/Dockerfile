
# Build project:
# $ gradle build
# Build image (from root directory):
# $ docker build -t ss:1.0 -f docker/Dockerfile .
# Run:
# $ docker run --name ss -e "SPRING_PROFILES_ACTIVE=prod" -p 8080:8080 ss:1.0
# $ docker run -e "SPRING_PROFILES_ACTIVE=prod" -e "MYSQL_DB_SS_SCHEMA:solicitacao" -e "MYSQL_DB_SS_USERNAME=sol" -p 8080:8080 -t ss:1.0
# $ docker run -e "JAVA_TOOL_OPTIONS=-agentlib:jdwp=transport=dt_socket,address=5005,server=y,suspend=n" -p 8080:8080 -p 5005:5005 -t ss:1.0
# java -jar build/libs/..... --spring.profiles.active=prod

# Docker production image: need to set variables manually:
# export MYSQL_DB_SS_SCHEMA=solicitacao
# export MYSQL_DB_SS_USERNAME=ss
# export MYSQL_DB_SS_PASSWORD=xxx


# FROM openjdk:11
# FROM openjdk:12-alpine
FROM azul/zulu-openjdk-alpine:11
ARG JAR_FILE=build/libs/*.jar
ENV MYSQL_DB_SS_SCHEMA=ssdev
ENV MYSQL_DB_SS_USERNAME=root
ENV MYSQL_DB_SS_PASSWORD=root
ENV JWT_TOKEN_SECRET=n2r5u8x/A%D*G-KaPdSgVkYp3s6v9y$B&E(H+MbQeThWmZq4t7w!z%C*F-J@NcRf0123jjkanu3j3@!23ja)jfdjdJ
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

# install tool in container:
# apk update
# apk add busybox-extras