package com.june.util.exception;

/**
 * 基础业务异常
 * <p>可以根据需要记录到error日志，辅助业务报警。
 */
public abstract class InfraException extends RuntimeException {
    public InfraException() {
    }

    public InfraException(String message) {
        super(message);
    }

    public InfraException(String message, Throwable cause) {
        super(message, cause);
    }

    public InfraException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * 是否需要记录单独错误日志
     * @return
     */
    public abstract boolean isNeedErrorLog();

    /**
     * 错误码
     * @return
     */
    public abstract String getErrorCode();

    /**
     * 错误描述
     * @return
     */
    public abstract String getDescription();

    /**
     * 异常级别
     * @return
     */
    public abstract String getErrorLevel();

    /**
     * 异常类型
     * @return
     */
    public abstract String getErrorType();

    /**
     * 是否可重试
     * @return
     */
    public abstract boolean isCanRetry();
}
