package com.cain.crm.classes.service;

import java.util.List;

import com.cain.crm.classes.domain.CrmClasses;

public interface ClassesService {

	public List<CrmClasses> findAll();
	
	public CrmClasses findById(String id);

	public void updateUpload(CrmClasses model);


}
