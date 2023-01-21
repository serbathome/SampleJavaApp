FROM openjdk:11
COPY . /src/main/java
WORKDIR /src/main/java
RUN javac Main.java
CMD ["java", "Main"]