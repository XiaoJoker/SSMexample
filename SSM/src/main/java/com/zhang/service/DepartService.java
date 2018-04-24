package com.zhang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhang.bean.Department;
import com.zhang.dao.DepartmentMapper;

@Service
public class DepartService {
   @Autowired
   private DepartmentMapper departmentMapper;
	
	public List<Department> getDepts() {
		// 查找所有信息，参数为空，无限制。查出所有的部门信息
		List<Department> list= departmentMapper.selectByExample(null);
		return list;
	}

}
