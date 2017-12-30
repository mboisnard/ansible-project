FROM openjdk:8-jre

COPY build/libs/java-*.jar /usr/app/devops.jar

WORKDIR /usr/app/

EXPOSE 8080

CMD ["java", "-jar", "devops.jar"]