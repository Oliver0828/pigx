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

package com.pig4cloud.pigx.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pig4cloud.pigx.admin.entity.CtbenefitRegister;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 福利开启登记
 *
 * @author XP
 * @date 2020-06-11 15:05:49
 */
@Mapper
public interface CtbenefitRegisterMapper extends BaseMapper<CtbenefitRegister> {

	//根据id调用存储过程cSP_BenefitCheck获取信息提示
	Map cSP_BenefitCheck(Map paramMap);

	//根据id调用存储过程cSP_BenefitStart获取信息提示
	Map cSP_BenefitStart(Map paramMap);
}
