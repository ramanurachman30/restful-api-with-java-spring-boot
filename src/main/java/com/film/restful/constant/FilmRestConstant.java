package com.film.restful.constant;

public class FilmRestConstant {
    public static final String FILM_REST = "/film";

    public static final String FILM_REST_GET_ALL_DATA = FILM_REST + "/getAllDataFilm";
    public static final String FILM_REST_GET_BY_ID = FILM_REST + "/getDataFilmById/{id}";

    public static final String FILM_REST_POST_DATA = FILM_REST + "/postDataFilm";
    public static final String FILM_REST_UPDATE_DATA = FILM_REST + "/updateDataFilm/{id}";

    public static final String FILM_REST_DELETE_DATA_BY_ID = FILM_REST + "/deletDataFilmById/{id}";
    public static final String FILM_REST_DELETE_ALL_DATAS = FILM_REST + "/deletAllDatas";
}
