package com.innov.training.rest;

import com.innov.training.rest.heavylifting.taskrunner.BulDataFetcher;
import org.apache.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * This class reprsents a long running task service
 */
@Path("heavylifting")
public class TrainingLongRunningTaskService {

  private Logger logger = Logger.getLogger(TrainingLongRunningTaskService.class);

  private final ExecutorService executorService = Executors.newCachedThreadPool();

  @GET
  @Path("fetch")
  @Produces(MediaType.APPLICATION_JSON)
  public void fetchBulkMetadata(@Suspended AsyncResponse asyncResponse){
    asyncResponse.setTimeout(30, TimeUnit.SECONDS);
    Runnable bulkFetchQuery = new Runnable() {
      @Override
      public void run() {
        BulDataFetcher bulDataFetcher = new BulDataFetcher();
        String data = bulDataFetcher.bulkFetch();
        String responsePayLoad = "{\"data\": [\"" + data + "\"]}";
        asyncResponse.resume(Response.ok().entity(responsePayLoad).build());
      }
    };
    executorService.execute(bulkFetchQuery);
  }


}
