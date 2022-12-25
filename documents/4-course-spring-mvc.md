# SBS아카데미 광주지점 스프링 프레임워크 과정

- [1. Spring MVC Project 설정](#1-spring-mvc-project-설정)
    - [1.1. 스프링 프레임워크 버전 수정](#11-스프링-프레임워크-버전-수정)
    - [1.2. 자바 컴파일러 버전 변경](#12-자바-컴파일러-버전-변경)
    - [1.3. `javax.servlet-api` 라이브러리 설정](#13-javaxservlet-api-라이브러리-설정)
    - [1.4. Lombok 라이브러리 추가](#14-lombok-라이브러리-추가)
    - [1.5. Log4j 라이브러리 설정 수정](#15-log4j-라이브러리-설정-수정)
    - [1.6. JUnit 라이브러리 버전 수정](#16-junit-라이브러리-버전-수정)
    - [1.7. `spring-test` 모듈 추가](#17-spring-test-모듈-추가)
    - [1.8. 오라클 JDBC 드라이버 추가](#18-오라클-jdbc-드라이버-추가)
    - [1.9. HikariCP 라이브러리 추가](#19-hikaricp-라이브러리-추가)
    - [1.10. 스프링 컨테이너에 HikariCP 라이브러리 설정](#110-스프링-컨테이너에-hikaricp-라이브러리-설정)
    - [1.11. 마이바티스 프레임워크 관련 라이브러리 추가](#111-마이바티스-프레임워크-관련-라이브러리-추가)
    - [1.12. Log4jdbc 라이브러리 추가](#112-log4jdbc-라이브러리-추가)
    - [1.13. Log4jdbc 라이브러리 설정](#113-log4jdbc-라이브러리-설정)
    - [1.14. 스프링 컨테이너에 `SqlSessionFactory` 객체를 빈(Bean)으로 등록](#114-스프링-컨테이너에-sqlsessionfactory-객체를-빈bean으로-등록)
    - [1.15. 스프링 컨테이너에 Mybatis-Spring 라이브러리의 맵퍼(Mapper) 인터페이스 설정 추가](#115-스프링-컨테이너에-mybatis-spring-라이브러리의-맵퍼mapper-인터페이스-설정-추가)
- [2. CRUD 게시판 애플리케이션](#2-crud-게시판-애플리케이션)
    - [2.1. 오라클 데이터베이스에 `board` 테이블을 생성하고 더미 데이터를 추가하는 SQL 스크립트](#21-오라클-데이터베이스에-board-테이블을-생성하고-더미-데이터를-추가하는-sql-스크립트)
    - [2.2. Mybatis-Spring 라이브러리의 맵퍼(Mapper) XML 추가](#22-mybatis-spring-라이브러리의-맵퍼mapper-xml-추가)
    - [2.3. 스프링 MVC에서 한글 인코딩 문제 해결](#23-스프링-mvc에서-한글-인코딩-문제-해결)
    - [2.4. `board` 테이블의 레코드 늘리기](#24-board-테이블의-레코드-늘리기)
    - [2.5. 게시물 목록에서 페이징 처리를 하기 위한 SQL 문](#25-게시물-목록에서-페이징-처리를-하기-위한-sql-문)

## 1. Spring MVC Project 설정

아래 내용은 수업 시간에 차근차근 살펴보면서 설정한다.

### 1.1. 스프링 프레임워크 버전 수정

`$PROJECT_HOME/pom.xml`

```xml
<properties>
    <java-version>11</java-version>
    <org.springframework-version>5.3.12</org.springframework-version>
    <org.aspectj-version>1.6.10</org.aspectj-version>
    <org.slf4j-version>1.6.6</org.slf4j-version>
</properties>
```

### 1.2. 자바 컴파일러 버전 변경

`$PROJECT_HOME/pom.xml`

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>2.5.1</version>
    <configuration>
        <source>11</source>
        <target>11</target>
        <compilerArgument>-Xlint:all</compilerArgument>
        <showWarnings>true</showWarnings>
        <showDeprecation>true</showDeprecation>
    </configuration>
</plugin>
```

### 1.3. `javax.servlet-api` 라이브러리 설정

`$PROJECT_HOME/pom.xml`

```xml
<!-- Servlet -->
<!--
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>servlet-api</artifactId>
    <version>2.5</version>
    <scope>provided</scope>
</dependency>
-->

<!-- https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>3.1.0</version>
    <scope>provided</scope>
</dependency>
```

`pom.xml` 파일에서 기존 `servlet-api` 라이브러리는 제거하고, `javax.servlet-api` 라이브러리를 추가한다.

### 1.4. Lombok 라이브러리 추가

`$PROJECT_HOME/pom.xml`

```xml
<!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.22</version>
    <scope>provided</scope>
</dependency>
```

### 1.5. Log4j 라이브러리 설정 수정

`$PROJECT_HOME/pom.xml`

```xml
<dependency>
    <groupId>log4j</groupId>
    <artifactId>log4j</artifactId>
    <version>1.2.17</version>
    <exclusions>
        <exclusion>
            <groupId>javax.mail</groupId>
            <artifactId>mail</artifactId>
        </exclusion>
        <exclusion>
            <groupId>javax.jms</groupId>
            <artifactId>jms</artifactId>
        </exclusion>
        <exclusion>
            <groupId>com.sun.jdmk</groupId>
            <artifactId>jmxtools</artifactId>
        </exclusion>
        <exclusion>
            <groupId>com.sun.jmx</groupId>
            <artifactId>jmxri</artifactId>
        </exclusion>
    </exclusions>
    <!--
    <scope>runtime</scope>
    -->
</dependency>
```

Lombok 라이브러리를 활용할 때 문제가 생길 수 있으니 Log4j 라이브러리를 버전 1.2.17로 사용한다. 그리고 스프링 MVC 프로젝트에서는 오류가 발생하니 `<scope>` 태그를 제거한다.

### 1.6. JUnit 라이브러리 버전 수정

`$PROJECT_HOME/pom.xml`

```xml
<!-- https://mvnrepository.com/artifact/junit/junit -->
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.13.2</version>
    <scope>test</scope>
</dependency>
```

의존성 주입을 테스트하기 위해 JUnit 라이브러리는 버전 4.10 이상을 써야 한다.

### 1.7. `spring-test` 모듈 추가

`$PROJECT_HOME/pom.xml`

```xml
<!-- spring-test for JUnit library -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-test</artifactId>
    <version>${org.springframework-version}</version>
</dependency>
```

### 1.8. 오라클 JDBC 드라이버 추가

프로젝트의 Classpath에 오라클 JDBC 드라이버인 `C:\dev\lib\ojdbc8.jar` 파일을 추가하고, "Deployment Assembly" 항목에도 추가한다.

### 1.9. HikariCP 라이브러리 추가

`$PROJECT_HOME/pom.xml`

```xml
<!-- https://mvnrepository.com/artifact/com.zaxxer/HikariCP -->
<dependency>
    <groupId>com.zaxxer</groupId>
    <artifactId>HikariCP</artifactId>
    <version>5.0.0</version>
</dependency>
```

### 1.10. 스프링 컨테이너에 HikariCP 라이브러리 설정

`$PROJECT_HOME/src/main/webapp/WEB-INF/spring/root-context.xml`

```xml
<!-- HikariCP Configuration -->
<bean id="hikariConfig" class="com.zaxxer.hikari.HikariConfig">
    <property name="driverClassName" value="oracle.jdbc.driver.OracleDriver" />
    <property name="jdbcUrl" value="jdbc:oracle:thin:@localhost:1521:XE" />

    <property name="username" value="c##scott" />
    <property name="password" value="tiger" />
</bean>

<!-- HikariCP Bean -->
<bean id="dataSource" class="com.zaxxer.hikari.HikariDataSource" destroy-method="close">
    <constructor-arg ref="hikariConfig" />
</bean>
```

### 1.11. 마이바티스 프레임워크 관련 라이브러리 추가

- `spring-jdbc` 모듈 - 스프링 프레임워크의 JDBC 모듈
- `spring-tx` 모듈 - 스프링 프레임워크의 트랜잭션 처리 모듈
- `mybatis` 프레임워크 - 마이바티스 프레임워크
- `mybatis-spring` 라이브러리 - 스프링 프레임워크와 마이바티스 프레임워크를 연동하는 라이브러리

`$PROJECT_HOME/pom.xml`

```xml
<!-- spring-jdbc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>${org.springframework-version}</version>
</dependency>

<!-- spring-tx -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-tx</artifactId>
    <version>${org.springframework-version}</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.5.7</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis-spring</artifactId>
    <version>2.0.6</version>
</dependency>
```

### 1.12. Log4jdbc 라이브러리 추가

`$PROJECT_HOME/pom.xml`

```xml
<!-- https://mvnrepository.com/artifact/org.bgee.log4jdbc-log4j2/log4jdbc-log4j2-jdbc4.1 -->
<dependency>
    <groupId>org.bgee.log4jdbc-log4j2</groupId>
    <artifactId>log4jdbc-log4j2-jdbc4.1</artifactId>
    <version>1.16</version>
</dependency>
```

### 1.13. Log4jdbc 라이브러리 설정

1. 로그 설정 파일 추가 : `$PROJECT_HOME/src/main/resources/log4jdbc.log4j2.properties`
2. 스프링 컨테이너의 HikariCP 라이브러리 설정 수정 : `$PROJECT_HOME/src/main/webapp/WEB-INF/spring/root-context.xml`
3. Log4jdbc 라이브러리의 로그 레벨 설정 : `$PROJECT_HOME/src/test/resources/log4j.xml`

`$PROJECT_HOME/src/main/resources/log4jdbc.log4j2.properties`

```conf
log4jdbc.spylogdelegator.name=net.sf.log4jdbc.log.slf4j.Slf4jSpyLogDelegator
```

`$PROJECT_HOME/src/main/webapp/WEB-INF/spring/root-context.xml`

```xml
<!-- HikariCP Configuration -->
<bean id="hikariConfig" class="com.zaxxer.hikari.HikariConfig">
    <!-- before installing Log4jdbc library -->
    <!--
    <property name="driverClassName" value="oracle.jdbc.driver.OracleDriver" />
    <property name="jdbcUrl" value="jdbc:oracle:thin:@localhost:1521:XE" />
    -->

    <!-- after installing Log4jdbc library -->
    <property name="driverClassName" value="net.sf.log4jdbc.sql.jdbcapi.DriverSpy" />
    <property name="jdbcUrl" value="jdbc:log4jdbc:oracle:thin:@localhost:1521:XE" />

    <property name="username" value="c##scott" />
    <property name="password" value="tiger" />
</bean>
```

`$PROJECT_HOME/src/test/resources/log4j.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE log4j:configuration PUBLIC "-//APACHE//DTD LOG4J 1.2//EN" "http://logging.apache.org/log4j/1.2/apidocs/org/apache/log4j/xml/doc-files/log4j.dtd">
<log4j:configuration xmlns:log4j="http://jakarta.apache.org/log4j/">
    ...

    <!-- Log4jdbc Loggers -->
    <logger name="jdbc.audit">
    <level value="warn" />
    </logger>

    <logger name="jdbc.connection">
    <level value="warn" />
    </logger>

    <logger name="jdbc.resultset">
    <level value="warn" />
    </logger>

    <!-- Root Logger -->
    <root>
        <priority value="info" />
        <appender-ref ref="console" />
    </root>
</log4j:configuration>
```

`log4j.xml` 파일의 DTD 오류 수정

### 1.14. 스프링 컨테이너에 `SqlSessionFactory` 객체를 빈(Bean)으로 등록

`$PROJECT_HOME/src/main/webapp/WEB-INF/spring/root-context.xml`

```xml
<!-- SqlSessionFactory for MyBatis Framework -->
<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
    <property name="dataSource" ref="dataSource" />
</bean>
```

### 1.15. 스프링 컨테이너에 Mybatis-Spring 라이브러리의 맵퍼(Mapper) 인터페이스 설정 추가

`$PROJECT_HOME/src/main/webapp/WEB-INF/spring/root-context.xml`

`root-context.xml`에 `mybatis-spring` 네임스페이스를 추가한 다음 아래 내용을 추가한다.

```xml
<!-- MyBatis Mapper -->
<mybatis-spring:scan base-package="com.spring.mapper" />
```

## 2. CRUD 게시판 애플리케이션

### 2.1. 오라클 데이터베이스에 `board` 테이블을 생성하고 더미 데이터를 추가하는 SQL 스크립트

[`C:\dev\database\scripts\table-board.sql`](../samples/table-board.sql)

```sql
-- create board table
CREATE TABLE board (
    id          NUMBER,
    title       VARCHAR2(200) NOT NULL,
    content     VARCHAR2(2000) NOT NULL,
    writer      VARCHAR2(50) NOT NULL,
    regdate     DATE DEFAULT SYSDATE NOT NULL,
    updatedate  DATE DEFAULT SYSDATE NOT NULL,
    CONSTRAINT PK_BOARD_ID PRIMARY KEY (id)
);

-- create sequence for board_id
CREATE SEQUENCE SEQ_BOARD_ID;

-- add dummy data
INSERT INTO board (id, title, content, writer)
VALUES (SEQ_BOARD_ID.NEXTVAL, '...', '...', 'Tom');

...

-- commit database
COMMIT;
```

[`table-board.sql`](../samples/table-board.sql) 파일을 다운로드해서 SQL Plus를 이용해 오라클 데이터베이스에 추가한다.

### 2.2. Mybatis-Spring 라이브러리의 맵퍼(Mapper) XML 추가

`$PROJECT_HOME/src/main/resources/com/board/mapper/BoardMapper.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!-- <mapper> 태그의 namespace 속성은 Mapper 인터페이스와 같은 이름으로 설정해야 한다. -->
<mapper namespace="com.board.mapper.BoardMapper">

    <!--
    <select> 태그의 id 속성은 메서드의 이름과 같아야 한다.
    resultType 속성은 SELECT 쿼리의 결과를 특정 클래스의 객체로 만들기 위해 설정한다.
    이때 SQL 문의 끝에 세미콜론(;)이 들어가지 않도록 주의한다.
    CDATA 부분은 쿼리에서 부등호(>)를 쓰기 위해 넣은 것이다.
    -->
    <select id="getList" resultType="com.board.domain.BoardVO">
    <![CDATA[
        SELECT * FROM board WHERE id > 0
    ]]>
    </select>

</mapper>
```

### 2.3. 스프링 MVC에서 한글 인코딩 문제 해결

`$PROJECT_HOME/src/main/webapp/WEB-INF/web.xml`

```xml
<!-- Character encoding filter -->
<filter>
    <filter-name>encoding</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
        <param-name>encoding</param-name>
        <param-value>UTF-8</param-value>
    </init-param>
</filter>

<filter-mapping>
    <filter-name>encoding</filter-name>
    <servlet-name>appServlet</servlet-name>
</filter-mapping>
```

`web.xml` 파일의 XML 오류를 수정하기 위해 `web-app` 요소의 `xsi:schemaLocation` 속성을 수정한다. (URL 사이에 세미콜론(;)을 추가)

```xml
<web-app version="2.5" xmlns="http://java.sun.com/xml/ns/javaee"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://java.sun.com/xml/ns/javaee; https://java.sun.com/xml/ns/javaee/web-app_2_5.xsd">
```

### 2.4. `board` 테이블의 레코드 늘리기

```sql
INSERT INTO board (id, title, content, writer)
(SELECT SEQ_BOARD_ID.NEXTVAL, title, content, writer FROM board);

INSERT INTO board (id, title, content, writer)
(SELECT SEQ_BOARD_ID.NEXTVAL, title, content, writer FROM board);

...

COMMIT;

SELECT COUNT(*) FROM board;
```

board 테이블의 레코드를 늘리기 위해 위에 있는 `INSERT` 문을 여러 번 실행하고 커밋한다. 위에 있는 `INSERT` 문을 한 번 실행할 때마다 전체 레코드의 개수는 두 배씩 증가한다.

### 2.5. 게시물 목록에서 페이징 처리를 하기 위한 SQL 문

`$PROJECT_HOME/src/main/resources/com/board/mapper/BoardMapper.xml`

```xml
<!-- Criteria 객체를 이용해 페이징 처리 -->
<!-- 오라클 12c 버전부터는 Row Limiting 절이 도입되어, 인라인 뷰(inline view)를 이용해서
     페이징을 처리하는 것보다 더 간단하게 처리할 수 있다. -->
<select id="getListWithPaging" resultType="com.board.domain.BoardVO">
<![CDATA[
    SELECT id, title, writer, regdate, updatedate
    FROM board
    ORDER BY id DESC
    OFFSET (#{page} - 1) * #{rowsPerPage} ROWS FETCH FIRST #{rowsPerPage} ROWS ONLY
]]>
</select>
```
