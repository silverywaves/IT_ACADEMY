/* 
    화살표 함수에서 {}를 생략하면 화살표 다음에 오는 코드는 return 문으로 처리
*/

const sum = (num1, num2) => num1 + num2;
const result = sum(10, 20);

console.log(result);    // 30