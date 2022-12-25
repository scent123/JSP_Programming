# Web_Spring with Eclipse

- [1. 설치할 프로그램과 라이브러리](#1-설치할-프로그램과-라이브러리)
    - [1.1. JDK(Java Development Kit)](#11-jdkjava-development-kit)
    - [1.2. 통합 개발 환경(IDE; Integrated Development Environment)](#12-통합-개발-환경ide-integrated-development-environment)
    - [1.3. 편집기(Editor)](#13-편집기editor)
    - [1.4. 서블릿 컨테이너(Servlet Container)](#14-서블릿-컨테이너servlet-container)
    - [1.5. 데이터베이스(Database)](#15-데이터베이스database)
    - [1.6. 스프링 프레임워크(Spring Framework)](#16-스프링-프레임워크spring-framework)
    - [1.7. 자바 라이브러리와 도구(Java Libraries and Tools)](#17-자바-라이브러리와-도구java-libraries-and-tools)
- [2. 레퍼런스와 유용한 문서](#2-레퍼런스와-유용한-문서)
- [3. JSP 프로그래밍 과정 수업 자료](#3-jsp-프로그래밍-과정-수업-자료)
    - [3.1. `$PROJECT_HOME/src/main/webapp/WEB-INF/web.xml`](#31-project_homesrcmainwebappweb-infwebxml)
    - [3.2. `table-member.sql`](#32-table-membersql)
    - [3.3. 톰캣에서 `DataSource` 설정](#33-톰캣에서-datasource-설정)
    - [3.4. `cookie.js`](#34-cookiejs)
    - [3.5. JSP 표준 태그 라이브러리(JSTL; JSP Standard Tag Library)](#35-jsp-표준-태그-라이브러리jstl-jsp-standard-tag-library)
- [4. 스프링 프레임워크 과정 수업 자료](#4-스프링-프레임워크-과정-수업-자료)
    - [4.1. 이클립스 실행 설정 파일 수정](#41-이클립스-실행-설정-파일-수정)
    - [4.2. 스프링 프로젝트의 스프링 프레임워크 버전 수정](#42-스프링-프로젝트의-스프링-프레임워크-버전-수정)
    - [4.3. 스프링 프로젝트의 JDK 버전 변경](#43-스프링-프로젝트의-jdk-버전-변경)
    - [4.4. 스프링 프로젝트에 Lombok 라이브러리 추가](#44-스프링-프로젝트에-lombok-라이브러리-추가)
    - [4.5. 스프링 프로젝트의 Log4j 라이브러리 버전 수정](#45-스프링-프로젝트의-log4j-라이브러리-버전-수정)
    - [4.6. 스프링 프로젝트의 JUnit 라이브러리 버전 수정](#46-스프링-프로젝트의-junit-라이브러리-버전-수정)
    - [4.7. 스프링 프로젝트에 `spring-test` 모듈 추가](#47-스프링-프로젝트에-spring-test-모듈-추가)
    - [4.8. 스프링 컨테이너에 빈(Bean) 등록](#48-스프링-컨테이너에-빈bean-등록)
    - [4.9. 스프링 프로젝트에 HikariCP 라이브러리 추가](#49-스프링-프로젝트에-hikaricp-라이브러리-추가)
    - [4.10. 스프링 컨테이너에 HikariCP 라이브러리 설정](#410-스프링-컨테이너에-hikaricp-라이브러리-설정)
    - [4.11. 스프링 프로젝트에 마이바티스 프레임워크 관련 라이브러리 추가](#411-스프링-프로젝트에-마이바티스-프레임워크-관련-라이브러리-추가)
    - [4.12. 스프링 컨테이너에 `SqlSessionFactory` 객체를 빈(Bean)으로 등록](#412-스프링-컨테이너에-sqlsessionfactory-객체를-빈bean으로-등록)
    - [4.13. 스프링 컨테이너에 마이바티스 프레임워크의 맵퍼(Mapper) 인터페이스 설정 추가](#413-스프링-컨테이너에-마이바티스-프레임워크의-맵퍼mapper-인터페이스-설정-추가)
    - [4.14. 스프링 컨테이너에 마이바티스 프레임워크의 맵퍼(Mapper) XML 추가](#414-스프링-컨테이너에-마이바티스-프레임워크의-맵퍼mapper-xml-추가)
    - [4.15. 스프링 프로젝트에 Log4jdbc 라이브러리 추가](#415-스프링-프로젝트에-log4jdbc-라이브러리-추가)
    - [4.16. Log4jdbc 라이브러리 설정](#416-log4jdbc-라이브러리-설정)
    - [4.17. 스프링 MVC 프로젝트 설정](#417-스프링-mvc-프로젝트-설정)
    - [4.18. 스프링 MVC 프로젝트에 `javax.servlet-api` 라이브러리 설정](#418-스프링-mvc-프로젝트에-javaxservlet-api-라이브러리-설정)
    - [4.19. 스프링 MVC 프로젝트의 Log4j 라이브러리 설정 수정](#419-스프링-mvc-프로젝트의-log4j-라이브러리-설정-수정)
    - [4.20. `table-board.sql`](#420-table-boardsql)

## 1. 설치할 프로그램과 라이브러리

### 1.1. JDK(Java Development Kit)

- [Oracle Java SE 8](https://www.oracle.com/java/technologies/javase/javase8u211-later-archive-downloads.html)
- [Eclipse Temurin : OpenJDK distribution from Adoptium](https://adoptium.net/)
- [OpenJDK Project](https://github.com/ojdkbuild/ojdkbuild)

### 1.2. 통합 개발 환경(IDE; Integrated Development Environment)

- [Eclipse IDE](https://www.eclipse.org/)

### 1.3. 편집기(Editor)

- [Visual Studio Code](https://code.visualstudio.com/)

### 1.4. 서블릿 컨테이너(Servlet Container)

- [Apache Tomcat 9](https://tomcat.apache.org/)

### 1.5. 데이터베이스(Database)

- [Oracle Database XE](https://www.oracle.com/database/technologies/xe-downloads.html)
- [Oracle JDBC Driver](https://www.oracle.com/database/technologies/appdev/jdbc-downloads.html)
- [DBeaver](https://dbeaver.io/)
- [SQL Developer](https://www.oracle.com/tools/downloads/sqldev-downloads.html)

### 1.6. 스프링 프레임워크(Spring Framework)

- [Spring Tool Suite 4](https://spring.io/tools/)
- [Spring Tool Suite 3](https://github.com/spring-projects/toolsuite-distribution/wiki/Spring-Tool-Suite-3)
- [Spring Framework Repository](https://github.com/spring-projects/spring-framework)
- [Spring Framework Library](https://repo.spring.io/ui/native/release/org/springframework/spring/)

### 1.7. 자바 라이브러리와 도구(Java Libraries and Tools)

- [JSP Standard Tag Library](https://tomcat.apache.org/download-taglibs.cgi)
- [JSON.simple](https://code.google.com/archive/p/json-simple/)
- [Lombok Library](https://projectlombok.org/)
- [Apache Maven](https://maven.apache.org/)
- [Gradle](https://gradle.org/)

## 2. 레퍼런스와 유용한 문서

- [개발자에게 유용한 레퍼런스와 문서들](https://mooozi.github.io/references.html)
- [Java EE 8 Specification API](https://javaee.github.io/javaee-spec/javadocs/)
- [어떤 JDK를 써야 할까?](https://www.lesstif.com/java/jdk-whichjdk-com-125305293.html)
- [D2Coding Font](https://github.com/naver/d2codingfont)
- [GitHub](https://github.com/)

## 3. JSP 프로그래밍 과정 수업 자료

### 3.1. `$PROJECT_HOME/src/main/webapp/WEB-INF/web.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns="http://java.sun.com/xml/ns/javaee"
    xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
    id="WebApp_ID" version="3.0">
</web-app>
```

### 3.2. `table-member.sql`

```sql
-- create member table
CREATE TABLE member (
    id      NUMBER,
    account VARCHAR2(50) NOT NULL,
    passwd  VARCHAR2(50) NOT NULL,
    name    VARCHAR2(50) NOT NULL,
    email   VARCHAR2(100) NOT NULL,
    regdate DATE DEFAULT SYSDATE NOT NULL,
    CONSTRAINT PK_MEMBER_ID PRIMARY KEY (id),
    CONSTRAINT UNQ_MEMBER_ACCT UNIQUE (account),
    CONSTRAINT UNQ_MEMBER_EMAIL UNIQUE (email)
);

-- create sequence for member_id
CREATE SEQUENCE SEQ_MEMBER_ID;

-- add member information
INSERT INTO member (id, account, passwd, name, email)
VALUES (SEQ_MEMBER_ID.NEXTVAL, 'jackson', 'dog', 'Michael Jackson', 'michael@jackson.com');

INSERT INTO member (id, account, passwd, name, email)
VALUES (SEQ_MEMBER_ID.NEXTVAL, 'watson', 'cat', 'Emma Watson', 'emma@watson.com');

INSERT INTO member (id, account, passwd, name, email)
VALUES (SEQ_MEMBER_ID.NEXTVAL, 'potter', 'deer', 'Harry Potter', 'harry@potter.com');

INSERT INTO member (id, account, passwd, name, email)
VALUES (SEQ_MEMBER_ID.NEXTVAL, 'carey', 'oriole', 'Mariah Carey', 'mariah@carey.com');

INSERT INTO member (id, account, passwd, name, email)
VALUES (SEQ_MEMBER_ID.NEXTVAL, 'dean', 'horse', 'James Dean', 'james@dean.com');

INSERT INTO member (id, account, passwd, name, email)
VALUES (SEQ_MEMBER_ID.NEXTVAL, 'cruise', 'cheetah', 'Tom Cruise', 'tom@cruise.com');

-- commit database
COMMIT;
```

### 3.3. 톰캣에서 `DataSource` 설정

`$CATALINA_HOME/conf/context.xml` 파일 끝 부분에 `<Resource>` 태그를 추가

```xml
    <!--
    <Manager pathname="" />
    -->

    <Resource
        name="jdbc/oracle"
        auth="Container"
        type="javax.sql.DataSource"
        driverClassName="oracle.jdbc.driver.OracleDriver"
        url="jdbc:oracle:thin:@localhost:1521:XE"
        username="c##scott"
        password="tiger"
        maxTotal="20"
        maxIdle="20"
    />
</Context>
```

### 3.4. `cookie.js`

```javascript
/**
 * Get cookie value
 * @param name cookie name
 * @return cookie value 
 */
function getCookie(name) {
    var values = document.cookie.match("(?:^|;) ?" + name + "=([^;]*)(?:;|$)");
    return values ? values[1] : null;
}

/**
 * Set cookie
 * @param name cookie name
 * @param value cookie value
 * @param expDays expiry in days
 */
function setCookie(name, value, expDays) {
    var date = new Date();
    date.setTime(date.getTime() + expDays * 24 * 60 * 60 * 1000);
    document.cookie = name + "=" + value + "; expires=" + date.toUTCString() + "; path=/";
}

/**
 * Delete cookie
 * @param name cookie name
 */
function deleteCookie(name) {
    document.cookie = name + "=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/";
}
```

### 3.5. JSP 표준 태그 라이브러리(JSTL; JSP Standard Tag Library)

```jsp
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
```

## 4. 스프링 프레임워크 과정 수업 자료

### 4.1. 이클립스 실행 설정 파일 수정

```conf
...
-vm
C:/dev/jdk/jdk-11.0.16.101-hotspot/bin
-vmargs
-Declipse.p2.max.threads=10
...
-Xms2048m
-Xmx2048m
--add-modules=ALL-SYSTEM
```

### 4.2. 스프링 프로젝트의 스프링 프레임워크 버전 수정

`$PROJECT_HOME/pom.xml`

```xml
<properties>
    <java-version>11</java-version>
    <org.springframework-version>5.3.12</org.springframework-version>
    <org.aspectj-version>1.6.10</org.aspectj-version>
    <org.slf4j-version>1.6.6</org.slf4j-version>
</properties>
```

### 4.3. 스프링 프로젝트의 JDK 버전 변경

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

### 4.4. 스프링 프로젝트에 Lombok 라이브러리 추가

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

### 4.5. 스프링 프로젝트의 Log4j 라이브러리 버전 수정

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
    <scope>runtime</scope>
</dependency>
```

Lombok 라이브러리를 활용할 때 문제가 생길 수 있으니 Log4j 라이브러리를 버전 1.2.17로 사용한다.

### 4.6. 스프링 프로젝트의 JUnit 라이브러리 버전 수정

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

### 4.7. 스프링 프로젝트에 `spring-test` 모듈 추가

`$PROJECT_HOME/pom.xml`

```xml
<!-- spring-test for JUnit library -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-test</artifactId>
    <version>${org.springframework-version}</version>
</dependency>
```

### 4.8. 스프링 컨테이너에 빈(Bean) 등록

`$PROJECT_HOME/src/main/webapp/WEB-INF/spring/root-context.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xmlns:mybatis-spring="http://mybatis.org/schema/mybatis-spring"
    xsi:schemaLocation="http://mybatis.org/schema/mybatis-spring http://mybatis.org/schema/mybatis-spring-1.2.xsd
    http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.3.xsd">

    <!-- Root Context: defines shared resources visible to all other web components -->
    <context:component-scan base-package="com.spring.ex01" />
</beans>
```

### 4.9. 스프링 프로젝트에 HikariCP 라이브러리 추가

`$PROJECT_HOME/pom.xml`

```xml
<!-- https://mvnrepository.com/artifact/com.zaxxer/HikariCP -->
<dependency>
    <groupId>com.zaxxer</groupId>
    <artifactId>HikariCP</artifactId>
    <version>5.0.0</version>
</dependency>
```

### 4.10. 스프링 컨테이너에 HikariCP 라이브러리 설정

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

### 4.11. 스프링 프로젝트에 마이바티스 프레임워크 관련 라이브러리 추가

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

### 4.12. 스프링 컨테이너에 `SqlSessionFactory` 객체를 빈(Bean)으로 등록

`$PROJECT_HOME/src/main/webapp/WEB-INF/spring/root-context.xml`

```xml
<!-- SqlSessionFactory for MyBatis Framework -->
<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
    <property name="dataSource" ref="dataSource" />
</bean>
```

### 4.13. 스프링 컨테이너에 마이바티스 프레임워크의 맵퍼(Mapper) 인터페이스 설정 추가

`$PROJECT_HOME/src/main/webapp/WEB-INF/spring/root-context.xml`

```xml
<!-- MyBatis Mapper -->
<mybatis-spring:scan base-package="com.spring.mapper" />
```

### 4.14. 스프링 컨테이너에 마이바티스 프레임워크의 맵퍼(Mapper) XML 추가

`$PROJECT_HOME/src/main/resources/com/spring/mapper/TimeMapper.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.spring.mapper.TimeMapper">
    <select id="getTime2" resultType="string">
        SELECT sysdate FROM dual
    </select>
</mapper>
```

### 4.15. 스프링 프로젝트에 Log4jdbc 라이브러리 추가

`$PROJECT_HOME/pom.xml`

```xml
<!-- https://mvnrepository.com/artifact/org.bgee.log4jdbc-log4j2/log4jdbc-log4j2-jdbc4.1 -->
<dependency>
    <groupId>org.bgee.log4jdbc-log4j2</groupId>
    <artifactId>log4jdbc-log4j2-jdbc4.1</artifactId>
    <version>1.16</version>
</dependency>
```

### 4.16. Log4jdbc 라이브러리 설정

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

### 4.17. 스프링 MVC 프로젝트 설정

1. [스프링 프로젝트의 스프링 프레임워크 버전 수정](#41-스프링-프로젝트의-스프링-프레임워크-버전-수정)
2. [스프링 프로젝트의 JDK 버전 변경](#42-스프링-프로젝트의-jdk-버전-변경)
3. [스프링 MVC 프로젝트에 `javax.servlet-api` 라이브러리 설정](#417-스프링-mvc-프로젝트에-javaxservlet-api-라이브러리-설정)
4. [스프링 프로젝트에 Lombok 라이브러리 추가](#43-스프링-프로젝트에-lombok-라이브러리-추가)
5. [스프링 MVC 프로젝트의 Log4j 라이브러리 설정 수정](#418-스프링-mvc-프로젝트의-log4j-라이브러리-설정-수정)
6. [스프링 프로젝트의 JUnit 라이브러리 버전 수정](#45-스프링-프로젝트의-junit-라이브러리-버전-수정)
7. [스프링 프로젝트에 `spring-test` 모듈 추가](#46-스프링-프로젝트에-spring-test-모듈-추가)
8. [스프링 프로젝트에 HikariCP 라이브러리 추가](#48-스프링-프로젝트에-hikaricp-라이브러리-추가)
9. [스프링 컨테이너에 HikariCP 라이브러리 설정](#49-스프링-컨테이너에-hikaricp-라이브러리-설정)
10. [스프링 프로젝트에 마이바티스 프레임워크 관련 라이브러리 추가](#410-스프링-프로젝트에-마이바티스-프레임워크-관련-라이브러리-추가)
11. [스프링 프로젝트에 Log4jdbc 라이브러리 추가](#414-스프링-프로젝트에-log4jdbc-라이브러리-추가)
12. [Log4jdbc 라이브러리 설정](#415-log4jdbc-라이브러리-설정)
13. [스프링 컨테이너에 `SqlSessionFactory` 객체를 빈(Bean)으로 등록](#411-스프링-컨테이너에-sqlsessionfactory-객체를-빈bean으로-등록)
14. [스프링 컨테이너에 마이바티스 프레임워크의 맵퍼(Mapper) 인터페이스 설정 추가](#412-스프링-컨테이너에-마이바티스-프레임워크의-맵퍼mapper-인터페이스-설정-추가)

### 4.18. 스프링 MVC 프로젝트에 `javax.servlet-api` 라이브러리 설정

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

### 4.19. 스프링 MVC 프로젝트의 Log4j 라이브러리 설정 수정

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

### 4.20. `table-board.sql`

[`table-board.sql`](https://github.com/lecture-jsp/lecture-jsp/blob/main/SQL/table-board.sql) 파일을 다운로드해서 SQL Plus를 이용해 오라클 데이터베이스에 추가

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
