package com.cain.crm.staff.dao;

import java.util.List;

import com.cain.crm.staff.domain.CrmStaff;

public interface StaffDao {

	public CrmStaff find(String username,String password);
	
	public List<CrmStaff> findAllStaff();
}
