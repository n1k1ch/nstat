package com.n1k1ch.nstat.api.service;

import com.n1k1ch.nstat.api.helper.ErrorResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by ncherevkov on 8/19/2016.
 */
@Provider
public class NStatRestExceptionHandler implements ExceptionMapper<RuntimeException> {

    @Override
    public Response toResponse(RuntimeException exception) {
        return Response.serverError().entity(ErrorResponse.fromException(exception)).build();
    }
}
