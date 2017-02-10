package com.exfantasy.template.vo.json.nba;

import java.util.ArrayList;
import java.util.List;

import com.exfantasy.template.mybatis.model.NBASchedule;
import com.exfantasy.template.vo.deserializer.nba.NBAScheduleFromNBATwDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;

@Data
@JsonDeserialize(using = NBAScheduleFromNBATwDeserializer.class)
public class NBAScheduleFromNBATw {

	private List<NBASchedule> schedules = new ArrayList<>();
	
	public void addSchedule(NBASchedule schedule) {
		schedules.add(schedule);
	}
}
