package com.example.suny.handler;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;//处理器的依赖
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;//统一处理
import org.slf4j.LoggerFactory;//日志记录依赖


@RestControllerAdvice//统一异常处理,出现异常自动调用
public class GlobalExceptionHandler {
    Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);//日志记录异常
    @ExceptionHandler({Exception.class})//所有/各种异常皆调用这个
    public ResponseMessage handlerException(HttpServletResponse response, HttpServletRequest request,Exception e) {
        log.error("统一异常",e);
        return new ResponseMessage(null,"error",500);//前端只会收到这个，具体在后端才能看日志
    }
}
