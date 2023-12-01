package com.film.restful.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "layanan")
public class Layanan implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;

    @Column(name = "nama_layanan", length = 100)
    private String name;

    @Column(name = "deskripsi", length = 255)
    private String description;

    @Column(name = "harga", length = 200)
    private String harga;

    @Column(name = "jadwal", length = 200)
    private String jadwal;

    @Column(name = "durasi_menu", length = 100)
    private String durasiMenu;

    @Column(name = "list_latihan", length = 100)
    private String listLatihan;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
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
    public String getListLatihan() {
        return listLatihan;
    }
    public void setListLatihan(String listLatihan) {
        this.listLatihan = listLatihan;
    }
    
    
}
