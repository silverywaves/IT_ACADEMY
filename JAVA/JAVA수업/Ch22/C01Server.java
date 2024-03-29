package Ch22;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class C01Server {

	public static void main(String[] args) throws Exception {
		
		// 1 서버 소켓 생성
		ServerSocket server = new ServerSocket(7000);		// 192.168.2.254:7000  / 7000 : 포트번호
		System.out.println("[INFO] Server Socket Listening");
		
		while(true) {
			Socket client = server.accept();	// 2 클라이언트 접속대기
			System.out.println("[INFO] " + client.getInetAddress() + " 접속하셨습니다.");
			// 데이터 송수신을 위한 input/output 스트림 생성
			OutputStream out = client.getOutputStream();
			// DataOutputStream : 자바의 기본 자료형 데이터를 바이트 스트림으로 출력
			// 바이트를 문자로 변환하고  primitive type 의 자료형을 읽고 쓸 수 있다
			DataOutputStream dout = new DataOutputStream(out);
			dout.writeUTF("WELCOME TO SERVER!");

			InputStream in = client.getInputStream();
			DataInputStream din = new DataInputStream(in);
			String recv = din.readUTF();
			System.out.println("[RECV] : " + recv);
			
			// 통신 종료
			dout.flush();
			dout.close();
			out.close();
			
		}
		
	}
}
