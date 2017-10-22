package com.innov.training.rest;

import com.innov.training.rest.users.bean.SimpleUserBean;
import com.innov.training.rest.users.store.SimpleUserStore;
import com.innov.training.rest.users.store.exception.SimpleUserStoreException;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * This class represents a sample User service application.
 * It allows us to create/update/delete and list users
 */
@Path("users")
public class TrainingUserService {

  private Logger logger = Logger.getLogger(TrainingUserService.class);

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createUser(SimpleUserBean simpleUserBean){
    Response response = null;
    if(simpleUserBean != null){
      simpleUserBean = SimpleUserStore.addUserToStore(simpleUserBean);
      response =  Response.status(Response.Status.OK).entity(simpleUserBean).build();
    }
    else {
      String err = "{\"errors\": [\"" + " Invalid payload = " + simpleUserBean +  "\"]}";
      logger.error(err);
      response = Response.status(Response.Status.BAD_REQUEST).entity(err).build();
    }
    return response;
  }


  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getUsers(){
    Response response = null;
    List<SimpleUserBean> users = SimpleUserStore.getAllUsers();
    if(users != null){
      GenericEntity<List<SimpleUserBean>> genericEntity = new GenericEntity<List<SimpleUserBean>>(users){};
      response = Response.status(Response.Status.OK).entity(genericEntity).build();
    }
    else{
      String err = "{\"errors\": [\"" + " Users not found " + "\"]}";
      logger.error(err);
      response = Response.status(Response.Status.NOT_FOUND).entity(err).build();
    }
    return response;
  }

  @GET
  @Path("/{userId}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getUser(@PathParam("userId") String userId){
    Response response = null;
    if(userId != null){
      SimpleUserBean simpleUserBean = SimpleUserStore.getUser(userId);
      if(simpleUserBean != null){
        response = Response.status(Response.Status.OK).entity(simpleUserBean).build();
      }
      else{
        String err = "{\"errors\": [\"" + " User= " + userId + " not found " + "\"]}";
        logger.error(err);
        response = Response.status(Response.Status.NOT_FOUND).entity(err).build();
      }
    }
    else{
      String err = "{\"errors\": [\"" + " User= " + userId + " not valid " + "\"]}";
      logger.error(err);
      response = Response.status(Response.Status.BAD_REQUEST).entity(err).build();
    }
    return response;
  }

  @DELETE
  @Path("/{userId}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response deleteUser(@PathParam("userId") String userId){
    Response response = null;
    try{
      SimpleUserStore.deleteUser(userId);
      String status = "{\"status\": [\"" + "delete user = " + userId + " successfully" + "\"]}";
      response = Response.status(Response.Status.OK).entity(status).build();
    }catch (SimpleUserStoreException e){
      String err = "{\"errors\": [\"" + e.getMessage() + "\"]}";
      logger.error(err);
      response = Response.status(Response.Status.NOT_FOUND).entity(err).build();
    }
    return response;
  }

  @PUT
  @Path("/{userId}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response updateUser(SimpleUserBean simpleUserBean){
    Response response = null;
    if(simpleUserBean != null){
      try {
       simpleUserBean =  SimpleUserStore.updateUser(simpleUserBean.getUserId(),simpleUserBean);
       response =  Response.status(Response.Status.OK).entity(simpleUserBean).build();
      } catch (SimpleUserStoreException e) {
        String err = "{\"errors\": [\"" + e.getMessage() + "\"]}";
        logger.error(err);
        response = Response.status(Response.Status.NOT_FOUND).entity(err).build();
      }
    }
    return response;
  }

}