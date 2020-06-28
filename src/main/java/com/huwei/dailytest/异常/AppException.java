package com.huwei.dailytest.异常;

public class AppException extends RuntimeException {

    private int exceptionCode = 1000;

    public AppException() {
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppException(String message) {
        super(message);
    }

    public AppException(Throwable cause) {
        super(cause);
    }

    public AppException(int exceptionCode, String message) {
        super(message);
        this.exceptionCode = exceptionCode;
    }

    public AppException(int exceptionCode, String message, Throwable cause) {
        super(message, cause);
        this.exceptionCode = exceptionCode;
    }


    public int getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(int exceptionCode) {
        this.exceptionCode = exceptionCode;
    }
}
