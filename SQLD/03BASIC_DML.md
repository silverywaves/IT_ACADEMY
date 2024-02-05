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
  - 관심있는 일부 칼럼에 대해서만 정보를 조회
    
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

<br>

- select *
  - select * from 테이블명;
    - 해당 테이블의 모든 칼럼값 조회

<br>


- select - 별칭 사용
  - 조회 결과에 일종의 별칭(ALIAS)을 부여하여 칼럼 레이블 변경
  - 칼럼명과 별칭 사이에 AS 키워드 사용 (optional)
  - 별칭이 공백, 특수문자 등을 포함하는 경우 큰 따옴표 사용

![select_as](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/56a5f6c9-9fc2-424a-9d34-af11a3c73f8b)


---

#### ORDER BY
- order by
  - 출력시 정렬 기준 설정
  - SQL 문장의 맨 마지막에 위치
  - select 문에 없는 필드도 order by 사용 가능
  - 오름차순 : ASC(생략 가능) / 내림차순 : DESC
    - 참고 : ORACLE에서 NULL은 가장 큰 값으로 취급


![order_by_asc](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/bcfbe08f-d476-4d90-9743-b69abaa22c0d)


![order_by_desc](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/cc9b47eb-0663-46d9-b707-64ccd6bf35cc)


![order_by_Quiz](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/d83bf655-5a43-4e02-b56d-6dc3d2895a27)


---

#### WHERE
- where 절
  - 특정 조건을 만족하는 데이터를 한정하기 위해 사용
  - select ~ from ~ where ~ 형태로 사용

![where](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/099c20f2-600e-4d43-bfc9-c6890261e823)


---

#### 연산자


![where_연산자](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/e406fcc4-590d-4b7f-bcaf-6ae383e5fd35)

![where_연산자2](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/abc69b7f-eafc-4964-95cf-04bd546b8bdb)


![where_연산자_우선순위](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/84e5dcd7-c35a-44af-b0d5-96577c8a7b40)


<br>

##### 산술 연산자
- NUMBER 와 DATE 자료형에 대해 적용
- 연산자는 select 문에도 사용 가능

![산술연산자](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/5ab91a10-fbae-490b-9222-5afc581700bc)



Q. NULL 값에 대한 산술 연산의 결과는?



![산술null](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/c85f367c-6dad-4d12-9db4-10e93d542e21)



<br>

##### 비교 연산자
- 모든 자료형에 대해 적용
- 문자열의 크기 비교는 사전 순으로 수행
  - ex) '01' < '02' < '1' < '11' < '2'
- NULL에는 비교 연산자 사용 불가   


![비교null](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/5030e92a-149a-4956-b01b-f74cb16d115a)


<br>

##### 논리 연산자
- 모든 자료형에 대해 적용
- NOT > AND > OR
- 진리표
 
![진리표](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/847d1f9b-d742-4f18-8845-06e008744db7)


<br>

##### SQL 연산자
- 합성(연결) 연산자 - 문자열과 문자열을 연결함
  - 방법1 함수 : concat(str1, str2) <- 두 개의 인자만 연결 가능
  - 방법2 연산자 : str1 || str2     <- 이항 연산 여러번 가능, 두 개 이상의 인자 연결 가능

![SQL연산자](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/78a5fc05-4365-4566-a42f-d31dbd30420e)

<br>

- BETWEEN
  - 항상 and 와 함께 사용
  - ex) height between 170 and 180

<br>

- NOT BETWEEN
  - BETWEEN 의 반대, or 개념 
  - ex) height < 170 or height > 180 


<br>

- IN


![in](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/d3bf6160-91f0-4f76-a4ee-1b125e427b2b)

<br>

- NOT IN

![not_in](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/edf7a246-0a15-4b35-8d8e-71dccc2e12f4)


<br>

- LIKE
  - 문자열 비교 연산
  - 와일드카드 사용 가능
    - '%' : 임의의 문자 N개
    - '_' : 임의의 문자 1개
      
   
![like1](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/1ed9089b-0371-4e56-9dc8-29901f1bb339)


![like2](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/ed0649dc-58c2-43a6-94a1-c4169aba8253)


<br>
#### 출력 개수 지정
- ROWNUM (TOP N개의 레코드 반환)
  - 사용자가 아닌 시스템이 관리하는 Pseudo Column(= 쓸 수는 있지만 진짜 컬럼은 X)
    - 채번, 출력 개수 지정 등에 활용 가능

  - 여러 행을 반환할 때
    - rownum = 3  // 불가능 => top~n개 추출이라 등호는 1 제외 사용불가
    - rownum <=3  // 가능
    - rownum <4   // 가능
   
  - 한 행만 반환할 때
    - rownum = 1   // 가능 -> 등호 예외적 사용 가능
    - rownum <= 1  // 가능
    - rownum < 2   // 가능

  - 테이블 내의 unique 한 값 설정에도 사용 가능
    - rownum을 이용하여 id 필드 생성
    - update 테이블명 set 칼럼명 = rownum;





