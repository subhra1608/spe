FROM openjdk:11
COPY ./target/spe_mini_project-1.0-SNAPSHOT-shaded.jar ./
WORKDIR ./
CMD ["java","-jar","spe_mini_project-1.0-SNAPSHOT-shaded.jar"]