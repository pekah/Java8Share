package com.eli.ppt.base.lambda;

public class LambdaThis {

    Runnable r1 = () -> {
        System.out.println(this);
    };

    Runnable r2 = () -> {
        System.out.println(toString());
    };

    public static void main(String[] args) {
        new LambdaThis().r1.run();
        new LambdaThis().r2.run();
    }

    @Override
    public String toString() {
        return "hello world";
    }
}
