package com.exfantasy.template.vo.response.nba;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class NBAGameResp {
	@ApiModelProperty(notes = "場次 ID")
	private Integer gameId;
	
	@ApiModelProperty(notes = "主隊隊名 (中文)")
	private String homeTeamNameCh;
	
	@ApiModelProperty(notes = "主隊隊名 (英文)")
	private String homeTeamNameEn;
	
	@ApiModelProperty(notes = "客隊隊名 (中文)")
	private String awayTeamNameCh;
	
	@ApiModelProperty(notes = "客隊隊名 (英文)")
	private String awayTeamNameEn;
	
	@ApiModelProperty(notes = "主隊第一節比分")
    private Integer homeTeam1stScores;

    @ApiModelProperty(notes = "主隊第二節比分")
    private Integer homeTeam2ndScores;

    @ApiModelProperty(notes = "主隊第三節比分")
    private Integer homeTeam3rdScores;

    @ApiModelProperty(notes = "主隊第四節比分")
    private Integer homeTeam4thScores;

    @ApiModelProperty(notes = "主隊總比分")
    private Integer homeTeamScoresSum;

    @ApiModelProperty(notes = "客隊第一節比分")
    private Integer awayTeam1stScores;

    @ApiModelProperty(notes = "客隊第二節比分")
    private Integer awayTeam2ndScores;

    @ApiModelProperty(notes = "客隊第三節比分")
    private Integer awayTeam3rdScores;

    @ApiModelProperty(notes = "客隊第四節比分")
    private Integer awayTeam4thScores;

    @ApiModelProperty(notes = "客隊總比分")
    private Integer awayTeamScoresSum;

    @ApiModelProperty(notes = "兩隊總比分")
    private Integer totalScoresSum;
}
