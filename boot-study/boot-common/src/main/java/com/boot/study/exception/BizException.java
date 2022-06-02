//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.boot.study.exception;

public class BizException extends BaseUncheckedException {
    private static final long serialVersionUID = -3843907364558373817L;

    public BizException(String message) {
        super("1", message);
    }

    public BizException(String code, String message, Object... args) {
        super(code, message, args);
    }

    public static BizException wrap(String code, String message, Object... args) {
        return new BizException(code, message, args);
    }

    public static BizException wrap(BaseExceptionCode ex) {
        return new BizException(ex.getCode(), ex.getMsg(), new Object[0]);
    }

    public String toString() {
        return "BizException [message=" + this.message + ", code=" + this.code + "]";
    }
}
