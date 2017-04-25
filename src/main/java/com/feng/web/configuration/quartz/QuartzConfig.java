///**
// * Created by Heart_Bool on 2017/4/17.
// */
//package com.feng.web.configuration.quartz;
//
//import org.quartz.Scheduler;
//import org.quartz.SchedulerException;
//import org.quartz.SchedulerFactory;
//import org.quartz.impl.StdSchedulerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.IOException;
//import java.util.Properties;
//
///***
// * Description:
// *
// * @AUTHOR: HEART_BOOL
// * @EMAIL: 18908069164@163.com
// * @DATE: 2017/4/17 22:42
// */
//@Configuration
//public class QuartzConfig {
//    @Bean
//    public Scheduler scheduler() throws IOException, SchedulerException {
//        SchedulerFactory schedulerFactory = new StdSchedulerFactory(quartzProperties());
//        Scheduler scheduler = schedulerFactory.getScheduler();
//        scheduler.start();
//        return scheduler;
//    }
//
//    /**
//     * 设置quartz属性
//     *
//     * @throws IOException 2016年10月8日下午2:39:05
//     */
//    public Properties quartzProperties() throws IOException {
//        Properties prop = new Properties();
//        prop.put("quartz.scheduler.instanceName", "ServerScheduler");
//        prop.put("org.quartz.scheduler.instanceId", "AUTO");
//        prop.put("org.quartz.scheduler.skipUpdateCheck", "true");
//        prop.put("org.quartz.scheduler.instanceId", "NON_CLUSTERED");
//        prop.put("org.quartz.scheduler.jobFactory.class", "org.quartz.simpl.SimpleJobFactory");
//        prop.put("org.quartz.jobStore.class", "org.quartz.impl.jdbcjobstore.JobStoreTX");
//        prop.put("org.quartz.jobStore.driverDelegateClass", "org.quartz.impl.jdbcjobstore.StdJDBCDelegate");
//        prop.put("org.quartz.jobStore.dataSource", "quartzDataSource");
//        prop.put("org.quartz.jobStore.tablePrefix", "QRTZ_");
//        prop.put("org.quartz.jobStore.isClustered", "true");
//        prop.put("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
//        prop.put("org.quartz.threadPool.threadCount", "5");
//
//        prop.put("org.quartz.dataSource.quartzDataSource.driver", "com.mysql.jdbc.Driver");
//        prop.put("org.quartz.dataSource.quartzDataSource.URL", "jdbc:mysql://localhost:3306/demo-schema");
//        prop.put("org.quartz.dataSource.quartzDataSource.user", "root");
//        prop.put("org.quartz.dataSource.quartzDataSource.password", "123456");
//        prop.put("org.quartz.dataSource.quartzDataSource.maxConnections", "10");
//        return prop;
//    }
//}