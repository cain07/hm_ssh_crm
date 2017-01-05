package com.cain.crm.coursetype.web.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.cain.crm.coursetype.domain.CrmCourseType;
import com.cain.crm.coursetype.service.CoursetypeService;
import com.cain.crm.page.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CourseTypeAction extends ActionSupport implements ModelDriven<CrmCourseType>{

	private CrmCourseType courseType = new CrmCourseType();
	
	private CoursetypeService coursetypeService;

	private int pageNum = 1;
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	private int pageSize = 2;
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setCoursetypeService(CoursetypeService coursetypeService) {
		this.coursetypeService = coursetypeService;
	}
	
	@Override
	public CrmCourseType getModel() {
		// TODO Auto-generated method stub
		return courseType;
	}
	
	public String getAllCourseType(){
		//List<CrmCourseType> courseTypes = coursetypeService.findAll(courseType);
		
		PageBean<CrmCourseType>  pageBean = coursetypeService.findAll(courseType,pageNum,pageSize);
		ActionContext.getContext().put("pageBean", pageBean);
		return "allCourseType";
	}
	
	public String editUI(){
		if (StringUtils.isNotBlank(courseType.getCourseTypeId())) {
			CrmCourseType findCourseType = coursetypeService.findById(courseType.getCourseTypeId());
			ActionContext.getContext().getValueStack().push(findCourseType);
		}
		return "editUI";
	}
	
	public String addOrEdit(){
		System.out.println(courseType.toString());
		coursetypeService.saveOrUpdate(courseType);
		return "addOrEdit";
	}

}
