package ch7;

class _06_SuperTest {
    public static void main(String[] args){
        Child c = new Child();
        c.method();
    }
}
class Parent{
    int x = 10;
}
class Child extends Parent{
    void method(){
        System.out.println("x=" + x);               // 10
        System.out.println("this.x=" + this.x);     // 10
        System.out.println("super.x=" + super.x);   // 10
    }   // 모두 같은 변수 의미
}

/**
 * super
 * - 자손 클래스에서 조상 클래스로부터 상속받은 멤버를 참조하는데 사용되는 참조변수
 * - 상속받은 멤버와 자신의 멤버가 이름이 같을 때 super 로 구별 가능
 *      this : 멤버 변수와 지역변수 이름을 같을 때
 * - 조상 클래스로부터 상속받은 멤버도 자손 클래스 자신의 멤버이기때문에 this 사용 가능
 *      조상클래스의 멤버와 자손클래스의 멤버가 중복 정의되어 서로 구별해야하는 경우에만 super 사용
 * - 자신이 속한 인스턴스 주소가 지역변수로 저장
 *      static 메서드 사용 불가 / 인스턴스 메서드 사용 가능
 */