package ch6;

class Product{
	static int count = 0;	// 생성된 인스턴스의 수를 저장하기 위한 변수
	int serialNo;			// 인스턴스 고유의 번호
	{
		++count;
		serialNo = count;	// Product 클래스의 인스턴스가 생성될때마다 count 값 1씩 증가 -> serialNo 에 저장
							// 만약, count 를 인스턴스 변수로 선언했다면 -> 인스턴스 생성시마다 0으로 초기화
							// => 모든 Product 인스턴스의 serialNo 값은 항상 1
	}
	public Product() {};	// 기본생성자(생략가능)
}

public class _31_ProductTest_멤버변수초기화 {

	public static void main(String[] args) {
		Product p1 = new Product();
		Product p2 = new Product();
		Product p3 = new Product();
		
		System.out.println("p1의 제품번호(serial no)는 " + p1.serialNo);
		System.out.println("p2의 제품번호(serial no)는 " + p2.serialNo);
		System.out.println("p3의 제품번호(serial no)는 " + p3.serialNo);
		System.out.println("생산된 제품의 수는 모두 " + Product.count + "개 입니다.");
	}

}
/*	멤버변수 초기화 시점 및 순서
 * 		- 클래스변수 : 클래스가 처음 로딩될 때 단 한 번 초기화
 * 					   기본값 -> 명시적초기화 -> 클래스 초기화 블럭
 * 		- 인스턴스 변수 : 인스턴스가 생성될때마다 각 인스턴스별로 초기화
 * 						  기본값 -> 명시적초기화 -> 인스턴스 초기화 블럭 -> 생성자
 * */
