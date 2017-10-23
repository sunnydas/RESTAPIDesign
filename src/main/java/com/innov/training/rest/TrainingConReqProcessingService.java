package com.innov.training.rest;

import com.innov.training.rest.dynamic.bean.DayTemperature;
import com.innov.training.rest.dynamic.resource.DayTemperatureLookUpresource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *This class illustrated conditional request processing using the Last-Modified header property
 */
@Path("daytemperature")
public class TrainingConReqProcessingService {


  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getCurrentTemperature(@Context Request request){
    Response response = null;
    DayTemperature dayTemperature = DayTemperatureLookUpresource.getCurrentTemperature();
    GregorianCalendar currentTime = dayTemperature.getLastModifiedDate();
    Date modifiedDate = currentTime.getTime();
    Response.ResponseBuilder builder =
        request.evaluatePreconditions(modifiedDate);
    if(builder == null){
      builder = Response.ok(dayTemperature);
      builder.lastModified(modifiedDate);
    }
    response = builder.build();
    return response;
  }



  @GET
  @Path("tagged")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getCurrentTemperatureTagged(@Context Request request){
    Response response = null;
    DayTemperature dayTemperature = DayTemperatureLookUpresource.getCurrentTemperature();
    EntityTag entityTag = new EntityTag(Integer.toString(dayTemperature.hashCode()));
    //evaluate etag
    Response.ResponseBuilder builder =
        request.evaluatePreconditions(entityTag);
    if(builder == null){
      builder = Response.ok(dayTemperature);
      builder.tag(entityTag);
    }
    response = builder.build();
    return response;
  }




}
