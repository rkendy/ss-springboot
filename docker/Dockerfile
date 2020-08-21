# Build project:
# $ gradle build
# Build image:
# $ docker build -t ss:1.0 .
# Run:
# $ docker run -p 8080:8080 ss:1.0
# $ docker run -e "SPRING_PROFILES_ACTIVE=prod" -p 8080:8080 -t ss:1.0
# $ docker run -e "JAVA_TOOL_OPTIONS=-agentlib:jdwp=transport=dt_socket,address=5005,server=y,suspend=n" -p 8080:8080 -p 5005:5005 -t ss:1.0
# java -jar build/libs/..... --spring.profiles.active=prod

# Docker production image: need to set variables manually:
# export MYSQL_DB_SS_SCHEMA=solicitacao
# export MYSQL_DB_SS_USERNAME=ss
# export MYSQL_DB_SS_PASSWORD=xxx

# FROM openjdk:11
# FROM openjdk:12-alpine
FROM azul/zulu-openjdk-alpine:11
ARG JAR_FILE../build/libs/*.jar
ENV MYSQL_DB_SS_SCHEMA=solicitacao
ENV MYSQL_DB_SS_USERNAME=ss
ENV MYSQL_DB_SS_PASSWORD=xxx
ENV jwt.token.secret=secret
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
