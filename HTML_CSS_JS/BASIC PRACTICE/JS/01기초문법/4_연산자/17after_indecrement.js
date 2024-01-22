// 후치연산 : 값을 먼저 할당한 후에 증감연산 진행

let num = 10;
let subNum = num++;  // 뒤에 사용했으므로 후치연산 방식
// num++ 연산은 증가 전의 값인 10을 subNum에 반환한 후 1이 증가하는 방식

console.log(subNum);    // 10;