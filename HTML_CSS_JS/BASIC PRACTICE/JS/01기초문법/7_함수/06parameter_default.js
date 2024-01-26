// 매개변수를 정의하고 데이터를 전달하지 않으면 매개변수에는 undefined 값이 자동 할당

// 매개변수에 직접 데이터를 할당하여 기본값 지정 가능
function sum(a = 10, b = 10){
    console.log(a, b);
}
sum();      // 10 10
