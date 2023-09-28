package com.june.util.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Loggers {
    /** 异常告警日志 **/
    public static final Logger ERROR       = LoggerFactory.getLogger("APP_ERROR");

    /** 配置缓存监控 **/
    public static final Logger LOCAL_CACHE = LoggerFactory.getLogger("LOCAL_CACHE");


}
