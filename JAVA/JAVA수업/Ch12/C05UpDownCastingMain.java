package Ch12;

// 상속관계 생성
// 		 A		
//	  B    C		// B 와 C 는 상속 관계 X	
//  D  E  F  B		

class A {
	int a;
	// 생성자
	public A(int a) {
		super();
		this.a = a;
	}
	// toString 
	@Override
	public String toString() {
		return "A [a=" + a + "]";
	}
}
class B extends A {
	int b;
	// 생성자
	public B(int a, int b) {
		super(a);
		this.b = b;
	}
	// toString : 하위 상속필드(inherited fields) 같이 선택
	@Override
	public String toString() {
		return "B [b=" + b + ", a=" + a + "]";
	}
}
class C extends A {
	int c;

	public C(int a, int c) {
		super(a);
		this.c = c;
	}
	@Override
	public String toString() {
		return "C [c=" + c + "]";
	}
}
class D extends B {
	int d;

	public D(int a, int b, int d) {
		super(a, b);
		this.d = d;
	}
	@Override
	public String toString() {
		return "D [d=" + d + ", b=" + b + ", a=" + a + "]";
	}
}
class E extends B {
	int e;
	
	public E(int a, int b, int e) {
		super(a, b);
		this.e = e;
	}
	@Override
	public String toString() {
		return "E [e=" + e + ", b=" + b + ", a=" + a + "]";
	}
}
class F extends C {
	int f;

	public F(int a, int c, int f) {
		super(a, c);
		this.f = f;
	}
	@Override
	public String toString() {
		return "F [f=" + f + ", c=" + c + ", a=" + a + "]";
	}
}
class G extends C {
	int g;

	public G(int a, int c, int g) {
		super(a, c);
		this.g = g;
	}
	@Override
	public String toString() {
		return "G [g=" + g + ", c=" + c + ", a=" + a + "]";
	}
}


public class C05UpDownCastingMain {

	public static void UpDownTestFunc(A obj, int...args) {
		// args 를 받아서 값 바꾸기
		obj.a = args[0];

//		obj.b = args[1];	// DownCasting 필요 -> 아래처럼 코드 바꿔야함
		// DownCasting 전에 instanceof 선행 필요
		if(obj instanceof B) {
			B down = (B)obj;
			down.b = args[1];
		} else if(obj instanceof C) {
			C down = (C)obj;
			down.c = args[1];
		}  if(obj instanceof D) {		// 여기서부터는 else if 쓰면 제대로 값이 안나옴
			D down = (D)obj;			// A 뿐마아니라 B 나 C 도 상속받기 때문(B에서 참이면 바로 다름으로 넘어가버려서 문제생김)
			down.d = args[1];			// 이렇게 하거나 아니면 하위클래스 조건을 위로 올리기
		}  if(obj instanceof E) {
			E down = (E)obj;
			down.e = args[1];
		}  if(obj instanceof F) {
			F down = (F)obj;
			down.f = args[1];
		}  if(obj instanceof G) {
			G down = (G)obj;
			down.g = args[1];
		} 
		
		System.out.println(obj);	
	}
	
	public static void main(String[] args) {
		A ob1 = new A(10);
		B ob2 = new B(11,12);
		B ob3 = new B(11,12);
		D ob4 = new D(15,16,17);
		E ob5 = new E(18,19,20);
		F ob6 = new F(21,22,23);
		G ob7 = new G(24,25,26);	
										// 근데 toString 때문에 바로 출력되긴함(오버라이딩 관련)
		UpDownTestFunc(ob1,15);			// A obj = ob1	// NoCasting
		UpDownTestFunc(ob2,99,98);		// A obj = ob2	// UpCasting
		UpDownTestFunc(ob3,77,66);	
		UpDownTestFunc(ob4,55,44,33);
		UpDownTestFunc(ob5,11,22,33);
		UpDownTestFunc(ob6,78,89,80);
		UpDownTestFunc(ob7,11,22,33);
	}
}
