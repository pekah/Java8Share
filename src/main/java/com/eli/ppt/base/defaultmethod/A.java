package com.eli.ppt.base.defaultmethod;

public interface A {
    default void sayHello() {
        System.out.println("hello A");
    }
}
