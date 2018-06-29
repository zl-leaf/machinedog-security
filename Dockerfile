FROM maven

VOLUME ["/opt/htdoc/security"]

WORKDIR /opt/htdoc/security

EXPOSE 5555

CMD mvn install && java -jar ./target/security.jar