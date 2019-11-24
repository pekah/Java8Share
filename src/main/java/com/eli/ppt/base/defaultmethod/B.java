package com.eli.ppt.base.defaultmethod;

public interface B extends A{
    default void sayHello() {
        System.out.println("hello B");
    }
}
