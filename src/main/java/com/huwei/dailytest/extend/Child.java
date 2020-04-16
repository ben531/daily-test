package com.huwei.dailytest.extend;

import lombok.Data;

@Data
public class Child extends Parent {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setXing(String xing){
        System.out.println("子类重写了setXing()方法");
        super.setXing("z");
    }

    @Override
    public String toString() {
        return super.toString() +"Child{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        // 父类的引用指向子类的对象, 只能调用父类的方法
        Parent p = new Child();
        p.setXing("l");
        System.out.println(p);
        Child c = new Child();
    }
}
