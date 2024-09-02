package com.june.quartz;

import org.quartz.*;

import java.util.Date;

public class HelloJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("执行时间为：" + new Date());
    }
}
