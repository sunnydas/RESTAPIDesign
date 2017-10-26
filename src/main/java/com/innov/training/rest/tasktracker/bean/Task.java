package com.innov.training.rest.tasktracker.bean;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * This class represents a simple task
 */
@Produces(MediaType.APPLICATION_JSON)
public class Task {

  private String taskId;

  private String taskName;

  private String taskDescription;

  @Override
  public String toString() {
    return "Task{" +
        "taskId='" + taskId + '\'' +
        ", taskName='" + taskName + '\'' +
        ", taskDescription='" + taskDescription + '\'' +
        ", taskStatus=" + taskStatus +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Task task = (Task) o;

    if (getTaskId() != null ? !getTaskId().equals(task.getTaskId()) : task.getTaskId() != null) return false;
    if (getTaskName() != null ? !getTaskName().equals(task.getTaskName()) : task.getTaskName() != null) return false;
    if (getTaskDescription() != null ? !getTaskDescription().equals(task.getTaskDescription()) : task.getTaskDescription() != null)
      return false;
    return getTaskStatus() == task.getTaskStatus();

  }

  @Override
  public int hashCode() {
    int result = getTaskId() != null ? getTaskId().hashCode() : 0;
    result = 31 * result + (getTaskName() != null ? getTaskName().hashCode() : 0);
    result = 31 * result + (getTaskDescription() != null ? getTaskDescription().hashCode() : 0);
    result = 31 * result + (getTaskStatus() != null ? getTaskStatus().hashCode() : 0);
    return result;
  }

  private TaskStatus taskStatus;

  public String getTaskId() {
    return taskId;
  }

  public void setTaskId(String taskId) {
    this.taskId = taskId;
  }

  public String getTaskName() {
    return taskName;
  }

  public void setTaskName(String taskName) {
    this.taskName = taskName;
  }

  public String getTaskDescription() {
    return taskDescription;
  }

  public void setTaskDescription(String taskDescription) {
    this.taskDescription = taskDescription;
  }

  public TaskStatus getTaskStatus() {
    return taskStatus;
  }

  public void setTaskStatus(TaskStatus taskStatus) {
    this.taskStatus = taskStatus;
  }
}
