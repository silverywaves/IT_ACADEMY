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

  











