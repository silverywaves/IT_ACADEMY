package hello.hellospring.service;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // => 스프링이 뜰 때 이 Configuration을 읽고 스프링 빈에 등록하라는 뜻으로 인식함
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());     // 해당 로직을 호출하여 스프링빈에 등록함
        // Ctrl + p 로 파라미터 확인 => 스프링빈에 있는 멤버리포지토리
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();    // MemoryMemberRepository 가 구현체 (MemberRepository 는 인터페이스)
    }
    // => memberService() 와 memberRepository() 둘 다 스프링빈에 등록
    // => 스프링빈에 등록되어있는 memberRepository를 MemberService에 넣어줌
}
