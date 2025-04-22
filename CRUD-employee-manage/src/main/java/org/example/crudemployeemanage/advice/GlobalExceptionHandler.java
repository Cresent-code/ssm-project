package org.example.crudemployeemanage.advice;

import org.example.crudemployeemanage.common.R;
import org.example.crudemployeemanage.exception.BizeException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//全局异常处理器
@ResponseBody
@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public R error(ArithmeticException e) {
        return R.error(500, e.getMessage(),e.getCause());
    }

    @ExceptionHandler(BizeException.class)
    public R handleBizeException(BizeException e) {
        Integer code = e.getCode();
        String msg = e.getMsg();
        return R.error(500, e.getMessage(),e.getCause());
    }

    @ExceptionHandler(Throwable.class)
    public R error(Throwable e) {
        return R.error(500, e.getMessage(),e.getCause());
    }
}
