package Ch29;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class TEST{
	String name;
	String addr;
	int age;
	
	// 생성자
	public TEST(){}
	public TEST(String name){this.name = name;}
	public TEST(String name, String addr){this.name=name;this.addr=addr;}
	
	// getter and setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getAge() {
		System.out.println("GETAGE FUNC");
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	// toString 
	@Override
	public String toString() {
		return "TEST [name=" + name + ", addr=" + addr + ", age=" + age + "]";
	}
	
	
}

public class C01Basic {

	public static void main(String[] args) throws Exception {
	
		Class<?>clazz = Class.forName(String.valueOf(TEST.class).split(" ")[1]);
		// 사용할 ClassObject를 forName 메서드를 통해 전달받기
		
//		System.out.println(TEST.class);
		
		// 클래스의 필드 정보 확인
//		Field[] fields = clazz.getFields();
//		for(Field field : fields) {
//			System.out.println(field);
//		}
		
		Method method = clazz.getDeclaredMethod("getAge",null);
		// getMethod 로 Method 정보 받아오기
		System.out.println("method : "+method);
		Object result = method.invoke(new TEST(), null);	
		// 메서드 동적 실행 : invoke(부르다)
		// invoke(메서드를 실행할 객체-new로 생성, 메서드의 파라미터값)
	
		Constructor<?> constructor = clazz.getConstructor(String.class); 	// 생성자 호출
		System.out.println("생성자 : " + constructor);
		
		Object obj = constructor.newInstance("홍길동");
		
		System.out.println("INSTANCE : " + obj);
		
		Field field = clazz.getDeclaredField("addr");
		TEST ob = new TEST();
		field.set(ob, "대구");
		System.out.println(ob);
		
	}
}




