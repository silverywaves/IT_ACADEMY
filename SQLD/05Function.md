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


---


![lower](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/278103f9-7721-4c94-88e9-c9986e73fe46)

- lower : 대문자 -> 소문자


![UPPER](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/956ebe93-06c4-42ae-a1ed-dd6510ab51d5)

- upper : 소문자 -> 대문자

![ASCII](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/c52101c2-f671-4a6b-aa9f-de640bd4ce81)


- ASCII : 문자 -> ASCII 코드
  

![CHR](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/a8b9c506-afc2-4c12-8b96-ba50a17c8ad5)

- chr : ASCII 코드 -> 문자


![concat](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/bf28a42c-421d-4203-8b88-2d5ea196430a)


- concat  : 문자열 연결


![substr](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/0211097f-d33b-46fb-b5d2-06d342b787a6)


- substr : 문자열 m 번째부터 n 번째까지 출력(공백도 카운팅)


![length](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/4ec536a0-8844-4e4a-afa9-7922c8bc61d6)

- length : 문자열 길이(공백도 카운팅)


---







