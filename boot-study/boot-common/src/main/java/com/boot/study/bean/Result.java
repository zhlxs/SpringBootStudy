package com.boot.study.bean;

/**
 * <响应实体>
 */
public class Result {

    private String code;
    private Boolean success;
    private String message;
    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * ajax返回异常信息
     *
     * @param msg 异常描述
     * @return {Result}
     */
    public static Result renderError(String msg) {
        Result result = new Result();
        result.setSuccess(false);
        result.setMessage(msg);
        return result;
    }

    public static Result renderError(String code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setSuccess(false);
        result.setMessage(msg);
        return result;
    }

    public static Result renderError(String code, Object data, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setSuccess(false);
        result.setData(data);
        result.setMessage(msg);
        return result;
    }

    /**
     * ajax成功信息
     *
     * @return {Result}
     */
    public static Result renderSuccess() {
        Result result = new Result();
        result.setSuccess(true);
        return result;
    }

    /**
     * ajax成功信息
     *
     * @param msg 描述
     * @return {Object}
     */
    public static Result renderSuccess(String msg) {
        Result result = new Result();
        result.setSuccess(true);
        result.setMessage(msg);
        return result;
    }

    public static Result renderSuccess(String code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setSuccess(true);
        result.setMessage(msg);
        return result;
    }

    /**
     * ajax请求成功
     *
     * @param data 数据对象
     * @return {Result}
     */
    public static Result renderSuccess(Object data) {
        Result result = new Result();
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

    public static Result renderSuccess(String code, Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

    /**
     * ajax成功
     *
     * @param data 数据对象
     * @param msg  描述
     * @return
     */
    public static Result renderSuccess(Object data, String msg) {
        Result result = new Result();
        result.setSuccess(true);
        result.setData(data);
        result.setMessage(msg);
        return result;
    }

    public static Result renderSuccess(String code, Object data, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setSuccess(true);
        result.setData(data);
        result.setMessage(msg);
        return result;
    }
}
