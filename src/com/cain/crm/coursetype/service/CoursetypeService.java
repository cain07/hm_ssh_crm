package com.cain.crm.coursetype.service;

import java.util.List;

import com.cain.crm.coursetype.domain.CrmCourseType;
import com.cain.crm.page.PageBean;

public interface CoursetypeService {

	public List<CrmCourseType> findAll();
	
	public List<CrmCourseType> findAll(CrmCourseType crmCourseType);
	
	public CrmCourseType findById(String courseTypeId);
	
	public void saveOrUpdate(CrmCourseType courseType);

	public PageBean<CrmCourseType> findAll(CrmCourseType courseType, int pageNum,
			int pageSize);
}
