package com.zhang.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhang.bean.Department;
import com.zhang.bean.Employee;
import com.zhang.dao.DepartmentMapper;
import com.zhang.dao.EmployeeMapper;

/*
    * ����dao��Ĺ���
    * ���ַ���
    * �Ƽ�ʹ��Spring����Ŀʹ��spring�ĵ�Ԫ���ԣ������Զ�ע��������Ҫ�����
    * 1.����SpringTest
    * 2.@ContextConfigurationָ��Spring�����ļ���λ��
    * 3.ֱ��autowired
    */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class MapperTest {
	@Autowired
	DepartmentMapper departmentMapper;
	@Autowired
	EmployeeMapper employeeMapper;

	@Autowired
	SqlSession sqlSession;

	/*
	 * ����department
	 */
	@Test
	public void testCRUD() {
		/*
		 * //1.����springIOC���� ApplicationContext ioc=new
		 * ClassPathXmlApplicationContext("applicationContext.xml"); //2.�������л�ȡmapper
		 * DepartmentMapper bean=ioc.getBean(DepartmentMapper.class);
		 */
		System.out.println(departmentMapper);

		// 1.���뼸������
	    departmentMapper.insertSelective(new Department(null,"开发部"));
		departmentMapper.insertSelective(new Department(null,"测试部"));

		// 2.����Ա�����ݣ�����Ա������
		//employeeMapper.insertSelective(new Employee(null, "dazhuang","M",
		//"994683607@qq.com", 1));
		// 3.����������Ա��: ������ʹ�ÿ���ִ������������sqlSession
		
		EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);
		for(int i=0;i<100;i++)
		{
			String uidString=UUID.randomUUID().toString().substring(0, 5)+""+i;
			mapper.insertSelective(new Employee(null, uidString, "M", uidString+"@com", 1));
		}
		}

}
	
