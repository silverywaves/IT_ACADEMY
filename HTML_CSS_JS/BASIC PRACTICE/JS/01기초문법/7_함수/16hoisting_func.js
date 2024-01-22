/*
    <함수 선언문> 으로 정의된 함수는 호이스팅에서 선언부로 봄
 */

printHello();                   // Hello 출력
function printHello(){          // 함수 선언문을 최상위로 끌어올림
    console.log("Hello");
}

/*
    호이스팅에 의해 다음 코드처럼 작동한 것
    function printHello(){
        console.log("Hello");
    }
    printHello();
*/