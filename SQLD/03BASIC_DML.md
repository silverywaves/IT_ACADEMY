### Basic DML
#### SQL (<-SEQUEL) (<-Structured Query Language)
- 관계형 데이터베이스에서 데이터 정의(DDL), 조작(DML), 제어(DCL)를 위해 사용하는 언어 (+ TCL)
  
- 표준 SQL : ISO 의 표준 규격을 따르는 SQL
  
- SQL 기본 작성 규칙
  - 문장 마지막은 세미콜론(;)으로 끝남
    
  - 명령어, 객체명, 변수명은 대/소문자 구분이 없음
    - 데이터 값은 대/소문자를 구분
      
  - 날짜와 문자열에는 작은 따옴표 사용
    
  - 단어와 단어 사이는 공백 또는 줄바꿈으로 구분
    
  - 주석문
    - -- 주석
    - /* 여기서부터
          여기까지 주석 */


#### SQL 구문 유형

![SQL구문유형](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/e656d1d1-6556-4f7f-b88a-64980a968701)


---

#### SELECT
- select
  - 테이블에 존재하는 레코드의 값을 조회
    
  - select[all/distinct] 칼럼1, 칼럼2, ... from 테이블명
    - all : 중복 데이터 모두 출력(default)
      
    - distinct : 중복 데이터를 1건으로 출력(select distinct ~)
      - distinct 키워드는 첫 칼럼의 앞에 위치
      - 칼럼의 조합에 대해 중복 체크
      - NULL 값도 하나의 값으로 간주

![select](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/64eaf37d-90a6-46ff-af82-da09a0db4bc3)



![select_all](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/c997aae7-ab6f-4335-b63b-d58aa87a68a9)


![select_distinct](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/9dc01001-30d3-43d0-9705-58e93c52f4b2)

![select_distinct2](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/68849933-516b-4b81-a9db-ab31ae4a0970)

---

#### 



