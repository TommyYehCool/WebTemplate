package com.exfantasy.template.cnst.nba;

/**
 * <pre>
 * NBA 東西區
 * </pre>
 * 
 * @author tommy.feng
 *
 */
public enum NBAConference {
	Eastern("Eastern", "東區聯盟"),

	Western("Western", "西區聯盟");
	
	private String english;
	
	private String chinese;
	
	private NBAConference(String english, String chinese) {
		this.english = english;
		this.chinese = chinese;
	}
	
	public static String getChinese(String english) {
		for (NBAConference e : NBAConference.values()) {
			if (e.english.equalsIgnoreCase(english)) {
				return e.chinese;
			}
		}
		return "";
	}
}
