package com.wmt.jdk8.model;

public class Students {
    private String name;
    private int score;
    public  Students(String name,int score){
        this.name=name;
        this.score=score;
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

    public static int compareStudentByScore(Students student1,Students student2){
        return student1.getScore()-student2.getScore();
    }
    public  static  int compareStudentByName(Students student1,Students student2){
        return student1.getName().compareTo(student2.getName());
    }

    public  int compareByScore(Students students){
        return this.score-students.getScore();
    }
    public int compareByName(Students students){
        return this.name.compareTo(students.getName());
    }
}
