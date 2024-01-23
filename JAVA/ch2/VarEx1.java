package ch2;

public class VarEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int year = 0;
        int age = 14;

        System.out.println(year);	// 변수 year 의 값을 화면에 출력	// 0
        System.out.println(age);	// 변수 age 의 값을 화면에 출력		// 14

        year = age + 2000;	// 변수 age 의 값에 2000을 더해서 변수 year 에 저장
        age = age + 1;		// 변수 age 에 저장된 값을 1 증가시킴

        System.out.println(year);	// 2014
        System.out.println(age);	// 15
	}

}

/**
 *  변수(variable) : 단 하나의 값을 저장할 수 있는 메모리상의 공간
 *                  새로운 값을 저장하면 기존의 값은 사라짐
 * 
 *  변수의 선언     : 변수를 사용하기 위한 첫번째 단계
 *                   int(변수타입) age(변수이름);    // age 라는 이름의 변수를 선언
 *                  메모리의 빈 공간에 변수타입에 알맞는 크기의 저장공간 확보, 그 저장공간은 변수이름을 통해 사용가능
 * 
 *  변수의 초기화   : 변수를 사용하기 전에 처음으로 값을 저장하는 것
 *                   int age = 25;               // 변수 age 를 선언하고 25로 초기화한다
 */