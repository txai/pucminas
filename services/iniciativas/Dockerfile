FROM openjdk:17-jdk-slim
LABEL author="Txai Garcia"
COPY build/libs/*.jar service.jar
ENTRYPOINT [ "java", "-jar", "service.jar" ]