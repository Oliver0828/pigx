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

/**
 * 审批流程子表-审批信息
 *
 * @author XP
 * @date 2020-06-22 14:18:07
 */
@Data
@TableName("qywx_workitem_approval")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "审批流程子表-审批信息")
public class QywxWorkitemApproval extends Model<QywxWorkitemApproval> {
	private static final long serialVersionUID = 1L;

	/**
	 * 序号
	 */
	@TableId
	@ApiModelProperty(value = "序号")
	private Integer id;
	/**
	 * 审批单编号
	 */
	@ApiModelProperty(value = "审批单编号")
	private String thirdno;
	/**
	 * 审批模板名称
	 */
	@ApiModelProperty(value = "审批模板名称")
	private String openspname;
	/**
	 * 审批模板id
	 */
	@ApiModelProperty(value = "审批模板id")
	private String opentemplateid;
	/**
	 * 用户所属企业的corpid
	 */
	@ApiModelProperty(value = "用户所属企业的corpid")
	private String qywxcorpid;
	/**
	 * 申请单当前审批状态：1-审批中；2-已通过；3-已驳回；4-已取消
	 */
	@ApiModelProperty(value = "申请单当前审批状态：1-审批中；2-已通过；3-已驳回；4-已取消")
	private Integer openspstatus;
	/**
	 * 提交申请时间
	 */
	@ApiModelProperty(value = "提交申请时间")
	private String applytime;
	/**
	 * 提交者姓名
	 */
	@ApiModelProperty(value = "提交者姓名")
	private String applyusername;
	/**
	 * 提交者userid
	 */
	@ApiModelProperty(value = "提交者userid")
	private Integer applyuserid;
	/**
	 * 提交者所在部门编码
	 */
	@ApiModelProperty(value = "提交者所在部门编码")
	private Integer applydeptid;
	/**
	 * 提交者所在部门
	 */
	@ApiModelProperty(value = "提交者所在部门")
	private String applyuserparty;
	/**
	 * 审批申请状态变化类型：1-提单；2-同意；3-驳回；4-转审；5-催办；6-撤销；8-通过后撤销；10-添加备注
	 */
	@ApiModelProperty(value = "审批申请状态变化类型：1-提单；2-同意；3-驳回；4-转审；5-催办；6-撤销；8-通过后撤销；10-添加备注")
	private Integer statuchangeevent;
	/**
	 * 类型
	 */
	@ApiModelProperty(value = "类型")
	private String type;
	/**
	 * 节点审批操作状态：1-审批中；2-已同意；3-已驳回；4-已转审
	 */
	@ApiModelProperty(value = "节点审批操作状态：1-审批中；2-已同意；3-已驳回；4-已转审")
	private Integer nodestatus;
	/**
	 * 审批节点属性：1-或签；2-会签
	 */
	@ApiModelProperty(value = "审批节点属性：1-或签；2-会签")
	private Integer nodeattr;
	/**
	 * 审批节点类型：1-固定成员；2-标签；3-上级
	 */
	@ApiModelProperty(value = "审批节点类型：1-固定成员；2-标签；3-上级")
	private Integer nodetype;
	/**
	 * 分支审批人姓名
	 */
	@ApiModelProperty(value = "分支审批人姓名")
	private String itemname;
	/**
	 * 分支审批人userid
	 */
	@ApiModelProperty(value = "分支审批人userid")
	private Integer itemuserid;
	/**
	 * 分支审批审批操作状态：1-审批中；2-已同意；3-已驳回；4-已转审
	 */
	@ApiModelProperty(value = "分支审批审批操作状态：1-审批中；2-已同意；3-已驳回；4-已转审")
	private Integer itemstatus;
	/**
	 * 分支审批人审批意见
	 */
	@ApiModelProperty(value = "分支审批人审批意见")
	private String itemspeech;
	/**
	 * 分支审批人操作时间
	 */
	@ApiModelProperty(value = "分支审批人操作时间")
	private String itemoptime;
	/**
	 * 分支审批人审批意见附件，media_id
	 */
	@ApiModelProperty(value = "分支审批人审批意见附件，media_id")
	private String mediaid;
	/**
	 * 备注人姓名
	 */
	@ApiModelProperty(value="备注人姓名")
	private String commentname;
	/**
	 * 备注人userid
	 */
	@ApiModelProperty(value="备注人userid")
	private Integer commentuserid;
	/**
	 * 备注提交时间
	 */
	@ApiModelProperty(value="备注提交时间")
	private LocalDateTime commenttime;
	/**
	 * 备注文本内容
	 */
	@ApiModelProperty(value="备注文本内容")
	private String commentcontent;
	/**
	 * 备注id
	 */
	@ApiModelProperty(value="备注id")
	private Integer commentid;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	private String createTime;
	/**
	 * 修改时间
	 */
	@ApiModelProperty(value = "修改时间")
	private String updateTime;
	/**
	 * 开始时间
	 */
	@TableField(exist = false)
	@ApiModelProperty(value = "开始时间")
	private String startTime;
	/**
	 * 结束时间
	 */
	@TableField(exist = false)
	@ApiModelProperty(value = "结束时间")
	private String endTime;
}
