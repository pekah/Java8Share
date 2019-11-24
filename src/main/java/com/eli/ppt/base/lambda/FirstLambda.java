package com.eli.ppt.base.lambda;

import java.util.function.*;

public class FirstLambda {

    public static void main(String[] args) {

        Supplier<String> stringSupplier = () -> {return "hello";};

        Consumer<String> consumer = (str) -> {System.out.println(str);};

        Predicate<Integer> predicate = (Integer i) -> true;

        Function<Integer, String> function = (i) -> i.toString();

        BiFunction<Integer, Long, String> biFunction = (i , j) -> i + "" + j;




    }
}
