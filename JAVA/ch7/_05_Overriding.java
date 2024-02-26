package ch7;

class Parent{
    void parentMethod(){}
}

class Child extends Parent{
    void parentMethod(){}       // 오버라이딩
    void parentMethod(int i) {} // 오버로딩

    void childMethod(){}
    void childMethod(int i){}   // 오버로딩
//    void childMethod(){}        // error : 중복정의 (already defined in Child)
}


/**
 * 오버라이딩(overriding)
 * - 조상 클래스로부터 상속받은 메서드의 내용을 변경하는 것
 * - 상속받은 메서드를 자손 클래스 자신에 맞게 변경해야 하는 경우
 * - 메서드의 내용만 새로 작성하는것
 * 
 * 오버라이딩의 조건
 * : 자손 클래스에서 오버라이딩하는 메서드는 조상 클래스의 메서드와
 * - 이름이 같아야 함
 * - 매개변수가 같아야 함
 * - 반환타입이 같아야 함
 *  => 선언부가 일치해야 함
 * 
 * : 조상 클래스의 메서드를 자손 클래스에서 오버라이딩할 때
 * - 접근 제어자는 조상 클래스의 메서드보다 좁은 범위로 변경 가능
 *      : public < protected < (default_ < private)
 * - 조상 클래스의 메서드보다 많은 수의 예외 선언 불가
 * - 인스턴스메서드를 static 메서드 혹은 그 반대로 변경 불가
 */

 /**
  * 오버로딩 vs 오버라이딩
        - 오버로딩 : 기존에 없는 새로운 메서드 정의(new)
        - 오버라이딩 : 상속받은 메서드의 내용 변경 (change, modify)
  */