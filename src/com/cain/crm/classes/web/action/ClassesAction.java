package com.cain.crm.classes.web.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.cain.crm.base.BaseAction;
import com.cain.crm.classes.domain.CrmClasses;
import com.cain.crm.utils.MyStringUtils;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

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
	
	public String editUI(){
		CrmClasses classes = this.getClassesService().findById(this.getModel().getClassId());
		this.push(classes);
		return "editUI";
	}
	
	private File schedule;				//上传内容
	private String scheduleFileName;	//上传文件名
	private String scheduleContentType;	//上传类型
	public void setSchedule(File schedule) {
		this.schedule = schedule;
	}
	public void setScheduleFileName(String scheduleFileName) {
		this.scheduleFileName = scheduleFileName;
	}
	public void setScheduleContentType(String scheduleContentType) {
		this.scheduleContentType = scheduleContentType;
	}
	/**
	 * 文件上传
	 * @return
	 * @throws IOException 
	 */
	@InputConfig(resultName="uploadInput")
	public String upload() throws IOException{
		
		//1 将课本 保存 硬盘  。
		// 1.1 位置：tomcat.../WEB-INF/upload/....
		String parentDir = ServletActionContext.getServletContext().getRealPath("/WEB-INF/upload");
		// 1.2 文件名 随机数，且没有扩展名
		String fileName = MyStringUtils.getUUID();
		// 1.3 保存
		FileUtils.copyFile(schedule, new File(parentDir,fileName));
		
		//2 更新
		this.getModel().setUploadTime(new Date());
		this.getModel().setUploadPath("/WEB-INF/upload/" + fileName);
		this.getModel().setUploadFilename(scheduleFileName);
		
		this.getClassesService().updateUpload(this.getModel());
		
		return "upload";
	}
}
