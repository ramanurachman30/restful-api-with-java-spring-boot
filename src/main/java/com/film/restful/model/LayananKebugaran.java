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
@Table(name = "layanan_kebugaran_overweight_obesity")
public class LayananKebugaran implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;

    @Column(name = "harga_per_pertemuan", length = 255)
    private String hargaPerPertemuan;

    @Column(name = "jadwal", length = 50)
    private String jadwal;

    @Column(name = "durasi_menu", length = 50)
    private String durasiMenu;

    @Column(name = "list_latihan")
    private String listLatihan;

    @Column(name = "deskripsi_latihan")
    private String deskripsiLatihan;

    @Column(name = "langganan_peserta")
    private String langgananPeserta;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getHargaPerPertemuan() {
        return hargaPerPertemuan;
    }
    public void setHargaPerPertemuan(String hargaPerPertemuan) {
        this.hargaPerPertemuan = hargaPerPertemuan;
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
    public String getDeskripsiLatihan() {
        return deskripsiLatihan;
    }
    public void setDeskripsiLatihan(String deskripsiLatihan) {
        this.deskripsiLatihan = deskripsiLatihan;
    }
    public String getLanggananPeserta() {
        return langgananPeserta;
    }
    public void setLanggananPeserta(String langgananPeserta) {
        this.langgananPeserta = langgananPeserta;
    }

    
}
