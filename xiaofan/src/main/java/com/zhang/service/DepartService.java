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
		// ����������Ϣ������Ϊ�գ������ơ�������еĲ�����Ϣ
		List<Department> list= departmentMapper.selectByExample(null);
		return list;
	}

}
