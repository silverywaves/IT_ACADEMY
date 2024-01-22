/*
    반환한다    : 함수 내부 변수에 할당된 값(데이터)이 함수를 호출한 곳으로 전달되는 과정
    반환값      : 반환된 데이터
*/

function sum(num1, num2){
    let result = num1 + num2;
    return result;              // 반환된 데이터를 함수 외부에서 사용하려면 
}                               // 함수 호출 부분에서 반환값을 다시 변수에 할당해야 함
const result = sum(10, 20);
console.log("out: " + result);  // out: 30

/*
    데이터를 반환할 때 return 문에 꼭 변수를 사용할 필요x
    function sum(num1, num2){
        return num1 + num2;
    }
    const result = sum(10, 20);
    console.log("out: " + result);
*/