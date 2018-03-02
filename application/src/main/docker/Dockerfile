FROM openjdk:8-jre-alpine

EXPOSE 8080
#install Spring Boot artifact
VOLUME /tmp
ADD /maven/application-0-SNAPSHOT.jar application.jar
RUN sh -c 'touch /application.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/application.jar"]
