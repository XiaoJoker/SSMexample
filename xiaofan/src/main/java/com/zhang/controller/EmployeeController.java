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

/*
 * 
 * 处理员工Crud请求
 */
@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	/*
	 * 单个，批量删除整合在一起。 批量删除：1-2-3
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/emp/{ids}", method = RequestMethod.DELETE)
	public MSG deleteEmpbyId(@PathVariable("ids") String ids) {
		//批量删除形似1-2-3
		if (ids.contains("-")) {
			List<Integer> del_ids=new ArrayList<>();
			//移除“-”
			String[] str_ids = ids.split("-");
			//组装id的集合，将String转换成int，并加入integer 的List集合
			for(String string :str_ids)
			{
				del_ids.add(Integer.parseInt(string));
			}
			//批量删除
			employeeService.deleteBatch(del_ids);
		} else {
			Integer id = Integer.parseInt(ids);
			employeeService.deleteEmp(id);

		}
		return MSG.success();

	}

	/*
	 * 如果直接发送ajax=PUT形式请求 封装的数据 将要更新的员工数据：Employee [workerId=321, workerName=null,
	 * workerGender=null, workerEmail=null, dId=null, department=null]
	 * 问题：请求体中有数据，但是employee对象封装不上； update tb1_emp where emp_id=201
	 * AJAX发送PUT请求引发的血案， 请求体中的数据,request.getParameter("workerName")拿不到
	 * Ttomcat一看是PUT不会封装请求体中的数据为map，只有POST形式的请求封装为map
	 * 
	 * 原因：Tomcat 1.将请求体中的数据，封装一个map， 2.request.getParameter("empName")就会从这个map取值
	 * 3.SPringMVC封装POJO对象的时候，会把POJO每个属性的值, request.getParamter("email")
	 * 解决：要能支持直接发送put之类的的请求还要封装请求体中的数据 配置上HttpPutFormContentFilter
	 * 他的作用：将请求体重的数据解析包装成一个map， request被重新包装，request，getParameter被重写 就会从自己封装的map中取数据
	 * 员工更新后保存员工
	 * 
	 * 此处的{empId}一定要和Employee.java中的属性对应一样才能传入参数？
	 * 
	 * @RequestMapping(value = "/emp/{workerId}", method = RequestMethod.PUT)
	 */
	@ResponseBody
	@RequestMapping(value = "/emp/{workerId}", method = RequestMethod.PUT)
	public MSG saveEmp(Employee employee, HttpServletRequest request) {

		System.out.println("将要更新的员工数据：" + employee);
		employeeService.updateEmp(employee);
		return MSG.success();
	}

	/*
	 * 
	 * 根据ID查询员工 一般查询服务的时候用get，向后台提交数据时用post，如注册等等。
	 * 这个说白了就是http里面get和post的差别了，post安全点，提交的数据多点， 数据是放在http头信息里面的，get的参数是在URL后面的
	 * $.ajax({url:"${APP_PATH}/emp/"+id, type:"GET", ajax要发送好几个数据。
	 * url：发送的请求地址（类似于action），后台controller用@RequestMapping的value属性接受请求
	 * type：请求方式（如post，get，delete等），controller的method属性与之对应一样
	 * dataType：数据返回的类型，可以是xml，json等，我们这里声明清楚是json类型。 data：要传进去的数据，格式为key:value
	 * ，controller里可以在方法的参数里，使用@RequestParam("value") 来获取这个数
	 * success：成功返回数据后要执行的操作，此处我们是弹出结果。里面的data（自定义名字，你取名aaa都行
	 * ）即对应着controller里的return XXX的XXX 。（后面再详讲）
	 */
	@RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
	@ResponseBody
	public MSG getEmp(@PathVariable("id") Integer id) {
		// 创建一个员工对象，指向Service层中找到的那个员工对象
		Employee employee = employeeService.getEmp(id);
		// public MSG add(String key, Object value)
		return MSG.success().add("emp", employee);
	}

	// 后端校验采用JSR303，防止用户提交非法数据
	/*
	 * 检验用户名是否存在 $("#empName_add").change(function(){ //发送ajax请求检验用户名是否可用 var
	 * empName=this.value; $.ajax({ url:"${APP_PATH}/checkuser",
	 * data:"empName="+empName, type:"POST",
	 */
	@ResponseBody
	@RequestMapping("/checkuser")
	public MSG checkuser(@RequestParam("empName") String empName) {
		// 先判断用户是否是合法的表达式
		String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9fff]{2,5})";
		if (!empName.matches(regx)) {
			return MSG.fail().add("va_msg", "后端校验用户名错误");

		}
		// 数据库重复校验
		if (employeeService.checkUser(empName)) {
			return MSG.success();// 100
		} else {
			return MSG.fail().add("va_msg", "后端校验用户名不可用");// 200
		}

	}

	/*
	 * 员工保存 1.支持JSR303 2.导入Hibernate validator $.ajax({ url : "${APP_PATH}/emp",
	 * type : "POST", data : $("#empAddmodal form").serialize(),
	 */
	@RequestMapping(value = "/emp", method = RequestMethod.POST)
	@ResponseBody
	public MSG saveEmp(@Valid Employee employee, BindingResult result) {
		if (result.hasErrors()) {
			// 校验失败,应该返回失败在莫泰框中显示错误信息
			Map<String, Object> map = new HashMap<>();
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError fieldError : errors) {
				System.out.println("错误的字段名" + fieldError.getField());
				System.out.println("错误信息：" + fieldError.getDefaultMessage());
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
	 * 导入jackson包，Respponsebody负责转为json
	 * 
	 * function to_page(pn) { $.ajax({ url : "${APP_PATH}/emps", data : "pn=" + pn,
	 * type : "GET",
	 */
	@RequestMapping("/emps")
	@ResponseBody
	public MSG getWorkersWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		// 这不是一个分页查询
		// 引入pageHelper分页插件
		// 在查询之前只需要调用,传入页码以及每页大小
		PageHelper.startPage(pn, 5);
		// startPage后面紧跟的这个查询就是一个分页查询
		List<Employee> emps = employeeService.getAll();
		// 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面
		// 封装了详细的分页信息，包括我们查询出来的数据,传入连续显示的页数
		// list.jsp调用pageInfo得到数据
		PageInfo page = new PageInfo(emps, 5);
		return MSG.success().add("pageInfo", page);

	}

	/*
	 * 查询所有员工（分页查询）,第一种请求方法，index.jsp发出emps请求，跳转到list页面
	 */
	// @RequestMapping("/emps"),index2
	public String getWorkers(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
		// 这不是一个分页查询
		// 引入pageHelper分页插件
		// 在查询之前只需要调用,传入页码以及每页大小
		PageHelper.startPage(pn, 5);
		// startPage后面紧跟的这个查询就是一个分页查询
		List<Employee> emps = employeeService.getAll();
		// 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面
		// 封装了详细的分页信息，包括我们查询出来的数据,传入连续显示的页数
		// list.jsp调用pageInfo得到数据
		PageInfo page = new PageInfo(emps, 5);
		model.addAttribute("pageInfo", page);
		// return list.jsp,在dispatcher-servlet中配置返回请求的前缀web-INF/view和后缀。jsp
		return "list";
	}
}
