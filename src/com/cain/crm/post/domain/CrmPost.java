package com.cain.crm.post.domain;

import java.util.HashSet;
import java.util.Set;

import com.cain.crm.department.domain.CrmDepartment;
import com.cain.crm.staff.domain.CrmStaff;

/**
 * 职务
 * @author cain
 *
 */
public class CrmPost {
	/*
	 * CREATE TABLE `crm_post` (
	  `postId` varchar(255) NOT NULL PRIMARY KEY,
	  `postName` varchar(100) DEFAULT NULL,
	  `depId` varchar(255) DEFAULT NULL,
	  CONSTRAINT FOREIGN KEY (`depId`) REFERENCES `crm_department` (`depId`)
	);
	 */
	
	private String postId;
	private String postName;		//职务名称
	
	//多对一：多个职务 属性 【一个部门】
	private CrmDepartment department;
	
	//一对多： 一个职务 可以有 【多个员工】
	private Set<CrmStaff> staffSet = new HashSet<CrmStaff>();

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public CrmDepartment getDepartment() {
		return department;
	}

	public void setDepartment(CrmDepartment department) {
		this.department = department;
	}

	public Set<CrmStaff> getStaffSet() {
		return staffSet;
	}

	public void setStaffSet(Set<CrmStaff> staffSet) {
		this.staffSet = staffSet;
	}
	
}
