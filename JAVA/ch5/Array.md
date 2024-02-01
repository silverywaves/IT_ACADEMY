## 배열(array)
**같은 타입**의 여러 변수를 하나의 묶음으로 다루는 것
<br>

  - 데이터의 수가 많아도 배열의 길이만 바꾸면 됨
  - 변수는 배열을 다루는데 필요한 참조변수일 뿐, 값을 저장하는 공간 X
  - 저장공간이 연속적으로 배치


---

### 선언
```
- 타입[] 변수이름;  // ex. int[] score;
- 타입 변수이름[];  // ex. int score[];
```


---

### 생성
```
타입[] 변수이름;                    // 배열을 선언(배열을 다루기 위한 참조변수 선언)
변수이름 = new 타입[길이];          // 실제 저장공간 생성

타입[] 변수이름 = new 타입[길이]    // 선언 & 생성 동시에
ex. int[] score = new int[5]
```


---

#### 길이
  - 배열의 요소의 개수(값을 저장할 수 있는 공간의 개수)
  - 양의 정수(0 포함)
  - 최대값 : int 타입의 최대값(약 20억)


---

#### 배열이름.length
```
int[] arr = new int[5];    // 길이가 5인 int배열
int tmp = arr.length;      // arr.length 값은 5 -> tmp 에 5 저장
```
  - 배열은 한번 생성하면 길이 변경 불가
  - 배열이름.length 는 상수(읽기 O, 변경 X)


---

#### 저장 공간 부족
```
배열의 길이 변경 :
  1. 더 큰 배열을 새로 생성
  2. 기존 배열의 내용을 새로운 배열에 복사
```
  - 길이 변경시 많은 비용 발생 -> 처음부터 기존의 2배정도의 길이로 생성하는 것이 좋음
  - [Ex4](https://github.com/silverywaves/IT_ACADEMY/blob/0b2ca97d21fa8692c1938971ec5906938b90d497/JAVA/ch5/ArrayEx04.java) 참고


---
