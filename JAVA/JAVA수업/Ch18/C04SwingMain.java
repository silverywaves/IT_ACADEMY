package Ch18;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class C04GUI extends JFrame{
	
	C04GUI(){
		super("두번째 프레임입니다.");		// JFrame의 생성자 호출
		setBounds(100,100,250,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Panel 생성
		JPanel panel = new JPanel();
		panel.setLayout(null);	 // 기본 layout 사용x(null)로 설정해줘야 내가 원한 위치에 버튼 추가가능
		
		// Panel 배경색 지정
//		Color col = new Color(r, g, b);
		Color col = new Color(237, 247, 183);
		panel.setBackground(col);
		
		//Btn_component 추가
		JButton btn1 = new JButton("BUTTON01");
		btn1.setBounds(10,10,100,30);
		JButton btn2 = new JButton("BUTTON02");
		btn2.setBounds(120,10,100,30);
		
		// TextField_component 추가
		JTextField txt1 = new JTextField();
		txt1.setBounds(10,50,210,30);
		JTextField txt2 = new JTextField();
		txt2.setBounds(10,90,210,30);

		// TextArea_Component 추가
		JTextArea area1 = new JTextArea();
//		area1.setBounds(10,130,210,200);
		
		// ScrollPanel_component 추가
		JScrollPane scroll1 = new JScrollPane(area1);
		scroll1.setBounds(10,130,210,200);
		
		// Component를 Panel에 추가
		panel.add(btn1);
		panel.add(btn2);
		panel.add(txt1);
		panel.add(txt2);
//		panel.add(area1);
		panel.add(scroll1);
		
		// Frame 에 Panel 추가
		add(panel);
		
		setVisible(true);
	}
}

public class C04SwingMain {

	public static void main(String[] args) {
		
		new C04GUI();
	}
}
