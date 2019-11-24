package com.eli.ppt.methodreference;

/**
 * Created by zhouyilin on 2017/5/7.
 */
public class Student {

    private String name;
    private int score;

    public Student(){

    }

    public Student(String name, int score){
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static int compareStudentByScore(Student s1, Student s2){
        return s1.getScore() - s2.getScore();
    }

    public static int compareStudentByName(Student s1, Student s2){
        return s1.getName().compareToIgnoreCase(s2.getName());
    }

    public int compareByScore(Student s){
        return this.getScore() - s.getScore();
    }

    public int compareByName(Student s){
        return this.name.compareToIgnoreCase(s.getName());
    }
}
