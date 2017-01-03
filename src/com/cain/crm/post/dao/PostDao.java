package com.cain.crm.post.dao;

import java.util.List;

import com.cain.crm.department.domain.CrmDepartment;
import com.cain.crm.post.domain.CrmPost;


public interface PostDao {

	public List<CrmPost> findAll(CrmDepartment department);
}
