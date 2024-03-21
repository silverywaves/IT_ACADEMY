package Ch16;

abstract class 팝콘재료{	// 재료 접근 제한(extends 걸어줌)
	
}

class 카라멜 extends 팝콘재료 {

	@Override
	public String toString() {
		return "카라멜 []";
	}
	
}

class 버터옥수수 extends 팝콘재료 {

	@Override
	public String toString() {
		return "버터옥수수 []";
	}
	
	
}

class PopCorn<T extends 팝콘재료>{
	private  T meterial;
	public PopCorn(T meterial) {
		this.meterial = meterial;
	}
	@Override
	public String toString() {
		return "PopCorn [meterial=" + meterial + "맛 팝콘]";
	}
	
}

public class C02GenericMain {

	public static void main(String[] args) {
		PopCorn<카라멜> ob1 = new PopCorn<카라멜>(new 카라멜());
		System.out.println(ob1);
		
		PopCorn<버터옥수수> ob2 = new PopCorn<버터옥수수>(new 버터옥수수());
		System.out.println(ob2);
	}
}
