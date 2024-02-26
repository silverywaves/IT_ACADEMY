package ch7;

class Tv{               // 조상
    boolean power;      // 전원상태(on/off)
    int channel;        // 채널

    void power(){power = !power;}
    void channelUp(){++channel;}
    void channelDown(){--channel;}
}

class VCR{              // TVCR 클래스에 포함시킴
    boolean power;      // 전원상태(on/off)
    int counter = 0;
    void power(){power = !power;}
    void play(){/* 내용생략 */}
    void stop(){/* 내용생략 */}
    void rew(){/* 내용생략 */}
    void ff(){/* 내용생략 */}
}

class TVCR extends Tv{      // 외부적으로는 TVCR 클래스의 인스턴스를 사용하는 것처럼 보이지만,
                            // 내부적으로는 VCR 클래스의 인슽턴스를 생성해서 사용하는 것
    VCR vcr = new VCR();    // VCR 클래스의 메서드와 일치하는 메서드와 일치하는 선언부를 가진 메서드 선언
                            // 내용은 VCR 클래스 것을 호출하여 사용
    void play(){
        vcr.play();
    }

    void stop(){
        vcr.stop();
    }
    
    void rew(){
        vcr.rew();
    }

    void ff(){
        vcr.ff();
    }
}       // => VCR 클래스의 메서드 내용이 변경시 TVCR클래스의 메서드들도 변경된 내용 적용됨

// 자바는 단일상속!
// 클래스간의 관계가 명확해지고 신뢰도가 높아짐

// Object 클래스 - 모든 클래스의 조상
// toString() or equals(Object o)와 같은 메서드를 정의하지 않고 사용할 수 있었던 이유
// => Object 클래스에 정의된 것들이기 때문