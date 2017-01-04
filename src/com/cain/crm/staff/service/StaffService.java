package com.cain.crm.staff.service;

import java.util.List;

import com.cain.crm.staff.domain.CrmStaff;

public interface StaffService {

	public CrmStaff login(CrmStaff crmStaff);
	
	public List<CrmStaff> findAllStaff();
	
	public CrmStaff findbyStaffId(String staffId);

	public void updateStaff(CrmStaff staff);
}
