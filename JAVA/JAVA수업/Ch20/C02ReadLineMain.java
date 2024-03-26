package Ch20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

public class C02ReadLineMain {

	public static void main(String[] args) throws Exception {
		
//		Writer out = new FileWriter("c:\\tmp_io\\test2.txt");
////		out.write("HELLO");
////		out.write("HELLO");
////		out.write("HELLO");
////		out.flush();
////		out.close();
//		BufferedWriter bout = new BufferedWriter(out);
//		PrintWriter pout = new PrintWriter(bout);
//		pout.println("Hello");
//		pout.println("Hello");
//		pout.println("Hello");
//		pout.flush();
//		pout.close();
//		
		Reader in = new FileReader("c:\\tmp_io\\test2.txt");
		BufferedReader bin = new BufferedReader(in);

		while(true) {
			String data = bin.readLine();
			if(data==null)
				break;
			System.out.println(data);
		}
		
	}
}
