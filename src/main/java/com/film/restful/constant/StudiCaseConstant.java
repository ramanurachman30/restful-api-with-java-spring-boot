package com.film.restful.constant;

public class StudiCaseConstant {

    // Template url
    public static final String FIRST_TEMPLATE = "/api";
    public static final String AUTHOR = "/nrchman";

    public static final String STUDI_CASE_REGIST = FIRST_TEMPLATE + AUTHOR + "/regist";
    public static final String GET_REGIST = STUDI_CASE_REGIST + "/cekRegist/{email}";

//    auth
    public static final String CREATE_REGIST = STUDI_CASE_REGIST + "/pendaftaran";
    public static final String LOGIN = FIRST_TEMPLATE + AUTHOR + "/login";
    public static final String EMAIL_VERIFICATION = FIRST_TEMPLATE + AUTHOR + "/verify-email";
    public static final String LOGOUT = FIRST_TEMPLATE + AUTHOR + "/logout";
    public static final String RESET_PASSWORD = FIRST_TEMPLATE + AUTHOR + "/reset-password";


    // Layanan
    public static final String LAYANAN = FIRST_TEMPLATE + AUTHOR + "/layanan";
    public static final String GET_ONE_LAYANAN = LAYANAN + "/get-layanan/{id}";
    public static final String GET_ALL_LAYANAN = LAYANAN + "/get-all-layanan";
    public static final String CREATE_LAYANAN = LAYANAN + "/create-layanan";
    public static final String EDIT_LAYANAN = LAYANAN + "/edit-layanan/{id}";
    public static final String DELETE_BYID_LAYANAN = LAYANAN + "/delete-byId-layanan/{id}";

    // list Latihan 
    public static final String LATIHAN = FIRST_TEMPLATE + AUTHOR + "/latihan";
    public static final String GET_ALL_LIST_LATIHAN = LATIHAN + "/list-latihan";
    public static final String GET_ONE_LATIHAN = LATIHAN + "/get-one-latihan/{id}";
    public static final String CREATE_LATIHAN = LATIHAN + "/create-latihan";
    public static final String EDIT_LATIHAN = LATIHAN + "/edit-latihan/{id}";
    public static final String DELETE_LATIHAN_BYID = LATIHAN + "/delete-byId-latihan/{id}";
}
