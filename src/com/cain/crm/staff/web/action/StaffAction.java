package com.cain.crm.staff.web.action;

import java.util.List;

import com.cain.crm.base.BaseAction;
import com.cain.crm.department.domain.CrmDepartment;
import com.cain.crm.staff.domain.CrmStaff;

public class StaffAction extends BaseAction<CrmStaff> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1076024806787086812L;


	public String login(){
		CrmStaff crmStaff = this.getStaffService().login(this.getModel());
		if (crmStaff != null) {
			//成功
			// 3.1 session作用域保存数据
			putSession("loginStaff", crmStaff);
			return "success";
		}
		this.addFieldError("", "用户名与密码不匹配");
		return "login";
	}
	
	public String findAllStaff(){
		List<CrmStaff> staffs = getStaffService().findAllStaff();
		put("allStaff", staffs);
		return "stafflist";
	}
	
	public String editUI(){
		CrmStaff crmStaff = this.getStaffService().findbyStaffId(this.getModel().getStaffId());
		push(crmStaff);
		
		//2 查询所有部门
		List<CrmDepartment> allDepartment = getDepartmentService().findAll();
		// * jsp页面通过“key”获得
		set("allDepartment",allDepartment);
		
		return "editUI";
	}
	
	/**
	 * 显示首页
	 * @return
	 */
	public String home(){
		return "home";
	}

	
	public String edit(){
		getStaffService().updateStaff(this.getModel());
		return "edit";
	}
	


}
