/*
    속성을 동적으로 추가한다 : 이미 만들어진 객체에 나중에 속성을 추가하는 것
*/

const person = {};
person.name = {
    fistName:"Gildong",
    lastName:"Hong"
};
person.likes = ["apple", "samsung"];
person.printHello = function(){
    return "hello";
}
