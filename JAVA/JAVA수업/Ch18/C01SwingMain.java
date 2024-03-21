package Ch18;

import javax.swing.JFrame;

public class C01SwingMain {

	public static void main(String[] args) {
		JFrame frame = new JFrame("첫번째 프레임입니다.");
//		frame.setBounds(x,y,width,heigth);
		frame.setBounds(100,100,500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 종료 처리 활성화
		frame.setVisible(true);
	}
}
