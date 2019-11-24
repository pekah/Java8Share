package com.eli.ppt.collector;

import java.util.*;
import java.util.stream.Collectors;

public class GroupBy {

    public static List<Student> students = Arrays.asList(
            new Student(Sex.MAN, 18),
            new Student(Sex.WOMAN, 13),
            new Student(Sex.MAN, 88),
            new Student(Sex.WOMAN, 15),
            new Student(Sex.WOMAN, 19),
            new Student(Sex.MAN, 11));


    public static void main(String[] args) {
        normalGroupBySex();
        System.out.println("----------");
        collectorGroupBySex();
    }

    private static void normalGroupBySex() {
        Map<Sex, List<Student>> studentsBySex = new HashMap<>();
        for (Student student : students) {
            Sex sex = student.getSex();
            List<Student> studentsForSameSex = studentsBySex.get(sex);
            if (studentsForSameSex == null) {
                studentsForSameSex = new ArrayList<>();
                studentsBySex.put(sex, studentsForSameSex);
            }
            studentsForSameSex.add(student);
        }

        System.out.println(studentsBySex);
    }

    private static void collectorGroupBySex() {
        Map<Sex, List<Student>> groupResult = students.stream().collect(Collectors.groupingBy(Student::getSex));
        System.out.println(groupResult);
    }

    public static class Student {
        private final Sex sex;
        private final int age;

        public Student(Sex sex, int age) {
            this.sex = sex;
            this.age = age;
        }

        public Sex getSex() {
            return sex;
        }

        public double getAge() {
            return age;
        }

        @Override
        public String toString() {
            return sex + " " + age;
        }
    }

    public enum Sex {
        MAN, WOMAN
    }
}
