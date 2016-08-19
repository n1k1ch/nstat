package com.n1k1ch.nstat.api.helper;

import com.google.common.base.Throwables;

/**
 * Created by ncherevkov on 8/19/2016.
 */
public class ErrorResponse {

    private String messase;

    public String getMessase() {
        return messase;
    }

    public void setMessase(String messase) {
        this.messase = messase;
    }

    public static ErrorResponse fromException(Exception exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.messase = Throwables.getRootCause(exception).getMessage();

        return errorResponse;
    }
}
