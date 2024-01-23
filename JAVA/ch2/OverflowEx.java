package ch2;

public class OverflowEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		short sMin = -32768;
		short sMax = 32767;
		char cMin = 0;
		char cMax = 65535;
		
		System.out.println("sMin  = " + sMin);
		System.out.println("sMin-1= " + (short)(sMin-1));	// 최소값 - 1 -> 최대값
		System.out.println("sMax  = " + sMax );
		System.out.println("sMax+1= " + (short)(sMax+1));	// 최대값 + 1 -> 최소값
		System.out.println("cMin  = " + (int)cMin);
		System.out.println("cMin-1= " + (int)--cMin);		// 최소값 - 1 -> 최대값
		System.out.println("cMin  = " + (int)cMax);
		System.out.println("cMin+1= " + (int)++cMin);		// 최대값 + 1 -> 최소값
	}

}
