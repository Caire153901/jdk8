package com.wmt.jdk8.model;

public class CollectorStudent {
    private String name;
    private int score;
    public  CollectorStudent(String name,int score){
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

    @Override
    public String toString() {
        return "CollectorStudent{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
