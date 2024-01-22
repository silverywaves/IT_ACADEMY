const arr = [10, 20, 30];
for(let i = 0; i < arr.length; i++){
    console.log(arr[i]);
}

/*
    파괴적 메서드 : 메서드를 사용했을 때 원본 데이터를 변경하는 메서드
                 배열에 데이터를 추가하거나 추출(제거하고 반환)하는 push(), pop(), unshift(), shift() 등
    비파괴적 메서드 : 원본은 변경하지 않는 메서드
                    forEach() : 배열 안의 요소를 순회하면서 콜백 함수인 function(V)를 호출해 접근한 요소의 값 출력
*/