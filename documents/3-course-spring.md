# SBS아카데미 광주지점 스프링 프레임워크 과정

- [1. 설치할 프로그램과 라이브러리](#1-설치할-프로그램과-라이브러리)
    - [1.1. JDK(Java Development Kit)](#11-jdkjava-development-kit)
    - [1.2. 통합 개발 환경(IDE; Integrated Development Environment)](#12-통합-개발-환경ide-integrated-development-environment)
    - [1.3. 편집기(Editor)](#13-편집기editor)
    - [1.4. 서블릿 컨테이너(Servlet Container)](#14-서블릿-컨테이너servlet-container)
    - [1.5. 데이터베이스(Database)](#15-데이터베이스database)
    - [1.6. 스프링 프레임워크(Spring Framework)](#16-스프링-프레임워크spring-framework)
    - [1.7. 자바 라이브러리와 도구(Java Libraries and Tools)](#17-자바-라이브러리와-도구java-libraries-and-tools)
- [2. 레퍼런스와 유용한 문서](#2-레퍼런스와-유용한-문서)
- [3. Spring Legacy Project 설정](#3-spring-legacy-project-설정)
    - [3.1. 스프링 프레임워크 버전 수정](#31-스프링-프레임워크-버전-수정)
    - [3.2. 자바 컴파일러 버전 변경](#32-자바-컴파일러-버전-변경)
    - [3.3. Lombok 라이브러리 추가](#33-lombok-라이브러리-추가)
    - [3.4. Log4j 라이브러리 버전 수정](#34-log4j-라이브러리-버전-수정)
    - [3.5. JUnit 라이브러리 버전 수정](#35-junit-라이브러리-버전-수정)
    - [3.6. `spring-test` 모듈 추가](#36-spring-test-모듈-추가)
    - [3.7. 스프링 컨테이너에 빈(Bean) 등록](#37-스프링-컨테이너에-빈bean-등록)
    - [3.8. 오라클 JDBC 드라이버 추가](#38-오라클-jdbc-드라이버-추가)
    - [3.9. HikariCP 라이브러리 추가](#39-hikaricp-라이브러리-추가)
    - [3.10. 스프링 컨테이너에 HikariCP 라이브러리 설정](#310-스프링-컨테이너에-hikaricp-라이브러리-설정)
    - [3.11. 마이바티스 프레임워크 관련 라이브러리 추가](#311-마이바티스-프레임워크-관련-라이브러리-추가)
    - [3.12. 스프링 컨테이너에 `SqlSessionFactory` 객체를 빈(Bean)으로 등록](#312-스프링-컨테이너에-sqlsessionfactory-객체를-빈bean으로-등록)
    - [3.13. 스프링 컨테이너에 Mybatis-Spring 라이브러리의 맵퍼(Mapper) 인터페이스 설정 추가](#313-스프링-컨테이너에-mybatis-spring-라이브러리의-맵퍼mapper-인터페이스-설정-추가)
    - [3.14. Mybatis-Spring 라이브러리의 맵퍼(Mapper) XML 추가](#314-mybatis-spring-라이브러리의-맵퍼mapper-xml-추가)
    - [3.15. Log4jdbc 라이브러리 추가](#315-log4jdbc-라이브러리-추가)
    - [3.16. Log4jdbc 라이브러리 설정](#316-log4jdbc-라이브러리-설정)

## 1. 설치할 프로그램과 라이브러리

`C:\dev`와 같은 폴더를 하나 만들어, 수업 시간에 필요한 프로그램과 라이브러리는 모두 그 폴더에 저장하고 설치하는 것이 관리하기 편하다. 폴더 이름에는 한글이나 빈칸을 넣지 않는다.

| 폴더                       | 설명                                                 |
|---------------------------|-----------------------------------------------------|
| `C:\dev\downloads`        | 다운로드한 파일들을 저장할 폴더                          |
| `C:\dev\jdk`              | JDK(Java Development Kit)를 설치할 폴더               |
| `C:\dev\eclipse`          | 이클립스 IDE를 설치할 폴더                              |
| `C:\dev\tomcat`           | 아파치 톰캣(WAS; Web Application Server)을 설치할 폴더  |
| `C:\dev\database`         | DMBS와 DB 관련 프로그램을 설치할 폴더                    |
| `C:\dev\database\scripts` | 수업 시간에 사용하는 SQL 스크립트를 저장할 폴더            |
| `C:\dev\lib`              | 수업 시간에 필요한 자바 라이브러리를 저장할 폴더            |

### 1.1. JDK(Java Development Kit)

- [Oracle Java SE 8](https://www.oracle.com/java/technologies/javase/javase8u211-later-archive-downloads.html)
- [Eclipse Temurin : OpenJDK distribution from Adoptium](https://adoptium.net/)
- [OpenJDK Project](https://github.com/ojdkbuild/ojdkbuild)

나중에 스프링 프레임워크를 사용하기 위해 JDK는 [OpenJDK 11](https://adoptium.net/temurin/releases/?version=11)을 설치하는 것이 좋다.
윈도우 10 사용자는 [OpenJDK 11 Windows x64](https://github.com/adoptium/temurin11-binaries/releases/download/jdk-11.0.17%2B8/OpenJDK11U-jdk_x64_windows_hotspot_11.0.17_8.msi) 버전을 설치하면 된다. 2022년 11월 25일 현재, OpenJDK 11의 최신 버전은 `11.0.17_8`이니 [OpenJDK 11](https://adoptium.net/temurin/releases/?version=11) 페이지를 확인해서 새로운 버전이 있으면 그 버전을 설치하도록 한다.

> OpenJDK 11을 설치할 때는 설치 경로를 `C:\dev\jdk\jdk-11.0.17.8-hotspot` 폴더로 지정한다.

### 1.2. 통합 개발 환경(IDE; Integrated Development Environment)

- [Eclipse IDE](https://www.eclipse.org/)

스프링 프레임워크와 관련 라이브러리는 이클립스 IDE와 JDK 등의 버전에 따라 오류가 발생하는 경우가 많으니 [Eclipse 2022-09 (4.21)](https://www.eclipse.org/downloads/packages/release/2021-09/) 버전을 설치하도록 한다.
윈도우 10 사용자는 [Eclipse Installer 2021-09 Windows x86_64](https://www.eclipse.org/downloads/download.php?file=/oomph/epp/2021-09/R/eclipse-inst-jre-win64.exe&mirror_id=1273) 버전을 설치하면 된다.

> 웹 애플리케이션을 개발하기 위해서는, 이클립스 IDE를 "Eclipse IDE for Enterprise Java and Web Developers" 패키지로 설치해야 한다. 설치 과정 중에 "Java 11+ VM"은 위에서 설치한 OpenJDK 11(`C:\dev\jdk\jdk-11.0.17.8-hotspot`)을 지정하고, 설치 경로(Installcation Folder)는 `C:\dev\eclipse\jee-2021-09` 폴더로 지정한다.
>
> 이클립스 IDE를 설치한 다음, 워크스페이스(Workspace)는 `D:\work\backend` 등과 같이 적당한 작업 폴더를 지정하도록 한다. 작업 폴더는 시스템 드라이브(C 드라이브)가 아닌 다른 드라이브에 만드는 것이 좋다.

이클립스 IDE를 종료한 다음, 이클립스 IDE의 실행 설정 파일인 `C:\dev\eclipse\jee-2021-09\eclipse\eclipse.ini` 파일을 아래와 같이 수정한다.

```conf
...
-vm
C:/dev/jdk/jdk-11.0.17.8-hotspot/bin
...
-Xms2048m
-Xmx2048m
```

### 1.3. 편집기(Editor)

- [Visual Studio Code](https://code.visualstudio.com/)

HTML 문서 등을 작성하기 위해 Visual Studio Code 편집기를 사용한다. 혹은 다른 익숙한 편집기가 있다면 그 편집기를 사용해도 괜찮다.

### 1.4. 서블릿 컨테이너(Servlet Container)

- [Apache Tomcat 9](https://tomcat.apache.org/)

WAS(Web Application Server; Servlet Container)로 [아파치 톰캣 9](https://tomcat.apache.org/download-90.cgi)를 사용한다. 윈도우 10 사용자는 [Apache Tomcat 9 32-bit/64-bit Windows Service Installer](https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.69/bin/apache-tomcat-9.0.69.exe)를 `C:\dev\tomcat` 폴더에 설치하면 된다. 2022년 11월 25일 현재, 아파치 톰캣 9의 최신 버전은 `9.0.69`이니 [아파치 톰캣 9 다운로드](https://tomcat.apache.org/download-90.cgi) 페이지를 확인해서 새로운 버전이 있으면 그 버전을 설치하도록 한다.

> 아파치 톰캣 9를 설치할 때, JVM(Java Virtual Machine)은 위에서 설치한 OpenJDK 11(`C:\dev\jdk\jdk-11.0.17.8-hotspot`)을 지정하고, 설치 경로(Destination Folder)는 `C:\dev\tomcat\tomcat-9.0.69` 폴더로 지정한다.

### 1.5. 데이터베이스(Database)

- [Oracle Database XE](https://www.oracle.com/database/technologies/xe-downloads.html)
- [Oracle JDBC Driver](https://www.oracle.com/database/technologies/appdev/jdbc-downloads.html)
- [DBeaver](https://dbeaver.io/)
- [SQL Developer](https://www.oracle.com/tools/downloads/sqldev-downloads.html)

DBMS(Database Management System)는 [오라클 데이터베이스](https://www.oracle.com/database/technologies/)의 개인 개발자용 무료 버전인 [Express Edition](https://www.oracle.com/database/technologies/xe-downloads.html)을 사용한다. Express Edition에서는 최대 12GB 데이터를 저장할 수 있으며, 메모리는 최대 2GB, CPU 쓰레드는 최대 2개까지 사용할 수 있다.

> 오라클 데이터베이스는 설치하면서 설정할 것과 확인할 것이 있으니, [Oracle Database 21c Express Edition for Windows x64](https://download.oracle.com/otn-pub/otn_software/db-express/OracleXE213_Win64.zip) 파일을 다운로드해놓고 수업 시간에 같이 설치하도록 한다. Oracle Database 21c Express Edition을 설치할 경로는 `C:\dev\database\oracle21c`이다.
>
> 실습하지 않을 때에도 오라클 데이터베이스가 실행되고 있으면 시스템 성능이 떨어진다. 따라서 실습하지 않을 때에는 오라클 데이터베이스가 실행되지 않도록 윈도우 서비스 항목 중에서 "OracleOraDB21Home1TNSListener"와 "OracleServiceXE" 서비스의 "시작 유형"을 "수동"으로 설정한다.
>
> 오라클 데이터베이스를 설치한 다음, `C:\dev\database\oracle21c\dbhomeXE\jdbc\lib` 폴더에 있는 오라클 JDBC 드라이버인 `ojdbc8.jar` 파일을 `C:\dev\lib` 폴더에 복사한다.

### 1.6. 스프링 프레임워크(Spring Framework)

- [Spring Tool Suite 4](https://spring.io/tools/)
- [Spring Tool Suite 3](https://github.com/spring-projects/toolsuite-distribution/wiki/Spring-Tool-Suite-3)
- [Spring Framework Repository](https://github.com/spring-projects/spring-framework)
- [Spring Framework Library](https://repo.spring.io/ui/native/release/org/springframework/spring/)

이클립스 IDE에서 스프링 프레임워크를 사용하기 위해 Spring Tools 3 플러그인을 설치한다. 스프링 프레임워크와 관련 라이브러리는 이클립스 IDE와 JDK 등의 버전에 따라 오류가 발생하는 경우가 많으니 [OpenJDK 11](https://adoptium.net/temurin/releases/?version=11)과 [Eclipse 2022-09 (4.21)](https://www.eclipse.org/downloads/packages/release/2021-09/) 버전을 설치하도록 한다.

이클립스 IDE에서 "Help" 메뉴의 "Eclipse Markplace"에 들어가 "STS3"로 검색해서, "Spring Tools 3 (Standalone Edition)"을 설치한다. 설치하는 도중 인증서를 신뢰할 수 있는지 알림 창이 나오는데 "Trust Selected" 버튼을 누르면 된다.

이클립스 IDE에 Spring Tools 3 플러그인을 설치하면 "Spring Tools 3 Add-On for Spring 4" 플러그인도 함께 설치된다.

### 1.7. 자바 라이브러리와 도구(Java Libraries and Tools)

- [JSP Standard Tag Library](https://tomcat.apache.org/download-taglibs.cgi)
- [JSON.simple](https://code.google.com/archive/p/json-simple/)
- [Lombok Library](https://projectlombok.org/)
- [Apache Maven](https://maven.apache.org/)
- [Gradle](https://gradle.org/)

JSP에서 표현 언어와 커스텀 태그를 사용하기 위해 JSTL(JSP Standard Tag Library)이 필요하며, 클래스를 정의하면서 생성자·설정자·접근자 등을 생성해주는 Lombok 라이브러를 사용한다.

> [JSTL 페이지](https://tomcat.apache.org/download-taglibs.cgi)에서 JAR 파일 4개를 다운로드해서 `C:\dev\lib` 폴더에 저장하고, [Lombok 프로젝트 다운로드 페이지](https://projectlombok.org/download)에서 [`lombok.jar`](https://projectlombok.org/downloads/lombok.jar)를 다운로드해서 `C:\dev\lib` 폴더에 저장한다.

## 2. 레퍼런스와 유용한 문서

- [개발자에게 유용한 레퍼런스와 문서들](https://mooozi.github.io/references.html)
- [D2Coding Font](https://github.com/naver/d2codingfont)
- [GitHub](https://github.com/)

## 3. Spring Legacy Project 설정

아래 내용은 수업 시간에 차근차근 살펴보면서 설정한다.

### 3.1. 스프링 프레임워크 버전 수정

`$PROJECT_HOME/pom.xml`

```xml
<properties>
    <java-version>11</java-version>
    <org.springframework-version>5.3.12</org.springframework-version>
    <org.aspectj-version>1.6.10</org.aspectj-version>
    <org.slf4j-version>1.6.6</org.slf4j-version>
</properties>
```

### 3.2. 자바 컴파일러 버전 변경

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

### 3.3. Lombok 라이브러리 추가

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

### 3.4. Log4j 라이브러리 버전 수정

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

### 3.5. JUnit 라이브러리 버전 수정

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

### 3.6. `spring-test` 모듈 추가

`$PROJECT_HOME/pom.xml`

```xml
<!-- spring-test for JUnit library -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-test</artifactId>
    <version>${org.springframework-version}</version>
</dependency>
```

### 3.7. 스프링 컨테이너에 빈(Bean) 등록

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

### 3.8. 오라클 JDBC 드라이버 추가

프로젝트의 Classpath에 오라클 JDBC 드라이버인 `C:\dev\lib\ojdbc8.jar` 파일을 추가하고, "Deployment Assembly" 항목에도 추가한다.

### 3.9. HikariCP 라이브러리 추가

`$PROJECT_HOME/pom.xml`

```xml
<!-- https://mvnrepository.com/artifact/com.zaxxer/HikariCP -->
<dependency>
    <groupId>com.zaxxer</groupId>
    <artifactId>HikariCP</artifactId>
    <version>5.0.0</version>
</dependency>
```

### 3.10. 스프링 컨테이너에 HikariCP 라이브러리 설정

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

### 3.11. 마이바티스 프레임워크 관련 라이브러리 추가

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

### 3.12. 스프링 컨테이너에 `SqlSessionFactory` 객체를 빈(Bean)으로 등록

`$PROJECT_HOME/src/main/webapp/WEB-INF/spring/root-context.xml`

```xml
<!-- SqlSessionFactory for MyBatis Framework -->
<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
    <property name="dataSource" ref="dataSource" />
</bean>
```

### 3.13. 스프링 컨테이너에 Mybatis-Spring 라이브러리의 맵퍼(Mapper) 인터페이스 설정 추가

`$PROJECT_HOME/src/main/webapp/WEB-INF/spring/root-context.xml`

`root-context.xml`에 `mybatis-spring` 네임스페이스를 추가한 다음 아래 내용을 추가한다.

```xml
<!-- MyBatis Mapper -->
<mybatis-spring:scan base-package="com.spring.mapper" />
```

### 3.14. Mybatis-Spring 라이브러리의 맵퍼(Mapper) XML 추가

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

### 3.15. Log4jdbc 라이브러리 추가

`$PROJECT_HOME/pom.xml`

```xml
<!-- https://mvnrepository.com/artifact/org.bgee.log4jdbc-log4j2/log4jdbc-log4j2-jdbc4.1 -->
<dependency>
    <groupId>org.bgee.log4jdbc-log4j2</groupId>
    <artifactId>log4jdbc-log4j2-jdbc4.1</artifactId>
    <version>1.16</version>
</dependency>
```

### 3.16. Log4jdbc 라이브러리 설정

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
