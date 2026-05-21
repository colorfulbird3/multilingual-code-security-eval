result>
```

## Databaseregistering

Voer dit in de volgende formaat in 'jdbc.properties' uit in konfiguratie, zodat de konfiguratie
gemaakt kan worden gebruikt in 'Spring Data JPA' 

```properties
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name?useSSL=false
spring.datasource.username=root
spring.datasource.password=kA5SYFS*By2
spring.datasource.max-active=100
spring.datasource.max-idle=40
spring.datasource.min-idle=5
spring.datasource.initial-size=10
spring.datasource.connection-test-method=jdbc.JdbcTestUtils.isValidConnection
spring.datasource.max-age=10000
```

## Spring Boot-toepassing 

Voer dit in de volgende formaat in konfiguratie:

```properties
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name?useSSL=false
spring.datasource.username=root
spring.datasource.password=kA5SYFS*By2
spring.datasource.max-active=100
spring.datasource.max-idle=40
spring.datasource.min-idle=5
spring.datasource.initial-size=10
spring.datasource.connection-test-method=jdbc.JdbcTestUtils.isValidConnection
spring.datasource.max-age=10000
```


## Verhaal

```bash
./bin/gradlew run
```

## Toepassing

**Niet aanvande aanvangsdata**

```bash