/*
    즉시 실행 함수(IIFE, Immediately Invoked Function Expression)
    => 함수를 정의하면서 동시에 실행까지 하는 함수. 한번 실행되고 나면 메모리에 데이터가 사라짐
    => (function(){})();

    함수를 선언하면 전역 스코프에 정의되며 프로그램이 종료되기까지 메모리에서 사라지지 않음
    => 동일한 식별자 재사용 불가

    전역 스코프가 오염됐다 : 한번만 사용할 함수의 식별자를 더이상 사용할 수 없게 되어버린 현상
                            즉시 실행 함수로 함수를 정의하면 방지 가능
*/

// const init = function(){            // init 식별자 더이상 사용 불가 => 전역 스코프가 오염됐다
//     console.log("initialized!");
// }

(function init(){
    console.log("initialized!");
})();           // initialized!
init();         // ReferenceError: init is not defined (데이터가 사라졌는데 재호출하여 오류 발생)


/* 매개변수가 있는 함수도 즉시 실행 함수로 정의해서 실행 가능 */
// (function sum(a, b){
//     console.log(a + b);
// })(10, 20);    // 30