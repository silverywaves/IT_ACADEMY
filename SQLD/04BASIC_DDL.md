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

#### FK 제약 조건 옵션
- ex. constraint fk1 Foreign key(team_id) references team(team_id)  <br>
      **on delete cascade on update restrict;**

- referential triggered action
  - on update, on delete
 
- referential action
  - restrict(default) : 기본값의 삭제 또는 갱신 불허
  - no action : restrict 와 동일하게 동작
  - cascade
    - 기본키가 삭제되면 해당 값을 외래키로 갖는 레코드도 삭제
    - 기본키가 갱신되면 이를 참조하는 외래키를 새로운 값으로 업데이트
  - set null
    - 기본키가 삭제 또는 갱신되면 이를 참조하는 외래키를 null 로 업데이트


---

#### 제약 조건 지정
- 제약 조건은 not null 만 복제O
  - pk, fk, unique, check 등은 수동으로 추가

![제약조건 지정](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/05724acf-6467-407b-b098-d8526d689b70)

![제약조건 지정2](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/5e2b8912-5239-4bd7-bb80-bac6a33f0bcb)

![제약조건 지정3](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/e1085a2b-a8dc-4e77-ae90-a8798abbc4d6)

![제약조건 확인](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/73c89d4a-6f07-413b-b7aa-e7b05fe1602c)


---

### DDL - 테이블 변경
#### alter 문을 통한 테이블 변경
- 칼럼의 추가/삭제/수정, 제약조건의 추가/삭제
  - 칼럼의 추가(ADD)
    - 새로 추가한 칼럼은 테이블의 맨 마지막에 추가됨
    - ALTER TABLE 테이블명 ADD (칼럼명/데이터유형);
  
  - 칼럼의 삭제(DROP COLUMN)
    - 삭제 후 최소 하나 이상의 칼럼이 테이블에 존재해야 함
    - ALTER TABLE 테이블명 DROP COLUMN 칼럼명;

  - 칼럼명 변경(RENAME COLUMN)
    - 해당 칼럼의 모든 정의가 그대로 유지됨
    - ALTER TABLE 테이블명 RENAME COLUMN 기존칼럼명 TO 새칼럼명

  - 칼럼의 정의 수정(MODIFY)
    - **이미 입력되어있는 값에 영향을 미치는 변경은 허용X**
    - 데이터 타입 변경
      - 테이블에 아무 행도 없거나, 해당 칼럼이 NULL만 갖고 있을 때 가능
    - 칼럼의 크기 변경
      - 칼럼의 크기 확대 -> 항상 가능
      - 칼럼의 크기 축소 -> 테이블에 아무 행도 없거나 해당 칼럼이 NULL만 갖고 있거나, 현재 저장된 값을 수용할 수 있는 크기로의 축소만 가능
    - DEFAULT 값 추가 및 수정
      - 추가 및 수정 이후 삽입되는 행에만 영향을 미침
     
        
    - NOT NULL 제약조건 추가
      - 테이블에 아무 행도 없거나, 해당 칼럼에 NULL이 없을 때 가능
    - NOT NULL 제약조건 삭제 -> 항상 가능
    - NOT NULL 제약조건 추가 / 삭제
      - ALTER TABLE 테이블명 MODIFY (속성명 NOT NULL / NULL)
     
![제약조건변경1](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/6c0e9515-3998-4a65-ba09-e3beb047b202)

![제약조건변경12](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/3414c78a-3cb9-4fc4-8b26-d7d77f501b8d)



  - 제약 조건의 추가/삭제(ADD/DROP CONSTRAINT)
    - 테이블 생성 이후에도 제약 조건 추가/삭제 가능
      
![제약조건 추가삭제](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/8f28bd28-1575-4330-9e60-986cf02daa1c)


---

#### RENAME 문을 통한 테이블 명칭 변경
- RENAME 기존테이블명 TO 새테이블명;


---

### DDL - 테이블 삭제
#### DROP 문을 통한 테이블 삭제
- DROP TABLE 테이블명 제약조건;


