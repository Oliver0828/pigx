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

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 
 *
 * @author gaoxiao
 * @date 2020-03-26 10:26:04
 */
@Data
@TableName("sys_suggest")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "")
public class Suggest extends Model<Suggest> {
private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @TableId
    @ApiModelProperty(value="")
    private Integer id;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String corpcode;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Integer userid;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String telphone;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String contact;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String suggest;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String createdate;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Integer status;


}
