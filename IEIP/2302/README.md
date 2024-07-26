# 정처산기 실기 정리
트랜잭션 ACID
---
- 원자성(Atomicity)
  - 모두 반영되거나 아니면 전혀 반영되지 않아야 함(부분 실행 X, **All or Nothing**)

- 일관성(Consistency)
  - 시스템이 가지고 있는 고정 요소는 **트랜잭션 수행 전과 트랜잭션 수행 완료 후의 상태가 같아야 함**

- 독립성, 격리성(Isolation)
  - 둘 이상의 트랜잭션이 동시에 병행 실행되고 있을 때 **또 다른 하나의 트랜잭션의 연산이 끼어들 수 없음**
 
- 영속성, 지속성(Durability)
  - 성공적으로 완료(COMMIT)된 트랜잭션의 결과가 **영구적으로 반영**되어야 함

<br>

DDL, DML, DCL
---
- 데이터 정의어(DDL; Data Definition Language)
  - 데이터의 형태, 구조, 데이터베이스의 저장에 관한 내용 정의, 변경, 제거하는 언어
  - CREATE, ALTER, DROP

- 데이터 조작어(DML; Data Manipulation Language)
  - 사용자의 요구에 따라 검색, 갱신, 삽입, 삭제 등을 지원하는 기능
  - SELECT, UPDATE, INSERT, DELETE

- 데이터 제어어(DCL; Data Control Language)
  - 정확성과 안정성을 유지하는 기능(무결성 유지, 보안, 권한, 병행 수행 제어, 회복)
  - REVOKE, GRANT

<br>

네트워크 프로토콜
---
### HDLC(High-level Data Link Control, 고급 데이터 링크 제어)
- **데이터링크 계층**(DataLink)의 대표적인 프로토콜

- 정보를 **전송 제어**(Control) 부호가 포함된 프레임이라는 단위로 분할하여 전송

- 프로토콜 구조(필드)
  - 플래그(Flag) : 프레임의 시작과 끝을 구분
  - 주소(Address) : 송수신지의 주소
  - 제어(Control) : 프레임의 종류를 구분(종류 : 정보 프레임, 감독 프레임, 비번호 프레임)
  - 데이터(Data) : 전송 데이터
  - 체크섬(Checksum) : 오류 검출 용도

- 프레임 종류
  - I-Frame(Information Frame, 정보 프레임)
    - 사용자 **데이터**를 전달하고 이와 관련된 데이터를 제어하는데 사용

   - S-Frame(Supervisory Frame, 감독 프레임)
    - **제어** 정보 전송 전용

  - U-Frame*Unnumbered Frame, 비번호 프레임)
    - 시스템 **관리**에 사용

- 전송 모드
  - NRM(Nomal Respnonse Mode, 정규 응답 모드)
    - **기본 서버**는 보조 서버로 데이터 **전송**을 시작할 수 있지만
    - **보조 서버**는 기본 서버의 명령에 대한 **응답**으로만 데이터를 전송할 수 있는 모드

  - ABM(Asynchronous Balanced Mode, 비동기 균형 모드)
    - 가장 널리 사용하는 모드
    - 기본 서버와 보조 서버가 서로 대등하게 **균형적으로 명령과 응답**하며 동작하는 모드

  - ARM(Asynchronous Response Mode, 비동기 응답 모드)
    - 보조 서버가 **기본 서버의 허가없이 데이터 전송**을 게시할 수 있는 모드

<br>

OSI 7계층 -PDU
---
#### PDU(Protocol Data Unit, 프로토콜 데이터 단위)
- 데이터를 처리하는 단위
  - 응용 계층 : 메시지, 데이터
  - 표현 계층 : 메시지, 데이터
  - 세션 계층 : 메시지, 데이터
  - 전송 계층 : 세그먼트
  - 네트워크 계층 : 패킷
  - 데이터링크 계층 : 프레임
  - 물리 계층 : 비트

<br>

SQL
---
> 처리 조건
```
  [학생]테이블에서 '학년'이 3학년 이상이 수강하는 '과목' 검색
  검색 결과에서 중복 제거
```
- SELECT DISTINCT 과목 FROM 학생 WHERE 학년>=3;

<BR>

v 모델 테스트 순서
---
#### 1. 단위 테스트
#### 2. 통합 테스트
#### 3. 시스템 테스트
#### 4. 인수 테스트

<BR>

- V 모델
  - 소프트웨어 공학에서 시스템의 검증과 테스트 작업을 강조하기 위해 고안한 모델

<BR>

정규화
---
### 정규화 절차(도부이결다조)
- 비정규화 → 1NF : 모든 *도*메인을 원자값으로

- 1NF → 2NF : 기본키에 속하지 않는 모든 속성이 기본키에 **완전 함수 종속**이 되도록 ***부*분 함수 종속성 제거**

- 2NF → 3NF : ***이*행적 함수 종속 관계** 제거

- 3NF → BCNF : ***결*정자가 후보키가 아닌** 함수 종속성을 제거

- BCNF → 4NF : ***다*치 종속 제거**

- 4NF → 5NF : ***조*인 종속성** 이용

<br>

HRN 스케줄링 기법 - 우선 순위 공식
---
### HRN(Highest Response ration Next)
- **SJF 방식의 단점(긴 작업과 짧은 작업간의 지나친 불평등)을 보완**하는 기법

- P : 우선 순위, S : 서비스 시간, W : 대기 시간
```
  P = (S + W) / S
```

<br>

전송 오류 제어 - ARQ 방식 종류
---
### ARQ(Automatic Repeat reQuest, 자동 반복 요청)
- 통신 경로에서 오류 발생 시 수신 측은 오류의 발생을 송신 측에 통보하고

- 송신 측은 오류가 발생한 프레임을 재전송하는 **오류 제어 방식**

- 종류
  - Go-Back N ARQ
    - 데이터 프레임을 연속적으로 전송하는 과정에서 NAK를 수신하게되면
    - **오류가 발생한 프레임 이후에 전송된 모든 데이터 프레임을 재전송**하는 방식

  - 정지-대기(Stop-and-Wait) ARQ
    - 송신 측은 하나의 블록을 전송한 후 수신측에서 에러의 발생을 점검한 다음 에러 발생 유무 신호(긍정 : ACK, 부정 : NAK)을 보내올 때까지 **기다리는 방식**

  - 연속 ARQ > Go-Back N ARQ
    - 여러 블록을 연속적(Continuous)으로 전송하고 **부정 응답(NAK) 이후 모든 블록은 재전송**

  - 연속 ARQ > Selective-Repeat ARQ(선택적 재전송)
    - 여러 블록을 연속적으로 전송하고 **부정 응답(NAK)이 있던 블록만 재전송**

  - 적응적(Adaptive) ARQ
    - 전송 효율을 최대로 하기 위해서 데이터 블록의 길이를 채널의 상태에 따라 변경하는 방식
      - **동적 블록**(가변적 프레임) → 전송 효율 우수 → 구현 복잡

<br>

Python 언어 특징
---
- 변수 선언 시 **자료형 작성 X**
  - ex) int a = 0 (X) , a = 0 (O)
- **세미콜론(;)을 사용하지 않아도 됨**
- **변수에 연속하여 값을 저장**하는 것이 가능
- **같은 수준의 코드는 반드시 동일한 여백**을 가져야 함
- 코드를 한 줄씩 읽어 내려가며 실행하는 **인터프리터 언어**

 <br>

JAVA 언어 관련 용어
---
- 가비지(Garbage)
  - JAVA에서 힙(HEAP)에 남아있으나 변수가 가지고 있던 참조값을 잃거나 **변수 자체가 없어짐으로써 더이상 사용되지 않는 객체**

- Garbaga Collector(GC, 가비지 컬렉터)
  - **가비지를 모아 주기적으로 제거해주는 역할을 하는 모듈**
  - 메모리 누수 현상 방지 방법 중 하나

<br>

블랙박스, 화이트박스 테스트
---
- 블랙박스(Black Box) 테스트
  - **사용자 요구사항 명세서**를 보면서 테스트
    - **요구사항 명세서**에 기술되어 있는 소프트웨어 기능을 토대로 실시
  - 주로 구현된 기능을 테스트
  - 기능 테스트
    - 각 **기능**별로 적절하 정보 영역을 정하여 적합한 **입력에 대한 출력**의 정확성 점검

- 화이트박스(White Box) 테스트
  - 프로그램의 **내부 로직(수행 경로 구조, 루프 등)**을 보면서 테스트 수행
    - 제품의 **내부** 요소들이 명세서에 따라 수행되고 충분히 실행되는가를 보장하기 위한 검사
  - 구조 테스트
    - 프로그램의 **구조**에 의거하여 테스트

<br>

OSI 7계층
---
### 응용(Application) 계층
- 정보처리를 수행하는 **응용프로그램과의 인터페이스 제공**

- **전자우편**이나 **파일전송**과 같은 **사용자 서비스**를 제공하는 계층

- 네트워크 가상 터미널(network virtual terminal)이 존재하여 서로 상이한 프로토콜에 의해 발생하는 호환성 문제를 해결하는 계층

<br>

SQL : CHECK
---
- **특정 속성의 값을 제한**하기 위해 사용하는 문법
- 도메인이 가질 수 있는 **값의 범위를 제약**하는 제약조건
  - **특정 속성의 입력 가능한 값의 범위를 지정**할 때 사용
    - ex) Age int CHECK (Age>=18)
    - ex) CONSTRAINT SUNG_ck CHECK (SUNG="남" OR SUNG="여")

<br>
