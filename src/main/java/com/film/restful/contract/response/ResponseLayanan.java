package com.film.restful.contract.response;

import java.util.List;

import com.film.restful.model.Layanan;

public class ResponseLayanan {
    private String code;
    private String description;
    private Layanan data;
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
    public Layanan getData() {
        return data;
    }
    public void setData(Layanan data) {
        this.data = data;
    }

    
}
