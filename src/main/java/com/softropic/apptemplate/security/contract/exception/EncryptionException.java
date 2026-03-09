package com.softropic.apptemplate.security.contract.exception;


import com.softropic.apptemplate.common.exception.ApplicationException;
import com.softropic.apptemplate.common.exception.ErrorCode;

public class EncryptionException extends ApplicationException {
    public EncryptionException(String msg,
                               ErrorCode errorCode) {
        super(msg, errorCode);
    }

    public EncryptionException(String msg, Throwable cause, ErrorCode errorCode) {
        super(msg, cause, errorCode);
    }
}
