package com.dog.it.until;

public enum RequestResponseCode {
    SUCCESS(200, "success"),
    QUERY_ERROR(203, "请求参数错误"),
    PERMISSION_NO_ACCESS(70001, "无访问权限"),
    PERMISSION_TOKEN_ERROE(70002, "Token有误"),
    NOT_USER(401, "用户不存在"),
    ERROR(400, "数据异常"),
    PASSWORD_ERROR(401, "密码错误"),
    CODE_ERROR(401, "验证码错误"),
    REQUEST_ERROR(401, "请求方式错误"),
    CREATE_ERROE(70003, "创建失败"),
    CAPTCH_ERROE(402, "验证码错误"),
    AUTH_ERROE(403, "用户权限有误"),
    AUTH_NOT(403, "没有访问权限"),
    NOT_FILE(404, "文件资源不存在"),
    SQL_DATA(401, "数据错误"),
    NOT_LOGIN(403, "请先登录");

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
