package com.innov.training.rest;

import com.innov.training.rest.metadata.StaticMetaDataStore;
import com.innov.training.rest.metadata.bean.MetadatBean;
import org.apache.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * This class illustrates the cache control directives available from native HTTP.
 */
@Path("metadata")
public class TrainingCacheControlService {

  private Logger logger = Logger.getLogger(TrainingCacheControlService.class);


  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getMetadata(){
    StaticMetaDataStore staticMetaDataStore = new StaticMetaDataStore();
    staticMetaDataStore.seed();
    List<MetadatBean> metadataBeans = staticMetaDataStore.getMetadatBeans();
    logger.info(metadataBeans);
    GenericEntity<List<MetadatBean>> genericEntity = new GenericEntity<List<MetadatBean>>(metadataBeans){};
    Response.ResponseBuilder responseBuilder = Response.ok(genericEntity).type(MediaType.APPLICATION_JSON);
    //This example sets validity as
    //Dec 31 of the current year
    int currentYear = getCurrentYear();
    logger.info(currentYear);
    Calendar expirationDate = new GregorianCalendar(currentYear,Calendar.DECEMBER,31);
    logger.info(expirationDate.getTime());
    responseBuilder.expires(expirationDate.getTime());
    CacheControl cacheControl = new CacheControl();
    /*
    if max age and expires are both set , max age takes precedence
     */
    cacheControl.setMaxAge(96400);
    cacheControl.setPrivate(true);
    cacheControl.setNoTransform(true);
    responseBuilder.cacheControl(cacheControl);
    Response response = responseBuilder.build();
    return response;
  }

  private int getCurrentYear() {
    GregorianCalendar gc = new GregorianCalendar();
    int year = gc.get(Calendar.YEAR);
    return year;
  }


}
