package com.cain.crm.department.dao;

import java.util.List;

import com.cain.crm.department.domain.CrmDepartment;

public interface DepartmentDao {

	public List<CrmDepartment> findAll();
}
