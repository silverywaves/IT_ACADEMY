# @RestController(BACKEND-SPRING)
- RESTful 웹 서비스를 제공하는 컨트롤러 <br>
  - RESTFul : REST 개념을 바탕으로 설계된 시스템
  - REST : Representative State Transfer의 약자로 분산 시스템을 위한 아키텍처 <br>
  - 네트워크를 경유해서 외부 서버에 접속하거나 필요한 정보를 불러오기 위한 구조 <br>
- 메서드의 반환 값이 JSON, XML 등과 같은 데이터로 처리 <br>

<br>

@Controller vs @RestController
---
- 공통점 : Spring에서 Controller를 지정해주기 위한 어노테이션
- 차이점 : ResponseBody가 생성되는 방식

> @Controlle (전통적인 Spring MVC의 Controller)

![image](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/e732a0ef-9698-45b2-b077-e9ab5deeb5db)
- View를 반환할 경우
  - Client에서 보낸 요청은 DispatcherServlet을 거쳐 HandlerMapping을 통해 Controller를 찾고 요청을 수행
  - Controller는 받은 요청을 처리하고 난 뒤 ViewName을 반환
  - DispatcherServlet은 ViewResolver를 통해 ViewName에 해당하는 View를 찾아 사용자에게 반환

![image](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/afccf7be-9c83-4870-8683-c920c663d7ea)
- Data를 반환할 경우
  - ResponseEntity(HttpStatus + HttpHeaders + HttpBody 형태의 데이터, 한 마디로 Http 응답 메시지)의 Body(Response Body)를 사용해야 함 → @ResponseBody
  - Controller도 View 뿐만이 아닌 JSON 형태의 데이터도 반환 가능

> 참고
```
@Controller를 통해 객체를 반환할 때, 일반적인 경우엔 ResponseEntity로 감싸서 반환
객체를 반환할 때는 View를 반환할 때와 마찬가지로 ViewResolver 대신 HttpMessageConverter가 동작
HttpMessageConverter에는 여러 Converter가 등록되어 있으며, 반환해야 하는 데이터의 종류에 따라 Converter도 그에 맞게 달라짐

<EX>
단순 문자열인 경우에는 StringHttpMessageConverter 사용
JSON 객체의 경우에는 MappingJackson2HttpMessageConverter 사용

Spring은 클라이언트의 HTTP Accept Header와 서버의 Controller 반환 타입 정보를 조합해 적합한 HttpMessageConverter를 선택하여 처리함
```

 <br>

> @RestController (RESTful 웹 서비스의 Controller)
- @Controller + @ResponseBody 형태
- REST API를 개발할 때 주로 사용, ResponseEntity로 감싸서 반환


 ---

비동기요청함수(FRONTEND-JAVASCRIPT)
---
|종류|연도|설명|
|:-:|:-:|-|
|XMLHttpRequest<br>(XHR)|1999|Microsoft의 인터넷 익스플로러 5에서 처음 등장한 기술<br>웹 페이지에서 비동기적으로 데이터를 받아오는 데 사용|
|Promise|2015|비동기 작업의 결과를 다루기 위한 객체<br>콜백 헬(callback hell)을 해결하고 코드를 보다 깔끔하게 작성 가능|
|Fetch API|2015|네트워크 요청을 생성 및 조작하기 위한 간단한 인터페이스를 제공<br>XHR보다 더 간결하고 유연한 API를 제공하며 Promise를 사용하여 비동기 작업을 처리|
|Axios|2014|HTTP 클라이언트 라이브러리 → 브라우저 및 Node.js 환경에서 모두 사용 가능<br>Promise 기반의 API, 간편한 인터셉터(interceptors), CSRF 보호, JSON 데이터 자동 직렬화 등 개발자들에게 매우 편리한 HTTP 요청 처리 방법을 제공|

