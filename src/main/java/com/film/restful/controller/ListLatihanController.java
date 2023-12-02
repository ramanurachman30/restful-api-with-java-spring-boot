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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.film.restful.constant.StudiCaseConstant;
import com.film.restful.contract.response.ResponseListLatihan;
import com.film.restful.contract.response.ResponseListsLatihan;
import com.film.restful.model.ListLatihan;
import com.film.restful.service.ListLatihanService;

@RestController
@CrossOrigin
public class ListLatihanController {

    public static Logger log = LogManager.getLogger(ListLatihanController.class);

    @Autowired
    private ListLatihanService latihanService;

    @GetMapping(StudiCaseConstant.GET_ALL_LIST_LATIHAN)
    public ResponseEntity<ResponseListsLatihan> getAll(@RequestParam(name = "name", required = false, defaultValue = "") String name){
        List<ListLatihan> listLatihan;
        listLatihan = latihanService.getAllListLatihan();
        log.info("GENERATED DATAS LIST LATIHAN SUCCESSFULLY");

        ResponseListsLatihan response = new ResponseListsLatihan();
        response.setCode("00");
        response.setDescription("Get All Data successfully");
        response.setMetadatas(listLatihan);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(StudiCaseConstant.GET_ONE_LATIHAN)
    public ResponseEntity<ResponseListLatihan> getOneLatihan(@PathVariable("id") long id){
        ListLatihan latihan;
        latihan = latihanService.getById(id);
        log.info("GENERATED ONE DATA HAS BEEN SUCCESSFULLY");

        ResponseListLatihan response = new ResponseListLatihan();
        response.setCode("00");
        response.setDescription("Get Latihan By Id is Successfully");
        response.setData(latihan);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
