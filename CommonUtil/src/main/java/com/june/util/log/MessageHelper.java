package com.june.util.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;

public class MessageHelper {
    private static final Logger LOG = LoggerFactory.getLogger(MessageHelper.class);

    /**
     * 格式化含有占位符的字符串。
     * <p>举例：
     * <pre>
     *     <ol>
     *         <li>
     *              所有占位符参数都存在：
     *              msgTemplate: My name is {0}, I'm {1} years old.
     *              params: Johnson, 15
     *              return: My name is Johnson, I'm 15 years old.
     *         </li>
     *         <li>
     *              占位符参数数组含有null值：占位符会被null替代
     *              msgTemplate: My name is {0}, I'm {1} years old.
     *              params: null, 15
     *              return: My name is null, I'm 15 years old.
     *         </li>
     *          <li>
     *              占位符参数数组为null：消息模板原样输出，占位符不替换
     *              msgTemplate: My name is {0}, I'm {1} years old.
     *              params: null
     *              return: My name is {0}, I'm {1} years old.
     *         </li>
     *     </ol>
     * </pre>
     * @param msgTemplate   含有占位符的消息模板，占位符为{}
     * @param params        消息占位符变量，按参数顺序取代{0},{1},{2}...等
     * @return              替换占位符之后的消息字符串
     */
    public static String formatMsg(String msgTemplate, Object... params) {
        try {
            if (null == params || 0 == params.length) {
                return msgTemplate;
            }

            return MessageFormat.format(msgTemplate, params);
        } catch (Exception e) {
            StringBuilder buf = new StringBuilder("模板信息占位符替换异常，占位符参数信息：");
            for (int i = 0; i < params.length; i++) {
                buf.append(" arg[").append(i).append("]=").append(params[i]);
            }
            LOG.warn(buf.toString(), e);
        }
        return msgTemplate;
    }
}
