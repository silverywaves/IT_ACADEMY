# 분석결과 해석 및 활용
# 1. 분석결과 해석
분석모형 해석
---
### 주성분 분석 (PCA)
- (1) 주성분 분석의 결과 해석

```R
  > result<-prcomp(data,center=T,scale.=T)
  > summary(result)
                            PC1      PC2      PC3     PC4      PC5      PC6      PC7
  Standard deviation      2.1119  1.0928  0.72181  0.67614  0.49524  0.27010  0.2214
  Proportion of Variance  0.6372  0.1706  0.07443  0.06531  0.03504  0.01042  0.0070
  Cumulative Proportion   0.6372  0.8078  0.88223  0.94754  0.98258  0.99300  1.0000
```

```
  - 첫번째 주성분(PC1)의 분산(0.6372)이 가장 큼

  - 두 개의 주성분(PC1, PC2)을 적용하면 전체 데이터의 약 80%를 설명
```


- (2) 스크리플롯 (Screeplot)

  - 주성분의 개수를 선택하는데 도움이 되는 그래프 (x축 주성분 개수, y축 분산변화)
 
  - **수평을 이루기 바로 전 단계 개수**로 선택

|-|
|-|
|![image](https://github.com/user-attachments/assets/8be4aff6-fe66-4a87-b08f-e8f9bb26536f)|
|- 기울기가 3-4 구간에서 완만해지므로 **주성분 개수는 2개로 선택**|

<br>

### 회귀분석의 분산분석(ANOVA)표
|요인|제곱합|자유도|제곱평균|F비|
|:-:|:-:|:-:|:-:|:-:|
|회귀|SSR = ∑(Ý - Y)²|p(회귀계수 수)|MSR = SSR/p|F = MSR/MSE|
|잔차|SSE = ∑(Y - Ý)²|n(전체 데이터 수) - p - 1|MSE = SSE/n-p-1|F = MSR/MSE|
|총|SST = SSR + SSE|n - 1|-|-|

- ANOVA 검정 : 3개 이상의 그룹의 평균을 비교하는 검정 (회귀모형의 유의성 분석 시 활용)

- 결정계수(R-Square) = SSR/SST = 1 - SSE/SST

- Adjusted R-Square = 1 - (n-1) * MSE/SST  (다중 회귀에서는 Adjusted R-Square 사용)

- **전체 데이터 수 = 자유도 + 1**

<br>

### 회귀 모형의 검정 결과
- (1) 모형이 통계적으로 유의미한가 : 모형에 대한 **F 통계량, p-value**

  - 귀무가설 : **'모든 회귀계수는 0이다'**
 
- (2) 회귀계수들이 유의미한가 : 회귀계수들의 **t 통계량, p-value**

  - 각각의 회귀계수에 대한 귀무가설 : **'회귀 계수는 0이다'**
 
- (3) 위 (1), (2) 모두를 기각하면 해당 모델을 활용

- (4) 모형이 설명력을 갖는가 : **결정계수(R-Square) 값**

```R
  - 종속변수 height / 독립변수 age, no_sibilings

  Call:
  lm(formula = height ~ age + no_siblings, data = ageandheight)

  Residuals:
      Min        1Q      Median      3Q      Max
  -0.28029  -0.22490  -0.02219  0.14418  0.48350

  Coefficients:
                Estimate  Std. Error  t value  Pr(>|t|)
  (Intercept)  64.95872    0.55752    116.515  1.28e-15  ***
  age           0.63516    0.02254     28.180  4.34e-10  ***
  no_siblings  -0.01137    0.05893     -0.193     0.851
  ---
  Signif.  codes: 0 '***'  0.001 '**'  0.01 '*'  0.05 '.'  0.1 ' '  1

  Residual standard error: 0.2693 on 9 degrees of freedom
  Multiple R-squared: 0.9888,  Adjusted R-squared: 0.9863
  F-statisticL 397.7 on 2 and 9 DF, p-value: 1.658e-09
```
- 회귀모형 F분포의 P-value(1.658e-09)가 0.05보다 작으므로 **모형 유의미**

- age의 p-value(4.34e-10)가 0.05보다 작으므로 **회귀계수 유의미**

- no_sibilings의 p-value(0.851)가 0.05보다 크므로 제외하고 회귀분석 **재수행 권장**

- 위 모형은 **다중회귀 모형**

- R-square:0.9888, Adjusted R-square:0.9863 (모형은 전체 데이터의 **98% 이상을 설명**)

- 회귀 자유도 : 2, 잔차의 자유도 : 9 → 총 2 + 9 + 1 = **12개의 데이터**를 활용하여 분석

- 모델 회귀 식

|-|
|-|
|![image](https://github.com/user-attachments/assets/72d5d83e-8b40-45c8-83db-56276c40023d)|

<br>

비즈니스 기여도 평가
---
### 비즈니스 기여도 평가
- 투자 대비 효과(ROI) : 투자로 얻을 수 있는 순 효과를 비용으로 나눈 값

- 순현재가치(NPV) : 미래의 현금 흐름을 현재가치로 계산

- 내부 수익률(IRR) : NPV = 0 일때의 수익률

- 총 소유 비용(TCO) : 자산의 매입 가격과 운용 원가를 더한 금액

<br>

---

<br>

# 2. 분석결과 시각화
시공간 시각화
---
### 시간 시각화
- 시간에 따른 변화를 표현 (x축 시간, y축 값)

|-|
|-|
|![image](https://github.com/user-attachments/assets/8e60b2d3-6738-4bff-80eb-a4132f244fa9)|

<br>

공간 시각화
---
- 장소나 지역에 대한 데이터의 분포를 표현

|-|
|-|
|![image](https://github.com/user-attachments/assets/8e9108c7-d3a9-4c84-b98d-bdb381ba70e6)|

<br>

관계 시각화
---
### 관계 시각화
- 데이터 사이의 관계나 분포, 패턴을 표현

|-|
|-|
|![image](https://github.com/user-attachments/assets/1e4ce000-ceba-471f-a2ce-e6432fab7a0b)|
|![image](https://github.com/user-attachments/assets/754245dc-8ba9-4dc5-8e32-c872b9eb9b66)|

<br>

비교 시각화
---
### 비교 시각화
- 여러 변수들간의 차이나 유사성을 비교

|-|
|-|
|![image](https://github.com/user-attachments/assets/a4196af3-938b-457d-9741-ad701db81ef6)|

<br>

인포그래픽
---
### 인포그래픽
- 정보(Information) + 시각적 형상(Graphic)

- 목적에 따라 정보를 시각적으로 표현

- 분석 시각화와는 달리 패턴을 발견하는 것보다 일반인에게 **설득형 메시지 전달** 목적

<br>

### 인포그래픽의 유형
- 지도형 : 지도 활용

- 도표형 : 표와 그래프 활용

- **타임라인형** : 시간 순서로 나열

- 스토리텔링형 : 이야기를 구성

- 만화형 : 만화적 요소를 활용

- 비교분석형 : 두 가지 이상의 내용을 비교

- **컨셉 맵** : 내용 간의 연관성

<br>

---

<br>

# 3. 분석결과 활용
### 분석결과 활용
- 분석모형 전개 : 분석결과를 확장 및 적용

- 분석결과 활용 시나리오 개발 : 인사이트 발굴, 결과를 업무에 반영

- 분석모형 모니터링 : 변화를 지속적 반영 위해 모니터링

- 분석모형 리모델링 : 새로운 알고리즘 및 데이터 반영

<br>






