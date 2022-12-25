# SBS아카데미 광주지점 백 엔드 프로그래밍 과정

- [1. 설치할 프로그램과 라이브러리](#1-설치할-프로그램과-라이브러리)
    - [1.1. JDK(Java Development Kit)](#11-jdkjava-development-kit)
    - [1.2. 통합 개발 환경(IDE; Integrated Development Environment)](#12-통합-개발-환경ide-integrated-development-environment)
- [2. 레퍼런스와 유용한 문서](#2-레퍼런스와-유용한-문서)

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

## 2. 레퍼런스와 유용한 문서

- [개발자에게 유용한 레퍼런스와 문서들](https://mooozi.github.io/references.html)
- [D2Coding Font](https://github.com/naver/d2codingfont)
- [GitHub](https://github.com/)
