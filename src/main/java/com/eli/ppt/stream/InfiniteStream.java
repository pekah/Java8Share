package com.eli.ppt.stream;

import java.util.Random;
import java.util.stream.Stream;

public class InfiniteStream {

    public static void main(String[] args) {
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]}).limit(10)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));

        System.out.println("--------------------------------------");

        Stream.generate(() -> new Random().nextInt(4))
                .filter((data) -> data > 0).limit(10).forEach(System.out::println);

    }
}
