package com.innov.training.rest.exception.mapper;

import com.innov.training.rest.endurancesports.exception.EnduranceSportsDataStoreException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * This class maps the EnduranceSportsDataStoreException to appropriate response
 */
@Provider
public class ESDataStoreExceptionMapper implements ExceptionMapper<EnduranceSportsDataStoreException>{


  @Override
  public Response toResponse(EnduranceSportsDataStoreException exception) {
        String err = "{\"errors\": [\"" + exception.getMessage() + "\"]}";
        return Response.status(
        Response.Status.NOT_FOUND).
        entity(err).build();
  }


}
