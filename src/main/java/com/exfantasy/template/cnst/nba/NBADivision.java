package com.exfantasy.template.cnst.nba;

/**
 * <pre>
 * NBA 組別
 * </pre>
 * 
 * @author tommy.feng
 *
 */
public enum NBADivision {
	Atlantic("Atlantic", "大西洋組"),
	Central("Central", "中央組"),
	Northwest("Northwest", "西北組"),
	Pacific("Pacific", "太平洋組"),
	Southeast("Southeast", "東南組"),
	Southwest("Southwest", "西南組");
	
	private String english;
	
	private String chinese;
	
	private NBADivision(String english, String chinese) {
		this.english = english;
		this.chinese = chinese;
	}
	
	public static String getChinese(String english) {
		for (NBADivision e : NBADivision.values()) {
			if (e.english.compareToIgnoreCase(english) == 0) {
				return e.chinese;
			}
		}
		return "";
	}
}
