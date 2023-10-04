package com.film.restful.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.film.restful.contract.request.RequestFilmRest;
import com.film.restful.contract.response.ResponseFilmRest;
import com.film.restful.contract.response.ResponseGeneral;
import com.film.restful.model.FilmRest;
import com.film.restful.service.FilmRestService;

@RestController
@CrossOrigin
public class FilmRestController {
    private static Logger log = LogManager.getLogger(FilmRestController.class);

    @Autowired
    private FilmRestService filmRestService;

    @GetMapping("/getAllFilm")
    public ResponseEntity<ResponseFilmRest> findFilm(
            @RequestParam(name = "name", required = false, defaultValue = "") String name) {

        ResponseFilmRest response = new ResponseFilmRest();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/postFilm")
    public ResponseEntity<ResponseFilmRest> tambahFilm(@RequestBody RequestFilmRest metadata) {
        ResponseFilmRest response = new ResponseFilmRest();

        List<FilmRest> filmRests;
        filmRests = filmRestService.getAll();

        FilmRest filmRest = new FilmRest();
        filmRest.setJudul(metadata.getJudul());
        filmRest.setGendre(metadata.getGendre());
        filmRest.setSutradara(metadata.getSutradara());
        filmRest.setPembuat(metadata.getPembuat());
        filmRest.setSinopsis(metadata.getSinopsis());
        filmRestService.save(filmRest);

        ResponseGeneral sg = new ResponseGeneral();
        sg.setCode("00");
        sg.setDescription("berhasil");
        sg.setMetadata(filmRests);
        response.setResponseGeneral(sg);

        System.out.println("judul dan gendre kenapa ga muncul cok " + filmRest.getJudul());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}