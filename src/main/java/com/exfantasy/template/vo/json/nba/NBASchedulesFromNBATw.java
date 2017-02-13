package com.exfantasy.template.vo.json.nba;

import java.util.ArrayList;
import java.util.List;

import com.exfantasy.template.mybatis.model.NBASchedule;
import com.exfantasy.template.vo.json.deserializer.nba.NBASchedulesFromNBATwDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;

@Data
@JsonDeserialize(using = NBASchedulesFromNBATwDeserializer.class)
public class NBASchedulesFromNBATw {

	private List<NBASchedule> schedules = new ArrayList<>();
	
	public void addNBASchedule(NBASchedule schedule) {
		schedules.add(schedule);
	}
}
