package com.june.util.sqlsession;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

import java.util.function.Function;

@Slf4j
public class SqlSessionQueryTemplate {

    public <R> R doQuery(Function<SqlSession, R> func) {
        try (SqlSession session = new DefaultSqlSessionFactory(new Configuration()).openSession()) {
            return func.apply(session);
        } catch (Exception e) {
//            log.info("数据库查询报错，错误堆栈：", e);
            return null;
        }
    }
}
