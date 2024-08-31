# 데이터 탐색
# 1. 데이터 탐색 기초
데이터 탐색 개요
---
### EDA (탐색적 자료 분석)
- 데이터의 의미를 찾기 위해 **통계, 시각화**를 통해 파악

- EDA의 4가지 주제 (*저잔재현*)

  - ***저*항성의 강조**
 
  - ***잔*차 계산**
 
  - **자료변수의 *재*표현**
 
  - **그래프를 통한 *현*시성**
 
<br>

상관관계 분석
---
### 상관분석
- 두 변수간의 선형적 관계가 존재하는지 파악하는 분석

  - 피어슨 상관분석 : 양적 척도, 연속형 변수, 선형관계 크기 측정
 
  - 스피어만 상관분석 : 서열 척도, 순서형 변수, 선형/**비선형적 관계** 나타냄
 
<br>

기초통계량 추출 및 이해
---
### 기초 통계량
- 평균(기댓값) : 전체 합을 개수로 나눈 값

- 중앙값 : 자료를 크기 순으로 나열했을 때 가운데 값

- 최빈값 : 가장 빈번하게 등장하는 값

- 분산 : 자료들이 퍼져있는 정도

- 표준편차 : 분산의 제곱근 값

- **공분산** : 두 확률변수의 상관정도

  - 공분산 = 0 : 상관이 전혀 없는 상태
 
  - 공분산 > 0 : 양의 상관관계
 
  - 공분산 < 0 : 음의 상관관계
 
  - **최소, 최대값이 없어** 강약 판단 불가
 
- **상관계수**

  - 상관정도를 -1 ~ 1 값으로 표현
 
  - 상관계수 = 1 : 정비례 관계
 
  - 상관계수 = 0 : 상관없음
 
  - 상관계수 = -1 : 반비례 관계
 
<br>

### 기댓값과 분산의 특성
> 서로 독립인 X, Y가 각각 정규분포 N(20, 2²) 와 N(27, 1²) 을 따른다고 할 때, <br>
> 확률 변수 Z = 5X - 7Y + 15 일 경우의 Z의 기댓값과 분산의 계산
```
  1) Z의 기댓값
    : E(Z) = E(5X - 7Y + 15) = 5 * 20 - 7 * 27 +15 = -74

  2) Z의 분산
    : V(Z) = V(5X - 7Y + 15) = V(5X - 7Y) = 25 * 2² + 49 * 1² = 149
```
- V(상수) = 0 으로 취급

<br>

### 첨도와 왜도
- 첨도 : 자료의 분포가 얼마나 뾰족한 지 나타내는 척도

  - 척도 = 0 : 정규 분포 상태
 
    - 3을 기준으로 정규분포 형태를 판단하기도 함
   
  - 값이 클수록 뾰족한 모양
 
- 왜도 : 자료의 분포의 비대칭 정도 (0일 때 대칭)

  - **왜도 < 0 : 최빈값 > 중앙값 > 평균값**
 
  - **왜도 > 0 : 최빈값 < 중앙값 < 평균값**
 
    - *평균값은 꼬리를 따라감*

<br>

|첨도|왜도|
|-|-|
|![스크린샷 2024-08-31 110438](https://github.com/user-attachments/assets/dac4cc08-be4c-4c54-a9c8-892d3c4bfe62)|![스크린샷 2024-08-31 110444](https://github.com/user-attachments/assets/9def0fd4-9bfc-410e-a3e1-7cba44124b30)|

<br>

### Summary 함수 결과의 해석
> 통계 요약 해석
```
          Age        Survived
  Min.    :  0.17    0:266
  1st Qu. : 21.00    1:152
  Median  : 27.00
  Mean    : 30.27
  3rd Qu. : 39.00
  Max.    : 76.00
  NA's    : 86
```
- Age 변수

  - Mean, Median 등 존재 → **수치형 변수**
 
  - 25% 지점 : 21.00, 75% 지정 : 39.00
 
  - Median < Mean → **왜도 > 0**
 
  - 결측치(NA's) 개수 : 86개
 
- Survived 변수

  - 집단의 빈도 수 → **범주형 변수**
 
  - 범주 0과 1이 클래스 불균형 상태
 
    - **0을 다운샘플링 하거나 1을 오버샘플링**

<br>

시각적 데이터 탐색
---
|-|
|-|
|![image](https://github.com/user-attachments/assets/9acce0b4-0bcc-41f6-a801-faa86e9c4a4a)|

<br>

---

<br>

# 2. 고급 데이터 탐색
시공간 데이터 탐색
---
### 시공간 데이터
- 공간적 정보에 시간의 흐름이 결합된 데이터

- 활용 (*패지격*)

  - 시공간 ***패*턴**을 통한 예측
 
  - ***지*도**를 통한 위치정보
 
  - 지리공간의 ***격*자** 차트 결합
 
<br>

다변량 데이터 탐색
---
### 다변량 데이터 탐색방법
- 주성분분석(PCA)

  - 데이터 분포의 분산이 최대가 되는 정보로 차원 축소
 
- 다차원척도법(MDS)

  - 데이터간의 근접성을 시각화하여 데이터간 거리를 보존하여 차원 축소
 
- 로컬선형임베딩(LLE)

  - 데이터들 간의 가까운 이웃에 선형적으로 연관되어 있는지 측정하여 저차원 좌표계 맵핑
 
<br>

비정형 데이터 탐색
---
### 비정형 데이터 분석 방법
- 데이터 마이닝

  - 방대한 데이터 속에서 새로운 규칙, 패턴을 찾고 예측을 수행하는 분야
 
  - 유형 : 인공신경망, 의사결정트리, 회귀분석, 로지스틱회귀, 군집분석, 연관분석 등
 
- 텍스트 마이닝

  - 단어나 문장 속에서 유의미한 인사이트를 찾아내는 분야
 
- 오피니언 마이닝

  - 단어나 문장 속에서 감정, 평판 등을 도출하는 분야
 
<br>



