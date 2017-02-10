package com.exfantasy.template.vo.response.nba;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class NBAScheduleResp {
	@ApiModelProperty(notes = "場次 ID")
	private Integer gameId;
	
	@ApiModelProperty(notes = "場次時間 (Date)")
    private Date gameTimeDate;
	
	@ApiModelProperty(notes = "場次時間 (String)")
	private String gameTimeStr;
	
	@ApiModelProperty(notes = "主隊隊名 (中文)")
	private String homeTeamNameCh;
	
	@ApiModelProperty(notes = "主隊隊名 (英文)")
	private String homeTeamNameEn;
	
	@ApiModelProperty(notes = "客隊隊名 (中文)")
	private String awayTeamNameCh;
	
	@ApiModelProperty(notes = "客隊隊名 (英文)")
	private String awayTeamNameEn;
	
	public String getGameTimeStr() {
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateTimeFormat.format(gameTimeDate);
	}
}
