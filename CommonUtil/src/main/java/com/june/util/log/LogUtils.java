package com.june.util.log;

import com.june.util.exception.InfraException;
import org.slf4j.Logger;
import static com.june.util.log.MessageHelper.formatMsg;

public final class LogUtils {

    /**
     * 防止类被实例化
     */
    private LogUtils(){
    }

    /**
     * 打印调试级别日志。
     * <p>可处理任意多个输入参数，并避免在日志级别不够是字符串拼接带来的资源浪费。
     * @param logger        日志打印对象
     * @param msgTemplate   日志描述信息
     * @param obj           任意个要输出到日志的参数[可空]
     */
    public static void debug(Logger logger, String msgTemplate, Object... obj) {
        if (logger.isDebugEnabled()) {
            logger.debug(formatMsg(msgTemplate, obj));
        }
    }

    /**
     * 打印通知级别日志。
     * <p>可处理任意多个输入参数，并避免在日志级别不够是字符串拼接带来的资源浪费。
     * @param logger        日志打印对象
     * @param msgTemplate   日志描述信息
     * @param obj           任意个要输出到日志的参数[可空]
     */
    public static void info(Logger logger, String msgTemplate, Object... obj) {
        if (logger.isInfoEnabled()) {
            logger.info(formatMsg(msgTemplate, obj));
        }
    }

    /**
     * 打印告警级别的日志。
     * <p>可处理任意多个输入参数，并避免在日志级别不够是字符串拼接带来的资源浪费。
     * @param logger        日志打印对象
     * @param msgTemplate   日志描述信息
     * @param obj           任意个要输出到日志的参数[可空]
     */
    public static void warn(Logger logger, String msgTemplate, Object... obj) {
        warn(logger, null, msgTemplate, obj);
    }

    /**
     * 打印告警级别的日志。
     * <p>可处理任意多个输入参数，并避免在日志级别不够是字符串拼接带来的资源浪费。
     * @param logger        日志打印对象
     * @param e             异常
     * @param msgTemplate   日志描述信息
     * @param obj           任意个要输出到日志的参数[可空]
     */
    public static void warn(Logger logger, Throwable e, String msgTemplate, Object... obj) {
        if (null == e) {
            logger.warn(formatMsg(msgTemplate, obj));
        } else {
            logger.warn(formatMsg(msgTemplate, obj), e);
        }
    }

    /**
     * 打印错误级别日志。
     * <p>可处理任意多个输入参数，并避免在日志级别不够是字符串拼接带来的资源浪费。
     * @param logger        日志打印对象
     * @param msgTemplate   日志描述信息
     * @param obj           任意个要输出到日志的参数[可空]
     */
    public static void error(Logger logger, String msgTemplate, Object... obj) {
        error(logger, null, msgTemplate, obj);
    }

    /**
     * 打印错误级别日志。
     * <p>可处理任意多个输入参数，并避免在日志级别不够是字符串拼接带来的资源浪费。
     * @param logger        日志打印对象
     * @param e             异常
     * @param msgTemplate   日志描述信息
     * @param obj           任意个要输出到日志的参数[可空]
     */
    public static void error(Logger logger, Throwable e, String msgTemplate, Object... obj) {
        if (null == e) {
            logger.error(formatMsg(msgTemplate, obj));
        } else {
            logger.error(formatMsg(msgTemplate, obj), e);

            if (e instanceof InfraException) {
                if (!((InfraException) e).isNeedErrorLog()) {
                    return;
                }
            }

            Loggers.ERROR.error(formatMsg(msgTemplate, obj), e);
        }
    }
}
