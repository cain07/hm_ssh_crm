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

	@Override
	public CrmClasses findById(String id) {
		// TODO Auto-generated method stub
		return classesDao.findById(id);
	}

	@Override
	public void updateUpload(CrmClasses model) {
		// TODO Auto-generated method stub
		//1先查询，2再更新。快照和一级缓存
		CrmClasses findClass = this.classesDao.findById(model.getClassId());
		findClass.setUploadFilename(model.getUploadFilename());
		findClass.setUploadPath(model.getUploadPath());
		findClass.setUploadTime(model.getUploadTime());
	}

	
}
