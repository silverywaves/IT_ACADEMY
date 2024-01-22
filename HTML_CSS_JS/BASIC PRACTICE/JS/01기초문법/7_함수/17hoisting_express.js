/*
    <함수 표현식>, <화살표 함수 방식>의 선언부는 변수를 선언한 부분 
    => let 이나 const 키워드로 선언했다면 호이스팅 자체가 되지 않음
*/

printHello();           // TypeError: printHello is not a function
var printHello = function printHello() {
    console.log("Hello");
}

/*
    호이스팅에 의해 다음 코드처럼 작동한 것
    var printHello;
    printHello();
    printHello = function printHello(){
        console.log("Hello");
    }
*/