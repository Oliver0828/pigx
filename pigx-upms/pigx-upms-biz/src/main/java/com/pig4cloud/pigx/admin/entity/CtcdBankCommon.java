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
 * 银行
 *
 * @author gaoxiao
 * @date 2020-07-10 15:17:34
 */
@Data
@TableName("ctcd_bank_common")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "银行")
public class CtcdBankCommon extends Model<CtcdBankCommon> {
private static final long serialVersionUID = 1L;

    /**
     * 编码
     */
    @TableId
    @ApiModelProperty(value="编码")
    private Integer id;
    /**
     * 代码
     */
    @ApiModelProperty(value="代码")
    private String code;
    /**
     * 名称
     */
    @ApiModelProperty(value="名称")
    private String title;
    /**
     * 是否默认
     */
    @ApiModelProperty(value="是否默认")
    private Integer isdefault;
    /**
     * 是否失效
     */
    @ApiModelProperty(value="是否失效")
    private Integer isdisabled;
    /**
     * 备注
     */
    @ApiModelProperty(value="备注")
    private String remark;
    /**
     * 公司ID
     */
    @ApiModelProperty(value="公司ID")
    private Integer compid;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String corpcode;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Integer corpid;
    }
