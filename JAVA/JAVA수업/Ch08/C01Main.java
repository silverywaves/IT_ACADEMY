package Ch08;

public class C01Main {

	public static void main(String[] args) {
		C01Person hong = new C01Person();	// C01Person 클래스 이용하여 참조변수 생성
		hong.name = "홍길동";
		hong.age = 55;
		hong.height = 177.5f;
		hong.weight = 70.4;
		System.out.printf("%s %d %f %f\n", hong.name, hong.age, hong.height, hong.weight);
		
		// new : 힙영역 메모리
	}
}
