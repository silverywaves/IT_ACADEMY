/*
    return 문은 데이터를 반환하지 않으면 함수 실행을 종료하는 역할
    return 문 다음에 코드가 있더라도 함수 실행을 즉시 종료하고 undefined 반환
*/

function sum(num1, num2){
    if(typeof num1 !== "number" || typeof num2 !== "number"){
        return;     // 매개변수가 숫자가 아니면 강제 종료
    }
    return num1 + num2;
}
let result = sum("a", "b");
console.log("out: " + result);      // out: undefined
