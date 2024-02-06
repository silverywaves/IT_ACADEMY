package ch6;


class TvTest3{
	public static void main(String args[]){
		Tv t1 = new Tv();
		Tv t2 = new Tv();	
		
		System.out.println("t1의 channel 값은 " + t1.channel + "입니다.");
		System.out.println("t2의 channel 값은 " + t2.channel + "입니다.");

		
		t2 = t1;	// t1 이 저장하고 있는 값(주소)을 t2 에 저장
					// => t2는 t1이 가지고있던 인스턴스 같이 참조 (t2의 원래 참조 인스턴스 사용 불가)
		t1.channel = 7;
		System.out.println("t1의 channel 값을 7로 변경하였습니다.");
		
		System.out.println("t1의 channel 값은 " + t1.channel + "입니다.");
		System.out.println("t2의 channel 값은 " + t2.channel + "입니다.");
	}
}
/*	참조변수에는 하나의 값(주소)만 저장 가능
 * 		=> 둘 이상의 참조변수가 하나의 인스턴스를 가리키는(참조하는) 것은 가능
 * 		=> 하나의 참조변수로 여러 개의 인스턴스를 가리키는 것은 불가능
 * */
