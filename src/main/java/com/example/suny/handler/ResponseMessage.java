package com.example.suny.handler;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data//要return给前端的会转化为json，需要调用getset
public class ResponseMessage<T> {
    private T data;
    private String message;
    private Integer code;

    public ResponseMessage(T data, String message, Integer code) {

        this.data = data;
        this.message = message;
        this.code = code;
    }

    public static <T> ResponseMessage<T> success(T data) {
        return new ResponseMessage(data, "success", HttpStatus.OK.value());


    }

}
