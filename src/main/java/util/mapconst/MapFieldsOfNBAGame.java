package util.mapconst;

public enum MapFieldsOfNBAGame implements MapFields {
	GAME_ID("gameId", "場次 ID"),
	HOME_TEAM_1ST_SCORES("homeTeam1stScores", "主隊第一節比分"),
	HOME_TEAM_2ND_SCORES("homeTeam2ndScores", "主隊第二節比分"),
	HOME_TEAM_3RD_SCORES("homeTeam3rdScores", "主隊第三節比分"),
	HOME_TEAM_4TH_SCORES("homeTeam4thScores", "主隊第四節比分"),
	HOME_TEAM_SCORES_SUM("homeTeamScoresSum", "主隊總比分"),
	AWAY_TEAM_1ST_SCORES("awayTeam1stScores", "客隊第一節比分"),
	AWAY_TEAM_2ND_SCORES("awayTeam2ndScores", "客隊第二節比分"),
	AWAY_TEAM_3RD_SCORES("awayTeam3rdScores", "客隊第三節比分"),
	AWAY_TEAM_4TH_SCORES("awayTeam4thScores", "客隊第四節比分"),
	AWAY_TEAM_SCORES_SUM("awayTeamScoresSum", "客隊總比分"),
	TOTAL_SCORES_SUM("totalScoresSum", "兩隊總比分")
	;

	private String fieldName;
	private String note;
	
	private MapFieldsOfNBAGame(String fieldName, String note) {
		this.fieldName = fieldName;
		this.note = note;
	}
	
	@Override
	public String getFieldName() {
		return this.fieldName;
	}
	
	@Override
	public String getNote() {
		return this.note;
	}
	
	public static MapFieldsOfNBAGame convert(String fieldName) {
		for (MapFieldsOfNBAGame e : MapFieldsOfNBAGame.values()) {
			if (e.getFieldName().compareToIgnoreCase(fieldName) == 0) {
				return e;
			}
		}
		return null;
	}

}
