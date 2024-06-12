# Use Tomcat base image
FROM tomcat:9.0-jdk11-openjdk

# Remove default webapps to save space
RUN rm -rf /usr/local/tomcat/webapps

# Copy WAR file to the webapps directory
COPY target/info_company_test-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Expose the port that the Tomcat server will run on
EXPOSE 8081
