package com.cain.crm.post.dao;

import java.util.List;

import com.cain.crm.base.BaseDao;
import com.cain.crm.department.domain.CrmDepartment;
import com.cain.crm.post.domain.CrmPost;


public interface PostDao extends BaseDao<CrmPost>{
	
	/**
	 * 查询指定部门的所有职务
	 * @param department
	 * @return
	 */
	public List<CrmPost> findAll(CrmDepartment department);


}
