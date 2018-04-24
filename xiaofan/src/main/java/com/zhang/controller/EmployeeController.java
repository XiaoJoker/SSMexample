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
 * ����Ա��Crud����
 */
@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	/*
	 * ����������ɾ��������һ�� ����ɾ����1-2-3
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/emp/{ids}", method = RequestMethod.DELETE)
	public MSG deleteEmpbyId(@PathVariable("ids") String ids) {
		//����ɾ������1-2-3
		if (ids.contains("-")) {
			List<Integer> del_ids=new ArrayList<>();
			//�Ƴ���-��
			String[] str_ids = ids.split("-");
			//��װid�ļ��ϣ���Stringת����int��������integer ��List����
			for(String string :str_ids)
			{
				del_ids.add(Integer.parseInt(string));
			}
			//����ɾ��
			employeeService.deleteBatch(del_ids);
		} else {
			Integer id = Integer.parseInt(ids);
			employeeService.deleteEmp(id);

		}
		return MSG.success();

	}

	/*
	 * ���ֱ�ӷ���ajax=PUT��ʽ���� ��װ������ ��Ҫ���µ�Ա�����ݣ�Employee [workerId=321, workerName=null,
	 * workerGender=null, workerEmail=null, dId=null, department=null]
	 * ���⣺�������������ݣ�����employee�����װ���ϣ� update tb1_emp where emp_id=201
	 * AJAX����PUT����������Ѫ���� �������е�����,request.getParameter("workerName")�ò���
	 * Ttomcatһ����PUT�����װ�������е�����Ϊmap��ֻ��POST��ʽ�������װΪmap
	 * 
	 * ԭ��Tomcat 1.���������е����ݣ���װһ��map�� 2.request.getParameter("empName")�ͻ�����mapȡֵ
	 * 3.SPringMVC��װPOJO�����ʱ�򣬻��POJOÿ�����Ե�ֵ, request.getParamter("email")
	 * �����Ҫ��֧��ֱ�ӷ���put֮��ĵ�����Ҫ��װ�������е����� ������HttpPutFormContentFilter
	 * �������ã����������ص����ݽ�����װ��һ��map�� request�����°�װ��request��getParameter����д �ͻ���Լ���װ��map��ȡ����
	 * Ա�����º󱣴�Ա��
	 * 
	 * �˴���{empId}һ��Ҫ��Employee.java�е����Զ�Ӧһ�����ܴ��������
	 * 
	 * @RequestMapping(value = "/emp/{workerId}", method = RequestMethod.PUT)
	 */
	@ResponseBody
	@RequestMapping(value = "/emp/{workerId}", method = RequestMethod.PUT)
	public MSG saveEmp(Employee employee, HttpServletRequest request) {

		System.out.println("��Ҫ���µ�Ա�����ݣ�" + employee);
		employeeService.updateEmp(employee);
		return MSG.success();
	}

	/*
	 * 
	 * ����ID��ѯԱ�� һ���ѯ�����ʱ����get�����̨�ύ����ʱ��post����ע��ȵȡ�
	 * ���˵���˾���http����get��post�Ĳ���ˣ�post��ȫ�㣬�ύ�����ݶ�㣬 �����Ƿ���httpͷ��Ϣ����ģ�get�Ĳ�������URL�����
	 * $.ajax({url:"${APP_PATH}/emp/"+id, type:"GET", ajaxҪ���ͺü������ݡ�
	 * url�����͵������ַ��������action������̨controller��@RequestMapping��value���Խ�������
	 * type������ʽ����post��get��delete�ȣ���controller��method������֮��Ӧһ��
	 * dataType�����ݷ��ص����ͣ�������xml��json�ȣ������������������json���͡� data��Ҫ����ȥ�����ݣ���ʽΪkey:value
	 * ��controller������ڷ����Ĳ����ʹ��@RequestParam("value") ����ȡ�����
	 * success���ɹ��������ݺ�Ҫִ�еĲ������˴������ǵ�������������data���Զ������֣���ȡ��aaa����
	 * ������Ӧ��controller���return XXX��XXX �����������꽲��
	 */
	@RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
	@ResponseBody
	public MSG getEmp(@PathVariable("id") Integer id) {
		// ����һ��Ա������ָ��Service�����ҵ����Ǹ�Ա������
		Employee employee = employeeService.getEmp(id);
		// public MSG add(String key, Object value)
		return MSG.success().add("emp", employee);
	}

	// ���У�����JSR303����ֹ�û��ύ�Ƿ�����
	/*
	 * �����û����Ƿ���� $("#empName_add").change(function(){ //����ajax��������û����Ƿ���� var
	 * empName=this.value; $.ajax({ url:"${APP_PATH}/checkuser",
	 * data:"empName="+empName, type:"POST",
	 */
	@ResponseBody
	@RequestMapping("/checkuser")
	public MSG checkuser(@RequestParam("empName") String empName) {
		// ���ж��û��Ƿ��ǺϷ��ı��ʽ
		String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9fff]{2,5})";
		if (!empName.matches(regx)) {
			return MSG.fail().add("va_msg", "���У���û�������");

		}
		// ���ݿ��ظ�У��
		if (employeeService.checkUser(empName)) {
			return MSG.success();// 100
		} else {
			return MSG.fail().add("va_msg", "���У���û���������");// 200
		}

	}

	/*
	 * Ա������ 1.֧��JSR303 2.����Hibernate validator $.ajax({ url : "${APP_PATH}/emp",
	 * type : "POST", data : $("#empAddmodal form").serialize(),
	 */
	@RequestMapping(value = "/emp", method = RequestMethod.POST)
	@ResponseBody
	public MSG saveEmp(@Valid Employee employee, BindingResult result) {
		if (result.hasErrors()) {
			// У��ʧ��,Ӧ�÷���ʧ����Ī̩������ʾ������Ϣ
			Map<String, Object> map = new HashMap<>();
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError fieldError : errors) {
				System.out.println("������ֶ���" + fieldError.getField());
				System.out.println("������Ϣ��" + fieldError.getDefaultMessage());
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
	 * ����jackson����Respponsebody����תΪjson
	 * 
	 * function to_page(pn) { $.ajax({ url : "${APP_PATH}/emps", data : "pn=" + pn,
	 * type : "GET",
	 */
	@RequestMapping("/emps")
	@ResponseBody
	public MSG getWorkersWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		// �ⲻ��һ����ҳ��ѯ
		// ����pageHelper��ҳ���
		// �ڲ�ѯ֮ǰֻ��Ҫ����,����ҳ���Լ�ÿҳ��С
		PageHelper.startPage(pn, 5);
		// startPage��������������ѯ����һ����ҳ��ѯ
		List<Employee> emps = employeeService.getAll();
		// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ��
		// ��װ����ϸ�ķ�ҳ��Ϣ���������ǲ�ѯ����������,����������ʾ��ҳ��
		// list.jsp����pageInfo�õ�����
		PageInfo page = new PageInfo(emps, 5);
		return MSG.success().add("pageInfo", page);

	}

	/*
	 * ��ѯ����Ա������ҳ��ѯ��,��һ�����󷽷���index.jsp����emps������ת��listҳ��
	 */
	// @RequestMapping("/emps"),index2
	public String getWorkers(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
		// �ⲻ��һ����ҳ��ѯ
		// ����pageHelper��ҳ���
		// �ڲ�ѯ֮ǰֻ��Ҫ����,����ҳ���Լ�ÿҳ��С
		PageHelper.startPage(pn, 5);
		// startPage��������������ѯ����һ����ҳ��ѯ
		List<Employee> emps = employeeService.getAll();
		// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ��
		// ��װ����ϸ�ķ�ҳ��Ϣ���������ǲ�ѯ����������,����������ʾ��ҳ��
		// list.jsp����pageInfo�õ�����
		PageInfo page = new PageInfo(emps, 5);
		model.addAttribute("pageInfo", page);
		// return list.jsp,��dispatcher-servlet�����÷��������ǰ׺web-INF/view�ͺ�׺��jsp
		return "list";
	}
}
