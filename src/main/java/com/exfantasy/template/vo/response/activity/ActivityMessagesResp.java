package com.exfantasy.template.vo.response.activity;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <pre>
 * 活動留言
 * </pre>
 * 
 * @author tommy.feng
 *
 */
@Data
public class ActivityMessagesResp {
	@ApiModelProperty(notes = "留言者的 email")
	private String createUserEmail;
	
	@ApiModelProperty(notes = "留言日期時間")
	private Date createDatetime;
	
	@ApiModelProperty(notes = "留言")
	private String msg;
}
