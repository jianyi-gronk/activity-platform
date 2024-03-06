package com.example.backend2.common.exception;

import cn.hutool.jwt.JWTException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<String> handler(RuntimeException e) {
        log.error("运行时异常：{}", e.getMessage());
        return ResponseEntity.ok(e.getMessage());
    }

    @ExceptionHandler(value = JWTException.class)
    public ResponseEntity<String> handler(JWTException e) {
        log.error("Token过期：{}", e.getMessage());
        return ResponseEntity.ok(e.getMessage());
    }
}
