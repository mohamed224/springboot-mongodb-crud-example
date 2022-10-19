FROM openjdk:11
ADD target/springboot-mongodb-demo.jar springboot-mongodb-demo.jar
ENTRYPOINT ["java", "-jar", "springboot-mongodb-demo.jar"]