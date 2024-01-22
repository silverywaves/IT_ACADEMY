/*
    호이스팅 : 코드를 선언과 할당으로 분리해 선언부를 자신의 스코프 최상위로 끌어올리는 것 
                var 키워드 & 함수만 적용.
                let 키워드 & const 키워드로 선언한 변수에는 적용x
*/

console.log(num);       // undefined 출력
var num = 10;

/*
    호이스팅에 의해 다음 코드처럼 작동한 것
    var num;                // 선언부를 스코프 최상위로 끌어올림
    console.log(num);       // uddefined 출력
    num = 10;
*/