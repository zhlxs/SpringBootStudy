FROM openjdk:8-jdk-slim
LABEL maintainer=hushanlin

#复制到容器
COPY target/*.jar /app.jar

ENTRYPOINT["java","-jar","/app.jar"]