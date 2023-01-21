FROM openjdk:11
COPY /src/main/java .
WORKDIR .
RUN javac Main.java
CMD ["java", "Main"]