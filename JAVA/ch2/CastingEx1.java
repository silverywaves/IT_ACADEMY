package ch2;

public class CastingEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double d = 85.4;
		int score = (int)d;		// double 타입의 변수 d 를 int 타입으로 형변환
		
		System.out.println("score="+score);	// 피연산자의 값을 읽어서 지정된 타입으로 형변환할 뿐
		System.out.println("d="+d);			// 피연산자인 변수 d 의 값은 형변환 후에도 변화 x
	}

}
/*	형변환(casting)
 * 		서로 다른 타입간의 연산을 수행하기 위해서 타입을 일치시켜야함
 * 		=> 변수 또는 상수의 타입을 다른 타입으로 변환
 * 
 * 		형변환하고자 하는 변수나 리터럴 앞에 변환하고자하는 타입을 괄호로 붙임
 * 		(타입)피연산자
 * 
 * 		boolean 타입을 제외한 기본형은 서로 형변환 가능
 * 		기본형과 참조형간의 형변환은 불가능
 * 		float 타입의 값을 int 타입으로 변활할 때는 소수점 이하의 값은 버림으로 처리
 * */
