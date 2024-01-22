/*
    블록 스코프 : {}로 구성된 블록문 기준으로 스코프의 유효 범위를 나누는 방식
                let, const 키워드로 선언한 변수에만 적용
*/

let a = 10;                                    // 전역 스코프(전역 변수 : 전역 스코프에 선언한 변수)
{
    let b = 20;                                // 지역 스코프(지역 변수 : 지역 스코프에 선언한 변수)
    console.log(`코드 블록 내부 a: ${a}`);      // 코드 블록 내부 a: 10
    console.log(`코드 블록 내부 b: ${b}`);      // 코드 블록 내부 b: 20
}
console.log(`코드 블록 외부 a: ${a}`);          // 코드 블록 외부 a: 10
console.log(`코드 블록 외부 b: ${b}`);          // ReferenceError: b is not defined

/*
    var 키워드로 선언한 변수에서는 함수 스코프 방식으로만 나뉘기때문에 변수 a, b 모두 전역 스코프에서 선언한 것과 마찬가지
*/

// var a = 10;
// {
//     var b = 20;
//     console.log(`코드 블록 내부 a: ${a}`);          // 코드 블록 내부 a: 10
//     console.log(`코드 블록 내부 b: ${b}`);          // 코드 블록 내부 b: 20
// }
// console.log(`코드 블록 외부 a: ${a}`);              // 코드 블록 외부 a: 10
// console.log(`코드 블록 외부 b: ${b}`);              // 코드 블록 외부 b: 20