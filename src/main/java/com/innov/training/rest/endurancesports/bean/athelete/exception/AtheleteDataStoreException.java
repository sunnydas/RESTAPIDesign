package com.innov.training.rest.endurancesports.bean.athelete.exception;

/**
 * Created by sundas on 10/22/2017.
 */
public class AtheleteDataStoreException extends Exception{

  public AtheleteDataStoreException() {
  }

  public AtheleteDataStoreException(String message) {
    super(message);
  }

  public AtheleteDataStoreException(String message, Throwable cause) {
    super(message, cause);
  }

  public AtheleteDataStoreException(Throwable cause) {
    super(cause);
  }

  public AtheleteDataStoreException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
