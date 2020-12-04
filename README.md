# exam-soaint  MicroService


These instructions will get you a copy of the project up and running on your
local machine for development and testing purposes. See deployment for notes on
how to deploy the project on a live system.

**Access**

```
mvn compile
```
```
mvn test              # Run test cases
mvn verify            # Run test cases & static code validations & package
```
**URL EXPOSED IN CLOUD AWS**
```
URL AWS : http://3.137.219.92:8080/soaint/try/logger
CREDENCIALES DB MYSQL IN AWS
HOST:3.137.219.92
PORT:3306
USER:root
PASSWORD:mysql
```

**Example call service logger localhost**

*Request
```
curl --location --request POST 'http://localhost:8080/soaint/try/logger' \
--header 'Content-Type: application/json' \
--data-raw '{
    "typeLog": "database",
    "typeError": "warning",
    "messageError": "Internal Server Error 2"
}'
```

*Response 
```
execute type log from: {typeLog}

```

**Software & Libs**

```
* Java SDK 8 or higher
* Maven 3.x or higher
* Docker 17.12.x or higher
* lombok 
* mysql-connector-java
* spring-boot-starter-validation
* spring-boot-starter-data-jpa
```


**TEST LIBS & PLUGINS**

```
#Plugin Jacoco coverage min 60% test 
mockito-junit-jupiter
junit-vintage-engine
junit-jupiter-engine
spring-boot-starter-test
```

**CREATE IMAGE DB**

```
#container mysql
docker run --name mysql-local -e MYSQL_ROOT_PASSWORD=mysql -p 3306:3306  -d mysql:latest

#create a simple script mysql for example
docker exec -ti mysql-local bash
mysql -uroot -pmysql
create database soaint;
use soaint;
create table Logger(message varchar(100),errorCode varchar(100));
```

**CREATE IMAGE APPLICATION JAVA**
```
mvn verify
#build image 
docker build -t logger-service:01 --build-arg artifact_id=logger-service --build-arg artifact_version=0.1  -f devops/Dockerfile .
docker run -d logger-service:01
```


Run MicroService within Eclipse or IntelliJ.

