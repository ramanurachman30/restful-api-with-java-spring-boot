package com.film.restful.contract.request;

import java.util.Date;

public class RequestRegister {
    private String nama;
    private String email;
    private String password;
    private Long noHp;
    private Long noKartu;
    private Long cvv;
    private Date expDate;
    private String namaPemegangKartu;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getNoHp() {
        return noHp;
    }

    public void setNoHp(Long noHp) {
        this.noHp = noHp;
    }

    public Long getNoKartu() {
        return noKartu;
    }

    public void setNoKartu(Long noKartu) {
        this.noKartu = noKartu;
    }

    public Long getCvv() {
        return cvv;
    }

    public void setCvv(Long cvv) {
        this.cvv = cvv;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public String getNamaPemegangKartu() {
        return namaPemegangKartu;
    }

    public void setNamaPemegangKartu(String namaPemegangKartu) {
        this.namaPemegangKartu = namaPemegangKartu;
    }
}
