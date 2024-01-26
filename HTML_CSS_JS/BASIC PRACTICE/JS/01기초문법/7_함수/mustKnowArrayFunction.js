/**
 * Array Function
 */

svtMembers = [
    '승철', '정한', '준휘', '순영', '원우', '지훈',
]

console.log(svtMembers);

// push()
svtMembers.push('코드팩토리'); // 실행하는 array 의 마지막 배열에 값 및 반환값을 추가한다음 길이를 반환
console.log(svtMembers);

// pop()
console.log(svtMembers.pop()); // 코드팩토리 반환. 마지막 배열을 삭제하고 그 삭제한 값을 반환
console.log(svtMembers);

// shif()
console.log(svtMembers.shift()); // 첫번째 값을 삭제하고 그 삭제한 값을 반환
console.log(svtMembers);

// unshift()
console.log(svtMembers.unshift('승철'));   // push 와 같으나 첫번째 값.
console.log(svtMembers);

// splice()
console.log(svtMembers.splice(0, 3))   // splice(어느 인덱스부터 삭제할지, 몇 개를 삭제할지) 삭제한 값을 반환
console.log(svtMembers);

// 새로운 array 반환
console.log('--------------------------')

svtMembers = [
    '승철', '정한', '준휘', '순영', '원우', '지훈',
]

console.log(svtMembers);

// concat()
console.log(svtMembers.concat('코드팩토리'));   // 새로운 array 를 만들어서 반환  
console.log(svtMembers);                        // 원래 array 는 변경x

// splice()
console.log(svtMembers.slice(0, 3)); //  (어떤 인덱스부터 삭제할지, 몇번 인덱스까지 삭제할지-해당 인덱스 제외하고서 삭제) 삭제된 값 반환
console.log(svtMembers);            // 원래 array 는 변경x

// spread operator
let svtMembers2 = [...svtMembers,];     // 리스트를 벗겨내고 상위리스트에 펼쳐서 값을 출력
console.log(svtMembers2);

let svtMembers3 = [svtMembers,];        // 리스트 안에 리스트가 들어감
console.log(svtMembers3);

console.log('--------------------------')

let svtMembers4 = svtMembers;

console.log(svtMembers4);
console.log(svtMembers4 === svtMembers);

console.log([
    ...svtMembers,]
    === svtMembers
);

// join()
console.log(svtMembers.join());         // 컴마 기준으로 모든 값을 합칠 수 있다
console.log(typeof svtMembers.join());
console.log(svtMembers.join('/'));         // (나눔의 기준이 되는 문자-ex./, 띄어쓰기 등)
console.log(svtMembers.join(', '));


// sort()   오름차순
svtMembers.sort();
console.log(svtMembers);

console.log(svtMembers.reverse());       // 내림차순 정렬이 된 함수 반환

let numbers = [1, 9, 7, 5, 3];
console.log(numbers);

// a, b 를 비교했을 때
// 1) a를 b 보다 나중에 정렬하려면 (뒤에 두려면) 0보다 큰 숫자를 반환
// 2) a를 b 보다 먼저 정렬하려면 (앞에 두려면) 0보다 작은 숫자를 반환
// 3) 원래 순서를 그대로 두려면 0을 반환
numbers.sort((a, b)=>{
    return a> b ? 1 : -1;
}); 
console.log(numbers);

numbers.sort((a, b)=>{
    a > b ? -1 : 1
});
console.log(numbers);


// map()    array 에 있는 모든 값들을 순회하면서 그 각각의 값들을 변형시키는 역할(새로운 array)
console.log(svtMembers.map((x) => x));

console.log('--------------------------')

console.log(svtMembers.map((x) => `세븐틴: ${x}`));

console.log(svtMembers.map((x) => {
    if(x === '정한'){
        return `세븐틴: ${x}`;
    } else{
        return x;
    }
}));

console.log(svtMembers);        // 기존 array 는 변경x

console.log('--------------------------')

// filter()     모든 값을 순회하면서 true=반환값에 들어감, false=반환값에 안들어감
numbers = [1, 8, 7, 6, 3];

console.log(numbers.filter((x) => true));
console.log(numbers.filter((x) => false));
console.log(numbers.filter((x) => x % 2 == 0));     // 짝수만 출력

console.log('--------------------------')

// find()       모든 값을 순회하면서 true=반환값에 들어감. 단, 순서대로 오다가 해당되는 첫번째 값만 반환
console.log(numbers.find((x) => x % 2 == 0));    

// findIndex()      find() 와 똑같은데 인덱스를 반환
console.log(numbers.find((x) => x % 2 == 0));       // 1 출력 (인덱스넘버)

// reduce()     (함수, 시작하고 싶은 값)
console.log(numbers.reduce((p, n) => p + n,0));     // 25 출력