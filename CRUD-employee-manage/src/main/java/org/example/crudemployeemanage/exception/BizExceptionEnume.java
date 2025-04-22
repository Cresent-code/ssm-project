package org.example.crudemployeemanage.exception;

import lombok.Getter;

@Getter
public enum BizExceptionEnume {
    BODY_NOT_MATCH(10001, "数据格式不正确"),
    EMP_NOT_EXIST(10002, "员工不存在"),
    SQL_TIME_OUT(10003, "数据库连接超时"),
    ID_NULL(10004,"ID不能为空"),
    NAME_NULL(10005,"姓名不能为空");
    private final Integer code;
    private final String msg;

    BizExceptionEnume(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
