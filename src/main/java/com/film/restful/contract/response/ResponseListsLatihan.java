package com.film.restful.contract.response;

import java.util.List;

import com.film.restful.model.ListLatihan;

public class ResponseListsLatihan {
    private String code;
    private String description;
    private List<ListLatihan> metadatas;
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
    public List<ListLatihan> getMetadatas() {
        return metadatas;
    }
    public void setMetadatas(List<ListLatihan> metadatas) {
        this.metadatas = metadatas;
    }

    
}
