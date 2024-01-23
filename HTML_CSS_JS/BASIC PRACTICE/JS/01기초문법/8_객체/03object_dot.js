/*
    마침표 연산자 : .를 이용해 객체 속성에 접근. 따옴표 사용x(공백있으면 사용불가)
                 접근할 객체명과 객체 속성의 키를 마침표 연산자로 연결
*/

const person ={
    name:{
        firstName:"Gildong",
        lastName:"Hong"
    },
    age:20,
    likes:["apple", "samsung"],
    printHello:function(){
        return "hello";
    }
};
console.log(person.name.lastName);  // Hong
console.log(person.age);            // 20
console.log(person.likes[0]);       // apple
console.log(person.printHello());   // hello

// const person = {
//     name:"Hong Gildong"
// };
// console.log(person."name");             //SyntaxError: Unexpected string

// const person = {
//     "phone number":"010-000-0000"
// };
// console.log(person["phone number"]);    // 010-000-0000
