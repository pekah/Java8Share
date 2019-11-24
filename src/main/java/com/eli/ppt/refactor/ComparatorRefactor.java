package com.eli.ppt.refactor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorRefactor {

    public static void main(String[] args) {
        List<String> strList = Arrays.asList("finch", "poi", "root");

        compareNormal(new ArrayList<>(strList));

        System.out.println("-----");

        compareLambda(new ArrayList<>(strList));

        System.out.println("-----");

        compareMethodRef(new ArrayList<>(strList));
    }

    private static void compareNormal(List<String> strList) {
        strList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        System.out.println(strList);
    }

    private static void compareLambda(List<String> strList) {
        strList.sort((o1, o2) -> o1.length() - o2.length());

        System.out.println(strList);
    }

    private static void compareMethodRef(List<String> strList) {
        strList.sort(Comparator.comparing(String::length));

        System.out.println(strList);
    }
}
