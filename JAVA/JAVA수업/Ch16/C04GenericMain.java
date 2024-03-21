package Ch16;

class C04animal{
	
}

class Tiger extends C04animal{
	String name;
	// 생성자
	public Tiger(String name) {
		super();
		this.name = name;
	}
	// toStirng
	@Override
	public String toString() {
		return "Tiger [name=" + name + "]";
	}
}

class Panda extends C04animal{
	String name;
	// 생성자
	public Panda(String name) {
		super();
		this.name = name;
	}
	// toStirng
	@Override
	public String toString() {
		return "Panda [name=" + name + "]";
	}
}

public class C04GenericMain {

	// Generic => 다운캐스팅 필요 X, 규격화에 좋음
	public static <T extends C04animal> void PrintInfo(T[] arr) {		// 반환자료형 앞에 어떤 제너릭 타입을 쓸지 명시
		for(T el: arr)
			System.out.println(el);
	}	
	
	// Object
	public static void PrintInfo2(Object[] arr) {
		for(Object el : arr) {
			System.out.println(el);
			if(el instanceof Tiger) {
				Tiger down = (Tiger)el;
			}
		}
	}
	
	public static void main(String[] args) {
		Tiger[] arr = {new Tiger("시베리안호랑이"), new Tiger("호랭이"), new Tiger("호호호")};
//		PrintInfo(arr);
		Panda[] arr2 = {new Panda("중국팬더"), new Panda("래서팬더")};
//		PrintInfo(arr2);
		Object[] arr3 = {new Tiger("호랭랭"), new Panda("팬더다")};		// 최상위클래스에서 하위클래스 받는상태
//		PrintInfo(arr3);	// error :  확장된 타입 접근 불가
		PrintInfo2(arr3);
		
	}
}






