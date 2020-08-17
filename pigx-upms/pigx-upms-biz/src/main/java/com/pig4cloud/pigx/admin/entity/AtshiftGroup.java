/*
 *    Copyright (c) 2018-2025, lengleng All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: lengleng (wangiegie@gmail.com)
 */

package com.pig4cloud.pigx.admin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 轮班定义
 *
 * @author gaoxiao
 * @date 2020-07-06 16:26:48
 */
@Data
@TableName("atshift_group")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "轮班定义")
public class AtshiftGroup extends Model<AtshiftGroup> {
private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @TableId
    @ApiModelProperty(value="")
    private Integer turnid;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String title;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Integer periods;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String remark;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Integer initialized;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Integer submit;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Integer ischeck;
    private String corpcode;
    private Integer corpid;
	@TableField(exist=false)
    private List<AtshiftGroupSub> atshiftGroupSubList;
	private Integer agentmode;
    }
