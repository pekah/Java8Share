package com.eli.ppt.base;

public class DefaultAndStaticInterfaceTest {

    public static void main(String[] args) {
        MyDefaultAndStaticInterface.staticMethod();

        MyDefaultAndStaticInterface ft = new MyDefaultAndStaticInterface() {};
        ft.defaultMethod();
    }
}
