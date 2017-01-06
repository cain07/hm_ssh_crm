package com.cain.crm.coursetype.web.action;


import org.apache.commons.lang3.StringUtils;

import com.cain.crm.base.BaseAction;
import com.cain.crm.coursetype.domain.CrmCourseType;
import com.cain.crm.page.PageBean;

public class CourseTypeAction extends BaseAction<CrmCourseType> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int pageNum = 1;
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	private int pageSize = 2;
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public String getAllCourseType(){
		//List<CrmCourseType> courseTypes = coursetypeService.findAll(courseType);
		PageBean<CrmCourseType>  pageBean = this.getCoursetypeService().findAll(this.getModel(),pageNum,pageSize);
		put("pageBean", pageBean);
		return "allCourseType";
	}
	
	public String editUI(){
		if (StringUtils.isNotBlank(this.getModel().getCourseTypeId())) {
			CrmCourseType findCourseType = getCoursetypeService().findById(this.getModel().getCourseTypeId());
			push(findCourseType);
		}
		return "editUI";
	}
	
	public String addOrEdit(){
		System.out.println(this.getModel().toString());
		getCoursetypeService().saveOrUpdate(this.getModel());
		return "addOrEdit";
	}

}
