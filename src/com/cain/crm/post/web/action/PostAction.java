package com.cain.crm.post.web.action;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;

import com.cain.crm.base.BaseAction;
import com.cain.crm.post.domain.CrmPost;

public class PostAction extends BaseAction<CrmPost>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8228668399933127622L;

	public String findAllPostWithDepartment() throws IOException{
		List<CrmPost> crmPosts = this.getPostService().findAll(this.getModel().getDepartment());
		
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"department","staffSet"});
		String jsonString = JSONArray.fromObject(crmPosts,jsonConfig).toString();
		//3.1 响应中文乱码
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().print(jsonString);
		
		return "none";
	}
	

}
