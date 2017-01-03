package com.cain.crm.post.service;

import java.util.List;

import com.cain.crm.department.domain.CrmDepartment;
import com.cain.crm.post.domain.CrmPost;

public interface PostService {

	public List<CrmPost> findAll(CrmDepartment department);
}
