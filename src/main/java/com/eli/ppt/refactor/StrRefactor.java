package com.eli.ppt.refactor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StrRefactor {

    public static void main(String[] args) {
        List<String> strList = Arrays.asList("shaw", "reese", "carter");

        filterLengthG4AndUppercaseByNormal(new ArrayList<>(strList));

        System.out.println("-----");

        filterLengthG4AndUppercaseByLambda(new ArrayList<>(strList));
    }

    /**
     * 筛选字符串长度大于4，并且将其转换为全大写
     * @param strList
     */
    private static void filterLengthG4AndUppercaseByNormal(List<String> strList) {
        List<String> result = new ArrayList<>();

        for (String str : strList) {
            if(str.length() > 4) {
                result.add(str.toUpperCase());
            }
        }

        System.out.println(result);
    }

    private static void filterLengthG4AndUppercaseByLambda(List<String> strList) {
        List<String> result = strList.stream().filter(str -> str.length() > 4).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(result);
    }
}
