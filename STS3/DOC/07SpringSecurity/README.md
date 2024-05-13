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

```
SecurityConfig 에 추가
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
## ***** 핸들러 추가 *****
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
					response.sendRedirect(request.getContextPath()+"/admin");
					return ;
				} else if(role_str.equals("ROLE_MANAGER")) {
					response.sendRedirect(request.getContextPath()+"/manager");
					return ;
				} else {
					response.sendRedirect(request.getContextPath()+"/user");
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




