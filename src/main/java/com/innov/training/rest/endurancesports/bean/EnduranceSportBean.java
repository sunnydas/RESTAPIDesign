package com.innov.training.rest.endurancesports.bean;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * This class represents the endurance sport activity
 */
@Produces(MediaType.APPLICATION_JSON)
public class EnduranceSportBean {

  private String activityName;

  public String getActivityName() {
    return activityName;
  }

  public void setActivityName(String activityName) {
    this.activityName = activityName;
  }

  @Override
  public String toString() {
    return "EnduranceSportBean{" +
        "activityName='" + activityName + '\'' +
        ", activityId='" + activityId + '\'' +
        ", activityDescription='" + activityDescription + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    EnduranceSportBean that = (EnduranceSportBean) o;

    if (getActivityName() != null ? !getActivityName().equals(that.getActivityName()) : that.getActivityName() != null)
      return false;
    if (getActivityId() != null ? !getActivityId().equals(that.getActivityId()) : that.getActivityId() != null)
      return false;
    return !(getActivityDescription() != null ? !getActivityDescription().equals(that.getActivityDescription()) : that.getActivityDescription() != null);

  }

  @Override
  public int hashCode() {
    int result = getActivityName() != null ? getActivityName().hashCode() : 0;
    result = 31 * result + (getActivityId() != null ? getActivityId().hashCode() : 0);
    result = 31 * result + (getActivityDescription() != null ? getActivityDescription().hashCode() : 0);
    return result;
  }

  public String getActivityId() {
    return activityId;

  }

  public void setActivityId(String activityId) {
    this.activityId = activityId;
  }

  public String getActivityDescription() {
    return activityDescription;
  }

  public void setActivityDescription(String activityDescription) {
    this.activityDescription = activityDescription;
  }

  private String activityId;

  private String activityDescription;


}
