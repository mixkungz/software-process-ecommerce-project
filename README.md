# PutYourHandsup 🙌🏻🙌🏻

simple e-commerce system homework of software process course in SIT KMUTT

## API Requirement

- Java JDK 8
- Maven

## Getting Started

after you clone this project you need to setting API config in application.properties file by copy application.example.properties to application.properties

```bash
cp api/src/main/resources/application.example.properties api/src/main/resources/application.properties
```

then go to setting your config in application.properties file

- setting your database driver at `spring.datasource.driver-class-name`
- setting your database url at `spring.datasource.url`
- setting your database usename at `spring.datasource.username`
- setting your database password at `spring.datasource.password`
- setting your jwt secret at `jwt.secret`

for running API Service

```bash
cd api

mvn clean package -e && java -jar ./target/EcommerceProject-0.0.1-SNAPSHOT
```

> Let's enjoy 🍻🍻
