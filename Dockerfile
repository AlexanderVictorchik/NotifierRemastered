FROM maven

RUN mkdir notifier
COPY ./target/Notifier-1.0-SNAPSHOT.jar /notifier

WORKDIR /notifier

EXPOSE 8081 8083 8087

CMD java -jar Notifier-1.0-SNAPSHOT.jar