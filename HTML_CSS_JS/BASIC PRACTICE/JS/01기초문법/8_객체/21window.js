/**
 *  브라우저 객체 모델 : 웹 브라우저에서 제공하는 객체
 *  Window
 *  - document  : 웹문서와 관련있는 기능    - form / cookie / links & anchors / images
 *  - location  : 현재 페이지의 URL 정보
 *  - history   : 방문 기록 정보
 *  - navigator : 웹 브라우저의 정보
 *  - screen    : 방문자의 화면 정보
 */

<body>
    <button onclick="printInfo()">window 객체 속성</button>
    <script>
        function printInfo(){
            console.log(`웹 브라우저의 너비: ${window.innerWidth}`);
            console.log(`웹 브라우저의 높이: ${window.innerHeight}`);
            console.log(`웹 브라우저 창의 너비: ${window.outerWidth}`);
            console.log(`웹 브라우저 창의 높이: ${window.outerHeight}`);
            console.log(`웹 브라우저 창 위쪽 면과 모니터 사이의 간격: ${window.screenTop}/${window.screenY}`);
            console.log(`웹 브라우저 창 왼쪽 면과 모니터 사이의 간격: ${window.screenLeft}/${window.screenX}`);
            console.log(`웹 브라우저 창의 스크롤 가로 위치: ${window.scrollX}`);
            console.log(`웹 브라우저 창의 스크롤 세로 위치: ${window.scrollY}`);
        }
    </script>
</body>