package com.huwei.dailytest.extend;

import lombok.Data;

@Data
public class Parent {
    private String xing;
    private Integer age;

    public String getXing() {
        return xing;
    }

    public void setXing(String xing) {
        System.out.println("父类姓王");
        this.xing = xing;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
