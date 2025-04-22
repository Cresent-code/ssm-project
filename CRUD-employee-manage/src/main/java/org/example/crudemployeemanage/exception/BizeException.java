package org.example.crudemployeemanage.exception;

import lombok.Data;

@Data
public class BizeException extends RuntimeException {
    private Integer code;//业务异常码
    private String msg;

    public BizeException(Integer code, String message) {
        super(message);
        this.code = code;
        this.msg = message;
    }

    public BizeException(BizExceptionEnume exceptionEnume) {
        super(exceptionEnume.getMsg());
        this.code = exceptionEnume.getCode();
        this.msg = exceptionEnume.getMsg();
    }
}
