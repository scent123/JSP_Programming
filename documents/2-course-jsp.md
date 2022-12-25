# SBS아카데미 광주지점 JSP 프로그래밍 과정

- [1. 설치할 프로그램과 라이브러리](#1-설치할-프로그램과-라이브러리)
    - [1.1. JDK(Java Development Kit)](#11-jdkjava-development-kit)
    - [1.2. 통합 개발 환경(IDE; Integrated Development Environment)](#12-통합-개발-환경ide-integrated-development-environment)
    - [1.3. 편집기(Editor)](#13-편집기editor)
    - [1.4. 서블릿 컨테이너(Servlet Container)](#14-서블릿-컨테이너servlet-container)
    - [1.5. 데이터베이스(Database)](#15-데이터베이스database)
    - [1.6. 자바 라이브러리와 도구(Java Libraries and Tools)](#16-자바-라이브러리와-도구java-libraries-and-tools)
- [2. 레퍼런스와 유용한 문서](#2-레퍼런스와-유용한-문서)
- [3. JSP 프로그래밍 과정 수업 자료](#3-jsp-프로그래밍-과정-수업-자료)
    - [3.1. 톰캣 컨테이너의 설정 파일](#31-톰캣-컨테이너의-설정-파일)
    - [3.2. 오라클 데이터베이스에 `member` 테이블을 생성하고 더미 데이터를 추가하는 SQL 스크립트](#32-오라클-데이터베이스에-member-테이블을-생성하고-더미-데이터를-추가하는-sql-스크립트)
    - [3.3. 톰캣 컨테이너에서 `DataSource` 설정](#33-톰캣-컨테이너에서-datasource-설정)
    - [3.4. 쿠키(Cookie)를 다루기 위한 JavaScript 라이브러리](#34-쿠키cookie를-다루기-위한-javascript-라이브러리)
    - [3.5. JSP 표준 태그 라이브러리(JSTL; JSP Standard Tag Library)](#35-jsp-표준-태그-라이브러리jstl-jsp-standard-tag-library)

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

### 1.6. 자바 라이브러리와 도구(Java Libraries and Tools)

- [JSP Standard Tag Library](https://tomcat.apache.org/download-taglibs.cgi)
- [JSON.simple](https://code.google.com/archive/p/json-simple/)
- [Lombok Library](https://projectlombok.org/)

JSP에서 표현 언어와 커스텀 태그를 사용하기 위해 JSTL(JSP Standard Tag Library)이 필요하며, 클래스를 정의하면서 생성자·설정자·접근자 등을 생성해주는 Lombok 라이브러를 사용한다.

> [JSTL 페이지](https://tomcat.apache.org/download-taglibs.cgi)에서 JAR 파일 4개를 다운로드해서 `C:\dev\lib` 폴더에 저장하고, [Lombok 프로젝트 다운로드 페이지](https://projectlombok.org/download)에서 [`lombok.jar`](https://projectlombok.org/downloads/lombok.jar)를 다운로드해서 `C:\dev\lib` 폴더에 저장한다.

## 2. 레퍼런스와 유용한 문서

- [개발자에게 유용한 레퍼런스와 문서들](https://mooozi.github.io/references.html)
- [D2Coding Font](https://github.com/naver/d2codingfont)
- [GitHub](https://github.com/)

## 3. JSP 프로그래밍 과정 수업 자료

### 3.1. 톰캣 컨테이너의 설정 파일

`$PROJECT_HOME/src/main/webapp/WEB-INF/web.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns="http://java.sun.com/xml/ns/javaee"
    xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
    id="WebApp_ID" version="3.0">
</web-app>
```

### 3.2. 오라클 데이터베이스에 `member` 테이블을 생성하고 더미 데이터를 추가하는 SQL 스크립트

[`C:\dev\database\scripts\table-member.sql`](../samples/table-member.sql)

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

[`table-member.sql`](../samples/table-member.sql) 파일을 다운로드해서 SQL Plus를 이용해 오라클 데이터베이스에 추가한다.

### 3.3. 톰캣 컨테이너에서 `DataSource` 설정

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

### 3.4. 쿠키(Cookie)를 다루기 위한 JavaScript 라이브러리

[`cookie.js`](../samples/cookie.js)

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
