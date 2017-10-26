package com.innov.training.rest.tasktracker.bean.tasktracker.store.exception;

/**
 * Represents a task store related exception
 */
public class TaskStoreException extends Exception{

  public TaskStoreException() {
    super();
  }

  protected TaskStoreException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public TaskStoreException(Throwable cause) {
    super(cause);
  }

  public TaskStoreException(String message, Throwable cause) {
    super(message, cause);
  }

  public TaskStoreException(String message) {
    super(message);
  }
}
