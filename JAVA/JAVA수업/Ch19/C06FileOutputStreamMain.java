package Ch19;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class C06FileOutputStreamMain {

	public static void main(String[] args) throws Exception{
		
		OutputStream out = new FileOutputStream("C:\\tmp_io\\test4.xlsx");
//		out.write("가");		// byte 단위 - 문자열 불가
		out.write("가".getBytes(StandardCharsets.UTF_8));
		out.write('a');
		out.write('b');
		out.write('c');

		out.flush();
		out.close(); 
	}
}
