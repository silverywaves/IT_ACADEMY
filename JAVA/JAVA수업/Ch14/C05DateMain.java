package Ch14;

import java.util.*;

public class C05DateMain {

	public static void main(String[] args) {
		
//		Date d1 = new Date();		// sql 도 있고 util 도 있음. sql 은 DB 연결시 사용
//		System.out.println(d1);
//		System.out.println(d1.getYear());		
//		System.out.println(d1.getMonth()+1);
//		System.out.println(d1.getDate());
//		System.out.println(d1.getDay());		// 요일 : 0~6(일~토)
//		System.out.println();
//		System.out.println(d1.getHours());
//		System.out.println(d1.getMinutes());
//		System.out.println(d1.getSeconds());
//		System.out.println();
//		System.out.println(d1.getTime());		// 시간대 계산
//		// Returns the number of milliseconds since January 1, 1970, 00:00:00 GMTrepresented by this Date object.
//		System.out.println(d1.getTimezoneOffset());
		
		Calendar cal = Calendar.getInstance();	// 싱글톤 : 생성자가 여러 차례 호출되더라도 실제로 생성되는 객체는 한개(객체 하나만 만들어 사용)
		System.out.println(cal);
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH)+1);
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));	// 요일 : 1~7(일~토)
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.SECOND));
		
	}
}
