package com.innov.training.rest.users.bean;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * This class represents a simple user bean used by User service.
 */
@Produces(MediaType.APPLICATION_JSON)
public class SimpleUserBean {

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  private String userId;

  @Override
  public String toString() {
    return "SimpleUserBean{" +
        "userId='" + userId + '\'' +
        ", fName='" + fName + '\'' +
        ", lName='" + lName + '\'' +
        ", primaryEmailAddress='" + primaryEmailAddress + '\'' +
        ", homeAddress='" + homeAddress + '\'' +
        ", age=" + age +
        ", primarymobilePhoneNumber=" + primarymobilePhoneNumber +
        '}';
  }

  private String fName;

  private String lName;

  private String primaryEmailAddress;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    SimpleUserBean that = (SimpleUserBean) o;

    if (getAge() != that.getAge()) return false;
    if (getPrimarymobilePhoneNumber() != that.getPrimarymobilePhoneNumber()) return false;
    if (getUserId() != null ? !getUserId().equals(that.getUserId()) : that.getUserId() != null) return false;
    if (getfName() != null ? !getfName().equals(that.getfName()) : that.getfName() != null) return false;
    if (getlName() != null ? !getlName().equals(that.getlName()) : that.getlName() != null) return false;
    if (getPrimaryEmailAddress() != null ? !getPrimaryEmailAddress().equals(that.getPrimaryEmailAddress()) : that.getPrimaryEmailAddress() != null)
      return false;
    return !(getHomeAddress() != null ? !getHomeAddress().equals(that.getHomeAddress()) : that.getHomeAddress() != null);

  }

  @Override
  public int hashCode() {
    int result = getUserId() != null ? getUserId().hashCode() : 0;
    result = 31 * result + (getfName() != null ? getfName().hashCode() : 0);
    result = 31 * result + (getlName() != null ? getlName().hashCode() : 0);
    result = 31 * result + (getPrimaryEmailAddress() != null ? getPrimaryEmailAddress().hashCode() : 0);
    result = 31 * result + (getHomeAddress() != null ? getHomeAddress().hashCode() : 0);
    result = 31 * result + getAge();
    result = 31 * result + getPrimarymobilePhoneNumber();
    return result;
  }

  public String getfName() {

    return fName;
  }

  public void setfName(String fName) {
    this.fName = fName;
  }

  public String getlName() {
    return lName;
  }

  public void setlName(String lName) {

    this.lName = lName;
  }

  public String getPrimaryEmailAddress() {
    return primaryEmailAddress;
  }

  public void setPrimaryEmailAddress(String primaryEmailAddress) {
    this.primaryEmailAddress = primaryEmailAddress;
  }

  public String getHomeAddress() {
    return homeAddress;
  }

  public void setHomeAddress(String homeAddress) {
    this.homeAddress = homeAddress;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getPrimarymobilePhoneNumber() {
    return primarymobilePhoneNumber;
  }

  public void setPrimarymobilePhoneNumber(int primarymobilePhoneNumber) {
    this.primarymobilePhoneNumber = primarymobilePhoneNumber;
  }

  private String homeAddress;

  private int age;

  private int primarymobilePhoneNumber;


}
