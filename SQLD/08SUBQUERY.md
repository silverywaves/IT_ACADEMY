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




























