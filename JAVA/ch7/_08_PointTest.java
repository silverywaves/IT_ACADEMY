package ch7;

class _08_PointTest {

	public static void main(String[] args) {
		Point3D p3 = new Point3D(1,2,3);		
	}
}

class Point{
	int x, y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	String getLocation() {
		return "x : " + x + ", y : " + y;
	}
}

class Point3D extends Point{
	int z;
	
	Point3D(int x, int y, int z){
		super(x,y);				// Point3D 의 조상인 Point 클래스의 기본 생성자인 Point() 의미
								// Point(int x, int y) 호출
		this.z = z;
	}
	
	String getLocation() {		// 오버라이딩
		return "x : " + x + ", y : " + y + ", z : " + z;
	}
}

/*	super() : 생성자
 * 	- 조상 클래스의 생성자를 호출하는데 사용
 * 	- Object 클래스를 제외한 모든 클래스의 생성자 첫 줄에 생성자, this() 또는 super() 호출
 * 		: 그렇지 않으면 컴파일러가 자동적으로 super(); 생성자의 첫 주렝 삽입
 * 	- 선택한 클래스의 어떤 생성자를 이용해서 인스턴스를 생성할 것인가?
 * */
