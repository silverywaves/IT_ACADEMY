package com.example.shop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemController {       // public : 다른 폴더에서도 사용 가능(없으면 같은 폴더 안에서만 사용가능)
    // /list 페이지로 접속하면 상품목록 페이지 보내주기


    // JPA 데이터 입출력 3-STEP
    // 1. repository 만들기
    // 2. 원하는 클래스에 repository 등록
    // 3. repository.입출력문법() 쓰기
    
    @GetMapping("/list")
    String list(Model model){   // <HTML에 서버데이터 넣기> 1. 파라미터에 Model model 넣기
        model.addAttribute("name","이용복");   // 2. model.addAttribute(전달할 데이터 이름, 데이터) : 데이터가 해당이름으로 .html에 전달됨
        return "list.html";
    }

}
