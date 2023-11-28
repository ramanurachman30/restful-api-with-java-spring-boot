package com.film.restful.contract.response;

import java.util.List;

import com.film.restful.model.Layanan;

public class ResponseListLayanan {
    private String code;
    private String description;
    private List<Layanan> metadata;
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
    public List<Layanan> getMetadata() {
        return metadata;
    }
    public void setMetadata(List<Layanan> metadata) {
        this.metadata = metadata;
    }
}
