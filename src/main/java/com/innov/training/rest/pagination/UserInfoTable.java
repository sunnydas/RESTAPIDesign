package com.innov.training.rest.pagination;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sundas on 10/24/2017.
 */
public class UserInfoTable {


  public List<UserInfoBean> getRows() {
    return rows;
  }

  @Override
  public String toString() {
    return "UserInfoTable{" +
        "rows=" + rows +
        '}';
  }

  public void setRows(List<UserInfoBean> rows) {
    this.rows = rows;
  }

  private List<UserInfoBean> rows;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UserInfoTable that = (UserInfoTable) o;

    return !(getRows() != null ? !getRows().equals(that.getRows()) : that.getRows() != null);

  }

  @Override
  public int hashCode() {
    return getRows() != null ? getRows().hashCode() : 0;
  }

  public UserInfoTable() {
    this.rows = new ArrayList<>();
  }


}
