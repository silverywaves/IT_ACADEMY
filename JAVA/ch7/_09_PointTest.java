package ch7;

public class _09_PointTest {
	public static void main(String[] args) {
		Point3D9 p3 = new Point3D9();
		System.out.println("p3.x=" + p3.x);
		System.out.println("p3.y=" + p3.y);
		System.out.println("p3.z=" + p3.z);
	}
}

class Point9{
	int x=10;
	int y=20;
	
	Point9(int x, int y){
		// 생성자 첫 줄에서 다른 생성자를 호출하지 않기 때문에 컴파일러가 super(); 를 여기에 삽입
		// super() 는 Point 의 조상인 Object 클래스의 기본 생성자인 Object() 의미
		this.x=x;
		this.y=y;
	}
}

class Point3D9 extends Point9{
	int z = 30;
	
	Point3D9(){
		this(100,200,300);		// Point3D(int x, int y, int z) 호출
	}
	Point3D9(int x, int y, int z){
		super(x, y);
		this.z=z;				// Point(int x, int y) 호출
	}
}
