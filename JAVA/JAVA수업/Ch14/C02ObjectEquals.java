package Ch14;

class C02Simple{
	int n;
	C02Simple(int n){
		this.n = n;
	}
	@Override
	public boolean equals(Object obj) {		// 업캐스팅 상태
		if(obj instanceof C02Simple) {
			C02Simple down=(C02Simple)obj;
			return this.n == down.n;		// 다운캐스팅 해줘야함
		}
		return false;
	}
	
}

public class C02ObjectEquals {

	public static void main(String[] args) {
		C02Simple ob1 = new C02Simple(10);
		C02Simple ob2 = new C02Simple(10);
		C02Simple ob3 = new C02Simple(10);
		
		// equalse 오버라이딩 전
//		ob1.equals(ob3);	// 재정의하지 않고 사용시 참조변수간 주소값 비교
		/*	    public boolean equals(Object obj-업캐스팅) {
        			return (this == obj);
    			}
		 * */

//		System.out.println(ob1.equals(ob2));	// 주소값 다르기때문에 false
//		System.out.println(ob1.equals(ob3));	// 주소값 다르기때문에 false
		
		// equalse 오버라이딩 후
		System.out.println(ob1.equals(ob2));	// 재정의된 equals 사용 -> ob2 의 n 값과 ob1 의 n 값 비교 => true
		System.out.println(ob1.equals(ob3));	// 재정의된 equals 사용 -> ob2 의 n 값과 ob1 의 n 값 비교 => true
	
		String str1 = new String("JAVA");
		String str2 = new String("JAVA");
		str1.equals(str2);
		/*    public boolean equals(Object anObject) {	
		        if (this == anObject) {
		            return true;
		        }
		        return (anObject instanceof String aString)		// 재정의하고 사용시 값 비교
		                && (!COMPACT_STRINGS || this.coder == aString.coder)
		                && StringLatin1.equals(value, aString.value);
		    	}
		 * */
		
//		str1.toString() : String - String 		: 재정의되어 있는 상태
	}
}
