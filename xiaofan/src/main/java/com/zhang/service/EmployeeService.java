package com.zhang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhang.bean.Employee;
import com.zhang.bean.EmployeeExample;
import com.zhang.bean.EmployeeExample.Criteria;
import com.zhang.dao.EmployeeMapper;

import net.sf.jsqlparser.statement.create.index.CreateIndex;

@Service
public class EmployeeService {

	@Autowired
	EmployeeMapper employeeMapper;
 
	public List<Employee> getAll() {

		// TODO Auto-generated method stub
		return employeeMapper.selectByExampleWithDept(null);
	}

	/*
	 * 
	 * 员工保存
	 */
	public void saveEmp(Employee employee) {
		employeeMapper.insertSelective(employee);
	}

	/*
	 * 检测用户名是否存在 true 可用，false不可用
	 * 
	 */
	public boolean checkUser(String empName) {
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andWorkerNameEqualTo(empName);
		long count = employeeMapper.countByExample(example);
		return count == 0;
	}

	/*
	 * 
	 * 按照员工ID查询员工
	 */
	public Employee getEmp(Integer id) {
		Employee employee = employeeMapper.selectByPrimaryKey(id);
		return employee;
	}
   
	//员工更新
	public void updateEmp(Employee employee) {
		employeeMapper.updateByPrimaryKeySelective(employee);
		
	}
   
	/*
	 *  员工删除
	 */
	public void deleteEmp(Integer id) {
		
		employeeMapper.deleteByPrimaryKey(id);
	}

	public void deleteBatch(List<Integer> ids) {
		EmployeeExample example=new EmployeeExample();
		Criteria criteria=example.createCriteria();
		//delete from xxx where workers_id in(1,2,3)
		criteria.andWorkerIdIn(ids);
		employeeMapper.deleteByExample(example);
		
	}

}
