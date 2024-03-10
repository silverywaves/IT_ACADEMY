package Ch08;

// 클래스 선언시 생성자함수를 1개이상 명시하게되면 디폴트생성자가 자동주입되지 않으니 주의

class C09Simple{
	int num;
	// 생성자 추가(초기값 입력)	=> 메인에서 Error 발생
	C09Simple(){}
	public C09Simple(int num){
		super();
		this.num = num;
	}
}

public class C09ConstructorMain {

	public static void main(String[] args) {
		C09Simple ob = new C09Simple();	// => Error : The constructor C09Simple() is undefined
	}

}
