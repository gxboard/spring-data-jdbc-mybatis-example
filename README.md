# spring-data-jdbc-mysql-example
Spring Data JDBC Mybatis Example Projects


spring Data 예제에서 JDBC MyBatis 예제를 Gradle 및 Docker Composer (MySQL:5.7) 로 작성함
https://github.com/spring-projects/spring-data-examples

Intellij IDEA 의 경우, lombok 을 활성황해야 한다.
 
IntelliJ Preferences => Build, Excution, Deployment => Compiler => Annotation Processors 

## Spring Data JDBC mybatis

`MyBatisTests` demonstrates how some queries executed by Spring Data JDBC can be replaced with MyBatis mappings.
The domain model is based on the basic JDBC example for comparison.

The map of models is maintained by two statements configured in MyBatis mappings.

`example.springdata.jdbc.mybatis.LegoSetMapper.findAllByProperty-models` showcases how a map can be loaded by configuring the select to return instances of `Map.Entry`

`example.springdata.jdbc.mybatis.Model.insert` showcases how one can access the `MyBatixContext` and thereby the instance to save and the key of the parent entity.


## Install

mysql 서버를 띄우거나 Composer 파일로 mysql:5.7 컨테이너 배포(Deploy)


### Docker


Compose 파일을 
docker-compose.yml 파일을 Run/Debug Configuration 으로 등록

https://www.jetbrains.com/help/idea/2018.2/run-debug-configuration-docker.html?utm_content=2018.2&utm_medium=link&utm_source=product&utm_campaign=IU


## 참조 

### 43. Testing

https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-testing.html


### 80.2 Configure Two DataSources
https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#howto-two-datasources
