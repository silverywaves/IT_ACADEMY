console.log(`3 * 1 = 3`);
console.log(`3 * 2 = 6`);
console.log(`3 * 3 = 9`);
console.log(`3 * 4 = 12`);
console.log(`3 * 5 = 15`);
console.log(`3 * 6 = 18`);
console.log(`3 * 7 = 21`);
console.log(`3 * 8 = 24`);
console.log(`3 * 9 = 27`);

console.log(``)
// 반복문을 사용해 간단하게 줄일 수 있음.

for(let i = 1; i <=9; i++){
    console.log(`3 * ${i} = ${3 * i}`);
}

// -> 함수를 이용하면 유지보수가 더 편해짐.