package Ch19;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class C07FileCopyMain {

	public static void main(String[] args) throws Exception {
		
		InputStream in = new FileInputStream("C:\\tmp_io\\"+args[0]);
		OutputStream out = new FileOutputStream("C:\\tmp_io\\"+args[1]);
		
		byte[] buffer = new byte[4096];
		
		while(true) {
			// 파일로부터 읽어오기
			int data = in.read(buffer);
			if(data==-1)
				break;
			
			// 파일에 쓰기
			out.write(buffer,0,data);
			out.flush();
		}
		in.close();
		out.close();
		
	}
}
