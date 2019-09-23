#App Server 
Flyway

#Database
Postgres

# Build
mvn clean package && docker build -t no.kiran/TodoApp .

# RUN
docker rm -f TodoApp || true && docker run -d -p 8080:8080 -p 4848:4848 --name TodoApp no.kiran/TodoApp 

# TODO Features
Consume Rest API
Create a jenkins pipeline file in the project
Use the class documentation as in the fpsak project
## Bundle Database driver into the application
https://www.illucit.com/java-ee/wildfly-15-bundle-database-driver-and-datasource-into-application/
http://dplatz.de/blog/2018/self-contained-jee-app.html

# Done Features
Expose a rest api
Create a util function and inject it using CDI

#Bean Validation
~~Use Not Null~~
use Bean Validation on the method parameters
Use bean validation that name should be more than 1 character, date is not in past, check pattern for emailID

#JPA
~~Implement JPA for postgres database~~
~~Use Sequence Strategy for primary key auto generation~~

#Java Features
~~Use LocalDateTime in the project~~

#Flyway
~~Implemented Flyway Maven plugin in pom.xml~~
~~Implemented Flyway clean~~
~~Implemented Flyway migrate~~
Run Flyway migrate as a part of the maven package lifecycle

#Postman
~~Implement a postman collection for the api~~

#Github
~~Test Github Gist in project~~
Have a working master

#Docker
Run the application in a docker container