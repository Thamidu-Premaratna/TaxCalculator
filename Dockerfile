FROM tomcat:10

WORKDIR /usr/local/tomcat/webapps

COPY TaxCalculator-1.0-SNAPSHOT.war ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]