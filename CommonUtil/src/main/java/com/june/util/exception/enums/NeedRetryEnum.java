package com.june.util.exception.enums;

public enum NeedRetryEnum implements IEnum {

    /** 可重试 **/
    TRUE("TRUE", "TRUE", "可重试", "此错误码属于外部可重试类型"),

    /** 不可重试 **/
    FALSE("FALSE", "FALSE", "不可重试", "此错误码属于不可重试类型"),

    /** 未知 **/
    UNKNOW("UNKNOW", "UNKNOW", "未知", "由调用者根据实际情况决定是否需要重试"),
    ;
    private final String code;

    private final String englishName;

    private final String chineseName;

    private final String description;

    NeedRetryEnum(String code, String englishName, String chineseName, String description) {
        this.code = code;
        this.englishName = englishName;
        this.chineseName = chineseName;
        this.description = description;
    }

    public static NeedRetryEnum getByCode(String code) {
        for (NeedRetryEnum each : values()) {
            if (each.getCode().equals(code)) {
                return each;
            }
        }

        return null;
    }

    @Override
    public String getCode() {
        return null;
    }

    @Override
    public String getEnglishName() {
        return null;
    }

    @Override
    public String getChineseName() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }
}
