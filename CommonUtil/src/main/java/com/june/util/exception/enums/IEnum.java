package com.june.util.exception.enums;

/**
 * 枚举基类
 */
public interface IEnum {

    /**
     * 返回对应枚举示例的编码。
     */
    public String getCode();

    /**
     * 返回对应枚举实例的英文名称。
     * @return
     */
    public String getEnglishName();

    /**
     * 返回对应枚举实例的中文名称。
     * @return
     */
    public String getChineseName();

    /**
     * 返回对应枚举实例的描述。
     * @return
     */
    public String getDescription();
}
