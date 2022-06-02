//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.boot.study.bean;

import cn.hutool.core.util.ArrayUtil;
import com.boot.study.exception.BaseExceptionCode;
import com.boot.study.exception.BizException;
import com.boot.study.exception.ExceptionCode;

import java.time.LocalDateTime;
import java.util.Collection;

public class BizAssert {
    private BizAssert() {
    }

    public static void fail(String code, String message) {
        throw new BizException(code, message, new Object[0]);
    }

    public static void fail(BaseExceptionCode exceptionCode) {
        if (exceptionCode != null) {
            throw new BizException(exceptionCode.getCode(), exceptionCode.getMsg(), new Object[0]);
        } else {
            fail(ExceptionCode.BASE_VALID_PARAM.getCode(), "参数验证异常");
        }
    }

    public static void fail() {
        fail(ExceptionCode.BASE_VALID_PARAM.getCode(), "参数验证异常");
    }

    public static void fail(String message) {
        if (message == null || "".equals(message)) {
            message = "参数验证异常";
        }

        fail(ExceptionCode.BASE_VALID_PARAM.getCode(), message);
    }

    public static void isTrue(boolean condition, BaseExceptionCode exceptionCode) {
        if (!condition) {
            fail(exceptionCode);
        }

    }

    public static void isTrue(boolean condition, String exceptionMessage) {
        if (!condition) {
            fail(exceptionMessage);
        }

    }

    public static void isTrue(boolean condition) {
        if (!condition) {
            fail();
        }

    }

    public static void isFalse(boolean condition, BaseExceptionCode exceptionCode) {
        if (condition) {
            fail(exceptionCode);
        }

    }

    public static void isFalse(boolean condition, String exceptionMessage) {
        if (condition) {
            fail(exceptionMessage);
        }

    }

    public static void notNull(Object object, BaseExceptionCode exceptionCode) {
        if (object == null) {
            fail(exceptionCode);
        }

    }

    public static void notNull(Object object) {
        if (object == null) {
            fail();
        }

    }

    public static void notNull(Object object, String message) {
        if (object == null) {
            fail(message);
        }

    }

    public static void isNull(Object object, BaseExceptionCode exceptionCode) {
        if (object != null) {
            fail(exceptionCode);
        }

    }

    public static void notEmpty(Collection<?> collection, BaseExceptionCode exceptionCode) {
        if (collection == null || collection.isEmpty()) {
            fail(exceptionCode);
        }

    }

    public static <T> void notEmpty(T[] array, BaseExceptionCode exceptionCode) {
        if (ArrayUtil.hasNull(array)) {
            fail(exceptionCode);
        }

    }

    public static void notEmpty(String value, BaseExceptionCode exceptionCode) {
        if (value == null || value.isEmpty()) {
            fail(exceptionCode);
        }

    }

    public static void notEmpty(String value, String exceptionMsgs) {
        if (value == null || value.isEmpty()) {
            fail(exceptionMsgs);
        }

    }

    public static void notEmpty(String value) {
        if (value == null || value.isEmpty()) {
            fail();
        }

    }

    public static void notEquals(Object unexpected, Object actual, BaseExceptionCode exceptionCode) {
        if (unexpected == actual) {
            fail(exceptionCode);
        }

        if (unexpected != null && unexpected.equals(actual)) {
            fail(exceptionCode);
        }

    }

    public static void equals(String expected, String actual, BaseExceptionCode exceptionCode) {
        if (expected != null || actual != null) {
            if (expected == null || !expected.equals(actual)) {
                fail(exceptionCode);
            }
        }
    }

    public static void equals(String expected, String actual, String exceptionMsgs) {
        if (expected != null || actual != null) {
            if (expected == null || !expected.equals(actual)) {
                fail(exceptionMsgs);
            }
        }
    }

    public static void equals(Object expected, Object actual, String exceptionMsgs) {
        if (expected != null || actual != null) {
            if (expected == null || !expected.equals(actual)) {
                fail(exceptionMsgs);
            }
        }
    }

    public static void gt(LocalDateTime expected, LocalDateTime actual, String exceptionMsgs) {
        if (expected == null || actual == null) {
            fail(exceptionMsgs);
        }

        if (expected.isAfter(actual)) {
            fail(exceptionMsgs);
        }

    }
}
