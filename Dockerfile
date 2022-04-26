FROM openjdk:11
EXPOSE 8083
ADD target/newaccountbank-ci-cd-process.jar newaccountbank-ci-cd-process.jar
ENTRYPOINT ["java","-jar","/newaccountbank-ci-cd-process.jar"]