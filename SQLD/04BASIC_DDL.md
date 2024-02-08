## DDL
### DDL - 테이블 생성
#### 테이블 생성 규칙
- 테이블명
  - 객체를 의미할 수 있는 이름
  - 단수형 **권고**
  - 다른 테이블의 이름과 중복X

- 칼럼명
  - 한 테이블 내에서는 칼럼명 중복X
  - 테이블 생성시 각 칼럼들은 괄호 내에서 콤마로 구분
  - 칼럼 뒤 데이터 유형 지정
 
- 테이블명 & 칼럼명
  - 사전에 정의된 예약어(Reserved word-select, set, where, from 등) 사용 불가
  - 문자, 숫자, 일부 기호(_, $, #)만 허용
  - 반드시 문자로 시작(숫자, 기호 불가)

- 제약조건명
  - 다른 제약조건의 이름과 중복X


---

#### 테이블 생성 SQL문
```
  CREATE TABLE 테이블명 (
    칼럼명  데이터타입 (+ NOT NULL),
          .
          .
          .
    CONSTRAINT  PK, FK 설정 등 제약조건
  );
```


---

### Data Types
#### Oracle 주요 데이터 타입

![oracle데이터타입](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/1bbcb0c3-6a6a-4c2d-82ac-ff531823d03b)



---

### Constraints
#### 제약 조건
- 제약조건명을 명시적으로 부여할수도 있고, 묵시적으로 제약조건명 없이 설정할수도 있음

![제약조건](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/043cb497-173f-4b6a-b09e-b4ee1b8f5393)



---

#### 제약 조건 지정
<div>
create table player1(
  player_id char(7) <span style="color:red">primary key</span>
);
</div>
