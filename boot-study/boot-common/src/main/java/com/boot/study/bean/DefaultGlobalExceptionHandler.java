//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.boot.study.bean;

import cn.hutool.core.util.StrUtil;
import com.boot.study.exception.BizException;
import com.boot.study.exception.ExceptionCode;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.exceptions.PersistenceException;
import org.mybatis.spring.MyBatisSystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class DefaultGlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(DefaultGlobalExceptionHandler.class);

    public DefaultGlobalExceptionHandler() {
    }

    @ExceptionHandler({BizException.class})
    public Result bizException(BizException ex, HttpServletRequest request, HttpServletResponse response) {
        log.warn("BizException:", ex);
        response.setStatus(ExceptionCode.OPERATION_EX.getStatus());
        return Result.result(ex.getCode(), "", ex.getMessage());
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    public Result httpMessageNotReadableException(HttpMessageNotReadableException ex, HttpServletRequest request, HttpServletResponse response) {
        log.warn("HttpMessageNotReadableException:", ex);
        String message = ex.getMessage();
        if (StrUtil.containsAny(message, "Could not read document:")) {
            String msg = String.format("无法正确的解析json类型的参数：%s", StrUtil.subBetween(message, "Could not read document:", " at "));
            return this.handleException(ExceptionCode.PARAM_EX, msg, request, response);
        } else {
            return this.handleException(ExceptionCode.PARAM_EX, ex.getMessage(), request, response);
        }
    }

    private Result handleException(ExceptionCode ex, String msg, HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(ex.getStatus());
        return Result.result(ex.getCode(), "", StringUtils.defaultIfEmpty(msg, ex.getMsg()));
    }

    @ExceptionHandler({BindException.class})
    public Result bindException(BindException ex, HttpServletRequest request, HttpServletResponse response) {
        log.warn("BindException:", ex);

        try {
            String msgs = ex.getBindingResult().getFieldError().getDefaultMessage();
            if (StrUtil.isNotEmpty(msgs)) {
                return this.handleException(ExceptionCode.PARAM_EX, msgs, request, response);
            }
        } catch (Exception var6) {
            log.error("BindException", var6);
        }

        StringBuilder msg = new StringBuilder();
        List<FieldError> fieldErrors = ex.getFieldErrors();
        fieldErrors.forEach((oe) -> {
            msg.append("参数:[").append(oe.getObjectName()).append(".").append(oe.getField()).append("]的传入值:[").append(oe.getRejectedValue()).append("]与预期的字段类型不匹配.");
        });
        return this.handleException(ExceptionCode.PARAM_EX, msg.toString(), request, response);
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public Result methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex, HttpServletRequest request, HttpServletResponse response) {
        log.warn("MethodArgumentTypeMismatchException:", ex);
        StringBuilder msg = (new StringBuilder("参数：[")).append(ex.getName()).append("]的传入值：[").append(ex.getValue()).append("]与预期的字段类型：[").append(ex.getRequiredType().getName()).append("]不匹配");
        return this.handleException(ExceptionCode.PARAM_EX, msg.toString(), request, response);
    }

    @ExceptionHandler({IllegalStateException.class})
    public Result illegalStateException(IllegalStateException ex, HttpServletRequest request, HttpServletResponse response) {
        log.warn("IllegalStateException:", ex);
        return this.handleException(ExceptionCode.ILLEGALA_ARGUMENT_EX, (String) null, request, response);
    }

    @ExceptionHandler({MissingServletRequestParameterException.class})
    public Result missingServletRequestParameterException(MissingServletRequestParameterException ex, HttpServletRequest request, HttpServletResponse response) {
        log.warn("MissingServletRequestParameterException:", ex);
        StringBuilder msg = new StringBuilder();
        msg.append("缺少必须的[").append(ex.getParameterType()).append("]类型的参数[").append(ex.getParameterName()).append("]");
        return this.handleException(ExceptionCode.ILLEGALA_ARGUMENT_EX, msg.toString(), request, response);
    }

    @ExceptionHandler({NullPointerException.class})
    public Result nullPointerException(NullPointerException ex, HttpServletRequest request, HttpServletResponse response) {
        log.warn("NullPointerException:", ex);
        return this.handleException(ExceptionCode.NULL_POINT_EX, (String) null, request, response);
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public Result illegalArgumentException(IllegalArgumentException ex, HttpServletRequest request, HttpServletResponse response) {
        log.warn("IllegalArgumentException:", ex);
        return this.handleException(ExceptionCode.ILLEGALA_ARGUMENT_EX, (String) null, request, response);
    }

    @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
    public Result httpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException ex, HttpServletRequest request, HttpServletResponse response) {
        log.warn("HttpMediaTypeNotSupportedException:", ex);
        MediaType contentType = ex.getContentType();
        if (contentType != null) {
            return this.handleException(ExceptionCode.MEDIA_TYPE_EX, "请求类型(Content-Type)[" + contentType.toString() + "] 与实际接口的请求类型不匹配", request, response);
        } else {
            return this.handleException(ExceptionCode.MEDIA_TYPE_EX, "无效的Content-Type类型", request, response);
        }
    }

    @ExceptionHandler({MissingServletRequestPartException.class})
    public Result missingServletRequestPartException(MissingServletRequestPartException ex, HttpServletRequest request, HttpServletResponse response) {
        log.warn("MissingServletRequestPartException:", ex);
        return this.handleException(ExceptionCode.REQUIRED_FILE_PARAM_EX, (String) null, request, response);
    }

    @ExceptionHandler({ServletException.class})
    public Result servletException(ServletException ex, HttpServletRequest request, HttpServletResponse response) {
        log.warn("ServletException:", ex);
        String msg = "Not a multi part request";
        return msg.equalsIgnoreCase(ex.getMessage()) ? this.handleException(ExceptionCode.REQUIRED_FILE_PARAM_EX, (String) null, request, response) : this.handleException(ExceptionCode.SYSTEM_BUSY, (String) null, request, response);
    }

    @ExceptionHandler({MultipartException.class})
    public Result multipartException(MultipartException ex, HttpServletRequest request, HttpServletResponse response) {
        log.warn("MultipartException:", ex);
        return this.handleException(ExceptionCode.REQUIRED_FILE_PARAM_EX, (String) null, request, response);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public Result constraintViolationException(ConstraintViolationException ex, HttpServletRequest request, HttpServletResponse response) {
        log.warn("ConstraintViolationException:", ex);
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        String message = (String) violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(";"));
        return this.handleException(ExceptionCode.BASE_VALID_PARAM, message, request, response);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Object methodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request, HttpServletResponse response) {
        log.warn("MethodArgumentNotValidException:", ex);
        return this.handleException(ExceptionCode.BASE_VALID_PARAM, ex.getBindingResult().getFieldError().getDefaultMessage(), request, response);
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public Result handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex, HttpServletRequest request, HttpServletResponse response) {
        log.warn("HttpRequestMethodNotSupportedException:", ex);
        return this.handleException(ExceptionCode.HTTP_STATUS_METHOD_NOT_ALLOWED, (String) null, request, response);
    }

    @ExceptionHandler({PersistenceException.class})
    public Result persistenceException(PersistenceException ex, HttpServletRequest request, HttpServletResponse response) {
        log.warn("PersistenceException:", ex);
        return ex.getCause() instanceof BizException ? this.bizException((BizException) ex.getCause(), request, response) : this.handleException(ExceptionCode.SQL_EX, (String) null, request, response);
    }

    @ExceptionHandler({MyBatisSystemException.class})
    public Result myBatisSystemException(MyBatisSystemException ex, HttpServletRequest request, HttpServletResponse response) {
        log.warn("PersistenceException:", ex);
        return ex.getCause() instanceof PersistenceException ? this.persistenceException((PersistenceException) ex.getCause(), request, response) : this.handleException(ExceptionCode.SQL_EX, (String) null, request, response);
    }

    @ExceptionHandler({SQLException.class})
    public Result sqlException(SQLException ex, HttpServletRequest request, HttpServletResponse response) {
        log.warn("SQLException:", ex);
        return this.handleException(ExceptionCode.SQL_EX, (String) null, request, response);
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    public Result dataIntegrityViolationException(DataIntegrityViolationException ex, HttpServletRequest request, HttpServletResponse response) {
        log.warn("DataIntegrityViolationException:", ex);
        return this.handleException(ExceptionCode.SQL_EX, (String) null, request, response);
    }

    @ExceptionHandler({ClassCastException.class})
    public Result dataIntegrityViolationException(ClassCastException ex, HttpServletRequest request, HttpServletResponse response) {
        log.warn("ClassCastException:", ex);
        return this.handleException(ExceptionCode.SYSTEM_BUSY, (String) null, request, response);
    }

    @ExceptionHandler({NoHandlerFoundException.class})
    public Result noHandlerFoundException(NoHandlerFoundException ex, HttpServletRequest request, HttpServletResponse response) {
        log.warn("NoHandlerFoundException:", ex);
        return this.handleException(ExceptionCode.HTTP_STATUS_NOT_FOUND, (String) null, request, response);
    }

    @ExceptionHandler({Exception.class})
    public Result otherExceptionHandler(Exception ex, HttpServletRequest request, HttpServletResponse response) {
        log.warn("Exception:", ex);
        return ex.getCause() instanceof BizException ? this.bizException((BizException) ex.getCause(), request, response) : this.handleException(ExceptionCode.SYSTEM_BUSY, (String) null, request, response);
    }
}
