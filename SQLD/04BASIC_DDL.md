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
- ex. constraint fk1 Foreign key(team_id) references team(team_id)
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

![제약조건 지정](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/05724acf-6467-407b-b098-d8526d689b70)

![제약조건 지정2](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/5e2b8912-5239-4bd7-bb80-bac6a33f0bcb)

![제약조건 지정3](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/e1085a2b-a8dc-4e77-ae90-a8798abbc4d6)

![제약조건 확인](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/73c89d4a-6f07-413b-b7aa-e7b05fe1602c)


