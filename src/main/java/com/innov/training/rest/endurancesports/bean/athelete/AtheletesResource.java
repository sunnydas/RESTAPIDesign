package com.innov.training.rest.endurancesports.bean.athelete;

import com.innov.training.rest.endurancesports.bean.athelete.exception.AtheleteDataStoreException;
import com.innov.training.rest.endurancesports.bean.athelete.store.AtheleteDataStore;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by sundas on 10/22/2017.
 */
public class AtheletesResource {

  private AtheleteBean atheleteBean;

  public AtheletesResource(AtheleteBean atheleteBean) {
    this.atheleteBean = atheleteBean;
  }

  public AtheletesResource(){

  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<AtheleteBean> getAllAtheletes(@PathParam("activityId") String activityId)throws AtheleteDataStoreException{
    return AtheleteDataStore.getAllAtheletesForActivity(activityId);
  }


  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public AtheleteBean addAthelete(@PathParam("activityId") String activityId,AtheleteBean atheleteBean)
      throws AtheleteDataStoreException {
    return AtheleteDataStore.addAthelete(activityId,atheleteBean);
  }

}
