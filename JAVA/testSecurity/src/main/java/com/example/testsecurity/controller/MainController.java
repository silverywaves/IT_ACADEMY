package com.example.testsecurity.controller;

/*  Authentication 객체를 만두 후, 이를 보유하고, 인증 정보를 검증하고, 사용자 인증 정보를 유지 관리, 사용자 권한 부여하기 위해 사용
    인증시 id와 password를 담고 인증 검증을 위해 전달되어 사용됨
    인증 성공시 사용자는 시스템에 대한 액세스 권한을 부여받고 SecurityContext에 저장되어 전역적으로 참조 가능

    principal : 사용자 아이디 혹은 User 객체 저장
    credentials : 사용자 비밀번호
    authorities : 인증된 사용자의 권한 목록
    details : 인증 부가 정보
    Authentication : 인증 여부

    *** 플로우
    1. 사용자가 username과 password를 입력하면 UsernamePasswordAuthenticationFilter에서 request를 받음
    2. usernamePasswordAuthenticatrionFilter는 그 정보로 Authentication 객체 생성(이 객체가 인증에 이용됨)
    3. AuthenticationManager가 Authentication 객체를 받아 인증 시도
    4. 인증에 성공하면 최종적으로 동일한 타입으로 Authentication 생성
    5. 최종적으로 생성된 Authentication 객체는 SecurityContextHolder>SecurityContext에 저장 -> 인증객체 전역적으로 사용 가능
* */


import org.springframework.security.core.Authentication;
// 사용자의 인증 정보를 나타내는 인터페이스
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.Iterator;

@Controller
public class MainController {

    @GetMapping("/")
    public String mainP(Model model){  // Model 인터페이스 선언해서 model 객체에 넣어주기

        // 사용자 아이디 체크
        String id = SecurityContextHolder.getContext().getAuthentication().getName();

        // 사용자의 롤값(어드민 or 일반유저) 검증
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Iterator<? extends GrantedAuthority> iter = authorities.iterator();
        GrantedAuthority auth = iter.next();
        String role = auth.getAuthority();

        model.addAttribute("id", id);
        model.addAttribute("role", role);


        return "main";
    }

}
