package com.cain.crm.post.service.impl;

import java.util.List;

import com.cain.crm.department.domain.CrmDepartment;
import com.cain.crm.post.dao.PostDao;
import com.cain.crm.post.domain.CrmPost;
import com.cain.crm.post.service.PostService;

public class PostServiceImpl implements PostService{

	private PostDao postDao;
	
	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}
	
	@Override
	public List<CrmPost> findAll(CrmDepartment department) {
		// TODO Auto-generated method stub
		return postDao.findAll(department);
	}

	
}
