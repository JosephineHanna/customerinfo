FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY sample.db sample.db
COPY ${JAR_FILE} customerinfo.jar
ENTRYPOINT ["java","-jar","/customerinfo.jar"]