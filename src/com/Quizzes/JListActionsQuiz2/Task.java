package com.Quizzes.JListActionsQuiz2;

public class Task {
    private String name, assign;

    public Task(String name, String assign) {
        this.name = name;
        this.assign = assign;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAssign() {
        return assign;
    }

    public void setAssign(String assign) {
        this.assign = assign;
    }

    @Override
    public String toString() {
        return name + "\n" + " @ " + assign;
    }
}
