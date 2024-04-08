package springbin.componentScan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "spring!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {    // 외부에서 파라미터 받음
//  @RequestParam(value = "name", required = false/true-디폴트
//  required 디폴트값이 true 이기때문에 값을 무조건 넣어야 함(false 면 안넘겨도 괜찮음)
//  http://localhost:8080/hello-mvc?name=spring!!!!!!!!
//  http://localhost:8080/hello-mvc 뒤에 물음표(?)를 사용해 값을 넘겨줌 (name=spring!!!!!!!!(
        model.addAttribute("name", name);   // 파라미터로 넘어온 name 을 넘김
        return "hello-template";
        // 이대로 실행시키면 Error 발생 -> Required request parameter 'name' for method parameter type String is not present
        // request parameter 'name' 이 없다 => @RequsetParam("name") 에서 Ctrl+p 누르면 파라미터 정보 조회 가능! 확인해보기
    }
    // => 템플릿이 있는 상황에서 조작하는 방식

    @GetMapping("hello-string")
    @ResponseBody       // html 에 나오는 body 태그 X
    // http 통신 프로토콜은 헤더부와 바디부로 나뉘어져 있음 -> 바디부에 이 데이터를 내가 직접 넣어주겠다는 뜻!
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;  // 템플릿 엔진과 다른 점 : 뷰 없이 문자 그대로 내려감
    }
    // => 데이터를 그대로 내려주는 방식

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        // 객체 생성
        Hello hello = new Hello();      // Ctrl + Shift + Enter : 자동 문장 마무리(;)
        hello.setName(name);    // 파라미터로 넘어온 name 넣어주기
        return hello;           // 문자가 아닌 객체를 리턴
        // http://localhost:8080/hello-api?name=spring!!!!!!!! => {"name":"spring!!!!!!!!"}
        // 문자를 넣었을 때와 다른 화면 출력(JSON 방식{key:value})
    }

    static class Hello  {
        // static class 로 만들면 HelloController 클래스 안에서 Hello 클래스를 그냥 쓸 수 있음
        private String name;

        // getter & setter 생성 / 프로퍼티 접근 방식
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}




