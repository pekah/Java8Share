package com.eli.ppt.collector;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsTest {
    public static void main(String[] args) {
        joiningTest();
        System.out.println("--------");
        summarizingTest();
    }

    private static void joiningTest() {
        List<String> strList = Arrays.asList("hello", "hi", "bye");
        System.out.println(strList.stream().collect(Collectors.joining()));
        System.out.println(strList.stream().collect(Collectors.joining(",")));
        System.out.println(strList.stream().collect(Collectors.joining(",", "[", "]")));
    }

    private static void summarizingTest() {
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5);

        IntSummaryStatistics result = numberList.stream().collect(Collectors.summarizingInt((item) -> item));
        System.out.println("最大值：" + result.getMax());
        System.out.println("最小值：" + result.getMin());
        System.out.println("平均数：" + result.getAverage());
        System.out.println("求和：" + result.getSum());

    }


}
