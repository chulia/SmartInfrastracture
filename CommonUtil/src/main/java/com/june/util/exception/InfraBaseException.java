package com.june.util.exception;

import com.june.util.exception.enums.ErrorCodeEnum;
import com.june.util.exception.enums.NeedRetryEnum;

public class InfraBaseException extends InfraException {

    private ErrorCodeEnum errorCode;

    private boolean needErrorLog = true;

    public InfraBaseException(String message, Throwable cause, ErrorCodeEnum errorCode, boolean needErrorLog) {
        super(message, cause);
        this.errorCode = errorCode;
        this.needErrorLog = needErrorLog;
    }

    @Override
    public boolean isNeedErrorLog() {
        return needErrorLog;
    }

    @Override
    public String getErrorCode() {
        return errorCode.getCode();
    }

    @Override
    public String getDescription() {
        return errorCode.getDescription();
    }

    @Override
    public String getErrorLevel() {
        return errorCode.getErrorLevel();
    }

    @Override
    public String getErrorType() {
        return errorCode.getErrorType();
    }

    @Override
    public boolean isCanRetry() {
        return errorCode.getNeedRetryEnum() == NeedRetryEnum.TRUE;
    }
}
