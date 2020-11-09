package com.dog.it.until;

public enum RequestResponseCode {
    SUCCESS(200, "success"),
    ERROR(400, "Error"),
    NO_MAPPING(200,"No mapping");

    private Integer code;
    private String msg;

    RequestResponseCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
