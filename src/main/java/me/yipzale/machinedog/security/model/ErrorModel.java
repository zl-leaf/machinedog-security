package me.yipzale.machinedog.security.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorModel {
    private String error;
    @JsonProperty("error_description")
    private String errorDescription;

    public ErrorModel(String error, String errorDescription) {
        this.error = error;
        this.errorDescription = errorDescription;
    }

    public String getError() {
        return error;
    }

    public String getErrorDescription() {
        return errorDescription;
    }
}
