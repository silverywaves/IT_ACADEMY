## 자바(JAVA)
객체지향 프로그래밍 언어
* 운영체제에 독립적
    * 한번 작성하면, 어디서나 실행된다 (Write once, run anywhere)
* 객체지향언어
* 문법 단순화로 비교적 배우기 쉬움
* 자동 메모리 관리
* 네트워크와 분산처리 지원
* 멀티쓰레드 지원
* 동적 로딩(Dynamic Loading) 지원

---

## JVM(Java Virtual Machine)
자바를 실행하기 위한 가상 컴퓨터

컴퓨터(하드웨어) <-> OS(Windows) <-> JVM <-> Java 애플리케이션
=> 일반 애플리케이션과 다르게 JVM을 한번 더 거침
=> 미리 컴파일x. 실행시에 해석되어 느림
=> OS에 종속적. 해당 OS에서 실행 가능한 JVM 필요

---

* JDK : 자바개발도구 
        = JRE + 개발에 필요한 실행파일(javac.exe 등)
* JRE : 자바실행환경, 자바로 작성된 응용프로그램이 실행되기 위한 최소환경
        = JVM + 클래스라이브러리(Java API)

---

* javac.exe : 자바 컴파일러, 자바소스코드를 바이트코드로 컴파일
* java.exe  : 자바 인터프리터, 컴파일러가 생성한 바이트코드를 해석하고 실행
* javap.exe : 역어셈블러, 컴파일된 클래스파일을 원래의 소스로 변환
* javadoc.exe : 자동문서생성기, 소스파일에 있는 주석(/** */)을 이용해 Jasa API 문서와 같은 형식의 문서를 자동으로 생성
* jar.exe   : 압축프로그램, 클래스파일과 프로그램의 실행에 관련된 파일을 하나의 jar파일로 압축하거나 해제

---

### 소스파일 작성
* public class가 있는 경우, 소스파일의 이름은 public class의 이름과 일치시킴
* public class가 없는 경우, 소스파일의 이름은 일반 class의 이름 모두 가능
* public class가 둘 이상인 경우, 잘못작성한 것. 각 클래스를 나눠서 저장하거나 한 클래스에 public 삭제
* 대소문자 일치 주의

  
