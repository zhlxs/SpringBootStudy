//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.boot.study.exception;

public interface BaseExceptionCode {
    String getCode();

    String getMsg();

    default int getStatus() {
        return 500;
    }
}
