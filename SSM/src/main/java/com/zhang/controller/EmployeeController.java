package com.zhang.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhang.bean.Employee;
import com.zhang.bean.MSG;
import com.zhang.service.EmployeeService;

/*  PathVariable 获取url中的数据
 *  RequestParam 获取请求参数的值
 *  GetMapping 组合注解
 */
@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;


	@ResponseBody
	@RequestMapping(value = "/emp/{ids}", method = RequestMethod.DELETE)
	public MSG deleteEmpbyId(@PathVariable("ids") String ids) {
		if (ids.contains("-")) {
			List<Integer> del_ids=new ArrayList<>();
			String[] str_ids = ids.split("-");
			//缁勮id鐨勯泦鍚�
			for(String string :str_ids)
			{
				del_ids.add(Integer.parseInt(string));
			}
			
			employeeService.deleteBatch(del_ids);
		} else {
			Integer id = Integer.parseInt(ids);
			employeeService.deleteEmp(id);

		}
		return MSG.success();

	}

	
	@ResponseBody
	@RequestMapping(value = "/emp/{empId}", method = RequestMethod.PUT)
	public MSG saveEmp(Employee employee, HttpServletRequest request) {
        System.out.println("员工将保存的数据：" + employee);
		employeeService.updateEmp(employee);
		return MSG.success();
	}

	
	@RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
	@ResponseBody
	public MSG getEmp(@PathVariable("id") Integer id) {

		Employee employee = employeeService.getEmp(id);
		
		return MSG.success().add("emp", employee);
	}

	
	@ResponseBody
	@RequestMapping("/checkuser")
	public MSG checkuser(@RequestParam("empName") String empName) {
		
		String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9fff]{2,5})";
		if (!empName.matches(regx)) {
			return MSG.fail().add("va_msg", "鍚庣鏍￠獙鐢ㄦ埛鍚嶉敊璇�");

		}
	
		if (employeeService.checkUser(empName)) {
			return MSG.success();// 100
		} else {
			return MSG.fail().add("va_msg", "鍚庣鏍￠獙鐢ㄦ埛鍚嶄笉鍙敤");// 200
		}

	}


	@RequestMapping(value = "/emp", method = RequestMethod.POST)
	@ResponseBody
	public MSG saveEmp(@Valid Employee employee, BindingResult result) {
		if (result.hasErrors()) {
			
			Map<String, Object> map = new HashMap<>();
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError fieldError : errors) {
				System.out.println("閿欒鐨勫瓧娈靛悕" + fieldError.getField());
				System.out.println("閿欒淇℃伅锛�" + fieldError.getDefaultMessage());
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			// public MSG add(String key, Object value)
			return MSG.fail().add("erroFiled", map);
		} else {

			employeeService.saveEmp(employee);
			return MSG.success();
		}

	}

	/*
	 * 
	 * 瀵煎叆jackson鍖咃紝Respponsebody璐熻矗杞负json
	 * 
	 * function to_page(pn) { $.ajax({ url : "${APP_PATH}/emps", data : "pn=" + pn,
	 * type : "GET",
	 */
	@RequestMapping("/emps")
	@ResponseBody
	public MSG getWorkersWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
	
		PageHelper.startPage(pn, 5);
		
		List<Employee> emps = employeeService.getAll();
		
		PageInfo page = new PageInfo(emps, 5);
		return MSG.success().add("pageInfo", page);

	}


	// @RequestMapping("/emps"),index2
	public String getWorkers(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
		
		PageHelper.startPage(pn, 5);
	
		List<Employee> emps = employeeService.getAll();
	
		PageInfo page = new PageInfo(emps, 5);
		model.addAttribute("pageInfo", page);
		
		return "list";
	}
}
