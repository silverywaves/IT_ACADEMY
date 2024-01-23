//    객체 속성에 접근하기

// 대괄호 연산자 [] 사용. 배열에서도 사용 가능
// 객체명 뒤에 대괄호를 붙이고 대괄호 안에 키 작성
// 큰따옴표나 작은따옴표로 감싼 문자열 형태로 작성

// const person = {
//     name:"Hong Gildong",
//     age:20
// };
// console.log(person["name"]);        // Hong Gildong
// console.log(person["age"]);         // 20

// 따옴표 생략시 키가 아닌 name 이라는 변수를 찾게되어 오류발생
// const person = {
//     name:"Hong Gildong"
// };
// console.log(person[name]);      //ReferenceError: name is not defined

const person = {
    name:{
        firstName:"Gildong",
        LastName:"Hong"
    },
    likes:["apple", "samsung"],
    printHello:function(){
        return "hello";
    }
};

console.log(person["name"]);    // {firstName:'Gildong', lastName:'Hong'}

console.log(person["name"]["firstName"]);       // Gildong
// <객체 리터럴> person 객체의 name 속성에 값으로 할당된 객체의 firstName 속석에 접근

console.log(person["likes"]);        // ['apple', 'samsung']
// <배열>의 각 데이터에 접근하려면 대괄호 연산자에 인덱스 사용
// 첫번째 대괄호 - 객체 속성의 키 / 두번째 대괄호 - 배열의 인덱스
console.log(person["likes"][0]);    // apple
console.log(person["likes"][1]);    // samsung

// <함수> 키를 이용해 접근. () 사용
console.log(person["printHello"]);      // [Function: printHello]
console.log(person["printHello"]());    // hello
