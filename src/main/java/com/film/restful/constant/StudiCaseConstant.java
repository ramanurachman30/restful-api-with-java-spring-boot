package com.film.restful.constant;

public class StudiCaseConstant {
    public static final String STUDI_CASE_REGIST = "/regist";
    public static final String GET_REGIST = STUDI_CASE_REGIST + "/cekRegist/{email}";

//    auth
    public static final String CREATE_REGIST = STUDI_CASE_REGIST + "/pendaftaran";
    public static final String LOGIN = "/login";
    public static final String EMAIL_VERIFICATION = "/verify-email";
    public static final String LOGOUT = "/logout";
}
