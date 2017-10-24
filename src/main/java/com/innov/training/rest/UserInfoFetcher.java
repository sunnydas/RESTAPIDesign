package com.innov.training.rest;

import com.innov.training.rest.pagination.UserInfoBean;
import com.innov.training.rest.pagination.UserInfoTableSimulator;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * This class is for illustrating pagination
 */
@Path("userinfo")
public class UserInfoFetcher {

  private Logger logger = Logger.getLogger(UserInfoFetcher.class);

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response fetchUserInfo(@QueryParam("offset")
                                       @DefaultValue("0") Integer offset, @QueryParam("limit")
      @DefaultValue("20") Integer limit){
    List<UserInfoBean> userList = UserInfoTableSimulator.getUserInfoData(offset,limit);
    logger.info(userList);
    GenericEntity<List<UserInfoBean>> entity = new GenericEntity<List<UserInfoBean>>(userList){};
    return Response.status(Response.Status.OK).entity(entity).build();
  }

}
