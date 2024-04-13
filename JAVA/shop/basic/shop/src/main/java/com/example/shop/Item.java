package com.example.shop;

import jakarta.persistence.*;

import java.util.Date;

@Entity     // JPA에선 @Entity 클래스 만들면 테이블 자동생성
// @ToString
public class Item { // => Item 이름으로 테이블 생성
    // 테이블에 어떤 컬럼(세로줄)이 들어갈지 먼저 정하기
    @Id     // id 컬럼에는 @Id 붙이라고 강요함
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // 자동으로 1씩 증가 기능(=Auto increment)
    public Long id;
    @Column(nullable=false) // @Column()으로 컬럼에 제약설정 가능
    private String title;    // VARCHAR(255) : 문자 255자까지만 저장가능 => length=1000 : 1000까지 저장가능
    // nuallable=false : 해당 컬럼 비어있을경우 테이블에 입력 방지
    // unique=true : 해당 컬럼값이 유니크하지 않으면 테이블 입력 막아줌
    // columnDefinition="TEXT" : 컬럼타입 강제로 지정가능
    // [참고] 컬럼설정 변경사항은 DB에 반영이 자동으로 안될수도 있음
    private Integer price;  // 컬럼용 변수에는 int 말고 Integer 강요함 => 20억까지 저장가능 // long/Long => 900경까지 저장가능

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }

    // getter 함수
    public String getTitle(){
        return title;
    }

    // setter 함수
    public void setTitle(String title){
        this.title = title;
    }    

    // [참고] @Entity 변수들에 public을 붙이면 다른 모든 클래스에서 문제없이 사용가능
    // 해당 내용 정리
    // 클래스 변수, 함수에 붙이는 modifier
    // 1. public 붙이면 모든 곳에서 사용 가능
    // 2. 아무것도 안붙이면 package-private, 같은 폴더의 클래스에서만 사용 가능
    // 3. private 붙이면 다른 클래스에서 사용 불가
    //    => private 변수를 출력하는 함수를 만들면 다른 클래스에서도 함수를 통해 출력 가능(getter 함수)
    //    => private 변수를 수정하는 함수를 만들면 다른 클래스에서도 함수를 통해 수정 가능(setter 함수)
    //    => private 사용 이유? 원본을 수정하여 고치는 것 보다 setter 함수에 검사 로직을 추가하여 변경하면 안전하니까!
    // 4. protected 붙이면 같은 폴더의 클래스에서만 사용 가능(예외: 상속한 클래스는 마음대로 사용 가능)
        // // 상속
        // class 클래스1 extends Item(){
        //     // Item 클래스를 복사한 클래스1 => Item 변수 함수 복사됨
        //     // => 클래스1 안에서 title 변수 사용 가능
        // }        => 요즘은 상속보다  composition 더 선호함
    // 5. static 붙이면 클래스.변수 이렇게 직접 사용 가능(=복사하여 사용하는 것이 아닌 변수의 원본 그대로 사용)
}
