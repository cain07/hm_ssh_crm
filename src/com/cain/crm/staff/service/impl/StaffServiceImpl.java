package com.cain.crm.staff.service.impl;

import com.cain.crm.staff.dao.StaffDao;
import com.cain.crm.staff.domain.CrmStaff;
import com.cain.crm.staff.service.StaffServic;

public class StaffServiceImpl implements StaffServic {

	private StaffDao staffDao;
	
	@Override
	public CrmStaff login(CrmStaff crmStaff) {
		// TODO Auto-generated method stub
		return staffDao.find(crmStaff.getLoginName(), crmStaff.getLoginPwd());
	}

	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}

}
