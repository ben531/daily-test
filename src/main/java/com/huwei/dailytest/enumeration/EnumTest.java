package com.huwei.dailytest.enumeration;

public enum  EnumTest {
    SUCCESS(0,"成功"),
    FAILED(1,"失败");
    private Integer code;
    private String msg;

    private EnumTest() {
    }

    private EnumTest(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
