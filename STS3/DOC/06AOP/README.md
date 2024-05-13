# AOP(Aspect Oriented Programming

- '관점' 지향프로그래밍 => 부수적인, 반복적으로 사용
-  어떤 로직을 기준으로 핵심적인 관점, 부가적인 관점으로 나누어서 보고 그 관점을 기준으로 각각 모듈화<br>
   (모듈화 : 어떤 공통된 로직이나 기능을 하나의 단위로 묶는 것)
  - 코드들을 부분적으로 나누어서 모듈화
  - 흩어진 관심사 (Crosscutting Concerns) : 소스 코드상에서 다른 부분에 계속 반복해서 쓰는 코드들
- 핵심로직 == 비즈니스로직
---
#### 용어

```
  Aspect : 위에서 설명한 흩어진 관심사를 모듈화 한 것. 주로 부가기능을 모듈화함.
  Target : Aspect를 적용하는 곳 (클래스, 메서드 .. )
  Advice : 실질적으로 어떤 일을 해야할 지에 대한 것, 실질적인 부가기능을 담은 구현체
  JointPoint : Advice가 적용될 위치, 끼어들 수 있는 지점. 메서드 진입 지점, 생성자 호출 시점, 필드에서 값을 꺼내올 때 등 다양한 시점에 적용가능
  PointCut : JointPoint의 상세한 스펙을 정의한 것. 'A란 메서드의 진입 시점에 호출할 것'과 같이 더욱 구체적으로 Advice가 실행될 지점을 정할 수 있음
```


# 스프링 AOP
- 프록시 패턴 기반의 AOP 구현체
	- 프록시 객체를 쓰는 이유 : 접근 제어 및 부가기능을 추가하기 위함
- 모든 AOP 기능을 제공하는 것이 아닌 스프링 IoC와 연동하여 엔터프라이즈 애플리케이션에서 가장 흔한 문제(중복코드, 프록시 클래스 작성의 번거로움, 객체들 간 관계 복잡도 증가 등)에 대한 해결책을 지원하는 것이 목적
---
#### 용어

```
  - Target : 핵심기능을 담고 있는 모듈, 부가기능을 부여할 대상
  - Advice : 어느 시점(ex. method의 수행 전/후, 예외 발생 후 등)에 어떤 공통 관심 기능(Aspect)을 적용할지 정의
  		target에 제공할 부가기능을 담고 있는 모듈
  - JoinPoint : Aspect가 적용될 수 있는 지점(method, field)
  		target 객체가 구현한 인터페이스의 모든 method == JoinPoint
  - Pointcut : 공통 관심 사항이 적용될 JoinPoint, Advice를 적용할 target의 method를 선별하는 정규 표현식
  		Pointcut 표현식은 execution으로 시작하고 method의 Signature를 비교하는 방법을 주로 이용
  - Aspect : Aspect = Advice + Pointcut
  		AOP의 기본 모듈, 싱글톤 형태의 객체로 존재, 여러 객체에서 공통으로 적용되는 공통 관심 사항(transaction, logging, security, ...)
  - Advisor : Advisor = Advice + pointcut  Spring AOP에서만 사용되는 특별한 용어
  - Weaving : 어떤 Advice를 어떤 Pointcut(핵심사항)에 적용시킬 것인지에 대한 설정(Advisor)
  		Pointcut에 의해 결정된 타겟의 JoinPoint에 부가기능(Advice)을 삽입하는 과정
  		AOP의 핵심기능(Target)의 코드에 영향을 주지 않으면서 필요한 부가기능(Advice)을 추가할 수 있도록 해주는 핵심적인 처리 과정
```
---
#### 포인트컷 표현식

```
	execution([접근제어자] 반환타입 패키지.패키지.패키지.패키지.클래스.메서드(인자))
	"execution(* com.example.app.domain.service.SimpleServiceImpl.get1())"
	
	excution : 메서드 실행
	* : 반환자료형(모든 리턴 타입)
	com.example.app.domain.service.SimpleServiceImpl.get1() : 실행할 함수 위치
```


# 애노테이션
```
  @Before (이전) : 어드바이스 타겟 메소드가 호출되기 전에 어드바이스 기능을 수행(반환값 void)
  @After (이후) : 타겟 메소드의 결과에 관계없이(즉 성공, 예외 관계없이) 타겟 메소드가 완료 되면 어드바이스 기능을 수행(반환값 void)
  @AfterReturning (정상적 반환 이후)타겟 메소드가 성공적으로 결과값을 반환 후에 어드바이스 기능을 수행
  @AfterThrowing (예외 발생 이후) : 타겟 메소드가 수행 중 예외를 던지게 되면 어드바이스 기능을 수행
  @Around (메소드 실행 전후) : 어드바이스가 타겟 메소드를 감싸서 타겟 메소드 호출전과 후에 어드바이스 기능을 수행(반환값 Object : 지정된 패턴에 해당하는 메소드의 실행 결과를 반환해야 함)
```

