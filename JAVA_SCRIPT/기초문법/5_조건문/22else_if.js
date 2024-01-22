/* 
    if(조건식1){
        조건식1이 참이면 블록문 실행
    } else if(조건식2){
        조건식2가 참이면 블록문 실행
    } else{
        조건식이 모두 거짓이면 블록문 실행
    }
*/

let num = 0;
if(num > 0){
    console.log("양수");
} else if(num < 0){
    console.log("음수");
} else{
    console.log("0");
}