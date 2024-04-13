package Ch33;

import java.util.HashMap;
import java.util.Map;

class Person{
	private String name;
	private Integer age;
	// 디폴트 생성자
	Person(){
		System.out.println("디폴트 생성자 호출");
	}
	// name 받는 생성자
	Person(String name){
		this.name = name;
		System.out.println("Person(String name) 생성자 호출");
	}	
	// name, age 받는 생성자
	Person(String name, Integer age){
		this.name = name;
		this.age = age;
		System.out.println("Person(String name, Integer age) 생성자 호출");
	}
	
	// 메서드 참조(::) 활성화를 위한 Object 를 받는 생성자
	Person(Object obj){
		Map<String, String> map = (Map<String, String>)obj;	// Map 형태 들어온다고 가정
		String name = map.get("name");	
		int age = Integer.parseInt(map.get("age"));
		this.name = name;
		this.age = age;
		System.out.println("Person(Object obj) 생성자 호출");
	}
	
	// toString 재정의
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}

interface Printer1<T>{
	void show(T message);
}

interface Printer2<T>{
	T show(T obj);
}

interface Printer3<T>{
	T show(Object param);
}

public class C05MAIN {

	public static void main(String[] args) {
		
		// Printer1 인터페이스를 이용하여 문자열 출력
//		Printer1<String> func1 = (m)->{System.out.println(m);};
//		Printer1<String> func1 = m->System.out.println(m);
//		Printer1<String> func1 = System.out::println;	// 메서드참조 '::' => 인스턴스명::메서드명(or new)
//		-> 함수인터페이스의 형태 중 반환자료형이 있다면 사용 불가. 즉, 조건 함수의 반환자료형이 void 여야만 사용 가능
//		func1.show("HELLO WORLD");
	
		// Printer2 인터페이스를 이용하여 문자열을 대문자로 변환
//		Printer2<String> func2 = (str)->{return str.toUpperCase();};
//		Printer2<String> func2 = str->str.toUpperCase();
//		Printer2<String> func2 = String::toUpperCase;
//		String r1 = func2.show("hello");
//		System.out.println(r1);
		
		// Printer2 인터페이스를 이용하여 문자열을 복사하여 반환
//		Printer2<String> func3 = (str)->{return new String(str);};
//		Printer2<String> func3 = String::new;	// 생성자 호출을 통해 객체 생성해서 반환
//		String r2 = func3.show("HAHAHAHAHAHA");
//		System.out.println(r2);
		
		// Printer3 인터페이스를 이용하여 Map을 Person 객체로 변환
//		Printer3<Person> func4 = (obj)->{return new Person(obj);};
		Printer3<Person> func4 = Person::new;
		Map<String, String> params = new HashMap();
		params.put("name", "홍길동");
		params.put("age", "55");
		Person ob1 = func4.show(params);
		System.out.println(ob1);
		
	}
}




