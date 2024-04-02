package Ch31;


interface Printer{
//	String print(String message);	// 02
//	void print(String message);		// 01
//	void print2(String message);	// 함수형 인터페이스일때 함수가 하나만 들어가있어야 람다 사용가능
//	String print();					// 03 파라미터 x 반환자료형 필요
	void print(String message);		// 04
}
//class A implements Printer{
//
//	@Override
//	public void print(String message) {
//		
//	}
//	
//}
public class C02LAMDA {

	public static void main(String[] args) {
		// 01 한 라인에 문장을 끝내는 경우 {} 생략가능
//		Printer printer =(message)->{System.out.println(message);};
		
//		// 02 리턴형 ()->{} 구조 사용시 {} 안에 return 예약어 사용
//		Printer printer = (message)->{
//			System.out.println(message);
//			return message;
//			};
//			
//		// 02 리턴형 ()-> 구조 사용시 return 예약어 생략가능
//		Printer printer2 = (message)->message+"!";
//		String str = printer2.print("HELLOWORLD");
//		System.out.println(str);
		
		// 03 파라미터가 없는 경우
//		Printer printer = ()->"HELLOWORLD";		
//		String str = printer.print();
//		System.out.println(str);
		
		// 04 보류
//		Printer printer = (message)->System.out.println(message);	
//		Printer printer = (message)->System.out::println;
//		
//		printer.print("HELLO?");
	}
}
