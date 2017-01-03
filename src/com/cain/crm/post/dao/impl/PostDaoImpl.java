package com.cain.crm.post.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cain.crm.department.domain.CrmDepartment;
import com.cain.crm.post.dao.PostDao;
import com.cain.crm.post.domain.CrmPost;

public class PostDaoImpl extends HibernateDaoSupport implements PostDao{

	@Override
	public List<CrmPost> findAll(CrmDepartment department) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from CrmPost where department = ?",department);
	}

}
