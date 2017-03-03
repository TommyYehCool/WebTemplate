package com.exfantasy.template.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.exfantasy.template.services.nba.NBAService;

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

    @Autowired
    private NBAService nbaService;
    
    // second, minute, hour, day of month, month, day(s) of week
//    private final String SCHEDULED_TIME = "0 0 8 * * *";

    // for testing
    private final String SCHEDULED_TIME = "0 9 16 * * *";

//    @Scheduled(fixedRate = 5000)
//    public void reportCurrentTime() {
//    	  SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//        System.out.println("Fix Scheduler running -> The time is now " + dateFormat.format(new Date()));
//    }
    
    /**
     * 每天早上 08:00 去抓最新的 NBA 隊伍資料
     */
    @Scheduled(cron = SCHEDULED_TIME)
    public void fetchNewestNBATeamsInformation() {
    	nbaService.fetchNewestNBATeamsInformation();
    }
    
    /**
     * 每天早上 08:00 去抓最新的 NBA 賽程資料
     */
    @Scheduled(cron = SCHEDULED_TIME)
    public void fetchNewestNBASchedules() {
    	nbaService.fetchNewestNBASchedules();
    }
    
    /**
     * 每天早上 08:00 去抓最新的 NBA 賽事結果
     */
    @Scheduled(cron = SCHEDULED_TIME)
    public void fetchNewestNBAGames() {
    	nbaService.fetchTodayNBAGameResults();
    }
}