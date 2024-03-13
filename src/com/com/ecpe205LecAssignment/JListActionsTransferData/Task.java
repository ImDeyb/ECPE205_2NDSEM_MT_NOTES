package com.ecpe205LecAssignment.JListActionsTransferData;

public class Task {
    private String taskname;

    public Task(String taskname) {
        this.taskname = taskname;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    @Override
    public String toString() {
        return taskname;
    }
}
