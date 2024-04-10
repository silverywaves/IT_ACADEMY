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
    public String title;    // VARCHAR(255) : 문자 255자까지만 저장가능 => length=1000 : 1000까지 저장가능
    // nuallable=false : 해당 컬럼 비어있을경우 테이블에 입력 방지
    // unique=true : 해당 컬럼값이 유니크하지 않으면 테이블 입력 막아줌
    // columnDefinition="TEXT" : 컬럼타입 강제로 지정가능
    // [참고] 컬럼설정 변경사항은 DB에 반영이 자동으로 안될수도 있음
    public Integer price;  // 컬럼용 변수에는 int 말고 Integer 강요함 => 20억까지 저장가능 // long/Long => 900경까지 저장가능

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }

    // [참고] @Entity 변수들에 public을 붙이면 다른 모든 클래스에서 문제없이 사용가능
}
