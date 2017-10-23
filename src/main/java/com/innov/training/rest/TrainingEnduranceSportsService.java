package com.innov.training.rest;

import com.innov.training.rest.endurancesports.bean.athelete.AtheletesResource;
import com.innov.training.rest.endurancesports.bean.athelete.exception.AtheleteDataStoreException;
import com.innov.training.rest.endurancesports.bean.athelete.store.EnduranceSportsDataStore;
import com.innov.training.rest.endurancesports.bean.EnduranceSportBean;
import com.innov.training.rest.endurancesports.bean.athelete.AtheleteBean;
import com.innov.training.rest.endurancesports.exception.EnduranceSportsDataStoreException;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * This class represents a collection of endurance sports (collection)
 *
 *
 */
@Path("endurancesports")
public class TrainingEnduranceSportsService {


  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<EnduranceSportBean> getAllCurrentActivities(){
    List<EnduranceSportBean> sportBeans = EnduranceSportsDataStore.getAllActivities();
    return sportBeans;
  }


  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public EnduranceSportBean addSportsActivity(@NotNull EnduranceSportBean enduranceSportBean){
    if(enduranceSportBean != null){
      enduranceSportBean = EnduranceSportsDataStore.addEnduranceSportsActivity(enduranceSportBean);
    }
    return enduranceSportBean;
  }

  @GET
  @Path("/{activityId}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public EnduranceSportBean getSportsActivityDetails(@PathParam("activityId") @NotNull String activityId)
      throws EnduranceSportsDataStoreException{
    return EnduranceSportsDataStore.getActivityDetails(activityId);
  }

  @DELETE
  @Path("/{activityId}")
  @Produces(MediaType.APPLICATION_JSON)
  public void deleteSportsActivityDetails(@PathParam("activityId") @NotNull String activityId)
      throws EnduranceSportsDataStoreException{
    EnduranceSportsDataStore.deleteActivityDetails(activityId);
  }


  @Path("/{activityId}/atheletes")
  public AtheletesResource getAllAtheletes(@PathParam("activityId") @NotNull String activityId)throws AtheleteDataStoreException{
    AtheletesResource atheletesResource = null;
    if(activityId != null){
      atheletesResource = new AtheletesResource();
    }
    return atheletesResource;
  }


  @Path("/{activityId}/athelete/")
  public AtheletesResource addAthelete(@PathParam("activityId") @NotNull String activityId) throws AtheleteDataStoreException{
    AtheletesResource atheletesResource = null;
    if(activityId != null){
      atheletesResource = new AtheletesResource();
    }
    return atheletesResource;
  }

  @Path("/{activityId}/athelete/{atheleteId}")
  public AtheletesResource updateAthelete(@PathParam("activityId") @NotNull String activityId,@PathParam("atheleteId") @NotNull String atheleteId) throws AtheleteDataStoreException{
    AtheletesResource atheletesResource = null;
    if(activityId != null){
      atheletesResource = new AtheletesResource();
    }
    return atheletesResource;
  }

}
