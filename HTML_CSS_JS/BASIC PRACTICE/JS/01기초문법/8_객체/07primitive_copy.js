let num = 10;
let copyNum = num;
num = 20;       // 변수 num을 재할당
console.log(num);       // 20
console.log(copyNum);   // 10

// 기본 자료형 : 변수에 데이터를 할당할 때 데이터 그 자체가 할당
// 깊은 복사(deep copy) : 복사한 값을 재할당할 때 한쪽 데이터가 변경되어도 서로 영향을 미치지 않게 복사
