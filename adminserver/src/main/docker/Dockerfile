FROM openjdk:8-jre-alpine

EXPOSE 8090
#install Spring Boot artifact
VOLUME /tmp
ADD /maven/adminserver-0-SNAPSHOT.jar adminserver.jar
RUN sh -c 'touch /adminserver.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/adminserver.jar"]
