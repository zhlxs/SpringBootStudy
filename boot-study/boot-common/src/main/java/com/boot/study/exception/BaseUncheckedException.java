//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.boot.study.exception;

public class BaseUncheckedException extends RuntimeException implements BaseException {
    private static final long serialVersionUID = -778887391066124051L;
    protected String message;
    protected String code;

    public BaseUncheckedException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BaseUncheckedException(String code, String format, Object... args) {
        super(String.format(format, args));
        this.code = code;
        this.message = String.format(format, args);
    }

    public BaseUncheckedException(String message, Throwable exception) {
        super(message, exception);
        this.code = ExceptionCode.HTTP_STATUS_INTERNAL_SERVER_ERROR.getCode();
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public String getCode() {
        return this.code;
    }
}
