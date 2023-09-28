package com.june.util.exception;

import com.june.util.exception.enums.ErrorCodeEnum;

public class InternalSystemException extends InfraBaseException{

    public InternalSystemException(String message) {
        this(message, null);
    }

    public InternalSystemException(String message, Throwable throwable) {
        super(message, throwable, ErrorCodeEnum.SYSTEM_EXCEPTION, true);
    }
}
