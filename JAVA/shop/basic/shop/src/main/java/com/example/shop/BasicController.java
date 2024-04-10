package com.example.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Controller     // 1. 클래스에 Controller 어노테이션 붙이면
public class BasicController {
    // [목표] 메인페이지 접속시 "안녕하세요" 보내주기
    // 2. 여기서 서버기능 제작 가능
    @GetMapping("/")        // 누군가 해당 URL(현재 메인페이지)에 접속하면
//    @ResponseBody             // 문자 그대로 보내달라는 내용
    String hello(){
//        return "안녕하세요";     // 이 내용을 보내주세요(return 해주세요)
        return "index.html";     // html 파일 경로 기재(기본경로 static 폴더) & @ResponseBody 삭제
    }

    // [목표] /about 접속시 사이트 소개글 보내주기
    @GetMapping("/about")
    @ResponseBody
    String about(){
        return "<h4>사이트입니다</h4>";
    }
    // html 보내려면?
    // 1. return 에 html로 작문
    // 2. html 파일 만들어두고 전송 => resources>static 폴더에 html 파일 생성

    // [숙제] /date 접속시 현재 날짜와 시간 보내주기
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    @GetMapping("/date")
    @ResponseBody
    String dateNow(){
        return formatter.format(calendar.getTime());
    }
}
