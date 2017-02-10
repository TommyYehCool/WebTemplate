package com.exfantasy.template.mybatis.custom;

import org.apache.ibatis.jdbc.SQL;

public class CustomNBAGameSqlProvider {
	
	private SQL getSelectNBAGameRespsSQL() {
		SQL sql = new SQL();
		
		sql.SELECT("ng.game_id AS gameId");
		sql.SELECT("ht.name_ch AS homeTeamNameCh");
		sql.SELECT("ht.name_en AS homeTeamNameEn");
		sql.SELECT("at.name_ch AS awayTeamNameCh");
		sql.SELECT("at.name_en AS awayTeamNameEn");
		sql.SELECT("ng.home_team_1st_scores AS homeTeam1stScores");
        sql.SELECT("ng.home_team_2nd_scores AS homeTeam2ndScores");
        sql.SELECT("ng.home_team_3rd_scores AS homeTeam3rdScores");
        sql.SELECT("ng.home_team_4th_scores AS homeTeam4thScores");
        sql.SELECT("ng.home_team_scores_sum AS homeTeamScoresSum");
        sql.SELECT("ng.away_team_1st_scores AS awayTeam1stScores");
        sql.SELECT("ng.away_team_2nd_scores AS awayTeam2ndScores");
        sql.SELECT("ng.away_team_3rd_scores AS awayTeam3rdScores");
        sql.SELECT("ng.away_team_4th_scores AS awayTeam4thScores");
        sql.SELECT("ng.away_team_scores_sum AS awayTeamScoresSum");
        sql.SELECT("ng.total_scores_sum AS totalScoresSum");
        sql.FROM("nba_game AS ng");
        sql.LEFT_OUTER_JOIN("nba_schedule AS ns ON ng.game_id = ns.game_id");
        sql.LEFT_OUTER_JOIN("nba_team AS ht ON ns.home_team_id = ht.team_id");
        sql.LEFT_OUTER_JOIN("nba_team AS at ON ns.away_team_id = at.team_id");
        
        return sql;
	}

	public String selectNBAGameResps() {
		SQL sql = getSelectNBAGameRespsSQL();
		return sql.toString();
	}
	
	public String selectNBAGameRespByGameId() {
		SQL sql = getSelectNBAGameRespsSQL();
		sql.WHERE("ng.game_id = #{gameId,jdbcType=INTEGER}");
		return sql.toString();
	}
}
