package com.film.restful.contract.response;

import com.film.restful.model.Registration;

import java.util.List;

public class ResponseRegist {
    private String code;
    private String description;
    private Registration metadata;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Registration getMetadata() {
        return metadata;
    }

    public void setMetadata(Registration metadata) {
        this.metadata = metadata;
    }
}
