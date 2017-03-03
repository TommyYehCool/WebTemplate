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
 * <a href="https://spring.io/guides/gs/scheduling-tasks/">Spring Boot 內建排程</a>
 * <a href="http://stackoverflow.com/questions/26147044/spring-cron-expression-for-every-day-101am">Cron Expression</a>
 * 
 * Cron Expression 格式說明:
 * 	second, minute, hour, day of month, month, day(s) of week
 *  
 * Heroku 筆記: 
 *	放在 heroku 上, 記得要設定 heroku timezone
 *
 *	指令: 
 *		heroku config:add TZ="Asia/Taipei" --app tommywebservice
 * </pre>
 * 
 * @author tommy.feng
 */
@Component
public class ScheduledTasks {

    @Autowired
    private NBAService nbaService;
    
    // 抓取最新 NBA 隊伍資料時間
    private final String FETCH_NEWEST_NBA_TEAM_TIME = "0 0 6 * * *";
    
    // 抓取最新 NBA 賽程資料時間
    private final String FETCH_NEWEST_NBA_SCHEDULES_TIME = "0 0 6 * * *";
    
    // 抓取最新 NBA 賽事結果時間
    private final String FETCH_NEWEST_NBA_GAME_RESULTS_TIME = "0 0 12 * * *";

//    @Scheduled(fixedRate = 5000)
//    public void reportCurrentTime() {
//    	  SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//        System.out.println("Fix Scheduler running -> The time is now " + dateFormat.format(new Date()));
//    }
    
    /**
     * 每天早上 06:00 去抓最新的 NBA 隊伍資料
     */
    @Scheduled(cron = FETCH_NEWEST_NBA_TEAM_TIME)
    public void fetchNewestNBATeamsInformation() {
    	nbaService.fetchNewestNBATeamsInformation();
    }
    
    /**
     * 每天早上 06:00 去抓最新的 NBA 賽程資料
     */
    @Scheduled(cron = FETCH_NEWEST_NBA_SCHEDULES_TIME)
    public void fetchNewestNBASchedules() {
    	nbaService.fetchNewestNBASchedules();
    }
    
    /**
     * 每天中午 12:00 去抓最新的 NBA 賽事結果
     */
    @Scheduled(cron = FETCH_NEWEST_NBA_GAME_RESULTS_TIME)
    public void fetchNewestNBAGameResults() {
    	nbaService.fetchTodayNBAGameResults();
    }
}