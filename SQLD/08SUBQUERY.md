## SUBQUERY
### 서브쿼리

![SUBQUERY](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/930c9833-7ff0-4eca-8d98-d0c3beed4574)

- SQL문 안에 포함된 SQL문
  - EX) 신장이 가장 큰 선수의 정보 조회
 
![SUBQUERYEX](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/1883df4f-22f5-4ecb-8638-2930dd2ddaae)

![서브쿼리](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/5dd8a884-54e3-4f6b-b395-918775ac6906)

- 서브쿼리는 메인쿼리의 칼럼 모두 사용 가능
- 메인쿼리는 서브쿼리의 칼럼 사용 불가
  - INLINE VIEW에 정의된 칼럼만 사용 가능


---

### 결과 칼럼/행의 수에 따른 구분

![결과 칼럼,행 수에 따른 구분](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/e8335d08-91a5-44f8-a9db-0c7521f5e66a)


#### 단일행 서브쿼리
  - 서브쿼리의 결과 건수가 반드시 1건 이하
  - 단일행 비교 연산자(=, <, <=, >, >=, <>)와 함께 사용
    - 결과가 2건 이상이면 RUN TIME 오류 발생 (문법적으로는 에러X, 실행시켜보니 에러 발생)
   

#### 다중행 서브쿼리
  - 서브쿼리의 결과 건수가 2건 이상일 **가능성**이 있을 때
  - 다중행 비교 연산자와 함께 사용
    - 2건 이상일 가능성은 있지만 결과 건수가 우연히 1개인 경우 -> 단일행 비교 연산자도 에러는 발생하지 않음
   
![다중행서브쿼리](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/7d9bdc2c-9aed-42d3-a583-92e8ec6c3166)



---

## 연관 서브쿼리
### 연관(CORRELATED) 서브쿼리
- 메인 쿼리의 칼럼이 서브쿼리에서 사용된 쿼리
- Q) AVG(SAL)은 SAL의 평균을 구하는 함수. 이 때, 다음은 무엇을 조회하는 질의인가?

![Q](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/ce60f06c-255e-4716-a2b5-32a0b4945052)


```
  ✔ MAIN 에서 EMP M 을 SUB 에 전달
  ✔ SUB 에서 EMP M 과 같은 부서인 EMP S 의 평균 급여를 계산하여 MAIN 에 전달
  ✔ MAIN 에서 EMP M 의 급여와 SUB 에서 전달받은 급여를 비교
```

### 연관 서브쿼리 특징
- 메인쿼리의 칼럼이 서브쿼리에서 사용된 쿼리
  - 비연관 서브쿼리 : 서브쿼리에서 메인쿼리의 칼럼 사용 X

- 메인쿼리가 먼저 수행되고, 그 후에 서브쿼리 수행
  - 테이블의 별칭을 이용하여 메인 쿼리에서 서브쿼리로 정보 전달
  - 서브쿼리가 메인쿼리의 값 이용, 그 후 서브쿼리의 결과를 메인쿼리가 이용

- 서브쿼리에서 메인쿼리의 칼럼과 서브쿼리의 칼럼 간 비교가 이루어짐
  - 메인쿼리에서는 서브쿼리의 칼럼 사용불가


---

## 다중행 서브쿼리
  - EXIST 연산자
    - 조건을 만족하는 값이 존재하는지 여부 확인
    - 조건이 만족되는 1건만 찾으면 더이상 검색X (속도 빠름)
    - 주로 참/거짓의 조건 판단용으로 사용
    - 
![image](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/c2d8bff5-f97f-46b3-9977-fd791c5f20ec)


  - ANY(=SOME) 연산자
    - 결과의 어느 하나의 값이라도 만족하면 되는 조건
    - EX) x > ANY(1,2,3,4,5) 의 경우, x > 1 이면 됨 


---

## 다중칼럼 서브쿼리
### 다중칼럼 서브쿼리
  - 서브쿼리의 결과로 여러 칼럼이 반환
  - EX) PLAYER_ID가 2007188인 선수와 키, 포지션이 같은 선수 조회
    
![image](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/2e38e47c-7195-47f8-8f10-5b9e62bd2458)


### 다중칼럼 다중행 서브쿼리
  - 서브쿼리의 결과로 여러 칼럼이 반환


---

## 스칼라 서브쿼리
### 스칼라 서브쿼리(SVALAR SUBQUERY)
  - 하나의 값을 반환하는 서브쿼리
    - 단일행, 단일칼럼
    - 하나의 값을 반환한다는 점에서 함수(FUNCTION)의 특성을 가짐
    - 공집합을 반환하는 경우 NULL 

  - 칼럼이 올 수 있는 대부분의 곳에서 사용가능
    - SELECT절, WHERE절, 함수인자, ORDER BY절, CASE절, HAVING절 등
   

---

## 뷰(VIEW)
### 뷰
  - 테이블은 실제로 데이터를 가지고 있지만, 뷰는 실제 데이터를 가지고 있지 않음
    - 뷰 정의(VIEW DEFINITION, SQL 텍스트파일)만 갖고있음
    - 쿼리에서 뷰가 사용되면 DBMS 내부적으로 질의 재작성(REWRITE)

  - 실제 데이터를 가지고 있지 않지만 테이블의 역할 수행(동일한 형태로 사용 가능)
    - 가상테이블(VIRTUAL TABLE)

  - CREATE VIEW 문을 통해 VIEW 생성 & 확인 (제거시 DROP VIEW)
![image](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/b6e8c80e-778f-469d-9d0c-7c69ec72ec26)

![image](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/4973c8ab-52d0-447b-a88a-3239c489b522)



### 인라인 뷰(INLINE VIEW)
  - FROM 절에서 사용되는 서브쿼리
  - 실행 순간에만 임시적으로 생성, DB에 저장X
    - 인라인뷰 = 동적뷰(DYNAMIC VIEW)
    - 일반뷰 = 정적뷰(STATIC VIEW)

  - 인라인 뷰의 SELECT문에서 정의된 칼럼은 메일쿼리에서 사용가능
    - CF) 일반적으로 서브쿼리에서 정의된 칼럼은 메인 쿼리에서 사용 불가


