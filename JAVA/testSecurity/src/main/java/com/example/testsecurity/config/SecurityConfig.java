package com.example.testsecurity.config;

/*  사용자의 요청 -> 컨트롤러
    WAS(사용자의 요청을 감시하고 통제하는 지점)의 필터단에서 요청을 가로챈 후 시큐리티의 역할 수행
    1. WAS 필터에 하나의 필터를 만들어 넣과, 해당 필터에서 요청을 가로챔
    2. 해당 요청은 스프링 컨테이너 내부에 구현되어 있는 스프링 시큐리티 감시 로직을 걸침
    3. 시큐리티 로직을 마친 후 다시 WAS의 다음 필터로 복귀
    
* */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration      // 이 클래스는 스프링부트한테 Configuration 클래스로 등록됨
@EnableWebSecurity  // Spring Security 한테서도 관리됨
public class SecurityConfig {

    // 사용자 인증(로그인)시 비밀번호에 대해 단방향 해시 암호화를 진행하여 저장되어 있는 비밀번호와 대조
    // -> 회원가입시 비밀번호 항목에 대해서 암호화를 진행
    // BCryptPasswordEncoder : 비밀번호를 암호화하는 데 사용할 수 있는 메서드를 가진 클래스


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain config(HttpSecurity http) throws Exception {
    /*  SecurityFilterChain : 일련의 과정들을 수행하는 필터들의 묶음 (여러개 가질 수 있음)
                            : 스프링 시큐리티 필터들의 묶음 -> 실제 시큐리티 로직이 처리되는 부분, FilterChianProcxy가 SecurityFileteChail 을 들고 있음
        * DelegatingFilterProxy : 스프링 Bean을 찾아 요청을 넘겨주는 서블릿 필터S
        * FilterChainProxy : 스프링 시큐리티 의존성을 추가하면 DelegatingFilterProxy에 의해 호출되는 SecurityFilterChain들을 들고있는 Bean
    * */
// 경로에 대한 인가작업
//        http
//                .authorizeHttpRequests(
//                        (auth) -> auth
//                                .requestMatchers("/*").permitAll()
//                                .requestMatchers("/", "/login", "/loginProc", "/join", "/joinProc").permitAll()
//                                .requestMatchers("/admin").hasRole("ADMIN")
//                                // /admin 이라는 경로에서 ADMIN 이라는 롤을 가지고 있으면 접근 가능하도록 설정
//                                .requestMatchers("/my/**").hasAnyRole("ADMIN", "USER")
//                                // 여러개의 유저아이디를 와일드카드로 설정
//                                .anyRequest().authenticated()   // 위에서 처리하지 못한 나머지 경로들을 처리
//                );

// 계층 권한(Role Hierarchy)
//    -> 권한 A, 권한 B, 권한 C가 존재하고 권한의 계층은 “A < B < C”라고 설정을 진행
//     ** 1. 기존방식
//        http
//                .authorizeHttpRequests((auth)->auth
//                        .requestMatchers("/login").permitAll()
//                        .requestMatchers("/").hasAnyRole("A","B","C")
//                        .requestMatchers("/manager").hasAnyRole("B","C")
//                        .requestMatchers("/admin").hasAnyRole("C")
//                        .anyRequest().authenticated()
//                );
//     ** 2. 계층 권한 메서드 등록(SecurityConfig 클래스 안)
//        @Bean
//        public RoleHierarchy roleHierarchy(){
//            RoleHierarchy hierarchy - new RoleHierarchy();
//            hierarchy.setHierarchy("ROLE_C > ROLE_B\n" +
//                    "ROLE_B" > "ROLE_A");
//            return hierarchy;
//        }

// 로그인 방식  1. formLogin  2. httpBasic
// 1. 폼로그인 작업
// : 로그인 페이지를 만든 후 내부에 폼태그를 작성해서 그 폼 태그에 아이디와 비밀번호를 넣은뒤 서버측으로 포스트 요청을 보내는 방식
        http
                .formLogin((auth)->{
                    auth.loginPage("/login");    // loginPage() : 우리가 커스텀해둔 로그인페이지 경로 설정 -> 자동으로 로그인페이지로 redirect
                    auth.loginProcessingUrl("/loginProc");
                        // loginProcessingUrl() : 로그인한 데이터를 특정한 경로(/loginProc)로 보냄
                        // -> 경로로 특정한 시큐리티가 오픈되어 프론트단에서 로그인 데이터를 넘기면 시큐리티가 받아서 로그인 처리 진행
                    auth.permitAll();
                });
// 2. httpBasic
// : 아이디와 비밀번호를 Base64 방식으로 인코딩한 뒤 HTTP 인증 헤더에 부착하여 서버측으로 요청을 보내는 방식
//        http
//                .httpBasic(Customizer.withDefaults());

// csrf 작업
        http
                .csrf((auth)->auth.disable());
        // Cross-Site-Request_Forgery : 요청을 위조하여 사용자가 원하지 않아도 서버측으로 특정 요청을 강제로 보내는 방식
        // 크로스 사이트 요청 위조 방지 설정이 동작되면 호스트 요청을 보낼때 csrf 토큰도 보내주어야 로그인 진행
        // 배포 환경에서는 csrf 공격 방지를 위해 csrf disable 설정을 제거하고 추가적인 설정을 진행
        // csrf.disable() 설정 x 시, enable 진행 -> POST, PUT, DELETE 요청에 대해 토큰 검증 진행
        // 앱에서 사용하는 API 서버의 경우 보통 세션을 STATELESS로 관리 -> 스프링 시큐리티 csrf enable 설정 진행하지 않아도 ok

// 다중 로그인 설정
        http
                .sessionManagement((auth) -> auth     // 메서드를 통한 설정 진행
                        .maximumSessions(1)         // 하나의 아이디에 대한 다중 로그인 허용 개수
                        .maxSessionsPreventsLogin(true));   // 다중 로그인 개수를 초과하였을 경우 처리 방법
// 세션 고정 공격을 보호하기 위한 로그인 성공시 세션 설정 방법                                                            // true : 새로운 로그인 차단 / false : 기존 세션 하나 삭제
        http
                .sessionManagement((auth) -> auth
                        .sessionFixation().changeSessionId());
        // sessionManagement().sessionFixation().none() : 로그인 시 세션 정보 변경 X
        // sessionManagement().sessionFixation().newSession() : 로그인시 세션 새로 생성
        // sessionMagagement().sessionFixation().changeSessionId() : 로그인시 동일한 세션에 대한 id 변경

// GET 방식 로그아웃 진행
        // csrf 설정시 POST 요청으로 로그아웃을 진행해야 하지만 아래 방식을 통해 GET 방식으로 진행가능
        http
                .logout((auth) -> auth.logoutUrl("/logout")
                        .logoutSuccessUrl("/"));

        return http.build();
    }

}



/*  permitAll() : 모든 사용자에게 로그인하지 않아도 접근할 수 있도록 허용하는 메서드
    hasRole() : 로그인한 후에 특정한 규칙이 있어야 접근 가능
    authenticated() : 로그인만 하면 모두 접근할 수 있는 메서드
    denyAll() : 모든 사용자가 접근하지 못하게 막는 메서드
    hasAnyRole() : 여러가지 롤을 설정 가능
* */

/*  참고  DB 연결 없이 소수 유저 정보 저장 : 회원가입 없는 InMemory 방식 사용
        => InMemoryUserManager 클래스 사용

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 = User.builder()
                .username("user1")
                .password(passwordEncoder().encode("1234"))
                .roles("admin")
                .build();
        UserDetails user2 = User.builder()
                .username("user2")
                .password(passwordEncoder().encode("1234"))
                .roles("admin")
                .build();
        return new InMemoryUserDetailsManager(user1,user2);
    }

* */
