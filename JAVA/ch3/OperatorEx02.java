package ch3;

public class OperatorEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 5, j = 0;
		
		j = i++;
		System.out.println("j=i++; 실행 후, i=" + i + ", j=" + j);
		
		i = 5;
		j = 0;	// 결과를 비교하기 위해, i 와 j 의 값을 다시 5와 0으로 변경
		
		j = ++i;
		System.out.println("j=++i; 실행 후, i=" + i + ", j=" + j);
	}

}
/*	
 *		j = ++i;	=>	++i;	// 증가 후에	+	j = i;	// 참조하여 대입
 * 		j = i++;	=>	j = i;	// 참조하여 대입 후에	+	i++;	// 증가
 * */
