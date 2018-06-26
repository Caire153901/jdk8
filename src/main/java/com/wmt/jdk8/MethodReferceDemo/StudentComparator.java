package com.wmt.jdk8.MethodReferceDemo;

import com.wmt.jdk8.model.Students;

public class StudentComparator {
    public  int compareStudentByScore(Students students1,Students students2){
        return students1.getScore()-students2.getScore();
    }
    public  int compareStudentByName(Students students1,Students students2){
        return students1.getName().compareTo(students2.getName());
    }
}
