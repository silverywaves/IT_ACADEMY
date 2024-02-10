package ch5;

public class MultiArrEx3 {

	public static void main(String[] args) {
		// 두 행렬을 곱한 결과 출력
		int[][] m1 = {
				{1, 2, 3},
				{4, 5, 6}
		};
		
		int[][] m2 = {
				{1, 2},
				{3, 4},
				{5, 6}
		};
		
		// 행렬의 곱셈 => m1 열의 길이(3)와 m2 행의(3) 길이가 같아야 계산 가능
		// {1, 2, 3}	{1, 2}	   {1*1 + 2*3 + 3*5 	1*2 + 2*4 + 3*6} 
		// {4, 5, 6} *  {3, 4}	=  {4*1 + 5*3 + 6*5		4*2 + 5*4 + 6*6}
		//				{5, 6}
		//	결과 : m3 의 행의 길이 = m1 행의 길이	//  m3 의 열의 길이 = m2 열의 길이
	
		final int row = m1.length;		// m1 의 행 길이 = m3 의 행 길이 = 2
		final int col = m2[0].length;	// m2 의 열 길이 = m3 의 열 길이 = 2
		final int m2_row = m2.length;	// m2 의 행 길이 = 3
		
		int[][] m3 = new int[row][col];
		
		// 행렬곱 m1 * m2 의 결과를 m3 에 저장
//		m3[0][0] = m1[0][0] * m2[0][0]
//				+ m1[0][1] * m2[1][0]
//				+ m1[0][2] * m2[2][0];
//		
//		m3[0][1] = m1[0][0] * m2[0][1]
//				+ m1[0][1] * m2[1][1]
//				+ m1[0][2] * m2[2][1];
//		
//		m3[1][0] = m1[1][0] * m2[0][0]
//				+ m1[1][1] * m2[1][0]
//				+ m1[1][2] * m2[2][0];
//		
//		m3[1][1] = m1[1][0] * m2[0][1]
//				+ m1[1][1] * m2[1][1]
//				+ m1[1][2] * m2[2][1];
		
//		for(int i=0; i<2;i++) {
//			for (int j=0; j<2; j++) {
//				m3[i][j] = m1[i][0] * m2[0][j]
//						+ m1[i][1] * m2[1][j]
//						+ m1[i][2] * m2[2][j];		// m1 열 인덱스 = m2 행 인덱스
//			}
//		}
		
//		for (int i=0; i<2; i++) {
//			for (int j=0; j<2; j++) {
//				for(int k=0; i<3; k++) {
//					m3[i][j] = m1[i][k] * m2[k][j];
//				}
//			}
//		}

		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				for(int k=0; k<m2_row; k++) {
					m3[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		
		// 행렬 m3 출력
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				System.out.printf("%3d", m3[i][j]);
			}
			System.out.println();
		}
	} // end of main

}
