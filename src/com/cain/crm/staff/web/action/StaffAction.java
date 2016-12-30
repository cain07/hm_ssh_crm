package com.cain.crm.staff.web.action;

import com.cain.crm.staff.domain.CrmStaff;
import com.cain.crm.staff.service.StaffServic;
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
	
	private StaffServic staffServic;
	
	public void setStaffServic(StaffServic staffServic) {
		this.staffServic = staffServic;
	}

	public String login(){
		CrmStaff crmStaff = staffServic.login(staff);
		if (crmStaff != null) {
			//成功
			// 3.1 session作用域保存数据
			ActionContext.getContext().getSession().put("loginStaff", crmStaff);
			return "success";
		}
		this.addFieldError("", "用户名与密码不匹配");
		return "login";
	}
	
	/**
	 * 显示首页
	 * @return
	 */
	public String home(){
		return "home";
	}


}
