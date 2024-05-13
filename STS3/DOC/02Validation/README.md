# VALIDATION


- 스프링 MVC에서 사용되는 데이터 바인딩과 유효성 검사를 수행하는 클래스
- 컨트롤러 메소드의 파라미터를 바인딩하고 유효성을 검사하는 역할
- 주로 폼 데이터를 처리하고 모델 객체에 바인딩하는 데 사용


```
@InitBinder: 컨트롤러 클래스 내부에 선언 -> 특정 컨트롤러에 대한 WebDataBinder 초기화 지정
주로 컨트롤러 클래스에 전역적으로 적용되는 초기화 작업을 수행할 때 사용

@ModelAttribute: 컨트롤러 메소드의 파라미터에 사용 -> 해당 파라미터를 모델에 추가하고 뷰에서 사용할 수 있게 함
폼 데이터를 모델 객체에 자동으로 바인딩할 때 주로 사용

@Valid: 컨트롤러 메소드의 파라미터에 사용 -> 해당 파라미터에 대한 유효성 검사를 지정
주로 모델 객체에 대한 유효성 검사를 수행할 때 사용

@Validated: 클래스나 그룹에 대한 유효성 검사를 수행하는 데 사용
주로 폼 데이터를 처리하는 DTO(Data Transfer Object)나 VO(Value Object)에 유효성 검사를 수행할 때 사용
```

의존처리(pom.xml)
---

```
		<dependency>
			<groupId>org.hibernate.validator</groupId>
			<artifactId>hibernate-validator</artifactId>
			<version>6.0.7.Final</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/javax.validation/validation-api -->
		<dependency>
    		<groupId>javax.validation</groupId>
    		<artifactId>validation-api</artifactId>
    		<version>2.0.1.Final</version>
		</dependency>
```


Validation 애노테이션 정리
---
```
숫자 유효성 검사:
  @Min(value, message): 숫자가 주어진 최솟값보다 큰지 확인
  @Max(value, message): 숫자가 주어진 최댓값보다 작은지 확인
  @Positive: 숫자가 양수인지 확인
  @PositiveOrZero: 숫자가 양수 또는 0인지 확인
  @Negative: 숫자가 음수인지 확인
  @NegativeOrZero: 숫자가 음수 또는 0인지 확인
문자열 유효성 검사:
  @NotBlank(message): 문자열이 비어 있지 않은지 확인
  @Size(min, max, message): 문자열의 길이가 주어진 범위 내에 있는지 확인
  @Email(message): 문자열이 유효한 이메일 주소인지 확인
  @Pattern(regexp, message): 정규 표현식에 맞는지 확인
  @URL(message): 문자열이 유효한 URL인지 확인
날짜와 시간 유효성 검사:
  @DateTimeFormat(pattern): 날짜와 시간의 형식을 지정
  @Future: 날짜가 미래인지 확인
  @FutureOrPresent: 날짜가 미래이거나 현재인지 확인
  @Past: 날짜가 과거인지 확인
  @PastOrPresent: 날짜가 과거이거나 현재인지 확인
기타:
  @AssertTrue: boolean 타입의 값이 true인지 확인
  @AssertFalse: boolean 타입의 값이 false인지 확인
  @CreditCardNumber: 신용카드 번호의 유효성을 검증
```



