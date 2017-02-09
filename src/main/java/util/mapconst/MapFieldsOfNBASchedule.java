package util.mapconst;

public enum MapFieldsOfNBASchedule implements MapFields {
	GAME_ID("gameId", "場次 ID"),
	GAME_TIME_IN_MILLIS("gameTimeInMillis", "場次時間 (in millis)"),
	GAME_TIME("gameTime", "場次時間"),
	HOME_TEAM_ID("homeTeamId", "主場隊伍 ID"),
	AWAY_TEAM_ID("awayTeamId", "客場隊伍 ID")
	;

	private String fieldName;
	private String note;
	
	private MapFieldsOfNBASchedule(String fieldName, String note) {
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
	
	public static MapFieldsOfNBASchedule convert(String fieldName) {
		for (MapFieldsOfNBASchedule e : MapFieldsOfNBASchedule.values()) {
			if (e.getFieldName().compareToIgnoreCase(fieldName) == 0) {
				return e;
			}
		}
		return null;
	}

}
