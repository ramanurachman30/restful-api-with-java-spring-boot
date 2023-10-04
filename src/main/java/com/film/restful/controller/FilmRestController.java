package com.film.restful.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.film.restful.constant.FilmRestConstant;
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

    @GetMapping(FilmRestConstant.FILM_REST_GET_ALL_DATA)
    public ResponseEntity<ResponseFilmRest> findFilm(
            @RequestParam(name = "name", required = false, defaultValue = "") String name) {

        ResponseFilmRest response = new ResponseFilmRest();
        List<FilmRest> filmRests;
        filmRests = filmRestService.getAll();
        ResponseGeneral sg = new ResponseGeneral();
        sg.setCode("00");
        sg.setDescription("Berikut data film yang telah anda tambahkan");
        sg.setMetadata(filmRests);
        response.setResponseGeneral(sg);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(FilmRestConstant.FILM_REST_GET_BY_ID)
    public ResponseEntity<ResponseFilmRest> getDataById(@PathVariable("id") long id){
        ResponseFilmRest response = new ResponseFilmRest();
        Optional<FilmRest> metadata;
        metadata = filmRestService.findDataById(id);
        ResponseGeneral sg = new ResponseGeneral();
        sg.setCode("00");
        sg.setDescription("berikut data dari id " + id);
        sg.setMetadataById(metadata);
        response.setResponseGeneral(sg);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(FilmRestConstant.FILM_REST_POST_DATA)
    public ResponseEntity<ResponseFilmRest> tambahFilm(@RequestBody RequestFilmRest metadata) {
        ResponseFilmRest response = new ResponseFilmRest();

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
        response.setResponseGeneral(sg);

        System.out.println("judul dan gendre kenapa ga muncul cok " + filmRest.getJudul());

        log.info("Berikut log Response post film cuy ==== ", response);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(FilmRestConstant.FILM_REST_UPDATE_DATA)
    public ResponseEntity<ResponseFilmRest> updateDataFilm(@PathVariable("id") long id, @RequestBody RequestFilmRest metadata){
        ResponseFilmRest response = new ResponseFilmRest();
        FilmRest filmRest = filmRestService.getDataById(id);
        filmRest.setJudul(metadata.getJudul());
        filmRest.setGendre(metadata.getGendre());
        filmRest.setSutradara(metadata.getSutradara());
        filmRest.setPembuat(metadata.getPembuat());
        filmRest.setSinopsis(metadata.getSinopsis());
        filmRestService.save(filmRest);

        ResponseGeneral sg = new ResponseGeneral();
        sg.setCode("00");
        sg.setDescription("Data dari id " + id + " Berhasil terupdate");
        response.setResponseGeneral(sg);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(FilmRestConstant.FILM_REST_DELETE_DATA_BY_ID)
    public ResponseEntity<ResponseFilmRest> deleteDataById(@PathVariable("id") long id){
        ResponseFilmRest response = new ResponseFilmRest();
        filmRestService.deleteDataById(id);
        ResponseGeneral sg = new ResponseGeneral();
        sg.setCode("00");
        sg.setDescription("Film dengan id " + id + " Berhasil dihapus");
        response.setResponseGeneral(sg);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}