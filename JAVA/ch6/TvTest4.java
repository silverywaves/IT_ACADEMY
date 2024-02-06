package ch6;

public class TvTest4 {

	public static void main(String[] args) {
		Tv[] tvArr = new Tv[3]; 	// 길이가 3인 Tv 객체 배열 -> 객체의 주소 저장
		
		// TV 객체를 생성해서 TV 객체 배열의 각 요소에 저장
		for(int i=0; i<tvArr.length; i++) {
			tvArr[i] = new Tv();
			tvArr[i].channel = i + 10;	// tvArr[i]의 channel에 i+10 저장
		}
		
		for(int i=0; i<tvArr.length; i++) {
			tvArr[i].channelUp();
			System.out.printf("tvArr[%d].channel=%d%n", i, tvArr[i].channel);
		}
	} // end of main

}
/*	객체 배열
 * 		- 객체를 배열로 다룰 수 있음
 * 		- 배열 안에 객체 자체가 아닌 객체의 주소가 저장
 * 		- 참조변수들을 하나로 묶은 참조변수배열
 * 		- 같은 타입의 객체만 저장 가능
 * */
