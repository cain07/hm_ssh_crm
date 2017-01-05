package com.cain.crm.coursetype.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cain.crm.coursetype.dao.CourseTypeDao;
import com.cain.crm.coursetype.domain.CrmCourseType;
import com.cain.crm.page.PageHibernateCallback;

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

	@Override
	public CrmCourseType findById(String courseTypeId) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(CrmCourseType.class, courseTypeId);
	}
	
	@Override
	public void saveOrUpdate(CrmCourseType courseType) {
		// TODO Auto-generated method stub
		System.out.println("CourseTypeDaoImpl"+courseType.toString());
		 this.getHibernateTemplate().saveOrUpdate(courseType);
	}

	@Override
	public int getTotalRecord(String condition, Object[] params) {
		// TODO Auto-generated method stub
		String hql = "select count(c) from CrmCourseType c where 1=1"+condition;
		List<Long>  cList = this.getHibernateTemplate().find(hql,params);
		return cList.get(0).intValue();
	}

	@Override
	public List<CrmCourseType> findAll(String condition,
			Object[] params, int startIndex, int pageSize) {
		// TODO Auto-generated method stub
		String hql = "from CrmCourseType where 1=1 " + condition;
		return this.getHibernateTemplate().execute(new PageHibernateCallback<CrmCourseType>()
				.setHql(hql).setPageSize(pageSize).setStartIndex(startIndex).setParams(params));
	}

}
