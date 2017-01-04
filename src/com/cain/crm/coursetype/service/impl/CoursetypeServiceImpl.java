package com.cain.crm.coursetype.service.impl;

import java.util.List;

import com.cain.crm.coursetype.dao.CourseTypeDao;
import com.cain.crm.coursetype.domain.CrmCourseType;
import com.cain.crm.coursetype.service.CoursetypeService;

public class CoursetypeServiceImpl implements CoursetypeService{

	private CourseTypeDao courseTypeDao;
	public void setCourseTypeDao(CourseTypeDao courseTypeDao) {
		this.courseTypeDao = courseTypeDao;
	}
	
	@Override
	public List<CrmCourseType> findAll() {
		// TODO Auto-generated method stub
		return courseTypeDao.findAll();
	}

}
