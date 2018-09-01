FROM maven

RUN mkdir -p /opt/htdoc/app
ADD ./target/security.jar /opt/htdoc/app/
WORKDIR /opt/htdoc/app

EXPOSE 5555

CMD java -jar ./security.jar