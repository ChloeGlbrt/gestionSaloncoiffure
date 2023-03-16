FROM openjdk:8
COPY ./target/gestion-salon-coiffure-0.0.1-SNAPSHOT.jar gestion-salon-coiffure-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","gestion-salon-coiffure-0.0.1-SNAPSHOT.jar"]