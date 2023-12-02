package com.film.restful.contract.response;

import com.film.restful.model.ListLatihan;

public class ResponseListLatihan {
    private String code;
    private String description;
    private ListLatihan data;
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
    public ListLatihan getData() {
        return data;
    }
    public void setData(ListLatihan data) {
        this.data = data;
    }

    
}
