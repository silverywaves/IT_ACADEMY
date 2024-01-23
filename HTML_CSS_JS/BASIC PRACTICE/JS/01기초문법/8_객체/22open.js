// open() : 웹 브라우저에서 새로운 창을 열 떄 사용
// window.open(새 창에서 열릴 파일의 경로, 새 창의 이름-탭에 보이는 이름x, 내부적으로 구분하는 용도, 속성-새 창의 속성 지정);

<body>
    <button onclick="popup()">팝업</button>
    <script>
        function popup(){
            window.open(`popup.html`, '팝업', 'width=200, height=100');
        }
    </script>
</body>