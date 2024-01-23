const person = {
    name:"Hong Gildong"
};
const copyPerson = person;      // 변수 person에 할당된 객체를 변수 copyPerson에 복사
person.name = "Hong";           // 변수 person에 할당된 객체의 값을 변경
console.log(person.name);       // Hong
console.log(copyPerson.name);   // Hong

// 참조 자료형 : 데이터가 위치하고 있는 메모리의 주소 값만 할당 (=참조한다)
// 얕은 복사(shallow copy) : 데이터를 복사했을 때 한쪽 데이터가 변경되면 다른 쪽 데이터도 변경되어 서로 영향을 받음
