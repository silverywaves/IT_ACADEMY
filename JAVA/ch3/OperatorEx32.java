package ch3;

public class OperatorEx32 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x, y, z;
		int absX, absY, absZ;
		char signX, signY, signZ;
		
		x = 10;
		y = -5;
		z = 0;
		
		absX = x >= 0 ? x : -x;		// x 의 값이 음수이면, 양수로 변경
		absY = y >= 0 ? y : -y;
		absZ = z >= 0 ? z : -z;
		
		signX = x > 0 ? '+' : ( x==0 ? ' ' : '-');	// 조건 연산자 중첩
		signY = y > 0 ? '+' : ( y==0 ? ' ' : '-');
		signZ = z > 0 ? '+' : ( z==0 ? ' ' : '-');
		
		System.out.printf("x=%c%d%n", signX, absX);
		System.out.printf("y=%c%d%n", signY, absY);
		System.out.printf("z=%c%d%n", signZ, absZ);
	}

}
/*	조건 연산자 ? :
 * 		- 조건식, 식1, 식2 총 3개의 피연산자 필요 => 삼항 연산자
 * 		- 조건식의 평가결과가 true 면 식1, false 면 식 2
 * 		- 식 1과 식2 의 타입이 다른 경우 산술 변환 발생
 * 		- 중첩 가능		<- 단, 가독성을 위해 꼭 필요한 경우만
 * */
