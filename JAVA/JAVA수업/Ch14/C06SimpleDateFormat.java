package Ch14;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class C06SimpleDateFormat {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("YYYY/MM/DD 입력 : ");
		String ymd = sc.next();
		
		// 포매터 객체 생성(입력용)
		SimpleDateFormat fmtin = new SimpleDateFormat("yyyy/MM/dd");	// y,M,d,h,m,s
		// import java.text.SimpleDateFormat;
		System.out.println(ymd);
		Date date = fmtin.parse(ymd);	// import java.text.ParseException;	예외처리 : throws ParseException
		System.out.println(date);
		
		// 포매터 객체 생성(출력용)
		SimpleDateFormat fmtout = new SimpleDateFormat("yyyy~MM~dd");
		System.out.println(fmtout.format(date));
	}
}
