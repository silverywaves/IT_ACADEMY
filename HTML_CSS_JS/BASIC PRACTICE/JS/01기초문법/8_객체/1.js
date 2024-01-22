/*
    객체    : (자료형의 관점) 키(key)와 값(value)으로 구성된 속성의 집합
             여러 개의 값을 가질 수 있고, 다른 자료형의 값도 가질 수 있음
    리터럴(literal) 방식 : {} 를 이용해 생성
    빈 객체             : 속성이 한개도 없는 객체. ex. const person = {};
 */

//    const person = {name:"Hong Gildong"};   // name : 키, Hong Gildong : 값

  const person = {
    name : {
        firstName: "Gildong",
        lastName: "Hong"
    },
    age:20,                             // 다른 객체ok
    isAdult:true,
    printInfo:function(){               // 다른 함수ok (객체에서 속성의 값으로 함수가 들어가면 메소드(method))
        console.log('printInfo');
    }
  };

//   키는 문자열로 작성하는데, 큰따옴표("")나 작은따옴표('')를 표시하지 않아도 문제x
//   하지만 키에 공백이 들어가는 경우 따옴표 필수!
//   const person = {"phone number":"010-000-0000"};