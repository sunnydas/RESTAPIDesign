package com.innov.training.rest.pagination;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * This class represents a single row of user infor
 * this ahs been done to get around the error:
 *
 * Oct 24, 2017 3:01:40 PM org.glassfish.jersey.message.internal.WriterInterceptorE
 xecutor$TerminalWriterInterceptor aroundWriteTo
 SEVERE: MessageBodyWriter not found for media type=application/json, type=class
 java.util.ArrayList, genericType=java.util.List<java.lang.String>.
 */
@Produces(MediaType.APPLICATION_JSON)
public class UserInfoBean {

  public String getRow() {
    return row;
  }

  public void setRow(String row) {
    this.row = row;
  }

  @Override
  public String toString() {
    return "UserInfoBean{" +
        "row='" + row + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UserInfoBean that = (UserInfoBean) o;

    return !(getRow() != null ? !getRow().equals(that.getRow()) : that.getRow() != null);

  }

  @Override
  public int hashCode() {
    return getRow() != null ? getRow().hashCode() : 0;
  }

  private String row;

}
