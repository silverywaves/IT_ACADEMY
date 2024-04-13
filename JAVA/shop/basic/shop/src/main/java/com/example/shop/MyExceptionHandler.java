package com.example.shop;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

// 모든 Controller 파일의 에러 캐치
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handler(){
        return ResponseEntity.status(400).body("에러");
    }

    // 에러 종류마다 다른 코드 실행 가능
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handler2(){
        return ResponseEntity.status(400).body("숫자말고 다른타입 넣음");
    }

}
