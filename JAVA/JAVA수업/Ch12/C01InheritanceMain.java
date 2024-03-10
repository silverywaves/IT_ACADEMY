//package Ch12;
//
//class Point2D{
//	int x;
//	int y;
//	
//	Point2D(){
//		System.out.println("Point2D() 생성자 호출");
//	}
//	
//	@Override
//	public String toString() {
//		return "Point2D [x=" + x + ", y=" + y + "]";
//	}
//	
//	
//}
//// 
//class Point3D extends Point2D{		// extends : 상속 기본
//	int z;
//	
//	Point3D(){
//		super();		// 기본으로 들어가있음. 상위클래스 Point2D() 생성자 호출
//		System.out.println("Point3D() 생성자 호출");
//	}
//
//	@Override
//	public String toString() {
//		return "Point3D [z=" + z + ", x=" + x + ", y=" + y + "]";
//	}
//
//	
//}
//
//public class C01InheritanceMain {
//	
//	public static void main(String[] args) {
//		Point3D ob = new Point3D();	// 객체 생성 전 상속관계의 상위 생성자를 통해 공간 먼저 생성 
//		ob.x=100;
//		ob.y=200;
//		ob.z=300;
//		System.out.println(ob);
//	}
//}
