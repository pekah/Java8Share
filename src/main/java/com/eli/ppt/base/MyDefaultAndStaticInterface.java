package com.eli.ppt.base;

public interface MyDefaultAndStaticInterface {

    /**
     * 默认方法，需要通过接口实现类的实例来调用
     */
    default void defaultMethod(){
        System.out.println("default method");
    }

    /**
     * 静态方法，不需要获得接口实现类的实例
     */
    static void staticMethod() {
        System.out.println("static method");
    }

}