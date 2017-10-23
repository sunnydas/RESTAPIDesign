package com.innov.training.rest.metadata;


import com.innov.training.rest.metadata.bean.MetadatBean;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a static metadata store , thsi will be used to illustrate cache control directives
 */
public class StaticMetaDataStore {


  public List<MetadatBean> getMetadatBeans() {
    return metadatBeans;
  }

  private List<MetadatBean> metadatBeans = new ArrayList<>();

  /**
   * Simulating a decent size seeding of metadata
   *
   *
   */
  public void seed(){
    int id = 0;
    int index = 0;
    while(index < 1000){
      MetadatBean metadataBean = new MetadatBean();
      metadataBean.setId(id++);
      String metadata = "metadata {} " + id;
      metadataBean.setMetadata(metadata);
      metadatBeans.add(metadataBean);
      index++;
    }
  }

  public void addToMetadata(MetadatBean metadatBean){
    metadatBeans.add(metadatBean);
  }

  @Override
  public String toString() {
    return "StaticMetaDataStore{" +
        "metadatBeans=" + metadatBeans +
        '}';
  }
}
