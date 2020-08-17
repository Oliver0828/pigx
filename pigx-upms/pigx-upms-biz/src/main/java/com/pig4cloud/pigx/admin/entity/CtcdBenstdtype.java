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
 * 基数类型
 *
 * @author gaoxiao
 * @date 2020-06-10 16:57:25
 */
@Data
@TableName("ctcd_benstdtype")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "基数类型")
public class CtcdBenstdtype extends Model<CtcdBenstdtype> {
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
     * 所属组织
     */
    @ApiModelProperty(value="所属组织")
    private String corpcode;
    }
