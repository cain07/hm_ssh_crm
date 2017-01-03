package com.cain.crm.staff.web.action;

import java.util.List;

import com.cain.crm.staff.domain.CrmStaff;
import com.cain.crm.staff.service.StaffService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StaffAction extends ActionSupport implements ModelDriven<CrmStaff> {

	private CrmStaff staff = new CrmStaff();

	@Override
	public CrmStaff getModel() {
		// TODO Auto-generated method stub
		return staff ;
	}
	
	private StaffService staffService;
	
	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}

	public String login(){
		CrmStaff crmStaff = staffService.login(staff);
		if (crmStaff != null) {
			//成功
			// 3.1 session作用域保存数据
			ActionContext.getContext().getSession().put("loginStaff", crmStaff);
			return "success";
		}
		this.addFieldError("", "用户名与密码不匹配");
		return "login";
	}
	
	public String findAllStaff(){
		List<CrmStaff> staffs = staffService.findAllStaff();
		ActionContext.getContext().put("allStaff", staffs);
		return "stafflist";
	}
	
	/**
	 * 显示首页
	 * @return
	 */
	public String home(){
		return "home";
	}


}
