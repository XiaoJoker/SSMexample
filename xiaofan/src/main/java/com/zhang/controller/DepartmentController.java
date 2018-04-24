package com.zhang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhang.bean.Department;
import com.zhang.bean.MSG;
import com.zhang.service.DepartService;

/*
 * 
 * 处理和部门有关的请求
 */
@Controller
public class DepartmentController {
    
	@Autowired
	private DepartService departService;
	
	/*
	 * 返回所有部门信息
	 */
	@ResponseBody
	@RequestMapping("/depts")
	public MSG getDepts() {
		//查出的所有部门
		List<Department> list=departService.getDepts();
		return MSG.success().add("depts", list);
	}
	
}
