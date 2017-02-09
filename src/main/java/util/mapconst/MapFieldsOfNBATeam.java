package util.mapconst;

public enum MapFieldsOfNBATeam implements MapFields {
	TEAM_ID("teamId", "ID"),
	
	ABBR("abbr", "簡稱"),
	
	CITY_CH("cityCh", "城市"),
	
	CITY_EN("cityEn", "城市-英文"),
	
	CODE("code", "代碼"),
	
	CONFERENCE_CH("conferenceCh", "聯盟"),
	
	CONFERENCE_EN("conferenceEn", "聯盟-英文"),
	
	DIVISION_CH("divisionCh", "組別"),
	
	DIVISION_EN("divisionEn", "組別-英文"),
	
	NAME_CH("nameCh", "隊名"),
	
	NAME_EN("nameEn", "隊名-英文")
	;
	
	private String fieldName;
	private String note;
	
	private MapFieldsOfNBATeam(String fieldName, String note) {
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
	
	public static MapFieldsOfNBATeam convert(String fieldName) {
		for (MapFieldsOfNBATeam e : MapFieldsOfNBATeam.values()) {
			if (e.getFieldName().compareToIgnoreCase(fieldName) == 0) {
				return e;
			}
		}
		return null;
	}

}
