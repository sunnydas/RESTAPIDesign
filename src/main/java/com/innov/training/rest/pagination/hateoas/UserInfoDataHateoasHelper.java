package com.innov.training.rest.pagination.hateoas;

import com.innov.training.rest.pagination.UserInfoBean;

import java.util.List;

/**
 * This class is a helper object designed to return HATEOAS User infor details
 */
public class UserInfoDataHateoasHelper {

  public List<UserInfoBean> getUserInfoBeans() {
    return userInfoBeans;
  }

  public void setUserInfoBeans(List<UserInfoBean> userInfoBeans) {
    this.userInfoBeans = userInfoBeans;
  }

  private List<UserInfoBean> userInfoBeans;

  private boolean hasMore;

  private long totalSize;

  @Override
  public String toString() {
    return "UserInfoDataHateoasHelper{" +
        "userInfoBeans=" + userInfoBeans +
        ", hasMore=" + hasMore +
        ", totalSize=" + totalSize +
        ", rowCount=" + rowCount +
        ", prev='" + prev + '\'' +
        ", self='" + self + '\'' +
        ", next='" + next + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UserInfoDataHateoasHelper that = (UserInfoDataHateoasHelper) o;

    if (isHasMore() != that.isHasMore()) return false;
    if (getTotalSize() != that.getTotalSize()) return false;
    if (getRowCount() != that.getRowCount()) return false;
    if (getUserInfoBeans() != null ? !getUserInfoBeans().equals(that.getUserInfoBeans()) : that.getUserInfoBeans() != null)
      return false;
    if (getPrev() != null ? !getPrev().equals(that.getPrev()) : that.getPrev() != null) return false;
    if (getSelf() != null ? !getSelf().equals(that.getSelf()) : that.getSelf() != null) return false;
    return !(getNext() != null ? !getNext().equals(that.getNext()) : that.getNext() != null);

  }

  @Override
  public int hashCode() {
    int result = getUserInfoBeans() != null ? getUserInfoBeans().hashCode() : 0;
    result = 31 * result + (isHasMore() ? 1 : 0);
    result = 31 * result + (int) (getTotalSize() ^ (getTotalSize() >>> 32));
    result = 31 * result + getRowCount();
    result = 31 * result + (getPrev() != null ? getPrev().hashCode() : 0);
    result = 31 * result + (getSelf() != null ? getSelf().hashCode() : 0);
    result = 31 * result + (getNext() != null ? getNext().hashCode() : 0);
    return result;
  }

  private int rowCount;

  private String prev;

  private String self;

  private String next;

  public boolean isHasMore() {
    return hasMore;
  }

  public void setHasMore(boolean hasMore) {
    this.hasMore = hasMore;

  }

  public long getTotalSize() {
    return totalSize;
  }

  public void setTotalSize(long totalSize) {
    this.totalSize = totalSize;
  }

  public int getRowCount() {
    return rowCount;
  }

  public void setRowCount(int rowCount) {
    this.rowCount = rowCount;
  }

  public String getPrev() {
    return prev;
  }

  public void setPrev(String prev) {
    this.prev = prev;
  }

  public String getSelf() {
    return self;
  }

  public void setSelf(String self) {
    this.self = self;
  }

  public String getNext() {
    return next;
  }

  public void setNext(String next) {
    this.next = next;
  }
}
