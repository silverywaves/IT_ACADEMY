## TCL(Transaction Control Language)
### 트랜잭션
- 데이터베이스의 논리적 연산 단위
  - 의미적으로 분할할 수 없는 최소의 단위
  - 일반적으로 하나의 트랜잭션은 여러 SQL 문장 포함
  - 성공시 모든 연산을 반영, 취소시 모든 연산을 취소 -> ALL or NOTHING


- 트랜잭션 예
  - 도서 주문
    - 재고 수량 감소, 주문 내역 상세, 결제, 포인트 적립

  - 계좌 이체
    - 원 계좌의 잔액 감소, 다른 계좌의 잔액 증가

  - 교통카드 충전
    - 잔액 증가, 결제


---

### 트랜잭션의 특성(ACID 특성)
#### 원자성(Atomicity)
  - 트랜잭션에서 정의된 연산들은 모두 성공적으로 실행되거나 아니면 전혀 실행되지 않은 상태 (all or nothing)


#### 일관성(Consistency)
  - 트랜잭션이 실행되기 전의 데이터베이스 내용이 잘못되어 있지 않다면, 트랜잭션
 실행 이후에도 데이터베이스의 내용에 잘못이 있으면 X


#### 고립성(Isolation)
  - 트랜잭션이 실행되는 도중에 다른 트랜잭션의 영향 X


#### 지속성, 영속성(Durability)
  - 트랜잭션이 성공적으로 수행되면 그 트랜잭션이 갱신한 데이터베이스의 내용은 다른 트랜잭션이 수행되지 않는 한 영구적으로 저장

```
💌 트랜잭션의 ACID 특성을 보장하기 위해 DBMS는 동시성 제어(Concurrency Control) 수행
  - Lock 기반
  - Timestamp 기반
```


---

### TCL
#### COMMIT 실행 전 상태
  - 변경된 내용은 메모리에 임시로 저장됨
  - 현재 사용자는 증가한 height 값 읽을 수 있음
  - 다른 사용자는 증가 전 height 값만 읽을 수 있음
  - height에는 잠금(Locking)이 설정되어 다른 사용자는 값 변경 불가


#### COMMIT 실행 후
  - 변경된 내용은 DB에 저장
  - 변경 내용을 모든 다른 사용자가 볼 수 있음
  - 이전 데이터는 모두 사라짐(별도 로그 보관시 복구 가능)
  - 관련된 행에 대한 잠금이 해제되어 모든 사용자가 변경 가능


#### 트랜잭션을 제어하기 위한 명령어
  - COMMIT
    - 변경된 내용을 DB 에 영구적으로 반영

  - ROLLBACK
    - 기본 - 변경된 내용을 버리고 변경 전 상태(마지막 COMMIT)로 복귀
    - SAVEPOINT를 지정한 경우, 지정한 저장점까지만 복귀
      - SAVEPOINT : 부분 복귀를 위해 지정한 저장점


#### 트랜잭션은 SQL문 실행시 자동 시작, COMMIT/ROLLBACK 실행시 종료


#### 자동 커밋 / 자동 롤백
  - DDL 문장 수행시 DDL 수행 전에 자동으로 커밋 (auto commit)
  - DB를 정상적으로 접속 종료하면 자동 커밋
  - 애플리케이션의 이상 종료로 DB와의 접속이 단절되었을 때 자동 롤백


---

### ROLLBACK
#### ROLLBACK 이후의 데이터 상태
  - 변경한 내용이 모두 취소됨
  - 이전 데이터가 다시 재저장됨
  - 관련된 행에 대한 잠금이 해제되어 모든 사용자가 변경 가능

![ROLLBACK](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/18984dcf-5bcc-49c6-967f-b1c5dc3ada33)



#### SAVEPOINT
  - 미리 지정한 SAVEPOINT까지만 ROLLBACK
    - **특정 저장점까지 롤백하면 그 이후의 명령과 저장점은 모두 무효처리**
  - 일부 tool에서는 지원 X
  - 동일 이름으로 여러 저장점 정의시 나중에 정의한 저장점만 유효


---

## DCL(Data Control Language)
### DCL
- 사용자의 계정 생성, 삭제, 권한 부여/회수에 대한 명령어

![DCL](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/7623acd2-f6e0-4a15-8a1e-216d20fa64be)


#### SESSION 생성 권한
  - 로그인을 위해 CREATE SESSION 권한 필요
    - GRANT CREATE SESSION TO 계정명;


#### Object 권한
  - 테이블 생성을 위해 CREATE TABLE 권한 필요
    - GRANT CREATE TABLE TO 계정명;
  - 다른 Object 권한
    - GRANT 권한 ON 소유계정.테이블명 TO 계정명;
   
```
  📌 EX
  - 관리자 계정으로 접속한 상태일 때  : GRANT SELECT ON masmis.PLAYER TO mis1;
  - masmis 계정으로 접속한 상태일 때  : GRANT SELECT ON PLAYER TO mis1;

  - mis1 계정에서 masmis 계정의 PLAYER 테이블 조회    : SELECT * FROM masmis.PLAYER;
  - masmis 계정에서 자신의 계정의 PLAYER 테이블 조회   : SELECT * FROM PLAYER;
```


#### 객체별 권한의 종류

![객체별 권한의 종류](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/7ed6ae9f-e47f-443c-bb79-1bd3616fb7fd)




---

### ROLE 을 이용한 권한 부여
  - ROLE : 권한들의 Package
  - 일반적으로 사용자 생성시 CONNECT와 RESOURCE를 통해 기본 권한을 부여함
  - 계정 생성과 권한 확인
    
![role](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/1dbb76a8-1b20-4ac4-8ddf-35bcbdd00831)

    

