package Ch12;

class Point2D{
	int x;
	int y;
	
	Point2D(){
		System.out.println("Point2D() 생성자 호출");
	}
	Point2D(int x){
		this.x = x; 
		System.out.println("Point2D(int x) 생성자 호출");
	}
	Point2D(int x, int y){
		this.x = x; this.y=y;
		System.out.println("Point2D(int x, int y) 생성자 호출");
	}
	
	@Override
	public String toString() {
		return "Point2D [x=" + x + ", y=" + y + "]";
	}
	
	
}
// 
class Point3D extends Point2D{		// extends : 상속 기본
	int z;
	
	Point3D(){
		super();		// 기본으로 들어가있음. 상위클래스 Point2D() 생성자 호출
		System.out.println("Point3D() 생성자 호출");
	}
	
	Point3D(int x){
//		super();	// Point2D() 호출
		super(x);	// Point2D(int x) 호츨
//		this.x=x;	// 시점의 차이
		System.out.println("Point3D(int x) 생성자 호출");
	}
	
	Point3D(int x, int y){
		super(x,y);
		System.out.println("Point3D(int x, int y) 생성자 호출");
	}
	Point3D(int x, int y, int z){
//		super(x,y,z); 	// Point2D 에 z 없어서 에러
		super(x,y);		// 상속받은 값들은 super 로 기재해주고
		this.z = z;		// Point3D 에서 추가된 int z 는 여기서 this.z = z; 로 정리함
		System.out.println("Point3D(int x, int y, int z) 생성자 호출");
	}

	@Override
	public String toString() {
		return "Point3D [z=" + z + ", x=" + x + ", y=" + y + "]";
	}

	
}

public class C02InheritanceMain {
	
	public static void main(String[] args) {
//		Point3D ob = new Point3D();	
//		Point3D ob2 = new Point3D(10);
//		Point3D ob3 = new Point3D(10,20);
		Point3D ob4 = new Point3D(10,20,30);
	}
}
