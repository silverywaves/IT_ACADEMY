/*
    for ...in : 객체 리터럴이나 배열에 반복 접근할 수 있는 반복문
    for(가변수 in 배열/객체 리터럴){
        블록문
    }
    가변수 : 배열 또는 객체 리터럴을 탐색해서 키를 저장할 임시 변수
*/

// 객체 리터럴 반복
let obj = {name:"철수", age:"20"};
for(let key in obj){
    console.log(key + ": " + obj[key]);
}