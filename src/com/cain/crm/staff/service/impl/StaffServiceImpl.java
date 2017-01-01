package com.cain.crm.staff.service.impl;

import com.cain.crm.staff.dao.StaffDao;
import com.cain.crm.staff.domain.CrmStaff;
import com.cain.crm.staff.service.StaffService;
import com.cain.crm.utils.MyStringUtils;

public class StaffServiceImpl implements StaffService {

	private StaffDao staffDao;
	
	@Override
	public CrmStaff login(CrmStaff crmStaff) {
		// TODO Auto-generated method stub
		String LoginPwd = MyStringUtils.getMD5Value(crmStaff.getLoginPwd());
		return staffDao.find(crmStaff.getLoginName(), LoginPwd);
	}

	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}

}
