package com.zhang.bean;

public class Department {
	//和empoyMapper.xml里面的result结果集属性一样
    private Integer deptId;

    private String deptName;

    public Department() {
		
	}
    
	

	public Department(Integer deptId, String deptName) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
	}



	public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }
}