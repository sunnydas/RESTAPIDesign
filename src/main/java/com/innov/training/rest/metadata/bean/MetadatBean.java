package com.innov.training.rest.metadata.bean;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * A simple metadata bean
 */
@Produces(MediaType.APPLICATION_JSON)
public class MetadatBean {

  private int id;

  private String metadata;

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return "MetadatBean{" +
        "id=" + id +
        ", metadata='" + metadata + '\'' +
        '}';
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getMetadata() {
    return metadata;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    MetadatBean that = (MetadatBean) o;

    if (getId() != that.getId()) return false;
    return !(getMetadata() != null ? !getMetadata().equals(that.getMetadata()) : that.getMetadata() != null);

  }

  @Override
  public int hashCode() {
    int result = getId();
    result = 31 * result + (getMetadata() != null ? getMetadata().hashCode() : 0);
    return result;
  }

  public void setMetadata(String metadata) {
    this.metadata = metadata;
  }
}
