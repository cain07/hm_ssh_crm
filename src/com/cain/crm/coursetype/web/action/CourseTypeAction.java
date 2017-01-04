package com.cain.crm.coursetype.web.action;

import java.util.List;

import com.cain.crm.coursetype.domain.CrmCourseType;
import com.cain.crm.coursetype.service.CoursetypeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CourseTypeAction extends ActionSupport implements ModelDriven<CrmCourseType>{

	private CrmCourseType courseType = new CrmCourseType();
	
	private CoursetypeService coursetypeService;
	public void setCoursetypeService(CoursetypeService coursetypeService) {
		this.coursetypeService = coursetypeService;
	}
	
	@Override
	public CrmCourseType getModel() {
		// TODO Auto-generated method stub
		return courseType;
	}
	
	public String getAllCourseType(){
		List<CrmCourseType> courseTypes = coursetypeService.findAll(courseType);
		ActionContext.getContext().put("courseTypes", courseTypes);
		return "allCourseType";
	}

}
