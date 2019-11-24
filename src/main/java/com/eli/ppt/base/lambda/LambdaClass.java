package com.eli.ppt.base.lambda;

public class LambdaClass {

    public static void main(String[] args) {
        new Thread(
                () -> System.out.println("Lambda Thread run()")
        ).start();;
    }
}
