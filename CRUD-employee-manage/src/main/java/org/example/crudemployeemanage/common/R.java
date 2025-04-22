package org.example.crudemployeemanage.common;

import lombok.Data;

@Data
public class R<T> {
    private Integer code;
    private String message;
    private T data;

    public static <T> R<T> ok(T data) {
        R<T> tr = new R<>();
        tr.setCode(200);
        tr.setMessage("ok");
        tr.setData(data);
        return tr;
    }

    public static R ok() {
        R tr = new R<>();
        tr.setCode(200);
        tr.setMessage("ok");
        return tr;
    }

    public static R error(Integer code, String msg,Object data) {
        R tr = new R();
        tr.setCode(code);
        tr.setMessage(msg);
        tr.setData(data);
        return tr;
    }
}
