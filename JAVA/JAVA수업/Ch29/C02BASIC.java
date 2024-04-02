package Ch29;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class C02BASIC {

	
	public static void main(String[] args) throws Exception {
	
		Class<?> clazz = Class.forName("java.lang.String");
			
		Field[] fields = clazz.getDeclaredFields();  // 클래스가 가진 모든 필드들 반환
		
		for(Field field : fields) {
			System.out.println(field);
		}
		System.out.println("===========================================");
		
		Method[] methods = clazz.getDeclaredMethods();  // 메서드 접근
		for(Method method : methods) {
			System.out.println(method);
		}
		
		System.out.println("===========================================");
		Constructor[] constructors = clazz.getDeclaredConstructors();	// 생성자 접근
		for(Constructor constructor : constructors) {
			System.out.println(constructor);
		}
		
	}
}
