/* 
    switch(key){
        case value1:
            // key가 value1 일 때 실행할 블록문
            break;      // 코드 실행을 멈춤(=else문)
            // key가 value2 일 때 실행할 블록문
            break;
        default:
            // 아무것도 일치하지 않을 때 실행할 블록문. case 문이 없으면 기본으로 실행.
            break;
    }
*/

let food = "melon";
switch(food){
    case "melon":
        console.log("fruit");
        break;
    case "apple":
        console.log("fruit");
        break;
    case "banana":
        console.log("fruit");
        break;
    case "carrot":
        console.log("vegetable");
        break;
    default:
        console.log("It's not fruits and vegetables.");
        break;
}