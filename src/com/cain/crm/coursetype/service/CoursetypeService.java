package com.cain.crm.coursetype.service;

import java.util.List;

import com.cain.crm.coursetype.domain.CrmCourseType;

public interface CoursetypeService {

	public List<CrmCourseType> findAll();
	
	public List<CrmCourseType> findAll(CrmCourseType crmCourseType);
	
	public CrmCourseType findById(String courseTypeId);
	
	public void saveOrUpdate(CrmCourseType courseType);
}
