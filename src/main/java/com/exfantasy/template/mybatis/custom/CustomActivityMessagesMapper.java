package com.exfantasy.template.mybatis.custom;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.exfantasy.template.mybatis.mapper.ActivityMessagesMapper;
import com.exfantasy.template.vo.response.activity.ActivityMessagesResp;

@Mapper
public interface CustomActivityMessagesMapper extends ActivityMessagesMapper {
	@Select({
        "select",
        	"u.email as createUserEmail,",
        	"am.create_datetime as createDatetime,",
        	"am.msg as msg",
        "from activity_messages am",
        "left join user u on am.create_user_id = u.user_id",
        "where am.activity_id = #{activityId,jdbcType=INTEGER}"
    })
    @Results(
    	id = "ActivityMessagesResp",
    	value = {
    		@Result(column="createUserEmail", property="createUserEmail", jdbcType=JdbcType.VARCHAR),
    		@Result(column="createDatetime", property="createDatetime", jdbcType=JdbcType.TIMESTAMP),
    		@Result(column="msg", property="msg", jdbcType=JdbcType.VARCHAR)
    	}
    )
	List<ActivityMessagesResp> selectActivityMessagesRespByActivityId(@Param("activityId") Integer activityId);
	
}
