package com.example.springcommon.common;//package com.brian.happyforum.common;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * @author brian
 */
@Data
@NoArgsConstructor
public class Result<T> implements Serializable {

    private String code;

    private String msg;

    private T data;

    Result(String code , String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static<T> Result<T> success() {
        return new Result<>("20000", "操作成功", null);
    }

    public static<T> Result<T> success(T data) {
        return new Result<>("20000", "操作成功", data);
    }
    public static<T> Result<T> success(String msg, T data) {
        return new Result<>("20000", msg, data);
    }

    public static<T> Result<T> fail() {
        return new Result<>("50000", "操作失败", null);
    }

    public static<T> Result<T> fail(String msg) {
        return new Result<>("50000", msg, null);
    }

    public static<T> Result<T> fail(String msg, T data) {
        return new Result<>("50000", msg, data);
    }

}