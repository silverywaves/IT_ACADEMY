package Ch11;

//디자인패턴 ? 무엇인가 만들때 반복되는 형태

class Company{
	int n1;
	int n2;
	// 싱글톤 패턴 코드
	private static Company instance;
	private Company() {}	// 생성자 접근 제한 -> 이 클래스에서만 생성 가능
	public static Company getInstance() {
		if(instance == null)
			instance = new Company();
		return instance;
	}
	@Override
	public String toString() {
		return "Company [n1=" + n1 + ", n2=" + n2 + "]";
	}
	
}



public class C03SingleTonPatternMain {
	
	public static void main(String[] args) {
		Company com1 = Company.getInstance();
		Company com2 = Company.getInstance();
		com1.n1=100; com1.n2=200;
		
		System.out.println(com2);		// Company [n1=100, n2=200]
	}
}
