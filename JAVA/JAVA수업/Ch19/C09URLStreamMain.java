package Ch19;

import java.io.BufferedInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;

public class C09URLStreamMain {

	public static void main(String[] args) throws Exception{
		
		URL url = new URL("https://velog.io/@seungmimi/javascript%EB%AA%A8%EB%8B%AC-%ED%8C%9D%EC%97%85-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0");
		InputStream bin = url.openStream();
		
		BufferedInputStream buffIn = new BufferedInputStream(bin);	// 보조스트림
																	// 버퍼공간 추가
		
		Reader in = new InputStreamReader(buffIn);					// 보조스트림
																	// byte단위 -> char단위로 변환해서 받음
		
		Writer wout = new FileWriter("c:\\tmp_io\\index.html");
		while(true) {
			int data = in.read();
			if(data==-1)
				break;
			
			wout.write((char)data);
		}
	}
}
