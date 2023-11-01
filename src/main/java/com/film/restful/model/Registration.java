package com.film.restful.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "registration")
public class Registration implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;

    @Column(name = "nama", length = 255)
    private String nama;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "no_hp", length = 255)
    private Long noHp;

    @Column(name = "no_kartu", length = 255)
    private Long noKartu;

    @Column(name = "cvv", length = 255)
    private Long cvv;

    @Temporal(TemporalType.TIMESTAMP)
    private Date expDate;

    @Column(name = "nama_pemegang_kartu", length = 255)
    private String namaPemegangKartu;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @PrePersist
    protected void onCreate() {
        // Menetapkan tanggal expired 30 hari dari sekarang
        expDate = new Date(System.currentTimeMillis() + 30 * 24 * 60 * 60 * 1000);
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
