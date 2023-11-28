package com.film.restful.constant;

public class StudiCaseConstant {
    public static final String STUDI_CASE_REGIST = "/regist";
    public static final String GET_REGIST = STUDI_CASE_REGIST + "/cekRegist/{email}";

//    auth
    public static final String CREATE_REGIST = STUDI_CASE_REGIST + "/pendaftaran";
    public static final String LOGIN = "/login";
    public static final String EMAIL_VERIFICATION = "/verify-email";
    public static final String LOGOUT = "/logout";
    public static final String RESET_PASSWORD = "/reset-password";


    // Layanan
    public static final String LAYANAN = "/layanan";
    public static final String GET_ONE_LAYANAN = LAYANAN + "/get-layanan/{id}";
    public static final String GET_ALL_LAYANAN = LAYANAN + "/get-all-layanan";
    public static final String CREATE_LAYANAN = LAYANAN + "/create-layanan";
    public static final String EDIT_LAYANAN = LAYANAN + "/edit-layanan";
}
