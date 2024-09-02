package com.june.quartz;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class JobStartupRunner implements CommandLineRunner {

    @Autowired
    SchedulerConfig schedulerConfig;

    private static String TRIGGER_GROUP_NAME = "test_trigger";
    private static String JOB_GROUP_NAME = "test_job";

    @Override
    public void run(String... args) throws Exception {
//        //创建jobDetail绑定HelloJob
//        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
//                .withIdentity("myJob","myGroup").usingJobData("message", "hello").build();
//        //创建触发器trigger每个2秒执行一次，一直执行
//        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger", "myGroup").startNow()
//                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
//                        .withIntervalInSeconds(20).repeatForever()).build();
//        //创建调度者工厂
//        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
//        //创建调度者
//        Scheduler scheduler = schedulerFactory.getScheduler();
//        //启动调度器
//        scheduler.start();
//        //设置调度任务
//        scheduler.scheduleJob(jobDetail, trigger);

        Scheduler scheduler;
        try {

            scheduler = schedulerConfig.scheduler();
            TriggerKey triggerKey = TriggerKey.triggerKey("trigger1", TRIGGER_GROUP_NAME);
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            if (null == trigger) {
                Class clazz = HelloJob.class;
                JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity("job1", JOB_GROUP_NAME).usingJobData("name","weiz QuartzJob").build();
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/10 * * * * ?");
                trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", TRIGGER_GROUP_NAME)
                        .withSchedule(scheduleBuilder).build();
                scheduler.scheduleJob(jobDetail, trigger);
                System.out.println("Quartz 创建了job:...:" + jobDetail.getKey());
            } else {
                System.out.println("Job已存在:{}" + trigger.getKey());
            }

            TriggerKey triggerKey2 = TriggerKey.triggerKey("trigger2", TRIGGER_GROUP_NAME);
            CronTrigger trigger2 = (CronTrigger) scheduler.getTrigger(triggerKey2);
            if (null == trigger2) {
                Class clazz = HelloJob2.class;
                JobDetail jobDetail2 = JobBuilder.newJob(clazz).withIdentity("job2", JOB_GROUP_NAME).usingJobData("name","weiz QuartzJob2").build();
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/10 * * * * ?");
                trigger2 = TriggerBuilder.newTrigger().withIdentity("trigger2", TRIGGER_GROUP_NAME)
                        .withSchedule(scheduleBuilder).build();
                scheduler.scheduleJob(jobDetail2, trigger2);
                System.out.println("Quartz 创建了job:...:{}" + jobDetail2.getKey());
            } else {
                System.out.println("Job2已存在:{}" + trigger2.getKey());
            }
            scheduler.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println( "Hello World!" );
    }
}
