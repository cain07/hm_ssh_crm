package com.cain.crm.staff.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cain.crm.staff.dao.StaffDao;
import com.cain.crm.staff.domain.CrmStaff;

public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao{

	@Override
	public CrmStaff find(String username, String password) {
		// TODO Auto-generated method stub
		List<CrmStaff> staffs = this.getHibernateTemplate().find("from crmStaff where loginName = ? and loginPwd = ? ", username,password);
		if (staffs.size() > 0) {
			return staffs.get(0);
		}
		return null;
	}

}
