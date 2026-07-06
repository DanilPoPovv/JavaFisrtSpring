package org.example.taskmanager.request;

public class CreateTaskRequest {
    private String taskName;
    private boolean status;
    private Integer userId;
    public boolean isStatus() {
        return status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
