package Ch08;

class Simple07{
	// 가변인자 : 기호(...) 사용 -> '타입...변수명' 으로 선언. (ex.printf()) <- 매개변수의 개수를 동적으로 지정
	// 내부적으로 배열 이용 -> 가변인자가 선언된 메서드를 호출할때마다 배열 생성(=> 인자 없으면 배열 안생김)
	// 가변인자를 선언한 메서드를 오버로딩하면, 메서드를 호출했을 때 JVM 이 구별하지 못하는 경우有
	// public PrintStream printf(String format, Object... args){...} (o) 
	// public PrintStream printf(Object... args, String format){...} (x) - 가변인자는 매개변수 마지막에 선언
	int sum(int ...arg) {	// 배열형태	// -> int 대신 Object 로도 가능.. 근데 왜 오버로딩을 쓰는걸까?
//		System.out.println(arg);
		for(int num :arg) {				// -> int 대신 Object 로도 가능.. 근데 왜 오버로딩을 쓰는걸까?
			System.out.print(num+" ");
		}
		return 0;
	}
	
	// 가변인자 vs 오버로딩
	// 공통점 : 하나의 함수에서 매개변수를 동적으로 받을 수 있음
	// 차이점 : 선언 간편, 가변인자는 전달인자를 0부터 n 개까지 넣을 수 있음. (배열로 처리)
	//		  오버로딩은 함수 정의를 어려개 해야하며 정의된 매개변수보다 많거나 적은 매개변수를 넘기면 안됨
}

public class C07Method가변인자 {

	public static void main(String[] args) {
		Simple07 obj = new Simple07();
		obj.sum(10);	// arg => 주소값 [I@6f2b958e => [ : 배열
		System.out.println();
		obj.sum(11, 22);
		System.out.println();
		obj.sum(10,23,44);
		System.out.println();
		
		
	}

}