package Ch15;

public class C04ExceptionMain {
	
	public static void main(String[] args) {
		// 예외처리 한번에 하기
		
		try {
			String str = null;
//			str.toString();				// null 예외발생
			
			int arr[] = {10,20,30};
			arr[5] = 100;				// Bound Exception 발생
		
			Integer.parseInt("a1234");	// Parse Exception 발생
		
			Animal animal = new Dog();
			Cat yummi = (Cat)animal;	// Cast Exception 발생
//		} catch(NullPointerException e) {
//			System.out.println("NULL 예외발생 처리");
//		} catch(ArrayIndexOutOfBoundsException e2) {
//			System.out.println("ARRAY BOUNDS 예외발생 처리");			
//		} catch(NumberFormatException e3) {
//			System.out.println("Number Format Exception 예외발생 처리");				
//		} catch(ClassCastException e4) {
//			System.out.println("Class Cast Exception 예외발생 처리");							
//		}
		} catch(Exception e) {		// 업캐스팅 - Exception 하위 모두 연결 (하위클래스 조회 : Ctrl+t)
			System.out.println(e);
		} finally {					// finally : DB 연결시 & resource(자원) 관리할때 사용
			System.out.println("무조건 실행되는 코드");
		}
	}
}
