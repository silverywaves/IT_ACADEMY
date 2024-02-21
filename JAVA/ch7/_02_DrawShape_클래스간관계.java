package ch7;


public class _02_DrawShape_클래스간관계 {
	
	public static void main(String[] args) {
		Point[] p = {
				new Point(100, 100),
				new Point(140, 50),
				new Point(200, 100),
		};
		Triangle t = new Triangle(p);
		Circle c = new Circle(new Point(150, 150), 50);
				// = new Circle(p, 50);		<- Point p = new Point(150, 150) 
		
		t.draw();	// 삼각형을 그림
		c.draw();	// 원을 그림
	}

}

class Shape{					// 도형
	String color = "black";
	void draw() {
		System.out.printf("[color=%s]%n", color);
	}
}

class Point{					// 2차원 좌표에서의 점
	int x;
	int y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	Point(){
		this(0, 0);
	}
	String getXY() {
		return "(" + x + ", " + y + ")";	// x, y 값을 문자열로 반환
	}
}

class Circle extends Shape{			// Circle 과 Shape 는 상속관계 => Shape 클래스에 정의된 color, draw() 사용 가능
	Point center;	// 원의 원점좌표	Circle 과 Point 는 포함관계
	int r;			// 반지름
	
	Circle(){
		this(new Point(0, 0), 100);		// Circle(Point center, int r) 호출
	}
	Circle(Point center, int r){
		this.center = center;
		this.r = r;
	}
	void draw() {		// 원을 그리는 대신 원의 정보를 출력
		System.out.printf("[center=(%d, %d), r=%d, color=%s%n", center.x, center.y, r, color);
	}	// 오버라이딩 : 조상클래스에 정의된 메서드와 같은 메서드를 자손클래스에 정의
}

class Triangle extends Shape{
	Point[] p = new Point[3];	// 3개의 Point 인스턴스를 담을 배열 생성
	
	Triangle(Point[] p) {
		this.p = p;
	}
	void draw() {
		System.out.printf("[p1=%s, p2=%s, p3=%s, color=%s]%n", p[0].getXY(), p[1].getXY(), p[2].getXY(), color);
	}
}


/*	포함관계
 * 		- 상속 이외에 클래스를 재사용하는 방법
 * 		- 한 클래스의 멤버변수로 다른 클래스 타입의 참조변수 선언
 * */

/*	관계 결정
 * 		- 클래스를 가지고 문장을 만들었을 때
 * 			=> '~은 ~이다.' : 상속관계
 * 			=> '~은 ~을 가지고 있다." : 포함관계
 * */
