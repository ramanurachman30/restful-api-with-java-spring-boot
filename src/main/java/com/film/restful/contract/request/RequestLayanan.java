package com.film.restful.contract.request;

public class RequestLayanan {
    private String name;
    private String deskripsi;
    private String harga;
    private String jadwal;
    private String durasiMenu;
    private String listsLatihan;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDeskripsi() {
        return deskripsi;
    }
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
    public String getHarga() {
        return harga;
    }
    public void setHarga(String harga) {
        this.harga = harga;
    }
    public String getJadwal() {
        return jadwal;
    }
    public void setJadwal(String jadwal) {
        this.jadwal = jadwal;
    }
    public String getDurasiMenu() {
        return durasiMenu;
    }
    public void setDurasiMenu(String durasiMenu) {
        this.durasiMenu = durasiMenu;
    }
    public String getListsLatihan() {
        return listsLatihan;
    }
    public void setListsLatihan(String listsLatihan) {
        this.listsLatihan = listsLatihan;
    }
    
}
