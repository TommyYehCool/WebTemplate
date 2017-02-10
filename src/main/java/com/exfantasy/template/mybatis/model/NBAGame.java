package com.exfantasy.template.mybatis.model;

import io.swagger.annotations.ApiModelProperty;

public class NBAGame {
    @ApiModelProperty(notes = "場次 ID", required = true)
    private Integer gameId;

    @ApiModelProperty(notes = "主隊第一節比分", required = true)
    private Integer homeTeam1stScores;

    @ApiModelProperty(notes = "主隊第二節比分", required = true)
    private Integer homeTeam2ndScores;

    @ApiModelProperty(notes = "主隊第三節比分", required = true)
    private Integer homeTeam3rdScores;

    @ApiModelProperty(notes = "主隊第四節比分", required = true)
    private Integer homeTeam4thScores;

    @ApiModelProperty(notes = "主隊總比分", required = true)
    private Integer homeTeamScoresSum;

    @ApiModelProperty(notes = "客隊第一節比分", required = true)
    private Integer awayTeam1stScores;

    @ApiModelProperty(notes = "客隊第二節比分", required = true)
    private Integer awayTeam2ndScores;

    @ApiModelProperty(notes = "客隊第三節比分", required = true)
    private Integer awayTeam3rdScores;

    @ApiModelProperty(notes = "客隊第四節比分", required = true)
    private Integer awayTeam4thScores;

    @ApiModelProperty(notes = "客隊總比分", required = true)
    private Integer awayTeamScoresSum;

    @ApiModelProperty(notes = "兩隊總比分", required = true)
    private Integer totalScoresSum;

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getHomeTeam1stScores() {
        return homeTeam1stScores;
    }

    public void setHomeTeam1stScores(Integer homeTeam1stScores) {
        this.homeTeam1stScores = homeTeam1stScores;
    }

    public Integer getHomeTeam2ndScores() {
        return homeTeam2ndScores;
    }

    public void setHomeTeam2ndScores(Integer homeTeam2ndScores) {
        this.homeTeam2ndScores = homeTeam2ndScores;
    }

    public Integer getHomeTeam3rdScores() {
        return homeTeam3rdScores;
    }

    public void setHomeTeam3rdScores(Integer homeTeam3rdScores) {
        this.homeTeam3rdScores = homeTeam3rdScores;
    }

    public Integer getHomeTeam4thScores() {
        return homeTeam4thScores;
    }

    public void setHomeTeam4thScores(Integer homeTeam4thScores) {
        this.homeTeam4thScores = homeTeam4thScores;
    }

    public Integer getHomeTeamScoresSum() {
        return homeTeamScoresSum;
    }

    public void setHomeTeamScoresSum(Integer homeTeamScoresSum) {
        this.homeTeamScoresSum = homeTeamScoresSum;
    }

    public Integer getAwayTeam1stScores() {
        return awayTeam1stScores;
    }

    public void setAwayTeam1stScores(Integer awayTeam1stScores) {
        this.awayTeam1stScores = awayTeam1stScores;
    }

    public Integer getAwayTeam2ndScores() {
        return awayTeam2ndScores;
    }

    public void setAwayTeam2ndScores(Integer awayTeam2ndScores) {
        this.awayTeam2ndScores = awayTeam2ndScores;
    }

    public Integer getAwayTeam3rdScores() {
        return awayTeam3rdScores;
    }

    public void setAwayTeam3rdScores(Integer awayTeam3rdScores) {
        this.awayTeam3rdScores = awayTeam3rdScores;
    }

    public Integer getAwayTeam4thScores() {
        return awayTeam4thScores;
    }

    public void setAwayTeam4thScores(Integer awayTeam4thScores) {
        this.awayTeam4thScores = awayTeam4thScores;
    }

    public Integer getAwayTeamScoresSum() {
        return awayTeamScoresSum;
    }

    public void setAwayTeamScoresSum(Integer awayTeamScoresSum) {
        this.awayTeamScoresSum = awayTeamScoresSum;
    }

    public Integer getTotalScoresSum() {
        return totalScoresSum;
    }

    public void setTotalScoresSum(Integer totalScoresSum) {
        this.totalScoresSum = totalScoresSum;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        NBAGame other = (NBAGame) that;
        return (this.getGameId() == null ? other.getGameId() == null : this.getGameId().equals(other.getGameId()))
            && (this.getHomeTeam1stScores() == null ? other.getHomeTeam1stScores() == null : this.getHomeTeam1stScores().equals(other.getHomeTeam1stScores()))
            && (this.getHomeTeam2ndScores() == null ? other.getHomeTeam2ndScores() == null : this.getHomeTeam2ndScores().equals(other.getHomeTeam2ndScores()))
            && (this.getHomeTeam3rdScores() == null ? other.getHomeTeam3rdScores() == null : this.getHomeTeam3rdScores().equals(other.getHomeTeam3rdScores()))
            && (this.getHomeTeam4thScores() == null ? other.getHomeTeam4thScores() == null : this.getHomeTeam4thScores().equals(other.getHomeTeam4thScores()))
            && (this.getHomeTeamScoresSum() == null ? other.getHomeTeamScoresSum() == null : this.getHomeTeamScoresSum().equals(other.getHomeTeamScoresSum()))
            && (this.getAwayTeam1stScores() == null ? other.getAwayTeam1stScores() == null : this.getAwayTeam1stScores().equals(other.getAwayTeam1stScores()))
            && (this.getAwayTeam2ndScores() == null ? other.getAwayTeam2ndScores() == null : this.getAwayTeam2ndScores().equals(other.getAwayTeam2ndScores()))
            && (this.getAwayTeam3rdScores() == null ? other.getAwayTeam3rdScores() == null : this.getAwayTeam3rdScores().equals(other.getAwayTeam3rdScores()))
            && (this.getAwayTeam4thScores() == null ? other.getAwayTeam4thScores() == null : this.getAwayTeam4thScores().equals(other.getAwayTeam4thScores()))
            && (this.getAwayTeamScoresSum() == null ? other.getAwayTeamScoresSum() == null : this.getAwayTeamScoresSum().equals(other.getAwayTeamScoresSum()))
            && (this.getTotalScoresSum() == null ? other.getTotalScoresSum() == null : this.getTotalScoresSum().equals(other.getTotalScoresSum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGameId() == null) ? 0 : getGameId().hashCode());
        result = prime * result + ((getHomeTeam1stScores() == null) ? 0 : getHomeTeam1stScores().hashCode());
        result = prime * result + ((getHomeTeam2ndScores() == null) ? 0 : getHomeTeam2ndScores().hashCode());
        result = prime * result + ((getHomeTeam3rdScores() == null) ? 0 : getHomeTeam3rdScores().hashCode());
        result = prime * result + ((getHomeTeam4thScores() == null) ? 0 : getHomeTeam4thScores().hashCode());
        result = prime * result + ((getHomeTeamScoresSum() == null) ? 0 : getHomeTeamScoresSum().hashCode());
        result = prime * result + ((getAwayTeam1stScores() == null) ? 0 : getAwayTeam1stScores().hashCode());
        result = prime * result + ((getAwayTeam2ndScores() == null) ? 0 : getAwayTeam2ndScores().hashCode());
        result = prime * result + ((getAwayTeam3rdScores() == null) ? 0 : getAwayTeam3rdScores().hashCode());
        result = prime * result + ((getAwayTeam4thScores() == null) ? 0 : getAwayTeam4thScores().hashCode());
        result = prime * result + ((getAwayTeamScoresSum() == null) ? 0 : getAwayTeamScoresSum().hashCode());
        result = prime * result + ((getTotalScoresSum() == null) ? 0 : getTotalScoresSum().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", gameId=").append(gameId);
        sb.append(", homeTeam1stScores=").append(homeTeam1stScores);
        sb.append(", homeTeam2ndScores=").append(homeTeam2ndScores);
        sb.append(", homeTeam3rdScores=").append(homeTeam3rdScores);
        sb.append(", homeTeam4thScores=").append(homeTeam4thScores);
        sb.append(", homeTeamScoresSum=").append(homeTeamScoresSum);
        sb.append(", awayTeam1stScores=").append(awayTeam1stScores);
        sb.append(", awayTeam2ndScores=").append(awayTeam2ndScores);
        sb.append(", awayTeam3rdScores=").append(awayTeam3rdScores);
        sb.append(", awayTeam4thScores=").append(awayTeam4thScores);
        sb.append(", awayTeamScoresSum=").append(awayTeamScoresSum);
        sb.append(", totalScoresSum=").append(totalScoresSum);
        sb.append("]");
        return sb.toString();
    }
}