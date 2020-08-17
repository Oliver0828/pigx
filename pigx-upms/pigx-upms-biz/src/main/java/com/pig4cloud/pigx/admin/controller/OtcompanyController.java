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

package com.pig4cloud.pigx.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pigx.admin.api.dto.DeptTreeOrg;
import com.pig4cloud.pigx.admin.api.dto.TreeOrg;
import com.pig4cloud.pigx.admin.entity.Etemployee;
import com.pig4cloud.pigx.admin.entity.Otdepartment;
import com.pig4cloud.pigx.admin.mapper.OtcompanyMapper;
import com.pig4cloud.pigx.admin.service.OtdepartmentService;
import com.pig4cloud.pigx.common.core.util.R;
import com.pig4cloud.pigx.common.log.annotation.SysLog;
import com.pig4cloud.pigx.admin.entity.Otcompany;
import com.pig4cloud.pigx.admin.service.OtcompanyService;
import com.pig4cloud.pigx.common.security.service.PigxUser;
import com.pig4cloud.pigx.common.security.util.SecurityUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 
 *
 * @author gaoxiao
 * @date 2020-03-26 16:50:17
 */
@RestController
@AllArgsConstructor
@RequestMapping("/otcompany" )
@Api(value = "otcompany", tags = "公司管理")
public class OtcompanyController {

    private final  OtcompanyService otcompanyService;
    private final OtdepartmentService otdepartmentService;
    private final OtcompanyMapper otcompanyMapper;


    /**
     * 分页查询
     * @param page 分页对象
     * @param otcompany 
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    public R getOtcompanyPage(Page page, Otcompany otcompany) {
        return R.ok(otcompanyService.page(page, Wrappers.query(otcompany)));
    }

	/**
	 * 查询所有
	 * @param otcompany 公司
	 * @return
	 */
	@ApiOperation(value = "查询所有", notes = "查询所有")
	@PostMapping("/getAllOtcompany" )
	public R getAllOtcompany(@RequestBody(required = false) Otcompany otcompany) {
		PigxUser pigxUser = SecurityUtils.getUser();
		String corpcode = pigxUser.getCorpcode();
		if(StringUtils.isEmpty(otcompany)){
			otcompany = new Otcompany();
		}
		otcompany.setCorpcode(corpcode);
		return R.ok(otcompanyService.list(Wrappers.query(otcompany)));
	}


    /**
     * 通过id查询
     * @param compid id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{compid}" )
    public R getById(@PathVariable("compid" ) Integer compid) {
        return R.ok(otcompanyService.getById(compid));
    }

    /**
     * 新增
     * @param otcompany 
     * @return R
     */
    @ApiOperation(value = "新增", notes = "新增")
    @SysLog("新增" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('admin_otcompany_add')" )
    public R save(@RequestBody Otcompany otcompany) {

        return R.ok(otcompanyService.save(otcompany));
    }


/*
    */
/**
     * 修改
     * @param otcompany 
     * @return R
     *//*

    @ApiOperation(value = "修改", notes = "修改")
    @SysLog("修改" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('admin_otcompany_edit')" )
    public R updateById(@RequestBody Otcompany otcompany) {
        return R.ok(otcompanyService.updateById(otcompany));
    }

    */
/**
     * 通过id删除
     * @param compid id
     * @return R
     *//*

    @ApiOperation(value = "通过id删除", notes = "通过id删除")
    @SysLog("通过id删除" )
    @DeleteMapping("/{compid}" )
    @PreAuthorize("@pms.hasPermission('admin_otcompany_del')" )
    public R removeById(@PathVariable Integer compid) {
    	return R.ok(otcompanyService.removeById(compid));
    }
*/

	/**
	 * 获取公司/部门  手机组织架构树一级菜单
	 * @return
	 */
	@ApiOperation(value = "获取公司列表", notes = "获取公司列表")
	@PostMapping("/getOtcompanyList" )
	public R getOtcompanyList() {
		Map map = new HashMap();
		List compList = otcompanyService.getOtcompanyList();
		if(compList==null){
			compList = new ArrayList();
		}
		List corpList = otcompanyService.getcorpList();
		if(corpList==null){
			corpList = new ArrayList();
		}
		map.put("comp",compList);
		map.put("corp",corpList);
		return R.ok(map);
	}
	/**
	 * 获取公司、部门  手机组织架构树二级及以后菜单
	 * @return
	 */
	@ApiOperation(value = "获取公司部门列表", notes = "获取公司部门列表")
	@PostMapping ("/getCompanyMoreLevelList" )
	public R getCompanyMoreLevelList(@RequestBody Map<String,String> map) {
		/*
		**1、如果为叶子节点flag{0:非叶子节点，1：叶子节点}，则根据sytpe{C:公司，D：部门}则跳转到相应明细
		* 2、如果为非叶子节点，则根据stype 调用getCompanyMoreLevelList
		 */
		PigxUser pigxUser = SecurityUtils.getUser();
		String flag = (String)map.get("flag");
		String stype = (String)map.get("stype");
		String id = (String)map.get("id");
		if("1".equals(flag)){
			if("C".equals(stype)){
				id = id.replace("C","");
				int compid = Integer.parseInt(id);
				return R.ok(otcompanyService.getById(compid));
			}else if("D".equals(stype)){
				id = id.replace("D","");
				int depid = Integer.parseInt(id);
				return R.ok(otdepartmentService.getById(depid));
			}
		}else if("0".equals(flag)){
			if("C".equals(stype)){
				id = id.replace("C","");
				int compid = Integer.parseInt(id);
				Map compMap = new HashMap();
				compMap.put("corpcode",pigxUser.getCorpcode());
				compMap.put("compid",compid);
				return R.ok(otcompanyService.getCompanySecondLevel(compMap));
			}else if("D".equals(stype)){
				id = id.replace("D","");
				int depid = Integer.parseInt(id);
				Map compMap = new HashMap();
				compMap.put("corpcode",pigxUser.getCorpcode());
				compMap.put("depid",depid);
				return R.ok(otcompanyService.getDept(compMap));
			}
		}
		return R.failed();


	}

	/**
	 * 获取公司/部门  手机组织架构树一级菜单
	 * @return
	 */
	@ApiOperation(value = "获取组织架构树", notes = "获取组织架构树")
	@PostMapping("/getOrganizationTree" )
	public R getOrganizationTree() {
		Otcompany otcompany = new Otcompany();
		//PigxUser pigxUser = SecurityUtils.getUser();
		//int compid = pigxUser.getCompid();
		//otcompany.setCompid(compid);
		otcompany.setCompid(2);
		TreeOrg tree = otcompanyService.getOrganizationTree(otcompany);

		return R.ok(tree);
	}


	/**
	 * 获取公司/部门/岗位  手机组织架构树
	 * @return
	 */
	@ApiOperation(value = "获取组织架构树", notes = "获取组织架构树")
	@PostMapping("/getOrganizationTreeMobile" )
	public R getOrganizationTreeMobile() {
		Otcompany otcompany = new Otcompany();
		PigxUser pigxUser = SecurityUtils.getUser();
		int compid = pigxUser.getCompid();
		String corpcode = pigxUser.getCorpcode();
		String compname = pigxUser.getCompname();
		otcompany.setCompid(compid);
		otcompany.setTitle(compname);
		otcompany.setCorpcode(corpcode);
		//otcompany.setCompid(2);
		TreeOrg tree = otcompanyService.getOrganizationTreeMobile(otcompany);

		return R.ok(tree);
	}

	/**
	 * 获取公司/部门/岗位  手机组织架构树
	 * @return
	 */
	@ApiOperation(value = "获取组织架构树", notes = "获取组织架构树")
	@PostMapping("/getToDeptTreeMobile" )
	public R getToDeptTreeMobile() {
		Otcompany otcompany = new Otcompany();
		PigxUser pigxUser = SecurityUtils.getUser();
		Integer compid = pigxUser.getCompid();
		String compname = pigxUser.getCompname();
		otcompany.setCompid(compid);
		otcompany.setTitle(compname);
		otcompany.setCorpcode(pigxUser.getCorpcode());
		//otcompany.setCompid(2);
		TreeOrg tree = otcompanyService.getToDeptTreeMobile(otcompany);

		return R.ok(tree);
	}
	@ApiOperation(value = "根据条件查询", notes = "根据条件查询")
	@GetMapping("/getOtcompanyByCondition" )
	public R getOtcompanyByCondition(Otcompany otcompany) {

		return R.ok(null,"部门编号已存在，请重新填写");
	}

	/**
	 * PC端部门管理
	 * @return
	 */
	@ApiOperation(value = "PC端部门管理", notes = "PC端部门管理")
	@PostMapping("/getOrganizationTreePC" )
	public R getOrganizationTreePC(Page page,@RequestBody(required = false) Otdepartment otdepartment) {
		PigxUser pigxUser = SecurityUtils.getUser();
		String corpcode = pigxUser.getCorpcode();
		if(!StringUtils.isEmpty(otdepartment)){
			otdepartment.setCorpcode(corpcode);
		}else{
			otdepartment = new Otdepartment();
		}

		IPage<DeptTreeOrg> treeOrgIPage= otcompanyService.getOrganizationTreePC(page,otdepartment);
		return R.ok(treeOrgIPage);
	}

	/**
	 * PC端部门管理
	 * @return
	 */
	@ApiOperation(value = "PC端部门管理-二级及以下菜单", notes = "PC端部门管理-二级及以下菜单")
	@PostMapping("/getOrganizationTreePCSecond" )
	public R getOrganizationTreePCSecond(@RequestBody Otdepartment otdepartment) {
		PigxUser pigxUser = SecurityUtils.getUser();
		String corpcode = pigxUser.getCorpcode();
		otdepartment.setCorpcode(corpcode);
		List resultList= otcompanyService.getOrganizationTreePCSecond(otdepartment);
		return R.ok(resultList);
	}

	/**
	 * 通过compid获取公司详情
	 * @return
	 */
	@ApiOperation(value = "通过compid获取公司详情", notes = "通过compid获取公司详情")
	@PostMapping("/getCompDeitalByCompid" )
	public R getCompDeitalByCompid(@RequestBody Otcompany otcompany) {
		PigxUser pigxUser = SecurityUtils.getUser();
		String corpcode = pigxUser.getCorpcode();
		otcompany.setCorpcode(corpcode);
		Map resultMap  = otcompanyMapper.listCompDeitalByCompid(otcompany);
		return R.ok(resultMap);
	}
/*	*//*
	 * 组织架构图
	 * @return
	 *//*
	@ApiOperation(value = "组织架构图", notes = "组织架构图")
	@GetMapping("/org" )
	public void org(HttpServletResponse response) throws IOException {
		response.sendRedirect("http://192.168.8.72:8080/admin/static/index.html");
	}*/

}
