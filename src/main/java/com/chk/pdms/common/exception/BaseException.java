package com.chk.pdms.common.exception;

public class BaseException extends RuntimeException {

    private String code;

    private String extMessage;

    private String message;

    private String posMsg;

    public BaseException(IError error, String extMessage,String posMsg) {
        this(error);
        this.extMessage = extMessage;
        this.posMsg=posMsg;
    }

    public BaseException(IError error, String extMessage) {
        this(error);
        this.extMessage = extMessage;
    }

    public BaseException(IError error) {
        super(error.getMessage());
        this.code = error.getCode();
        this.message = error.getMessage();
    }

    public BaseException(String code, String message) {
        this.code = code;
        this.message = message;
    }
//    public IError getError() {
//        return error;
//    }

    public String getExtMessage() {
        return extMessage;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getPosMsg() {
        return posMsg;
    }
}
