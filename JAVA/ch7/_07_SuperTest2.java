package ch7;

class _07_SuperTest2 {
    public static void main(String args[]){
        Child c = new Child();
        c.method();
    }
}
class Parent{
    int x = 10;     // 조상클래스의 x
}
class Child extends Parent {
    int x = 20;     // 자손클래스의 x

    void method(){
        System.out.println("x=" + x);
        System.out.println("this.x=" + this.x);     // 자손클래스에 선언된 멤버변수x
        System.out.println("super.x=" + super.x);   // 조상클래스로부터 상속받은 멤버변수x
    }
}

// ------------- 메서드드도 super 로 호출 가능-----------------

class Point {
    int x;
    int y;

    String getLocation(){
        return "x :" + x + ", y :" + y;
    }
}

class Point3D extends Point{
    int z;
    String getLocation(){       // 오버라이딩
        return "x :" + x + ", y :" + y + ", z :" + z;
        return super.getLocation() + ", z :" + z;   // 조상 메서드 호출
    }
}