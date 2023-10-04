package com.film.restful.contract.response;

import java.util.List;

import com.film.restful.model.FilmRest;

public class ResponseGeneral {
    private String code;
    private String description;
    private List<FilmRest> metadata;
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
    public List<FilmRest> getMetadata() {
        return metadata;
    }
    public void setMetadata(List<FilmRest> metadata) {
        this.metadata = metadata;
    }
    
}