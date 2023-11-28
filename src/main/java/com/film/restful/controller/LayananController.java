package com.film.restful.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.film.restful.constant.StudiCaseConstant;
import com.film.restful.contract.request.RequestLayanan;
import com.film.restful.contract.response.ResponseLayanan;
import com.film.restful.contract.response.ResponseListLayanan;
import com.film.restful.model.Layanan;
import com.film.restful.service.LayananService;

@RestController
@CrossOrigin
public class LayananController {
    private static Logger log = LogManager.getLogger(LayananController.class);
    
    @Autowired
    private LayananService layananService;

    @GetMapping(StudiCaseConstant.GET_ALL_LAYANAN)
    public ResponseEntity<ResponseListLayanan> getAll(@RequestParam(name = "name", required = false, defaultValue = "") String name){
        List<Layanan> layanan;
        
        layanan = layananService.getAll();
        
        ResponseListLayanan response = new ResponseListLayanan();
        response.setCode("00");
        response.setDescription("Data Layanan");
        response.setMetadata(layanan);
        log.info("DATA TER GENERATED");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(StudiCaseConstant.CREATE_LAYANAN)
    public ResponseEntity<ResponseLayanan> postLayanan(@RequestBody RequestLayanan requestLayanan){
        Layanan layanan = new Layanan();
        layanan.setName(requestLayanan.getName());
        layanan.setDescription(requestLayanan.getDeskripsi());
        layananService.save(layanan);
        log.info("SAVE PROCESSING");

        ResponseLayanan response = new ResponseLayanan();
        response.setCode("00");
        response.setDescription("Data Telah terbuat");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(StudiCaseConstant.GET_ONE_LAYANAN)
    public ResponseEntity<ResponseLayanan> getById(@PathVariable("id") long id){
        Layanan layanan;
        layanan = layananService.getDatabyId(id);
        log.info("GET ONE DATA");

        ResponseLayanan response = new ResponseLayanan();
        response.setCode("00");
        response.setDescription("Get data layanan per id");
        response.setData(layanan);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
