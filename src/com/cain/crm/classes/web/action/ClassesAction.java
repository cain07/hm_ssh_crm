package com.cain.crm.classes.web.action;

import java.util.List;

import com.cain.crm.base.BaseAction;
import com.cain.crm.classes.domain.CrmClasses;

public class ClassesAction extends BaseAction<CrmClasses>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String findAll(){
		List<CrmClasses> classes = this.getClassesService().findAll();
		this.put("classes", classes);
		return "findAll";
	}
}
