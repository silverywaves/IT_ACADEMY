package com.example.testsecurity.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserEntity {

    @Id // PK 표기
    @GeneratedValue(strategy = GenerationType.IDENTITY)    // 생성 전략 정의
    // IDENTITY : 기본키 생성을 데이터베이스에 위임
    private int id;

    @Column(unique = true)
    private String username;
    private String password;

    private String role;

}
