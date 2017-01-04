package com.cain.crm.coursetype.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cain.crm.coursetype.dao.CourseTypeDao;
import com.cain.crm.coursetype.domain.CrmCourseType;

public class CourseTypeDaoImpl extends HibernateDaoSupport implements CourseTypeDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<CrmCourseType> findAll() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from CrmCourseType");
	}

	@Override
	public List<CrmCourseType> findAll(String condition, Object[] param) {
		// TODO Auto-generated method stub
		String hql = "from CrmCourseType where 1=1 " + condition;
		return this.getHibernateTemplate().find(hql, param);
	}

}
