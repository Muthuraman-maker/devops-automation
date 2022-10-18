FROM openjdk:11
EXPOSE 8080
ADD target/springbootaws.war springbootaws.war
ENTRYPOINT ["java","-jar","/springbootaws.war"]