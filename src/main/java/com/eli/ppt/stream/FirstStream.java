package com.eli.ppt.stream;


import java.util.Arrays;
import java.util.List;

public class FirstStream {

    public static void main(String[] args) {
        List<String> cityList = Arrays.asList("beijing", "shanghai", "shenzhen");
        cityList.stream()
                .filter(city -> city.equals("shenzhen"))
                .map(String::length)
                .forEach(System.out::println);

    }
}
