# Build image:
# $ docker build -t ss:1.0 .
# Run:
# $ docker run -p 8080:8080 ss:1.0
# $ docker run -e "SPRING_PROFILES_ACTIVE=prod" -p 8080:8080 -t ss:1.0
# $ docker run -e "JAVA_TOOL_OPTIONS=-agentlib:jdwp=transport=dt_socket,address=5005,server=y,suspend=n" -p 8080:8080 -p 5005:5005 -t ss:1.0
# java -jar build/libs/..... --spring.profiles.active=prod

# FROM openjdk:11
# FROM openjdk:12-alpine
FROM azul/zulu-openjdk-alpine:11
ARG JAR_FILE=build/libs/*.jar
ARG DEPENDENCY=build/dependency
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
