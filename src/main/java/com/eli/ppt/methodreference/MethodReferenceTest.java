package com.eli.ppt.methodreference;


import java.util.Arrays;
import java.util.List;

public class MethodReferenceTest {

    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 10);
        Student student2 = new Student("lisi", 90);
        Student student3 = new Student("wangwu", 50);
        Student student4 = new Student("zhaoliu", 40);

        List<Student> students = Arrays.asList(student1, student2, student3, student4);

        // 使用lambda表示进行排序
        students.sort((s1, s2) -> s1.getScore() - s2.getScore());
        students.forEach(student -> System.out.println(student.getScore()));

        System.out.println("--------");

        //类名::静态方法名
        students.sort(Student::compareStudentByScore);
        students.forEach(student -> System.out.println(student.getScore()));

        System.out.println("--------");

        //引用名::实例方法名
        students.sort(new StudentComparator()::compareStudentByScore);
        students.forEach(student -> System.out.println(student.getScore()));

        System.out.println("--------");

        //sort方法的第一个入参调用compareByScore，并把第二个入参作为compareByScore方法的参数
        //类名::实例方法名
        students.sort(Student::compareByScore);
        students.forEach(student -> System.out.println(student.getScore()));
    }
}
