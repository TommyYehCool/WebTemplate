package com.exfantasy.template.vo.response.consume;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <pre>
 * 發票開獎資訊
 * </pre>
 * 
 * @author tommy.feng
 *
 */
@Data
public class RespReward {
	@ApiModelProperty(notes = "期別")
	private String section;
	
	@ApiModelProperty(notes = "獎別")
	private int rewardType;
	
	@ApiModelProperty(notes = "號碼")
	private String no;
}
