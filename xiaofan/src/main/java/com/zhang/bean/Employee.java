package com.zhang.bean;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;

public class Employee {
    private Integer workerId;
     
    @Pattern(regexp="(^[a-zA-Z0-9_-]{6,16}$)|(^[\\u2E80-\\u9fff]{2,5})",message="后端验证：用户名必须是2-5位中文或者6-16位英文和数字的组合")
    private String workerName;

    private String workerGender;
    
    //@Email()
    @Pattern(regexp="^([a-zA-Z0-9]+[_|\\_|\\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\\_|\\.]?)*[a-zA-Z0-9]+\\.[a-zA-Z]{2,3}$",message="后端验证邮箱格式不正确")
    private String workerEmail;

    private Integer dId;
    //查询员工的同时得到部门信息
    private Department department;
        

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employee() {
		super();
	}

	public Employee(Integer workerId, String workerName, String workerGender, String workerEmail, Integer dId) {
		super();
		this.workerId = workerId;
		this.workerName = workerName;
		this.workerGender = workerGender;
		this.workerEmail = workerEmail;
		this.dId = dId;
	}

	public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName == null ? null : workerName.trim();
    }

    public String getWorkerGender() {
        return workerGender;
    }

    public void setWorkerGender(String workerGender) {
        this.workerGender = workerGender == null ? null : workerGender.trim();
    }

    public String getWorkerEmail() {
        return workerEmail;
    }

    public void setWorkerEmail(String workerEmail) {
        this.workerEmail = workerEmail == null ? null : workerEmail.trim();
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

	@Override
	public String toString() {
		return "Employee [workerId=" + workerId + ", workerName=" + workerName + ", workerGender=" + workerGender
				+ ", workerEmail=" + workerEmail + ", dId=" + dId + ", department=" + department + "]";
	}
    
}