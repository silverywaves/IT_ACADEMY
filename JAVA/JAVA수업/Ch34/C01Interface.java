package Ch34;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 사용자 정의 애노테이션 C01Interface 정의
// 클래스나 메소드에 적용 가능, 런타임까지 애노테이션 정보 유지

@Retention(RetentionPolicy.RUNTIME)		// 애노테이션의 유지시간지정(메타 애노테이션)
										// RetentionPolicy.RUNTIME: 런타임까지 애노테이션 정보를 유지(실행 중에 리플렉션을 통해 애노테이션 정보를 조회 가능)
										// RetentionPolicy.SOURCE : 컴파일시에만 동작
@Target({ElementType.TYPE, ElementType.METHOD})	// 애노테이션 적용대상을 메소드로 지정
public @interface C01Interface {		// 애노테이션용 인터페이스

	String value() default "";		// 애노테이션의 기본 속성 value 정의 : 문자열 값 가짐(기본 값 = 빈 문자열)
	int number() default 0;			// 애노테이션의 number 속성 정의 : 정수 값 가짐(기본 값 = 0)
	
}
