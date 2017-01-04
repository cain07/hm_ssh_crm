package com.cain.crm.post.web.action;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;

import com.cain.crm.post.domain.CrmPost;
import com.cain.crm.post.service.PostService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PostAction extends ActionSupport implements ModelDriven<CrmPost>{

	private CrmPost post = new CrmPost();

	@Override
	public CrmPost getModel() {
		// TODO Auto-generated method stub
		return post ;
	}
	
	private PostService postService;
	
	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	
	public String findAllPostWithDepartment() throws IOException{
		List<CrmPost> crmPosts = postService.findAll(post.getDepartment());
		
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"department","staffSet"});
		String jsonString = JSONArray.fromObject(crmPosts,jsonConfig).toString();
		//3.1 响应中文乱码
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().print(jsonString);
		
		return "none";
	}
	

}
