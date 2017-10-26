package com.innov.training.rest.users.store.exception;

/**
 * Created by user on 10/22/2017.
 */
public class SimpleUserStoreException extends Exception {

  public SimpleUserStoreException(String message, Throwable cause) {
    super(message, cause);
  }

  public SimpleUserStoreException(String message) {
    super(message);
  }
}
