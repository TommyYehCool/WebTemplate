package com.exfantasy.template.schedule;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

/**
 * <pre>
 * Spring Boot 內建排程
 * 
 * 參考:
 * 	<a href="https://spring.io/guides/gs/scheduling-tasks/">Spring Boot 內建排程</a>
 *  <a href="http://stackoverflow.com/questions/26147044/spring-cron-expression-for-every-day-101am">Cron Expression</a>
 * </pre>
 * 
 * @author tommy.feng
 */
@Component
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

//    @Scheduled(fixedRate = 5000)
//    public void reportCurrentTime() {
//        System.out.println("Fix Scheduler running -> The time is now " + dateFormat.format(new Date()));
//    }
    
//    @Scheduled(cron = "0 23 14 9 * ?")
//    public void testCornSchedule() {
//    	System.out.println("Cron Scheduler running -> The time is now " + dateFormat.format(new Date()));
//    }
}