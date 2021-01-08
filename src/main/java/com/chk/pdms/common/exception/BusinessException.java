package com.chk.pdms.common.exception;

import java.text.MessageFormat;

public class BusinessException extends BaseException {

    public BusinessException(String msg) {
        super(new IError() {
            @Override
            public String getCode() {
                return "-1";
            }

            @Override
            public String getMessage() {
                return msg;
            }
        });
    }

    public BusinessException(String code, String msg) {
        super(new IError() {
            @Override
            public String getCode() {
                return code;
            }

            @Override
            public String getMessage() {
                return msg;
            }
        });
    }

    public BusinessException(IError error) {
        super(error);
    }

    public BusinessException(IError error, String extMessage) {
        super(error, extMessage);
    }

    public BusinessException(IError error, String extMessage,String posMsg) {
        super(error, extMessage,posMsg);
    }

    public BusinessException(IError error, Object[] args) {
        super(error.getCode(), MessageFormat.format(error.getMessage(), args));
    }


}
