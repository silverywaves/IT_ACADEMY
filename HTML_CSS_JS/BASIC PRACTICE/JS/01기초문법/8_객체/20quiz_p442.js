// 가장 큰 수 출력

const arr = [10, 120, 30, 50, 20]; 
arr.sort(function(a,b){         // 배열의 요소를 내림차순으로 정렬한 뒤 첫번째 인덱스 요소를 출력
    if(a<b) return 1;
    else if(a>b) return -1;
    else return 0;
})
console.log(arr[0]);