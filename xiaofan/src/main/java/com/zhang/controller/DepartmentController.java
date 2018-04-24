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
 * ����Ͳ����йص�����
 */
@Controller
public class DepartmentController {
    
	@Autowired
	private DepartService departService;
	
	/*
	 * �������в�����Ϣ
	 */
	@ResponseBody
	@RequestMapping("/depts")
	public MSG getDepts() {
		//��������в���
		List<Department> list=departService.getDepts();
		return MSG.success().add("depts", list);
	}
	
}
