/**
 *  scroll 메서드의 매개변수에 객체 리터럴을 전달할 때, behavior 속성 전달 가능
 *  behavior 속성값을 smooth로 하면 웹 브라우저 스크롤이 해당 위치로 마우스 휠을 굴리듯이 부드럽게 이동
 */

window.scrollTo({top:4000, behavior:'smooth'});
window.scrollBy({top:600, behavior:'smooth'});