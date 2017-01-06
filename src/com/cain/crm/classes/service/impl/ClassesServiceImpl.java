package com.cain.crm.classes.service.impl;

import java.util.List;

import com.cain.crm.classes.dao.ClassesDao;
import com.cain.crm.classes.domain.CrmClasses;
import com.cain.crm.classes.service.ClassesService;

public class ClassesServiceImpl implements ClassesService{

	private ClassesDao classesDao;
	public void setClassesDao(ClassesDao classesDao) {
		this.classesDao = classesDao;
	}
	
	@Override
	public List<CrmClasses> findAll() {
		// TODO Auto-generated method stub
		return  classesDao.findAll();
	}

}
