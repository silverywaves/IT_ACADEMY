// continue 문 : 반복문을 건너뛰고 실행

// for(let i = 1; i <=10; i++){
//     if(i % 2 === 1) continue;   // 홀수는 건너뛰기
//     console.log(i);
// }

// 1에서 100까지의 합을 출력해보기
let sum = 0;
for(let i = 1; i <= 100; i++){
    sum = sum + i;      // sum += i;
}
console.log(sum);