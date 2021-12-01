
FROM maven:3.8.3-openjdk-11
LABEL org.opencontainers.image.created='2021-11-29'       
LABEL org.opencontainers.image.authors='jinwon@ai-doop.com'

WORKDIR /app

RUN git clone https://github.com/operatochef/barcode-reader-api-service.git

WORKDIR /app/barcode-reader-api-service

RUN mvn package

EXPOSE 8080

CMD [ "./mvnw", "spring-boot:run"]
