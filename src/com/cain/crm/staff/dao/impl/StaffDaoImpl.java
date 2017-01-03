package com.cain.crm.staff.dao.impl;

import java.util.List;
import javax.persistence.criteria.From;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cain.crm.staff.dao.StaffDao;
import com.cain.crm.staff.domain.CrmStaff;

public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao{

	@SuppressWarnings("unchecked")
	@Override
	public CrmStaff find(String username, String password) {
		// TODO Auto-generated method stub
		List<CrmStaff> staffs = this.getHibernateTemplate().find("from CrmStaff where loginName = ? and loginPwd = ? ", username,password);
		if (staffs.size() > 0) {                                
			return staffs.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CrmStaff> findAllStaff() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from CrmStaff");
	}

	@Override
	public CrmStaff findByStaffId(String StaffId) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(CrmStaff.class, StaffId);
	}

}
