package com.cain.crm.post.dao.impl;


import java.util.List;

import com.cain.crm.base.impl.BaseDaoImpl;
import com.cain.crm.department.domain.CrmDepartment;
import com.cain.crm.post.dao.PostDao;
import com.cain.crm.post.domain.CrmPost;

public class PostDaoImpl extends BaseDaoImpl<CrmPost> implements PostDao{

	@Override
	public List<CrmPost> findAll(CrmDepartment department) {
		return this.getHibernateTemplate().find("from CrmPost where department = ?", department);
	}

}
