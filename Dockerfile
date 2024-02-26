# Use an official maven image as a parent image
FROM maven:3.8.4-openjdk-11 as build

# Set the working directory in the image to /app
WORKDIR /app

# Copy the pom.xml file to download dependencies
COPY pom.xml .

# Download the dependencies
RUN mvn dependency:go-offline -B

# Copy the rest of the working directory contents into the image
COPY src ./src

# Package the application
RUN mvn package

# Use Tomcat image to deploy the .war
FROM tomcat:10.1.17-jdk11-openjdk

# Remove the default Tomcat applications
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy the .war file from the build image to the tomcat image
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/ROOT.war

# Expose port 8080 for the application
EXPOSE 8080

CMD ["catalina.sh", "run"]