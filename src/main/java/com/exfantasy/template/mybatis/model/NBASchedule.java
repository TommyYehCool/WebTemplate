package com.exfantasy.template.mybatis.model;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

public class NBASchedule {
    @ApiModelProperty(notes = "場次 ID", required = true)
    private Integer gameId;

    @ApiModelProperty(notes = "場次時間 (in millis)", required = true)
    private Long gameTimeInMillis;

    @ApiModelProperty(notes = "場次時間", required = true)
    private Date gameTime;

    @ApiModelProperty(notes = "主場隊伍 ID", required = true)
    private Integer homeTeamId;

    @ApiModelProperty(notes = "客場隊伍 ID", required = true)
    private Integer awayTeamId;

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Long getGameTimeInMillis() {
        return gameTimeInMillis;
    }

    public void setGameTimeInMillis(Long gameTimeInMillis) {
        this.gameTimeInMillis = gameTimeInMillis;
    }

    public Date getGameTime() {
        return gameTime;
    }

    public void setGameTime(Date gameTime) {
        this.gameTime = gameTime;
    }

    public Integer getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(Integer homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public Integer getAwayTeamId() {
        return awayTeamId;
    }

    public void setAwayTeamId(Integer awayTeamId) {
        this.awayTeamId = awayTeamId;
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
        NBASchedule other = (NBASchedule) that;
        return (this.getGameId() == null ? other.getGameId() == null : this.getGameId().equals(other.getGameId()))
            && (this.getGameTimeInMillis() == null ? other.getGameTimeInMillis() == null : this.getGameTimeInMillis().equals(other.getGameTimeInMillis()))
            && (this.getGameTime() == null ? other.getGameTime() == null : this.getGameTime().equals(other.getGameTime()))
            && (this.getHomeTeamId() == null ? other.getHomeTeamId() == null : this.getHomeTeamId().equals(other.getHomeTeamId()))
            && (this.getAwayTeamId() == null ? other.getAwayTeamId() == null : this.getAwayTeamId().equals(other.getAwayTeamId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGameId() == null) ? 0 : getGameId().hashCode());
        result = prime * result + ((getGameTimeInMillis() == null) ? 0 : getGameTimeInMillis().hashCode());
        result = prime * result + ((getGameTime() == null) ? 0 : getGameTime().hashCode());
        result = prime * result + ((getHomeTeamId() == null) ? 0 : getHomeTeamId().hashCode());
        result = prime * result + ((getAwayTeamId() == null) ? 0 : getAwayTeamId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", gameId=").append(gameId);
        sb.append(", gameTimeInMillis=").append(gameTimeInMillis);
        sb.append(", gameTime=").append(gameTime);
        sb.append(", homeTeamId=").append(homeTeamId);
        sb.append(", awayTeamId=").append(awayTeamId);
        sb.append("]");
        return sb.toString();
    }
}