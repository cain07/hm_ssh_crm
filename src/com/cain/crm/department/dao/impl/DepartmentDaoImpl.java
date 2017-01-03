package com.cain.crm.department.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cain.crm.department.dao.DepartmentDao;
import com.cain.crm.department.domain.CrmDepartment;

public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

	@Override
	public List<CrmDepartment> findAll() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from CrmDepartment");
	}

}
