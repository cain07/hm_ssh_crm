package com.cain.crm.coursetype.dao;

import java.util.List;

import com.cain.crm.coursetype.domain.CrmCourseType;

public interface CourseTypeDao {

	public List<CrmCourseType> findAll();
}
