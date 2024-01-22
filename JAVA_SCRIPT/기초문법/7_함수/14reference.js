/*
    let, const 키워드는 같은 식별자의 중복 선언 불가
    => 같은 스코프 영역에서 중복 선언이 불가능하다는 뜻

    전역 스코프와 지역 스코프에 같은 식별자를 가지는 참조 대상이 있다면,
    먼저 같은 지역 스코프의 식별자를 참조하고, 
    같은 지역 스코프에서 참조할 식별자를 찾지 못할 때만 전역 스코프에서 찾음
*/

let a = 10;
const b = 20;
function sum(){      // 같은 스코프 내 중복 선언이 아니라 오류발생x
    let a = 50;
    const b = 70;       
    console.log(`함수 내부 a: ${a}`);
    console.log(`함수 내부 b: ${b}`);
}
sum();              // 함수 내부 a: 50, 함수 내부 b: 70