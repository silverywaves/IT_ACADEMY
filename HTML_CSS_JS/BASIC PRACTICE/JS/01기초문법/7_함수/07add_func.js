/* return 문 : 함수 외부로 데이터를 반환. // return 식(또는 값) */

// function sum(num1, num2){
//     let result = num1 + num2;
//     console.log("inner: " + result);
// }
// sum(10, 20);        // inner: 30

function sum(num1, num2){
    let result = num1 + num2;
}
sum(10, 20);
console.log("out: " + result);      // RdferenceError: result is not defined
                                    // 함수 외부에서 함수 내부의 변수를 참조하려고 해서 발생한 오류
