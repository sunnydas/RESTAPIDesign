package com.innov.training.rest;

import com.innov.training.rest.tasktracker.bean.Task;
import com.innov.training.rest.tasktracker.bean.TaskStatus;
import com.innov.training.rest.tasktracker.bean.tasktracker.store.SimpleTaskStore;
import com.innov.training.rest.tasktracker.bean.tasktracker.store.exception.TaskStoreException;
import org.apache.log4j.Logger;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * This class denotes a simple task tracker service
 *
 * A task is created
 * A task is updated
 * List of tasks is fetched
 * a particular task is fetched
 */
@Path("tasks")
public class TrainingTaskTrackerService {

  private Logger logger = Logger.getLogger(TrainingTaskTrackerService.class);

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response addTask(@NotNull Task task){
    Response response = null;
    try{
      task = SimpleTaskStore.createTask(task);
      response =  Response.status(Response.Status.OK).entity(task).build();
    }catch(TaskStoreException e){
      String err = "{\"errors\": [\"" + " Unable to create task , error = " + e.getMessage() +  "\"]}";
      logger.error(err);
      response = Response.status(Response.Status.BAD_REQUEST).entity(err).build();
    }
    return response;
  }


  @GET
  @Path("{taskId}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getTask(@PathParam("taskId") @NotNull String taskId){
    Response response = null;
    try{
      Task task = SimpleTaskStore.getTask(taskId);
      response = Response.status(Response.Status.OK).entity(task).build();
    }catch (TaskStoreException e){
      String err = "{\"errors\": [\"" + "error = " + e.getMessage() +  "\"]}";
      logger.error(err);
      response = Response.status(Response.Status.NOT_FOUND).entity(err).build();
    }
    return response;
  }


  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getTasks(@QueryParam("offset") @DefaultValue("0") Integer offset,
                           @QueryParam("limit") @DefaultValue("10") Integer limit,
                           @QueryParam("taskstatus") @DefaultValue("CREATED") String taskStatus){
    Response response = null;
    List<Task> tasks = SimpleTaskStore.getTasks(offset,limit,TaskStatus.valueOf(taskStatus));
    GenericEntity<List<Task>> genericEntity = new GenericEntity<List<Task>>(tasks){};
    response = Response.status(Response.Status.OK).entity(genericEntity).build();
    return response;
  }


  @DELETE
  @Path("{taskId}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response deleteTask(@PathParam("taskId") @NotNull String taskId){
    Response response = null;
    try{
      SimpleTaskStore.deleteTask(taskId);
      response = Response.status(Response.Status.NO_CONTENT).build();
    }catch (TaskStoreException e){
      String err = "{\"errors\": [\"" + "error = " + e.getMessage() +  "\"]}";
      logger.error(err);
      response = Response.status(Response.Status.NOT_FOUND).entity(err).build();
    }
    return response;
  }


  @PUT
  @Path("{taskId}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response updateTask(@PathParam("taskId") @NotNull String taskId,@NotNull Task task){
    Response response = null;
    try{
      task = SimpleTaskStore.updateTask(taskId, task);
      response = Response.status(Response.Status.OK).entity(task).build();
    }catch (TaskStoreException e){
      String err = "{\"errors\": [\"" + "error = " + e.getMessage() +  "\"]}";
      logger.error(err);
      response = Response.status(Response.Status.NOT_FOUND).entity(err).build();
    }
    return response;
  }




}
