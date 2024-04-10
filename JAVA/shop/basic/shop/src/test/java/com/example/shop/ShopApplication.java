package com.example.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);		// 스프링으로 만든 웹 서버를 띄우는 메인 함수

		// server : 요청자가 A 달라고 하면 A를 보내주는 프로그램

	}

}

/*	src 폴더 : 실제로 코드 짜는 곳
	resources 폴더 : HTML CSS JavaScript 이미지 등 파일 보관소
	application.properties 파일 : 환경변수나 프로젝트 설정 보관하는 곳
	build.gradle 파일 : 프로젝트 이름, 버전, 라이브러리 등 기록용 파일
	gradle~ : gradle 이라는 작업자동화 프로그램 작동 도와주는 파일, 수정할 일 없음
* */