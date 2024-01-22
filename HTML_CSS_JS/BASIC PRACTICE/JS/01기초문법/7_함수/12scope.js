/*
    스코프(scope) : 변수나 함수와 같은 참조 대상 식별자를 찾아내기 위한 규칙
*/

/*
    함수 스코프 : 함수에서 정의한 블록문만 스코프의 유효 범위로 인정
    지역 스코프 : 함수 내부 - 내부가 아닌 외부에서 참조하려고 하면 오류 발생
    전역 스코프 : 함수 외부 - 스코프와 상관없이 모두 참조 가능
*/

// let a = 10;                             // 전역 스코프
// function sum(){
//     console.log(`함수 내부: ${a}`);      // 함수 내부: 10
// }
// sum();
// console.log(`함수 외부: ${a}`);          // 함수 외부: 10

function sum(){
    let a = 10;                            // 지역 스코프
    console.log(`함수 내부: ${a}`);         // 함수 내부: 10
}
sum();
console.log(`함수 외부: ${a}`);             // ReferenceError: a is not defined