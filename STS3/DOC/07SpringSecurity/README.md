# Spring Security
- 스프링 기반의 애플리케이션 보안(인증, 인가, 권한)을 담당하는 스프링 하위 프레임워크
```
  * 인증(Authentication)
    - 사용자의 신원을 입증하는 과정
    - ex. 아이디와 비밀번호를 입력하고 로그인하는 과정
  
  * 인가(Authorization)
    - 사용자의 권한을 확인하는 과정
    - ex. 권한 별로 접근할 수 있는 페이지가 상이함(관리자 페이지, 회원 페이지 등)
```
- 여러 보안 위협 방어 및 요청 헤더 보안 처리
- 세션 기반 인증 제공
- 필터 기반 동작

![image](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/186e1091-b132-45e9-a410-cf7ea0a4a309)

```
- UsernamePasswordAuthenticationFilterSecurityInterceptor
	: id, pw 넘어어오면 인증 요청을 위임하는 인증 관리자 역할
- FilterSecurityInterceptor
	: 권한 부여 처리를 위임해 접근 제어 결정을 쉽게하는 접근 결정 관리자 역할
```

|필터명|설명|
|-|-|
|SecurityContextPersistenceFilter|SecurityContextRepository에서 SecurityContext(접근 주체와 인증에 대한 정보를 담고 있는 객체)를 가져오거나 저장|
|LogoutFilter|설정된 로그아웃 URL로 오는 요청을 확인해 해당 사용자를 로그아웃 처리|
|UsernamePasswordAuthenticationFilter|인증관리자. 폼 기반 로그인시 사용되는 필터. ID&PW 데이터를 파싱하여 인증 요청 위임.<br>인증 성공시 AuthenticationSuccessHandler, 실패시 AuthenticationFailureHandler 실행|
|DefaultLoginPageGeneratingFilter|사용자가 로그인 페이지를 따로 지정하지 않았을 때 기본으로 설정하는 로그인 페이지 관련 필터|
|BasicAuthenticationFilter|요청 헤더에 있는 ID&PW 데이터를 파싱하여 인증 요청 위임.<br>인증 성공시 AuthenticationSuccessHandler, 실패시 AuthenticationFailureHandler 실행|
|RequestCacheAwareFilter|로그인 성공 후, 관련있는 캐시 요청이 있는지 확인하고 캐시 요청 처리|
|SecurityContextHolderAwareRequestFilter|HttpServletRequest 정보를 감싸 필테 체인 상의 다음 필터들에게 부가 정보 제공|
|AnonymousAuthenticationFilter|필터가 호출되는 시점까지 인증되지 않았다면 익명 사용자 전용 객체인 AnonymousAuthentication을 만들어 SecurityContext에 넣음|
|SessionManagementFilter|인증된 사용자와 관련된 세션 작업 진행. 세션 변조 방지 전략 설정, 유효하지 않은 세션에 대한 처리, 세션 생성 전략을 세우는 등의 작업 처리|
|ExceptionTranslationFilter|요청을 처리하는 중에 발생할 수 있는 예외를 위임하거나 전달|
|FilterSecurityInterceptor|접근 결정 관리자. AccessDecisionManager로 권한 부여 처리 위임하여 접근 제어 결정을 쉽게 함.<br>해당 과정에서 이미 사용자 인증이 되어있으므로 유효한 사용자인지 확인 및 인가 관련 설정 가능|

## 인증 처리 과정
![image](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/02ce6354-72d6-43d4-a484-7a8989c7e6ce)


1. 사용자가 폼에 id, pw 입력시 HTTPServletRequest에 id, pw 정보가 전달됨<br>
   → AuthenticationFilter가 넘어온 id, pw 유효성 검사 실시<br>
   
2. 유효성 검사 후 실제 구현체인 UsernamePasswordAuthenticationToken 생성 후 넘김<br>

3. 인증용 객체인 UsernamePasswordAuthenticationToken을 AutneticationManager에게 전달<br>

4. UsernamePasswordAuthenticationToken을 AuthenticationProvider에게 전달<br>

5. 사용자 아이디를 UserDetailsServcie로 보냄<br>
   → UserDetailService는 사용자 아이디로 찾은 사용자의 정보를 UserDetails 객체로 만들어 AuthenticationProvider에게 전달<br>
   
6. DB에 있는 사용자 정보 가져옴<br>

7. 입력정보와 UserDetails 정보를 비교해 실제 인증 처리 진행
 
8. 인증 완료시 SecurityContextHolder에 Authentication 저장<br>
	- 인증 성공시 AuthenticationSuccessHandler 실행<br>
	- 인증 실패시 AuthenticationFailureHandler 실행<br>

<br>

---

# 실습
### 1. pom.xml 추가 후 maven update project
spring-security-core / spring-security-web / spring-security-config / spring-security-taglibs

<br>

### 2. web.xml 에 security filter 추가
```
	<filter>
	        <filter-name>springSecurityFilterChain</filter-name>
	        <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
	</filter>
	    
	<filter-mapping>
	        <filter-name>springSecurityFilterChain</filter-name>
	        <url-pattern>/*</url-pattern>
	</filter-mapping> 
```

<br>

### 3. SecurityConfig 클래스 추가
- @Configuration @EnableWebSecurity
- extends WebSecurityConfigurerAdapter

<br>

### 4. 우클릭 source -> @Override Method : configure(HttpSecurity) 
- 권한 부여 및 로그인/아웃 코드 작성
```
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private PrincipalDetailsService principalDetailsService;
	
	//웹요청 처리 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//CSRF TOKEN 비활성화
		http.csrf().disable();
		
		//CSRF TOKEN을 쿠키로 전달(개발자도구(F12) 확인)
		//http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
		
		
		http.authorizeRequests()
			.antMatchers("/","/join").permitAll()
			.antMatchers("/user").hasRole("USER") 		//ROLE_USER
			.antMatchers("/member").hasRole("MEMBER") 	//ROLE_MEMBER
			.antMatchers("/admin").hasRole("ADMIN") 	//ROLE_ADMIN
			.anyRequest().authenticated();
					
//		//로그인
		http.formLogin()
			.loginPage("/login")
			.permitAll();
		
//		
//		//로그아웃
		http.logout()
			.logoutUrl("/logout")
			.permitAll();
	}
```

> method 정리
- 

<br>

### 5. SecurityTestController 클래스 추가
- @Controller @Slf4j
- @GetMapping 으로 user, manager, admin 메서드 추가 후 로그 출력

<br>

### 6. view 추가
- user page, manager page, admin page

<br>

### 7. SecurityConfig에서 우클릭 source -> configure(AuthenticationManagerBuilder)
- USER, MANAGER, ADMIN 계정 추가
```
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication()
			.withUser("user")
			.password("1234")
			.roles("USER");
		
		auth.inMemoryAuthentication()
			.withUser("manager")
			.password("1234")
			.roles("MANAGER");
		
		auth.inMemoryAuthentication()
			.withUser("admin")
			.password("1234")
			.roles("ADMIN");
		
	}
```
- 로그인해보면 오류발생(패스워드 불일치) => 암호화 필요
![image](https://github.com/silverywaves/IT_ACADEMY/assets/155939946/e69473dc-57d0-41bc-97e8-374bcb7fae89)

> SecurityConfig.java
```
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
```
- pw 암호화 진행
```
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication()
			.withUser("user")
			.password(passwordEncoder.encode("1234"))
			.roles("USER");
		
		auth.inMemoryAuthentication()
			.withUser("manager")
			.password(passwordEncoder.encode("1234"))			
			.roles("MANAGER");
		
		auth.inMemoryAuthentication()
			.withUser("admin")
			.password(passwordEncoder.encode("1234"))
			.roles("ADMIN");
		
	}
```

<br>

### 8. 커스텀뷰페이지 작성을 위해 csrf 잠깐 끄기(켠 상태라면 모든 폼에 csrf 추가해야함)
```
protected void configure(HttpSecurity http) throws Exception {
	http.csrf().disable();
	...(생략)
}
```

<br>

### 9. 로그인/아웃 url 매핑
```
		// 로그인
		http.formLogin()
			.loginPage("/login")
			.permitAll();
		
		// 로그아웃
		http.logout()
			.logoutUrl("/logout")
			.permitAll();
```

<br>

### 10. UserController 에 login 메서드 추가
```
@GetMapping("/login")
	public void login() {
		log.info("GET /login");
	}
```

<br>

### 11. login  viewPage 생성
```
<form action="${pageContext.request.contextPath}/login" method="post">
	<input name="username"><br>
	<input name="password"><br>
	<button>LOGIN</button>

	<!-- CSFR TOKEN 전달 -->
	<%-- <input type="hidden" name="_csrf" value="${_csrf.token}"/> --%>
</form>
```

<br>

---
## ***** DB에 저장된 정보 가져와서 검증해보기 *****
### 1. join.jsp 수정(username, password만 남기기)

<br>

### 2. UserMapper interface 생성 및 UserDto와 UserController 수정 후 DB에 저장 잘되는지 확인하기
- UserMapper
```
@Mapper
public interface UserMapper {

	@Insert("insert into user values(#{username},#{password}, 'ROLE_USER')")
	public void Insert(UserDto userDto);
}
```
- UserDto
```
@Data
public class UserDto {
	@NotBlank(message="username을 입력하세요")
	private String username;
	@NotBlank(message="password을 입력하세요")
	private String password;
}
```
- UserController
```
@Autowired
	UserMapper userMapper;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostMapping("/join")
	public String join_post(@Valid UserDto userDto,BindingResult bindingResult ,Model model) {
		log.info("POST /join..."+userDto);	
		
		if(bindingResult.hasFieldErrors()) {
			//log.info("ValidationCheck Error : "+bindingResult.getFieldError("id").getDefaultMessage());
			for(FieldError error  :bindingResult.getFieldErrors()) {
				log.info("ErrorField : " + error.getField() + " ErrorMsg : " + error.getDefaultMessage());
				model.addAttribute(error.getField(),error.getDefaultMessage());
			}
		}
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		userMapper.Insert(userDto);
		
		return "redirect:/login";
	}	
```

<br>

### 3. config/auth/PrincipalDetails.java 생성
- @Data @NoArgsConstructor @AllArgsConstructor
- implements UserDetails -> add unimplemented methods
```
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrincipalDetails implements UserDetails {

	private UserDto userDto;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return userDto.getPassword();
	}

	@Override
	public String getUsername() {
		return userDto.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}

```

> UserDetails 클래스

|메서드|설명|
|-|-|
|getAuthorities()|사용자가 가지고 있는 권한 목록 반환|
|getUsername()|사용자를 식별할 수 있는 사용자 이름 반환<br>사용되는 값은 반드시 고유해야 함|
|getPassword()|사용자의 비밀번호 반환<br>반드시 암호화해서 저장|
|isAccountNonExpired()|계정이 만료되었는지 확인<br>만료되지 않았을 시 true 반환|
|isAccountNonLocked()|계정이 잠금되었는지 확인<br>잠금되지 않았을 시 true 반환|
|isCredentialsNonExpired()|비밀번호가 만료되었는지 확인<br>만료되지 않았을 시 true 반환|
|isEnabled()|계정이 사용 가능한지 확인<br>사용 가능할 시 true 반환|

<br>

### 4. config/auth/PrincipalDetailsService.java 생성
- @Service
- implements UserDetailsService -> add unimplemented methods
```
@Service
public class PrincipalDetailsService implements UserDetailsService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return null;
	}
```

<br>

### 5. UserMapper에 SelectOnt 함수 추가
```
	@Select("select * from user where username=#{username}")
	public UserDto SelectOne(String username);
```

<br>

### 6. PrincipalDetailsService's loadUserByUsername 완성
```
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("PrincipalDetailsService's loadUserByUsername invoke.. username : " + username);
		UserDto userDto = userMapper.SelectOne(username);
		if(userDto==null) {
			throw new UsernameNotFoundException(username);
		}
		return new PrincipalDetails(userDto);
	}
```

<br>

### 7. SecurityConfig 수정
```
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
//		auth.inMemoryAuthentication()
//			.withUser("user")
//			.password(passwordEncoder.encode("1234"))
//			.roles("USER");
//		
//		auth.inMemoryAuthentication()
//			.withUser("manager")
//			.password(passwordEncoder.encode("1234"))			
//			.roles("MANAGER");
//		
//		auth.inMemoryAuthentication()
//			.withUser("admin")
//			.password(passwordEncoder.encode("1234"))
//			.roles("ADMIN");
		
		auth.userDetailsService(principalDetailsService)
			.passwordEncoder(passwordEncoder);
		
	}
```

<br>

### 8. PrincipalDetails's getAuthorities 완성시키기
```
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collection = new ArrayList();
		collection.add(new GrantedAuthority() {

			@Override
			public String getAuthority() {
				return userDto.getRole();
			}
			
		});
		return collection;
	}
```


---
## ***** 로그인 성공 핸들러 추가 *****
###  1. SecurityConfig 내용 추가
```
		// 로그인
		http.formLogin()
			.loginPage("/login")
			.permitAll()
			.successHandler(new CustomLoginSuccessHandler());
```

<br>

### 2. config/auth/loginHandler/CustomLoginSuccessHandler.java 생성 후 확인 -> admin, manager, user 계정 생성 후 권한 잘뜨는지 확인하기
```
@Slf4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		log.info("CustomLoginSuccessHandler's onAuthenticationSuccess : "+authentication);
		Collection<? extends GrantedAuthority> collection = authentication.getAuthorities();
		
		collection.forEach(role->{
			
			log.info("ROLE : " + role.getAuthority());
			String role_str = role.getAuthority();

			try {
				// 권한이 둘 이상일 경우 고려하지 않은 상태임
				if(role_str.equals("ROLE_USER")){
					response.sendRedirect(request.getContextPath()+"/user");
					return ;
				} else if(role_str.equals("ROLE_MANAGER")) {
					response.sendRedirect(request.getContextPath()+"/manager");
					return ;
				} else {
					response.sendRedirect(request.getContextPath()+"/admin");
					return ;
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		});

	}

}
```

---
## ***** 사용자정보 뷰로 전달 *****
### 1. controller에 Authentication 연결하는 방법
- SecurityTestController.java
```
@Controller
@Slf4j
public class SecurityTestController {

	@GetMapping("/user")
	public void user(Authentication authentication, Model model) {	// controller에 Authentication 연결
		log.info("GET /user.. authentication : "+authentication);
		log.info("name : "+authentication.getName());
		log.info("principal : "+authentication.getPrincipal());
		log.info("authorities : "+authentication.getAuthorities());
		log.info("details : "+authentication.getDetails());
		log.info("credential : "+authentication.getCredentials());
		
		// Model로 전달
		model.addAttribute("authentication",authentication);
		
		model.addAttribute("name",authentication.getName());
		model.addAttribute("principal",authentication.getPrincipal());
		model.addAttribute("isAuthenticated",authentication.isAuthenticated());
	}
```
- user.jsp
```
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body class="m-2 p-2">
<h1>
	USER PAGE
</h1><hr>
${authentication}
<hr>
${name}
<hr>
${principal}
<hr>
${isAuthenticated}
</body>
</html>
```

<br>

### 2. Authentication 가져오는 방법
- SecurityTestController.java
```
	@GetMapping("/manager")
	public void manager(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute(authentication);
		
		log.info("GET /manager..");
	}
```
- manager.jsp
```
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	MANAGER PAGE
</h1><hr>
${authentication }
</body>
</html>
```

<br>

### 3. controller에서는 작업x, 뷰에서 바로 처리
- jsp에서 spring security tag library를 사용하기 위한 준비
```
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
```
- admin.jsp
```
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
	<title>MEMO</title>
	
</head>
<body class="m-2 p-2">
		
		<h1>ADMIN PAGE</h1>
		
		PRINCIPAL : <sec:authentication property="principal" /> <br>
		USERDTO : <sec:authentication property="principal.userDto" /><br>
		USERNAME : <sec:authentication property="principal.userDto.username" /><br>
		ROLE : <sec:authentication property="principal.userDto.role" /><br>
		ISAUTHENTICATED : <sec:authorize access="isAuthenticated()">LOGINED...</sec:authorize>
</body>
</html>
```

---
## ***** 로그인 실패 핸들러 추가 *****
###  1. SecurityConfig 내용 추가
> SecurityConfig.java
```
//		//로그인
		http.formLogin()
			.loginPage("/login")
			.permitAll()
			.successHandler(new CustomLoginSuccessHandler())
			.failureHandler(new CustomAuthenticationFailureHandler());
```

<br>

### 2. config/auth/loginHandler/CustomAuthenticationFailureHandler 생성
- implements AuthenticationFailureHandler 
- add unimplemented methods
- 로그인 실패 내용 띄우고 이동할 경로 설정
> CustomAuthenticationFailureHandler.java
```
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		System.out.println("로그인 실패 : " + exception);
		
		// 실패시 이동할 경로
		response.sendRedirect(request.getContextPath()+"/login?error="+exception.getMessage());
		
	}

}
```
  
> UserController.java
```
	@GetMapping("/login")
	public void login(Exception exception) {
		log.info("GET /login.."+exception);
	}
```

---
## ***** 로그아웃 핸들러 추가 *****
###  1. SecurityConfig 내용 추가
> SecurityConfig.java
```
//		//로그아웃
		http.logout()
			.logoutUrl("/logout")
			.permitAll()
			.addLogoutHandler(new CustomLogoutHanlder());
```

<br>

### 2. config/auth/loginHandler/CustomLogoutHanlder 생성
- implements LogoutHandler 
- add unimplemented methods
```
public class CustomLogoutHanlder implements LogoutHandler {

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {

		System.out.println("CusdtomLogoutHandler's logout() invoke..");

		// 세션 초기화
		HttpSession session = (HttpSession)request.getSession(false);
		if(session!=null)
			session.invalidate();
		
	}

}
```

---
## ***** 로그아웃 성공 핸들러 추가 *****
###  1. SecurityConfig 내용 추가
```
//		//로그아웃
		http.logout()
			.logoutUrl("/logout")
//			.logoutSuccessUrl("/")	// logoutSuccessHandler와 같이 logoutSuccessHandler를 적용시 우선적용
			.permitAll()
			.addLogoutHandler(new CustomLogoutHanlder())
			.logoutSuccessHandler(new CustomLogoutSuccessHandler());
	}
```

<br>

### 2. config/auth/loginHandler/CustomLogoutSuccessHandler 생성
- implements LogoutSuccessHandler 
- add unimplemented methods
> CustomLogoutSuccessHandler
```
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {

		System.out.println("CustomLogoutSuccessHandler's onLogoutSuccess) invoke..");
		response.sendRedirect(request.getContextPath());
	}

}
```

---
## ***** 예외 핸들러 추가 *****
###  1. SecurityConfig 내용 추가
```
	//예외처리
	http.exceptionHandling()
		.authenticationEntryPoint(new CustomAthenticationEntryPoint())	// 미인증 사용자를 처리
		.accessDeniedHandler(new CustomAccessDeniedHandler());		// 접근 권한 실패시 예외처리
```

<br>

### 2. config/auth/exception/CustomAccessDeniedHandler 생성
- implements AccessDeniedHandler 
- add unimplemented methods
> CustomAccessDeniedHandler
```
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		
		System.out.println("CustomAccessDeniedHandler's handle() invoke.. ex : "+accessDeniedException);
		request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
	}

}
```

<br>

### 3. config/auth/exception/CustomAthenticationEntryPoint 생성
- implements AuthenticationEntryPoint 
- add unimplemented methods
> CustomAthenticationEntryPoint
```
public class CustomAthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {

		System.out.println("CustomAthenticationEntryPoint's commence() invoke.. err : "+authException);

		request.setAttribute("msg","인증이 필요한 페이지입니다.");
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

}
```

> CustomAuthenticationFailureHandler
```
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		System.out.println("로그인 실패 : " + exception);
		
		request.setAttribute("msg","로그인 실패.. ID/PW 확인하세요");
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		
	}

}
```

> login.jsp
```
<form action="${pageContext.request.contextPath}/login" method="post">
	<input name="username"><br>
	<input name="password"><br>
	<button>LOGIN</button>
	
	<!-- CSFR TOKEN 전달 -->
	<%-- <input type="hidden" name="_csrf" value="${_csrf.token}"/> --%>
	
	MSG : ${msg }<br>
</form>
```

---
## ***** 자동로그인(Local 방식) *****
###  1. SecurityConfig 내용 추가
> SecurityConfig
```
	//REMEMBER_ME
	http.rememberMe()
		.key("rememberMeKey")
		.rememberMeParameter("remember-me")
		.alwaysRemember(false)
		.tokenValiditySeconds(60*60)
		.tokenRepository(null);
```

<br>

###  2. 뷰페이지 자동로그인 체크박스 생성
> login.jsp
```
<form action="${pageContext.request.contextPath}/login" method="post">
	<input name="username"><br>
	<input name="password"><br>
	<input type="checkbox" name="remember-me"/>REMEMBER_ME<br>
	<button>LOGIN</button>
	
	<!-- CSFR TOKEN 전달 -->
	<%-- <input type="hidden" name="_csrf" value="${_csrf.token}"/> --%>
	
	MSG : ${msg }<br>
</form>
```

<br>

###  3. @Bean 생성
> SecurityConfig.java
```
	@Autowired
	private DataSource dataSource3;
	
	@Bean
	public PersistentTokenRepository tokenRepository() {
		JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
		repo.setDataSource(dataSource3);
		return repo;
	}
```

<br>

###  4. ID/PW 저장을 위한 DB 테이블 생성
> JdbcTokenRepositoryImpl 컨트롤+클릭해서 함수 살펴보기 → sql문 복사해서 워크벤치에서 추가
```
	/** Default SQL for creating the database table to store the tokens */
	public static final String CREATE_TABLE_SQL = "create table persistent_logins (username varchar(64) not null, series varchar(64) primary key, "
			+ "token varchar(64) not null, last_used timestamp not null)";
```

<br>

###  5. DB 연결
> SecurityConfig 에 등록
```
		//REMEMBER_ME
		http.rememberMe()
			.key("rememberMeKey")
			.rememberMeParameter("remember-me")
			.alwaysRemember(false)
			.tokenValiditySeconds(60*60)
			.tokenRepository(tokenRepository());
```

