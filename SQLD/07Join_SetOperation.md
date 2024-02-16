## JOIN
### E.F.CODD의 연산자
🌠 SQL의 많은 기능이 RDB이론을 수립한 E.F.Codd 박사의 논문에서 소개됨

- 4개의 일반집합연산자 + 4개의 순수관계연산자
- 일반집합연산자의 SQL 구현
  - UNION -> UNION / UNION ALL (공통집합의 중복 허용)
  - INTERSECTION -> INTERSECT
  - DIFFERENCE -> MINUS(Oracle) / EXCEPT(MS-SQL)
  - PRODUCT -> CROSS JOIN

![E F Codd](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/eef54357-e0c5-4a6a-ab01-1fc380f052e9)


- 순수관계연산자의 SQL 구현
  - SELECT(행을 선택) -> WHERE 절
  - PROJECT(열을 선택) -> SELECT 절
  - JOIN -> 매우 다양한 JOIN으로 구현
  - DIVIDE -> 현재 사용 X

![순수연산자의sql구현](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/369f334e-0b7d-411e-845c-2a64e2192d6e)


---

### 정규화와 JOIN
#### 정규화
  - 이상현상(Anomaly) 발생을 피하기 위해 테이블을 분할
  - 학계/실무에서 주로 3NF(3차 정규형) 사용


#### JOIN
  - 데이터의 통합 조회를 위해 여러 테이블들을 연결
  - 실제 JOIN 연산은 두 개의 테이블에 대해서만 적용
    - 조인을 연속적으로 사용함으로서 여러개의 테이블을 조인 가능
  - 일반적인 경우 PK/FK 연관에 의해 JOIN 성립
    - 그 외에도 논리적인 값들의 연관성만으로 JOIN 성립 가능


#### JOIN 적용 예

![JOIN예](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/591ee646-aa38-4544-827c-427521b347a0)



#### JOIN 유형 (기준이 다름)
  - EQUI JOIN / NON-EQUI JOIN
  - 암시적 조인 / 명시적 조인
  - INNER JOIN / OUTER JOIN / CROSS JOIN / SELF JOIN


---

## EQUI JOIN
### EQUI JOIN(동등 조인)
  - 조인 조건으로 Equal(=) 연산 사용
  - 중복 칼럼의 경우, 칼럼명 앞에 테이블명을 붙여야 함
    - 중복되지 않는 칼럼도 칼럼명 앞에 테이블명을 붙이는 것을 권장
      - 테이블명이 긴 경우 ALIAS(별칭) 사용
      - FROM 절에서 ALIAS 정의 후에는 WHERE/SELECT절에서 테이블명 사용 불가(ALIAS만 사용 가능)
  - 셋 이상 테이블의 조인은 실제로는 두 테이블 간 조인이 연쇄적으로 일어나는 것

![EQUI JOIN](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/80a0f652-8301-412f-860b-998407426404)


### NON EQUI JOIN
  - 조인 조건으로 Equal(=) 이외의 연산 사용
    - BETWEEN, >, >=, <, <= 등
    - EX) 사원별 급여 등급 조회


---

## INNER JOIN
### INNER JOIN(내부 조인)
  - 서로 대응되는 내용만 검색하는 조인
    - 조건절 필수 사용
      - 왼쪽테이블 컬럼과 오른쪽테이블 컬럼의 교집합
      - 조건 맞지 않은 것들은 무시

  - 조인의 DEFAULT 이므로 'INNER' 생략 가능
    - INNER JOIN = JOIN
   
  - 조인 조건과 일반 조건이 혼용되어 가독성 떨어짐
    -> 명시적 조인(=표준 조인)의 필요성

  - 명시적 조인에서는 조인 관련 조건은 ON 절에, 그 외의 조건은 WHERE 절에 기술

  - 대부분의 DBMS는 명시적 조인을 표준으로 채택하지만, 기존의 암시적 조인도 허용

![INNER JOIN](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/d209bc28-5cce-432a-8810-8800699cb48d)


---

## NATURAL JOIN
### NATURAL JOIN
  - INNER JOIN의 특수한 경우
    - NATURAL INNER JOIN - NATURAL JOIN

  - 두 테이블 간 동일한 이름을 갖는 모든 칼럼들에 대해 EQUI JOIN 수행
    - 칼럼 간 데이터 타입도 동일해야 함
    - 별도의 조인 칼럼 및 조건 지정 불가

  - 조인의 대상이 되는 칼럼에는 접두사(테이블명 또는 ALIAS) 사용 불가


---

### ON 조건절
#### 암시적 JOIN
  - 모든 조건을 WHERE 절에 기술


#### 명시적 JOIN
  - JOIN 기준 조건은 ON절에 기술
    - ON절의 괄호는 생략 가능

  - JOIN과 무관한 일반 조건은 WHERE절에 기술


---

### USING 조건절
  - ON 절의 "=" 연산자 대신 USING절 사용 가능
    - ON절에서는 괄호 생략 가능 USING에서는 괄호 생략 불가

  - 접두사(테이블명 또는 ALIAS) 사용 불가

![ON USING](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/a0c49032-1b68-451e-946d-bb2e8adcb05a)



---

### ON, USING 조건 기술 비교
- USING절과 NATURAL JOIN은 동일하게 사용 가능
  - 여러 컬럼이 중복되는 경우
    - 중복 컬럼 전체에 대해 EQUI JOIN 적용시 => NATURAL JOIN 사용
    - 컬럼 중 일부에 대해서만 EQUI JOIN 적용시 => NATURAL JOIN 사용 불가 => 자세히 풀어서 쓰려면 ON절, 축약해서 쓰려면 USING 사용


---

## OUTER JOIN
### OUTER JOIN(외부 조인)
  - 서로 대응되지 않는 행도 출력하는 조인
  - 조건절 필수 사용
  - 성능 저하의 원인 -> 꼭 필요한 경우만 사용

![OUTER JOIN](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/9023dfee-845a-47ad-9b34-095ac3169bb3)



#### LEFT OUTER JOIN
  - 왼쪽 테이블의 데이터를 모두 읽은 후, 오른쪽 테이블에서 JOIN 데이터 가져옴
  - 오른쪽 테이블이 JOIN 조건에 해당되지 않는 경우, 해당 칼럼은 NULL


#### RIGHT OUTER JOIN
  - 오른쪽 테이블의 데이터를 모두 읽은 후, 왼쪽 테이블에서 JOIN 데이터 가져옴
  - 왼쪽 테이블이 JOIN 조건에 해당되지 않는 경우, 해당 칼럼은 NULL


#### FULL OUTER JOIN
  - 양쪽 테이블의 데이터를 모두 읽은 후, 상대 테이블에서 JOIN 데이터를 가져옴
  - JOIN 조건에 해당되지 않는 경우, 해당 칼럼은 NULL
  - RIGHT OUTER JOIN과 LEFT OUTER JOIN의 합집합과 동일 (중복 제거 후)
    - UNION ALL 이 아닌 UNION 과 동일

![FULL OUTER JOIN](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/7b0a3bca-9674-4c87-82ff-195b1d033f3d)



---

## CROSS JOIN
### CROSS JOIN(교차 조인)
   - 두 테이블의 곱집합(Cartesian Product)을 출력하는 조인
   - 별도의 조인 조건 X


---

## JOIN 결과 비교
- 다음 5가지 JOIN 으로 생성되는 각 결과의 레코드 수 확인하기

![JOIN결과](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/7130bafe-e4eb-4e7e-8a8f-dce3d347e4b0)


#### 📌 INNER JOIN

![JOIN결과 INNER](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/5f2abec3-e8fe-4416-9763-43c67a91ac1d)


#### 📌 CROSS JOIN

![JOIN결과 CROSS](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/0d4a9b0b-5258-47c7-a7d1-e17f82f85d1e)


#### 📌 LEFT OUTER JOIN

![JOIN결과 LEFT](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/0d10d586-1ad4-4c9f-88f6-4c3d774dd1d6)


#### 📌 RIGHT OUTER JOIN

![JOIN결과 RIGHT](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/e2e3a296-7402-43aa-b045-542bbfd7fe6c)


#### 📌 FULL OUTER JOIN

![JOIN결과 FULL](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/7c68d35d-0f3e-44c3-a51c-17a7a237313f)



---

## SELF JOIN
### SELF JOIN(셀프 조인)
  - 동일 테이블 사이의 조인
    - FROM절에 동일 테이블이 두번 이상 나타남

  - 테이블 식별을 위해 반드시 별칭(ALIAS) 사용
    - 동일한 테이블을 **개념적으로** 서로 다른 두개의 테이블로 사용
    - EX) FROM EMP E  INNER JOIN  EMP M

![SELF JOIN](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/028c1089-c272-4988-9f29-cde8ab06f2bc)


✔ Q. EMP 테이블 -> 사원의 사번&이름, 매니저의 사번&이름 출력 (매니저 없는 사원 정보도 출력)

    ❗ LEFT OUTER JOIN 사용해야 함!

![QUIZ SELF JOIN](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/83cade0e-bc34-4815-a2c1-1f2e66f2a57b)




---

## 계층형 질의
### 계층형 데이터
  - 동일 테이블에 계층적으로 상위와 하위 데이터가 포함된 데이터
  - 엔터티가 순환관계 모델로 설계된 경우 발생
  - 계층형 질의(HIERARCHICAL QUERY)를 통해 접근 가능


---

### 계층형 질의의 방향

![계층형질의](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/5bfabb35-503d-4161-81b7-47bcd61bc975)



---

### 계층형 질의의 구조
#### START WITH : 시작 조건 지정
  - EX) START WITH MGR IS NULL
  - EX) START WITH EMPNO = 'D'


#### CONNECT BY : 다음에 전개될 방향 지정
  - (순방향) PRIOR 자식 = 부모
    - CONNECT BY PRIOR EMPNO = MGR

  - (역방향) PRIOR 부모 = 자식
    - EX) CONNECT BY PRIOR MGR = EMPNO

![계층형 질의 구조](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/09085dfc-d4f6-431a-8ac0-7e51c5d540b5)



#### 순방향 계층형 질의 예


![순방향계층형질의 예1](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/c3c66282-361c-4556-908e-6c38f62e76a0)



![순방향계층형질의 예2](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/0d803f2c-8520-4c4f-bbee-c4cc2786598f)




#### 역방향 계층형 질의 예


![역방향계층형질의 예1](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/3d7e97f5-dea6-42f4-8fa9-2cc5ec754512)


---

## 집합 연산자
### 집합 연산자 개요
  - 여러 질의(SELECT 문) 결과를 하나로 결합하기 위해 사용
  - 집합 연산의 대상이 되는 두 질의
    - SELECT 절의 칼럼수 동일
    - SELECT 절 동일 위치에 존재하는 칼럼의 데이터 타입이 상호 호환 가능
      - 반드시 동일한 데이터 타입일 필요는 X
     
![집합연산자개요](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/b91ee699-4762-42e3-9dbe-0111e2860c29)


---

### 집합 연산 예

![집합연산예](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/9b794005-887a-4c06-b7f3-5301cd2da841)



---

### 집합 연산 질의 예
  - 집합 연산은 둘 이상의 SELECT 문을 결합하는 것
  - ORDER BY 는 집합 연산을 적용한 최종 결과에 대한 정렬
    - 맨 마지막 줄에 한번만 기술
   

---

### UNION ALL

![UNIONALL](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/312d1e97-ca5b-42fc-b33e-7eb3ee92e260)

- 이질적 성격의 데이터를 한꺼번에 출력하는 연산도 가능
  - 'P' 와 'T'는 상수값

![UNIONALL2](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/526a0551-b421-4cf0-8b8c-cb117693962c)


- 출력 칼럼의 칼럼명은 첫 SELECT 문의 칼럼명 적용
  - ORDER BY 구분코드, POSITION -> ERROR!
 

---

### INTERSECT

![INTERSECT](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/6fa7eeba-80ee-49cf-9488-ed13ba9f8acc)

- INTERSECT 연산자는 IN 서브쿼리, EXISTS 서브쿼리로도 표현 가능
  -> 서브쿼리 챕터에서 추가 정리 예정


---

### MINUS

![MINUS](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/0716879e-cd58-4960-b411-0f6a783adfd6)


---

### 집합 연산과 ALIAS

![ALIAS1](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/b7555226-be7d-475f-aa11-448279b3cb87)

![ALIAS2](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/21ea9a02-21a1-441d-b9d0-1b1fcdca7f47)

