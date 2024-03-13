package com.ecpe205LecAssignment.JListActions;

public class Student {
    private String name, course;

    public Student(String name, String course) {
        this.name = name;
        this.course = course;
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return name;
    }
}