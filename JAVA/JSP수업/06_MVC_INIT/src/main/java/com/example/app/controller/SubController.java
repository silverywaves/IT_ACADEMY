package com.example.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SubController {
	
	void execute(HttpServletRequest request,HttpServletResponse response);
	// 자바에서는 일일이 많은 양의 데이터들을 뷰에서 받아써야해서 Map 형태로 진행했었음
	// 여기에서는 어차피 response에 내용이 달릴 것임 -> 그냥 void형으로 해주면 됨
	// 파라미터가 중요함 => HttpServletRequest : request를 맏들어내는 클래스
	//				  HttpServletResponse : response가 브라우저로 내용을 전달할때 사용되는 기본 내장객체
	
	// execute() : 클라이언트 요청 처리 및 그 결과에 따른 적절한 응답 생성
		// 1. 요청 처리: request 객체를 사용하여 클라이언트의 요청 처리(요청 파라미터 읽기, 세션 확인 등)
		// 2. 비즈니스 로직 실행: 컨트롤러가 처리해야 할 비즈니스 로직 실행(데이터베이스 조회, 계산, 다른 서비스 호출 등)
		// 3. 응답 생성: 비즈니스 로직의 결과를 바탕으로 response 객체에 응답 생성(HTML 페이지, JSON 데이터, 이미지 파일 등 다양한 형태)
}
