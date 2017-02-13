package com.exfantasy.template.mybatis.model;

import io.swagger.annotations.ApiModelProperty;

public class NBATeam {
    @ApiModelProperty(notes = "ID", required = true)
    private Integer teamId;

    @ApiModelProperty(notes = "簡稱", required = true)
    private String abbr;

    @ApiModelProperty(notes = "城市-中文", required = true)
    private String cityCh;

    @ApiModelProperty(notes = "城市-英文", required = true)
    private String cityEn;

    @ApiModelProperty(notes = "代碼", required = true)
    private String code;

    @ApiModelProperty(notes = "聯盟-中文", required = true)
    private String conferenceCh;

    @ApiModelProperty(notes = "聯盟-英文", required = true)
    private String conferenceEn;

    @ApiModelProperty(notes = "組別-中文", required = true)
    private String divisionCh;

    @ApiModelProperty(notes = "組別-英文", required = true)
    private String divisionEn;

    @ApiModelProperty(notes = "隊名-中文", required = true)
    private String nameCh;

    @ApiModelProperty(notes = "隊名-英文", required = true)
    private String nameEn;

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr == null ? null : abbr.trim();
    }

    public String getCityCh() {
        return cityCh;
    }

    public void setCityCh(String cityCh) {
        this.cityCh = cityCh == null ? null : cityCh.trim();
    }

    public String getCityEn() {
        return cityEn;
    }

    public void setCityEn(String cityEn) {
        this.cityEn = cityEn == null ? null : cityEn.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getConferenceCh() {
        return conferenceCh;
    }

    public void setConferenceCh(String conferenceCh) {
        this.conferenceCh = conferenceCh == null ? null : conferenceCh.trim();
    }

    public String getConferenceEn() {
        return conferenceEn;
    }

    public void setConferenceEn(String conferenceEn) {
        this.conferenceEn = conferenceEn == null ? null : conferenceEn.trim();
    }

    public String getDivisionCh() {
        return divisionCh;
    }

    public void setDivisionCh(String divisionCh) {
        this.divisionCh = divisionCh == null ? null : divisionCh.trim();
    }

    public String getDivisionEn() {
        return divisionEn;
    }

    public void setDivisionEn(String divisionEn) {
        this.divisionEn = divisionEn == null ? null : divisionEn.trim();
    }

    public String getNameCh() {
        return nameCh;
    }

    public void setNameCh(String nameCh) {
        this.nameCh = nameCh == null ? null : nameCh.trim();
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn == null ? null : nameEn.trim();
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
        NBATeam other = (NBATeam) that;
        return (this.getTeamId() == null ? other.getTeamId() == null : this.getTeamId().equals(other.getTeamId()))
            && (this.getAbbr() == null ? other.getAbbr() == null : this.getAbbr().equals(other.getAbbr()))
            && (this.getCityCh() == null ? other.getCityCh() == null : this.getCityCh().equals(other.getCityCh()))
            && (this.getCityEn() == null ? other.getCityEn() == null : this.getCityEn().equals(other.getCityEn()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getConferenceCh() == null ? other.getConferenceCh() == null : this.getConferenceCh().equals(other.getConferenceCh()))
            && (this.getConferenceEn() == null ? other.getConferenceEn() == null : this.getConferenceEn().equals(other.getConferenceEn()))
            && (this.getDivisionCh() == null ? other.getDivisionCh() == null : this.getDivisionCh().equals(other.getDivisionCh()))
            && (this.getDivisionEn() == null ? other.getDivisionEn() == null : this.getDivisionEn().equals(other.getDivisionEn()))
            && (this.getNameCh() == null ? other.getNameCh() == null : this.getNameCh().equals(other.getNameCh()))
            && (this.getNameEn() == null ? other.getNameEn() == null : this.getNameEn().equals(other.getNameEn()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTeamId() == null) ? 0 : getTeamId().hashCode());
        result = prime * result + ((getAbbr() == null) ? 0 : getAbbr().hashCode());
        result = prime * result + ((getCityCh() == null) ? 0 : getCityCh().hashCode());
        result = prime * result + ((getCityEn() == null) ? 0 : getCityEn().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getConferenceCh() == null) ? 0 : getConferenceCh().hashCode());
        result = prime * result + ((getConferenceEn() == null) ? 0 : getConferenceEn().hashCode());
        result = prime * result + ((getDivisionCh() == null) ? 0 : getDivisionCh().hashCode());
        result = prime * result + ((getDivisionEn() == null) ? 0 : getDivisionEn().hashCode());
        result = prime * result + ((getNameCh() == null) ? 0 : getNameCh().hashCode());
        result = prime * result + ((getNameEn() == null) ? 0 : getNameEn().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", teamId=").append(teamId);
        sb.append(", abbr=").append(abbr);
        sb.append(", cityCh=").append(cityCh);
        sb.append(", cityEn=").append(cityEn);
        sb.append(", code=").append(code);
        sb.append(", conferenceCh=").append(conferenceCh);
        sb.append(", conferenceEn=").append(conferenceEn);
        sb.append(", divisionCh=").append(divisionCh);
        sb.append(", divisionEn=").append(divisionEn);
        sb.append(", nameCh=").append(nameCh);
        sb.append(", nameEn=").append(nameEn);
        sb.append("]");
        return sb.toString();
    }
}