package com.vn.sbit.idenfity_service.exception;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999,"UNCATEGORIZED_EXCEPTION"),
    INVALID_KEY(1000,"Invalid message key"), //khi error.code gặp lỗi(không được tìm thấy,....)
    USER_EXISTED(1001,"User existed" ),
    USER_USERNAME_INVALID(1002,"Username must be at least 3 character "),
    USER_PASSWORD_INVALID(1003,"Password must be at least 8 character ")
    ;

    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
