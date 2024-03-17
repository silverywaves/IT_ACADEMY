package ch7;

class A42{
	void autoPlay(I i) {
		i.play();
	}
}

interface I {
	public abstract void play();
}

class B42 implements I{
	public void play() {
		System.out.println("play in B class");
	}
}

class C42 implements I{
	public void play() {
		System.out.println("play in C class");
	}
}

public class _42_InterfaceTest2 {

	public static void main(String[] args) {
		A42 a = new A42();
		a.autoPlay(new B42());	// play in B class / void autoPlay(I i) 호출
		a.autoPlay(new C42());	// play in C class / void autoPlay(I i) 호출
	}
}
