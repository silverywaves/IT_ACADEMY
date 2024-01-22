const person = {
    name:"Hong Gildong"
};
delete person.name;     // 또는 delete person["name"]
console.log(person);    // {} 출력

// 객체 속성 동적으로 삭제 : 객체 속성에 접근할 때 앞에 delete 명시