//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.boot.study.exception;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum ExceptionCode implements BaseExceptionCode {
    SUCCESS("1", "成功"),
    SYSTEM_BUSY("系统繁忙~请稍后再试~"),
    SYSTEM_TIMEOUT("系统维护中~请稍后再试~"),
    PARAM_EX("参数类型解析异常"),
    SQL_EX("运行SQL出现异常"),
    NULL_POINT_EX("空指针异常"),
    ILLEGALA_ARGUMENT_EX("无效参数异常", 400),
    MEDIA_TYPE_EX("请求类型异常", 400),
    LOAD_RESOURCES_ERROR("加载资源出错"),
    BASE_VALID_PARAM("统一验证参数异常", 400),
    OPERATION_EX("操作异常"),
    SERVICE_MAPPER_ERROR("Mapper类转换异常"),
    TIMEOUT("请求超时，请稍候再试", 504),
    INVALID_DATA("不合法的数据", 400),
    LOGIN_EX("访问失败，用户未登录", 401),
    HTTP_STATUS_OK("OK", 200),
    HTTP_STATUS_BAD_REQUEST("错误的请求", 400),
    HTTP_STATUS_UNAUTHORIZED("未经授权", 403),
    HTTP_STATUS_NOT_FOUND("没有找到资源", 404),
    HTTP_STATUS_METHOD_NOT_ALLOWED("不支持当前请求类型", 405),
    HTTP_STATUS_TOO_MANY_REQUESTS("请求超过次数限制", 429),
    HTTP_STATUS_INTERNAL_SERVER_ERROR("内部服务错误", 500),
    HTTP_STATUS_BAD_GATEWAY("网关错误", 502),
    HTTP_STATUS_GATEWAY_TIMEOUT("网关超时", 504),
    REQUIRED_FILE_PARAM_EX("请求中必须至少包含一个有效文件"),
    DATA_SAVE_ERROR("新增数据失败"),
    DATA_UPDATE_ERROR("修改数据失败"),
    JWT_TOKEN_EXPIRED("会话超时，请重新登录", 401),
    JWT_SIGNATURE("不合法的token，请认真比对 token 的签名", 401),
    JWT_ILLEGAL_ARGUMENT("缺少token参数", 401),
    JWT_GEN_TOKEN_FAIL("生成token失败", 401),
    JWT_PARSER_TOKEN_FAIL("解析token失败", 401),
    JWT_USER_INVALID("用户名或密码错误", 401),
    JWT_USER_ENABLED("用户已经被禁用！", 401),
    VERIFICATION_CODE_INVALID("验证码错误");

    private static final Logger log = LoggerFactory.getLogger(ExceptionCode.class);
    private String code;
    private String msg;
    private Integer status = 500;

    private ExceptionCode(String msg) {
        this.msg = msg;
        this.status = 500;
    }

    private ExceptionCode(String msg, int status) {
        this.msg = msg;
        this.status = status;
    }

    private ExceptionCode(Object code, String msg) {
        this.code = code == null ? null : String.valueOf(code);
        this.msg = msg;
    }

    public String getCode() {
        return StringUtils.defaultIfEmpty(this.code, this.name().toLowerCase());
    }

    public String getMsg() {
        return this.msg;
    }

    public int getStatus() {
        return this.status;
    }

    public ExceptionCode build(String msg, Object... param) {
        this.msg = String.format(msg, param);
        return this;
    }

    public ExceptionCode param(Object... param) {
        this.msg = String.format(this.msg, param);
        return this;
    }

    public static ExceptionCode required(String fieldName) {
        return BASE_VALID_PARAM.build(fieldName + "长度不能为空");
    }

    public static ExceptionCode illeglaArguments(String fieldName, Object fieldValue) {
        log.error("{} 输入了错误的值 ：{}", fieldName, fieldValue);
        return ILLEGALA_ARGUMENT_EX.build("请输入正确的%s", fieldName);
    }

    public static ExceptionCode unauthorized() {
        return HTTP_STATUS_UNAUTHORIZED.build("您没有权限操作");
    }
}
