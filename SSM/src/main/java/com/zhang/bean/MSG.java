package com.zhang.bean;

/*
 * 
 * 通用的返回类
 */
import java.util.HashMap;
import java.util.Map;

public class MSG {
	/*{"code":100,"msg":"����ɹ���","extend":{"pageInfo":{"pageNum":1,
	 * "pageSize":5,"size":5,"startRow":1,"endRow":5,"total":115,
	 * "pages":23,"list":[{"workerId":201,"workerName":"bf7000","
	 * workerGender":"M","workerEmail":"bf7000@com","dId":1,"
	 * department":{"deptId":1,"deptName":"������"}},
	 * {"workerId":202,"workerName":"721c71","workerGender":
	 * "M","workerEmail":"721c71@com","dId":
	 * 1,"department":{"deptId":1,"deptName":"������"}}
	 * ,{"workerId":203,"workerName":"ab1772","
	 * workerGender":"M","workerEmail":"ab1772@com","dId":1,
	 * "department":{"deptId":1,"deptName":"������"}},
	 * {"workerId":204,"workerName":"661db3",
	 * "workerGender":"M","workerEmail":"661db3@com","
	 * dId":1,"department":{"deptId":1,"deptName":"������"}}
	 * ,{"workerId":205,"workerName":"ad3ef4","workerGender":"M",
	 * "workerEmail":"ad3ef4@com","dId":1,"department":
	 * {"deptId":1,"deptName":"������"}}],"prePage":0,"nextPage":2,
	 * "isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,
	 * "hasNextPage":true,"navigatePages":5,"navigatepageNums":[1,2,3,4,5],"navigateFirstPage":1,"navigateLastPage":5,"lastPage":5,"firstPage":1}}}
	 * 
	 * 
	 */
	// 状态码100成功，失败200
	private int code;
	// 提示信息
	private String msg;

	// 用户要返回给浏览器的数据
	private Map<String, Object> extend = new HashMap<String, Object>();

	public static MSG success() {
		MSG result = new MSG();
		result.setCode(100);
		result.setMsg("处理成功");
		return result;
	}

	public static MSG fail() {
		MSG result = new MSG();
		result.setCode(200);
		result.setMsg("处理失败");
		return result;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getExtend() {
		return extend;
	}

	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}

	public MSG add(String key, Object value) {
		 this.getExtend().put(key, value);
		 return this;
	}

}
