/*
* 全局捕获异常
* */
package com.zjs.blogserver.exception;

import com.zjs.blogserver.util.AxiosResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandle {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value=RuntimeException.class)
    public AxiosResult handle(RuntimeException e){
        log.error("运行时异常：---------------{}",e);
        return AxiosResult.error(e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value= MethodArgumentNotValidException.class)
    public AxiosResult handle(MethodArgumentNotValidException e){
        log.error("实体校验异常：---------------{}",e);
        return AxiosResult.error(e.getMessage());
    }
}
