FROM maven

RUN mkdir -p /opt/app
ADD ./target/security.jar /opt/app/
WORKDIR /opt/app

EXPOSE 8080

CMD java -jar ./security.jar