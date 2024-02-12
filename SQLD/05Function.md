## Function
### Function
#### 함수의 유형
특정한 기능을 수행하는 단위

- 생성 주체
  - 사용자 정의 함수(User Defined Function) : 사용자가 정의
  - **내장 함수**(Built-in Function) : 벤더가 정의

    
- 적용 범위
  - **단일 행 함수**(Single-Row Function)
    - 문자형 함수, 숫자형 함수, 날짜형 함수
    - 제어 함수, 변환 함수, NULL 관련 함수
 
  - 다중 행 함수(Multi-Row Function)
    - 그룹 함수(Group Function)
      - 집계 함수(Aggregate Function) 포함
    - 윈도우 함수(Window Function)


---

#### 단일행 함수의 특징
- 각 행(Row)에 대해 개별적으로 작용, 그 결과 반환
  - 단일 행 내에 있는 하나 또는 복수의 값을 인수로 사용
  - 여러 행에 걸친 값 사용 불가

- 함수 중첩(함수의 인자로 함수를 사용) 가능

- SELECT, WHEREM ORDER BY 절에 사용 가능

![단일행함수특지](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/4d8f74e6-5739-4822-aeab-420634772b9b)



---

#### Oracle의 단일행 내장 함수

![오라클내장함수](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/2f352ee3-7ee9-4568-8195-6d629c3f945b)


---

#### ASCII 코드표

![ASCII코드표](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/dd906ba3-238d-490c-8c65-9cfeed6b66af)


---

#### 문자형 함수

![문자형함수](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/9c501bd2-ef00-4df5-9b51-ba40569e2c44)


![문자형함수2](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/d6555a44-f773-44be-8239-3586c6d1730f)


![substr연습문제](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/c75c4335-0315-44bd-9ead-7f4f2fad2747)


---

- lower : 대문자 -> 소문자

![lower](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/278103f9-7721-4c94-88e9-c9986e73fe46)


- upper : 소문자 -> 대문자

![UPPER](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/956ebe93-06c4-42ae-a1ed-dd6510ab51d5)


- ASCII : 문자 -> ASCII 코드

![ASCII](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/c52101c2-f671-4a6b-aa9f-de640bd4ce81)


- chr : ASCII 코드 -> 문자  

![CHR](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/a8b9c506-afc2-4c12-8b96-ba50a17c8ad5)


- concat  : 문자열 연결

![concat](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/bf28a42c-421d-4203-8b88-2d5ea196430a)


- substr : 문자열 m 번째부터 n 번째까지 출력(공백도 카운팅)


![substr](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/0211097f-d33b-46fb-b5d2-06d342b787a6)


- length : 문자열 길이(공백도 카운팅)


![length](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/4ec536a0-8844-4e4a-afa9-7922c8bc61d6)


- ltrim : 문자열의 왼쪽부터 시작해서 다른 문자를 만나기 전까지 지정 문자를 제거
  - 지정 문자가 생략되면 공백값이 디폴트
 
![LTRIM](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/34df065c-9877-495e-b7b0-92d16f38e152)

- rtrim : 문자열의 오른쪽부터 시작해서 다른 문자를 만나기 전까지 지정 문자를 제거
  - 지정 문자가 생략되면 공백값이 디폴트

![RTRIM](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/6f09501b-7938-4b00-9673-6eb4ef6306b7)


- trim : 문자열의 양쪽에서 시작해서 다른 문자를 만나기 전까지 지정 문자를 제거
  - 지정 문자와 FROM이 생략되면 공백 값이 디폴트
 
![TRIM](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/1783161b-1f89-4836-a060-410a22aa33e3)


---

#### 숫자형 함수

![숫자형함수](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/8285f73e-6087-457f-83cc-729ea73205b5)


---

- ABS : 숫자의 절대값 리턴

![ABS](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/3c235ee7-d1b9-4a17-ab6b-8d3436aa4dd9)


- SIGN : 숫자가 양수(1)인지, 음수(-1)인지, 0(0)인지 구분

![SIGN](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/9074d4b5-14c0-4f59-8bf1-36204d2e11a2)


- MOD : 숫자1을 숫자2로 나누었을 때 나머지 값
  - % 연산자로도 대체 가능

![MOD](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/0952f242-b46e-4eb6-b386-d5dd251c6f30)


- CEIL : 숫자보다 크거나 같은 최소 정수 리턴

![CEIL](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/85b8994f-52ce-445e-a69f-a6642e04d0d0)


- FLOOR : 숫자보다 작거나 같은 최대 정수 리턴

![FLOOR](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/3536f38c-2d8a-444e-a7f3-4a6eeaad2453)


- ROUND : 숫자를 소수점 m 자리에서 반올림하여 리턴 (m 생략시 디폴트값 0)

![ROUND](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/2d55662e-c949-4e24-9c8c-4ad7224a2b01)


 - TRUNC : 숫자를 소수점 m 자리에서 잘라서 버림 (m 생략시 디폴트값 0)
   - SQL server 에서는 TRUNC 함수 미제공

![TRUNC](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/9cc3bec2-bca0-4556-9f1e-7d410220a6ac)

- SIN, COS, TAN... : 숫자의 삼각함수 값 리턴

- EXP, POWER, SQRT, LOG, LN : 숫자의 지수, 거듭제곱, 제곱근, 자연로그 값 리턴


---

#### 반환형 함수
- 데이터 타입 변환
  - 명시적(Explicit) 데이터 타입 변환
    - 함수를 사용하여 명시적으로 데이터 타입을 변환
 
  - 암시적(Implicit) 데이터 타입 변환
    - 시스템이 자동으로 데이터 타입 변환
      - ex. MOD(PLAYER_ID, 4) -> 문자열을 숫자로 변환
    - 성능 저하 및 에러 발생의 가능성 존재


![명시적암시적!](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/df8f727d-c007-47ff-ad16-939b69fb63c9)


![반환형 함수](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/332c6e82-24aa-4165-8ced-3cbc2aed9110)


---

- TO_CHAR : 숫자나 날짜를 **문자열로** 변환

![TO_CHAR](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/ffb088e6-b36f-4ca5-a612-ab2fe5737106)


- TO_NUMBER : 문자열을 **숫자로** 변환

![TO_NUMBER](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/a5727cdb-be93-466b-b054-29f6fd48bafb)



- TO_DATE : 문자열을 **날짜로** 변환

![TO_DATE-ERROR](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/91d922bf-1a5d-4567-ad67-440cf2d63143)

![TO_DATE](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/d3377ac9-78be-42ef-b5cb-f0d8f3de4795)


---

#### 날짜형 함수

![날짜형함수](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/a4d5d4e2-fb96-4267-8af4-ec1455ca5ce2)


![날짜형함수예제](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/311e0b25-24f5-40a4-8f3e-7e1c0a67960f)


---

- SYSDATE : 현재 날짜와 시각

![SYSDATE1](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/69bc5240-c2d4-4c87-8c38-d560f5000373)

![SYSDATE2](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/17ffb62a-f725-490d-bba8-066c5e8d4c0f)


- EXTRACT : 날짜 데이터에서 년/월/일 정보 추출

![EXTRACT1](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/19497ad7-0d77-43fd-8d61-aa12268f9771)


![EXTRACT2](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/4fbc2a41-adbc-4914-80a1-38b69af1ecfb)


- TRUNC : 날짜 데이터에서 시/분/초를 잘라냄

![TRUNC1](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/179af70c-38ee-4983-a69d-1856abbfa787)


---

#### CASE EXPRESSION
- 표현식이지만 함수의 성격을 갖고 있음
- IF ~ THEN ~ ELSE 논리 흐름

![case](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/f8b768c0-006e-4c11-ac2a-743377530bc8)


![CASEEXPRESSION](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/94aa9059-b636-4d62-ad7c-14f09064687e)


** 동등(=) 이외의 조건은 SIMPLE CASE EXPRESSION 또는 DECODE 함수로 표현 불가


- CASE 표현식의 중첩


![CASE 중첩](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/c2ac2e58-d57d-4598-8a42-b0a852f825da)


- DECODE
  - Oracle 에서만 사용되는 함수
  - DECODE(표현식, 기준값1, 출력값1, 기준값2, 출력값2, ..., 디폴트값)
  - 표현식의 값이 기준값1이면 값1 출력, 기준값2이면 값2 출력
  - 기준값이 없으면 디폴트 값 출력
    
![DECODE](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/b02b007e-cd67-4860-abeb-d244b6f875a3)


---

#### NULL
- 비어있는 값
- 공백(space), 0 과는 다른 의미
- NULL 을 포함하는 모든 산술 연산의 결과는 NULL
  - NULL+0, NULL-1, NULL*0, NULL/0 -> NULL
- NULL 과 공집합도 역시 다른 의미

![NULL1](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/2a7b00d3-65c0-487d-9716-92cccc3de4d1)

** 결과가 NULL

![NULL2](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/73077160-5300-4b0e-bff9-bf69e90b6530)


** 결과가 NULL 이 아니라 공집합


---

#### NULL 관련 함수


![NULL함수](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/2a64fc10-b397-43c0-b390-b82d33d7faf9)

![NVL](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/a41d7989-7a63-40d3-8345-c300ffb57d37)

- NVL
  - 표현식의 값이 NULL 이면 대체값, NULL이 아니면 표현식의 값 반환
  - 표현식의 값과 대체값의 데이터 타입이 같아야 함


![NULLJF](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/2d1f4cdd-671a-4297-9307-2500a82a771a)


- NULLIF
  - 두 식이 같으면 NULL, 같지 않으면 표현식1 값 반환

![COALESCE](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/2eb65e3b-629d-48b4-8687-0545f6e8a168)


- COALESCE
  - 임의의 개수의 표현식에서 NULL 이 아닌 최초의 표현식 반환
  - 모든 표현식이 NULL이라면 NULL 반환



