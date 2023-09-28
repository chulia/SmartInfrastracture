package com.june.util.exception.enums;

import com.june.util.exception.constants.ErrorLevels;
import com.june.util.exception.constants.ErrorTypes;

/**
 * 错误码
 */
public enum ErrorCodeEnum implements IEnum {

    /*
     * 系统公共错误
     */
    SYSTEM_EXCEPTION("001", "SYSTEM_EXCEPTION", "系统异常", "SYSTEM_EXCEPTION",
            NeedRetryEnum.TRUE, ErrorLevels.ERROR, ErrorTypes.SYSTEM),

    ;

    private final String code;

    private final String englishName;

    private final String chineseName;

    private final String description;

    private final NeedRetryEnum needRetryEnum;

    private final String errorLevel;

    private final String errorType;

    ErrorCodeEnum(String code, String englishName, String chineseName, String description, NeedRetryEnum needRetryEnum, String errorLevel, String errorType) {
        this.code = code;
        this.englishName = englishName;
        this.chineseName = chineseName;
        this.description = description;
        this.needRetryEnum = needRetryEnum;
        this.errorLevel = errorLevel;
        this.errorType = errorType;
    }


    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getEnglishName() {
        return englishName;
    }

    @Override
    public String getChineseName() {
        return chineseName;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public NeedRetryEnum getNeedRetryEnum() {
        return needRetryEnum;
    }

    public String getErrorLevel() {
        return errorLevel;
    }

    public String getErrorType() {
        return errorType;
    }
}
