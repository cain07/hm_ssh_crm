package com.cain.crm.staff.service.impl;

import java.util.List;

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

	@Override
	public List<CrmStaff> findAllStaff() {
		// TODO Auto-generated method stub
		return staffDao.findAllStaff();
	}

	@Override
	public CrmStaff findbyStaffId(String staffId) {
		// TODO Auto-generated method stub
		return staffDao.findByStaffId(staffId);
	}

	@Override
	public void updateStaff(CrmStaff staff) {
		// TODO Auto-generated method stub
		CrmStaff findByStaffId = staffDao.findByStaffId(staff.getStaffId());
		findByStaffId.setGender(staff.getGender());
		findByStaffId.setLoginName(staff.getLoginName());
		if (!findByStaffId.getLoginPwd().equals(staff.getLoginPwd())) {
			findByStaffId.setLoginPwd(staff.getLoginPwd());
		}
		
		findByStaffId.setOnDutyDate(staff.getOnDutyDate());
		findByStaffId.setStaffName(staff.getStaffName());
		findByStaffId.setPost(staff.getPost());
	}

}
