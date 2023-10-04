package com.film.restful.contract.request;

public class RequestFilmRest {
    private String judul;
    private String gendre;
    private String sutradara;
    private String pembuat;
    private String sinopsis;
    public String getJudul() {
        return judul;
    }
    public void setJudul(String judul) {
        this.judul = judul;
    }
    public String getGendre() {
        return gendre;
    }
    public void setGendre(String gendre) {
        this.gendre = gendre;
    }
    public String getSutradara() {
        return sutradara;
    }
    public void setSutradara(String sutradara) {
        this.sutradara = sutradara;
    }
    public String getPembuat() {
        return pembuat;
    }
    public void setPembuat(String pembuat) {
        this.pembuat = pembuat;
    }
    public String getSinopsis() {
        return sinopsis;
    }
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
     
}
