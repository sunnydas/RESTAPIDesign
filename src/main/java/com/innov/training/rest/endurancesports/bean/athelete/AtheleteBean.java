package com.innov.training.rest.endurancesports.bean.athelete;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * This class represents a single endurance athelete bean
 */
@Produces(MediaType.APPLICATION_JSON)
public class AtheleteBean {

  private String atheleteId;

  private String fName;

  private String lName;

  @Override
  public String toString() {
    return "AtheleteBean{" +
        "atheleteId='" + atheleteId + '\'' +
        ", fName='" + fName + '\'' +
        ", lName='" + lName + '\'' +
        ", location='" + location + '\'' +
        ", club='" + club + '\'' +
        ", age=" + age +
        ", gender=" + gender +
        ", activityId='" + activityId + '\'' +
        ", rank=" + rank +
        '}';
  }

  public String getAtheleteId() {
    return atheleteId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    AtheleteBean that = (AtheleteBean) o;

    if (getAge() != that.getAge()) return false;
    if (getRank() != that.getRank()) return false;
    if (getAtheleteId() != null ? !getAtheleteId().equals(that.getAtheleteId()) : that.getAtheleteId() != null)
      return false;
    if (getfName() != null ? !getfName().equals(that.getfName()) : that.getfName() != null) return false;
    if (getlName() != null ? !getlName().equals(that.getlName()) : that.getlName() != null) return false;
    if (getLocation() != null ? !getLocation().equals(that.getLocation()) : that.getLocation() != null) return false;
    if (getClub() != null ? !getClub().equals(that.getClub()) : that.getClub() != null) return false;
    if (getGender() != that.getGender()) return false;
    return !(getActivityId() != null ? !getActivityId().equals(that.getActivityId()) : that.getActivityId() != null);

  }

  @Override
  public int hashCode() {
    int result = getAtheleteId() != null ? getAtheleteId().hashCode() : 0;
    result = 31 * result + (getfName() != null ? getfName().hashCode() : 0);
    result = 31 * result + (getlName() != null ? getlName().hashCode() : 0);
    result = 31 * result + (getLocation() != null ? getLocation().hashCode() : 0);
    result = 31 * result + (getClub() != null ? getClub().hashCode() : 0);
    result = 31 * result + getAge();
    result = 31 * result + (getGender() != null ? getGender().hashCode() : 0);
    result = 31 * result + (getActivityId() != null ? getActivityId().hashCode() : 0);
    result = 31 * result + getRank();
    return result;
  }

  public void setAtheleteId(String atheleteId) {
    this.atheleteId = atheleteId;
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

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getClub() {
    return club;
  }

  public void setClub(String club) {
    this.club = club;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public AtheleteGender getGender() {
    return gender;
  }

  public void setGender(AtheleteGender gender) {
    this.gender = gender;
  }

  public String getActivityId() {
    return activityId;
  }

  public void setActivityId(String activityId) {
    this.activityId = activityId;
  }

  public int getRank() {
    return rank;
  }

  public void setRank(int rank) {
    this.rank = rank;
  }

  private String location;

  private String club;

  private int age;

  private AtheleteGender gender;

  private String activityId;

  private int rank;

}
