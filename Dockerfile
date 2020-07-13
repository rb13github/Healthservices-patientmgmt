FROM openjdk:latest
ADD target/Healthmgmt-services-0.0.1-SNAPSHOT.jar Healthmgmt-services-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","Healthmgmt-services-0.0.1-SNAPSHOT.jar"]