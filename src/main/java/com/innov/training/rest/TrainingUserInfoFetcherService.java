package com.innov.training.rest;

import com.innov.training.rest.pagination.UserInfoBean;
import com.innov.training.rest.pagination.UserInfoTableSimulator;
import com.innov.training.rest.pagination.hateoas.UserInfoDataHateoasHelper;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is for illustrating pagination
 */
@Path("userinfo")
public class TrainingUserInfoFetcherService {

  private Logger logger = Logger.getLogger(TrainingUserInfoFetcherService.class);

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



  @GET
  @Path("hateoas")
  @Produces(MediaType.APPLICATION_JSON)
  public Response fetchUserInfoHTEOAS(@QueryParam("offset")
                                      @DefaultValue("0") Integer offset, @QueryParam("limit")
                                      @DefaultValue("10") Integer limit){
    Response response = null;
    // This is not ideal , we should modularise indvidual functions
    UserInfoDataHateoasHelper userInfoDataHateoasHelper = UserInfoTableSimulator.getUserInfoHateoas(offset, limit);
    logger.info(userInfoDataHateoasHelper);
    Link prev = null;
    List<Link> tempLinks = new ArrayList<>();
    String prevString = userInfoDataHateoasHelper.getPrev();
    if(prevString != null){
      prev = Link.fromUri("/userinfo/hateoas" + prevString).rel("prev").build();
      tempLinks.add(prev);
    }
    String nextString = userInfoDataHateoasHelper.getNext();
    Link next = null;
    if(nextString != null){
      next = Link.fromUri("/userinfo/hateoas" + nextString).rel("next").build();
      tempLinks.add(next);
    }
    String selfString = userInfoDataHateoasHelper.getSelf();
    Link self = null;
    if(selfString != null){
      self = Link.fromUri("/userinfo/hateoas" + selfString).rel("self").build();
      tempLinks.add(self);
    }
    GenericEntity<List<UserInfoBean>> entity = new GenericEntity<List<UserInfoBean>>(userInfoDataHateoasHelper.getUserInfoBeans()){};
    Link[] links = new Link[tempLinks.size()];
    tempLinks.toArray(links);
    response = Response.ok().header("totalSize",userInfoDataHateoasHelper.getTotalSize()).header("count",userInfoDataHateoasHelper.getRowCount()).links(links).entity(entity).build();
    return response;
  }

}
