# 분석모형 평가 및 개선
# 1. 분석모형 평가
평가 지표
---
### 분류모델 평가지표
- (1) 혼동행렬 (오분류표)

|예측\실제|TRUE|FALSE|
|:-:|:-:|:-:|
|TRUE|TRUE<br>POSITIVE<BR>(TP)|FALSE<BR>POSITIVE<BR>(FP)|
|FALSE|FALSE<BR>NEGATIVE<BR>(FN)|TRUE<BR>NEGATIVE<BR>(TN)|

#### 💡 예측과 실제가 같으면 TRUE, 예측이 TRUE 면 POSITIVE

<BR>

- (2) 평가지표

|지표|계산식|
|:-:|:-:|
|정밀도(Precision)|TP / TP+FP|
|재현율(Recall)|TP / TP+FN|
|특이도(Specificity)|TN / FP+TN|
|정확도(Accuracy)|TP+TN / TP+FP+FN+TN|
|FP Rate<br>(False Alarm Rate)|FP / FP+TN|
|F-1 Score|2 * ( (Precision * recall) / (Precision + recall) )|
|F-β Score|(1 + β²) * ( (Precision * recall) / (β² * Precision + recall) )|

```
  - 재현율(Reacll)은 민감도(Sensitivity), TP Rate, Hit Rate 라고도 함
  
  - F-1 Score 는 Precision 과 Recall 의 조화평균
  
  - Precision 과 Recall 은 Trade-Off 관계  
```

- (3) ROC 커브

  - **가로축을 1-특이도(FPR), 세로축을 민감도(TPR)**로 두어 시각화한 그래프
 
  - 그래프 면적이 클수록(1에 가까울수록) 모델의 성능이 좋다고 평가
 
- (4) 이익도표(Lift chart)

  - 임의로 나눈 각 등급별로 **반응검출율, 반응률, 리프트** 등의 정보를 산출하여 나타내는 도표
 
  - **향상도 곡선** : 이익도표를 시각화한 곡선
 
<br>

### 회귀모델 평가지표
- 손실함수(비용함수)

  - MSE (Mean Squared Error) = 1/n∑(y-ŷ)²
 
  - MAE (Mean Absolute Error) = 1/n∑|y-ŷ|
 
  - RMSE : MSE 에 제곱근
 
- 결정계수(R Square)

  - 결정계수(R-Square) = SSR/SST = 1 - SSE/SST
 
  - Adjusted R-Square = 1 - (n-1) * MSE/SST
 
<br>

### 군집분석의 평가지표
- 실루엣 계수

|-|
|-|
|![image](https://github.com/user-attachments/assets/799ad749-8b92-485f-bf6b-f246d9cfa023)|

```
  - a(ἱ) : i번째 데이터에서 자신이 속한 군집 내 다른 데이터 포인트들과의 평균 거리
 
  - b(ἱ) : i번째 데이터에서 가장 가까운 다른 군집 내 다른 데이터 포인트들과의 평균 거리
```


- WCSS (Whithin Clusters Sum of Squares)

|-|
|-|
|![image](https://github.com/user-attachments/assets/d41e1c4a-8a9c-4742-8524-04c6a169b7ba)|

```
  - C : 군집의 중심 값

  - d : 클러스터 내에 있는 데이터
```

> **Elbow 기법** : 최적의 군집 개수(K) 선택 방법

|Elbow 기법|
|-|
|![image](https://github.com/user-attachments/assets/2472ccd4-6ba6-43bb-bf85-db04a0f93c20)|
|- 경사가 완만해지는 지점이 최적의 K 개수|
|💡 같은 군집간에는 응집도가 높고, 다른 군집간에는 응집도가 낮아야 좋은 모델|

<br>

분석모형 진단
---
### 과대적합과 과소적합
|-|
|-|
|![image](https://github.com/user-attachments/assets/b393584f-9307-40c0-8778-e86074a47a80)|

<br>

교차 검증
---
### 교차 검증
- 홀드아웃 : 훈련용과 평가용 **2개의 셋**으로 분할

- K-fold 교차검증 : 데이터를 k개의 집단으로 구분하여 **k-1개 학습, 나머지 1개로 평가**

- LOOCV : **1개의 데이터로만 평가**, 나머지로 학습

- 부트스트래핑 : 복원추출을 활용하여 데이터 셋을 생성, 데이터 부족, 불균형 문제 해소

<br>

모수 유의성 검정
---
### 모집단 유의성 검증
- Z-검정 : 표본이 모집단에 속하는 검정

- T-검정 : 두 집단의 평균치 차이의 비교 검정 시 사용

- ANOVA 검정 : 셋 이상의 집단에 대한 평균 검정

- 카이제곱 검정 : 두 집단의 동질성 검정, 혹은 단일 집단 모분산에 대한 검정

- F-검정 : 두 집단의 분산의 동일성 검정 시 사용

<br>

적합도 검정
---
### 적합도 검정
- Q-Q plot : 데이터의 정규성을 시작점으로 파악

- 카이제곱 검정 : 변수를 **범주**로 묶어 적합성에 대한 검정

- 샤피로 윌크 검정 : 데이터의 표준정규점수와 선형상관관계를 측정하여 검정

- 콜모고로프0스미르노프 검정 : **누적 분포함수**를 비교하여 **연속성** 데이터의 검정

<br>

---

<br>

# 2. 분석모형 개선
과대적합 방지
---
### 과대적합 방지방안
- 모델의 복잡도 감소 : 경량화된 모델의 활용, 드롭아웃(Dropout)

- 규제

  - 라쏘(L1) 규제
 
    - L1 : ∑W² (**유클리디안 거리** 기반)
   
  - 릿지(L2) 규제
 
    - L2 : ∑|W| (**맨하탄 거리** 기반)
   
- **편향-분산의 트레이드오프** 확인

<br>

매개변수 최적화
---
### 파라미터(매개변수)와 하이퍼파라미터(초매개변수)
- 파라미터 : 최적화된 모델 구현이 목적이며, 수동으로 설정 불가

- 하이퍼파라미터 : 최적의 파라미터 도출이 목적이며, **사용자가 수동으로 설정**

<br>

### 경사하강법
- 모델 최적화를 위해 손실함수의 최솟값을 찾아가는 반복 알고리즘

|경사하강법|
|-|
|![image](https://github.com/user-attachments/assets/3b0f21a3-4b9a-4721-89fa-587d4fa28783)|
|- a가 너무 클 때 : 이전보다 높은 곳으로 발산|
|- a가 너무 작을 떄 : 수렴하는데 시간이 오래 걸림|

<br>

### Batch Size, Epoch, Iteration

|-|
|-|
|![image](https://github.com/user-attachments/assets/80dcf8b7-fcb0-4736-bc0e-a037fb2eb1ea)|

- Batchsize : 하나의 소그룹에 속하는 데이터 수

- Epoch : 모든 데이터셋을 학습하는 횟수

- Iteration : 1 Epoch 를 마치는데 필요한 배치

<br>

### 하이퍼파라미터 튜닝
- Manual Search : 경험 또는 감으로 설정

- Grid Search : 모든 조합을 탐색

- Random Search : 임의로 탐색

- Bayesian Optimization : 모델링을 통한 최적의 조합 발견

<br>

### 경사하강법 옵티마이저
- 옵티마이저를 통하여 경사하강법의 학습속도 및 지역 극솟값 수렴 문제 해결 가능

|-|
|-|
|![image](https://github.com/user-attachments/assets/d3a40675-8cc8-4e0f-9cc9-cd16b4bd52d8)|

<br>

분석모형 융향
---
### 앙상블
- 보팅(Voting), 배깅(Bagging), 부스팅(Boosting), 랜덤포레스트

<br>

최종모형 선정
---
### 최종모형 선정
- 평가 기준 선정

  - 분류모델 : Accuracy, Precision, Recall, F-1 Score 등의 지표
 
  - 회귀모델 : MSE, MAE, RMSE, 결정계수 등의 지표
 
- 평가 지표 계산 및 모델간의 지표 비교

- 최종 모형의 선정

<br>

