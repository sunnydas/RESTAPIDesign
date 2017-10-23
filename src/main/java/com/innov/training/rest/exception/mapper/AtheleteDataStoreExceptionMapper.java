package com.innov.training.rest.exception.mapper;

import com.innov.training.rest.endurancesports.bean.athelete.exception.AtheleteDataStoreException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Thsi class maps exception of AtheleteDataStoreException
 */
@Provider
public class AtheleteDataStoreExceptionMapper implements ExceptionMapper<AtheleteDataStoreException> {

  @Override
  public Response toResponse(AtheleteDataStoreException exception) {
    String err = "{\"errors\": [\"" + exception.getMessage() + "\"]}";
    return Response.status(
        Response.Status.NOT_FOUND).
        entity(err).build();
  }
}
