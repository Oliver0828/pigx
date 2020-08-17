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

/**
 * 薪资项
 *
 * @author XP
 * @date 2020-06-09 15:32:47
 */
@Data
@TableName("systpaystditem_common")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "薪资项")
public class SystpaystditemCommon extends Model<SystpaystditemCommon> {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	@ApiModelProperty(value = "")
	private Integer id;
	/**
	 * 薪资项列名 值为item+id
	 */
	@ApiModelProperty(value = "薪资项列名 值为item+id")
	private String colname;
	/**
	 * 薪资项名称
	 */
	@ApiModelProperty(value = "薪资项名称")
	private String title;
	/**
	 * 排序
	 */
	@ApiModelProperty(value = "排序")
	private Integer xorder;
	/**
	 * 是否有效(0:有效，1:失效)
	 */
	@ApiModelProperty(value = "是否有效(0:有效，1:失效)")
	private Integer isdisabled;
	/**
	 * 备注
	 */
	@ApiModelProperty(value = "备注")
	private String remark;
	/**
	 * 类型
	 */
	@ApiModelProperty(value = "类型")
	private Integer type;
	/**
	 * 公司corpcode
	 */
	@ApiModelProperty(value = "公司corpcode")
	private String corpcode;
	/**
	 * 公司corpid
	 */
	@ApiModelProperty(value = "公司corpid")
	private Integer corpid;
	private Integer gid;
}
