package com.cain.crm.coursetype.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;


import com.cain.crm.coursetype.dao.CourseTypeDao;
import com.cain.crm.coursetype.domain.CrmCourseType;
import com.cain.crm.coursetype.service.CoursetypeService;
import com.cain.crm.page.PageBean;

public class CoursetypeServiceImpl implements CoursetypeService {

	private CourseTypeDao courseTypeDao;

	public void setCourseTypeDao(CourseTypeDao courseTypeDao) {
		this.courseTypeDao = courseTypeDao;
	}

	@Override
	public List<CrmCourseType> findAll() {
		// TODO Auto-generated method stub
		return courseTypeDao.findAll();
	}

	@Override
	public List<CrmCourseType> findAll(CrmCourseType courseType) {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		// 1.2 拼凑实际参数 , 可以重复，顺序 --> List
		List<Object> paramsList = new ArrayList<Object>();

		// 2 过滤条件
		// 2.1 课程类别
		if (StringUtils.isNotBlank(courseType.getCourseName())) {
			builder.append(" and courseName like ?");
			paramsList.add("%" + courseType.getCourseName() + "%");
		}
		// 2.2 课程简介
		if (StringUtils.isNotBlank(courseType.getRemark())) {
			builder.append(" and remark like ?");
			paramsList.add("%" + courseType.getRemark() + "%");
		}
		// 2.3 总学时：
		if (StringUtils.isNotBlank(courseType.getTotalStart())) {
			builder.append(" and total >= ?");
			paramsList.add(Integer.parseInt(courseType.getTotalStart()));
		}
		if (StringUtils.isNotBlank(courseType.getTotalEnd())) {
			builder.append(" and total <= ?");
			paramsList.add(Integer.parseInt(courseType.getTotalEnd()));
		}
		// 2.4课程费用
		if (StringUtils.isNotBlank(courseType.getCourseCostStart())) {
			builder.append(" and courseCost >= ?");
			paramsList.add(Double.parseDouble(courseType.getCourseCostStart()));
		}
		if (StringUtils.isNotBlank(courseType.getCourseCostEnd())) {
			builder.append(" and courseCost <= ?");
			paramsList.add(Double.parseDouble(courseType.getCourseCostEnd()));
		}

		// 3 使用
		// 条件 , 格式：" and ..? and ..."
		String condition = builder.toString();
		// 实际参数
		Object[] params = paramsList.toArray();
		
		//System.out.println(condition);
		//System.out.println(params.toString());
		return courseTypeDao.findAll(condition, params);
	}

	@Override
	public CrmCourseType findById(String courseTypeId) {
		// TODO Auto-generated method stub
		return this.courseTypeDao.findById(courseTypeId);
	}

	@Override
	public void saveOrUpdate(CrmCourseType courseType) {
		// TODO Auto-generated method stub
		System.out.println("CoursetypeServiceImpl"+courseType.toString());
		this.courseTypeDao.saveOrUpdate(courseType);
	}
	
	@Override
	public PageBean<CrmCourseType> findAll(CrmCourseType courseType,int pageNum,int pageSize) {
		
		// TODO Auto-generated method stub
				StringBuilder builder = new StringBuilder();
				// 1.2 拼凑实际参数 , 可以重复，顺序 --> List
				List<Object> paramsList = new ArrayList<Object>();

				// 2 过滤条件
				// 2.1 课程类别
				if (StringUtils.isNotBlank(courseType.getCourseName())) {
					builder.append(" and courseName like ?");
					paramsList.add("%" + courseType.getCourseName() + "%");
				}
				// 2.2 课程简介
				if (StringUtils.isNotBlank(courseType.getRemark())) {
					builder.append(" and remark like ?");
					paramsList.add("%" + courseType.getRemark() + "%");
				}
				// 2.3 总学时：
				if (StringUtils.isNotBlank(courseType.getTotalStart())) {
					builder.append(" and total >= ?");
					paramsList.add(Integer.parseInt(courseType.getTotalStart()));
				}
				if (StringUtils.isNotBlank(courseType.getTotalEnd())) {
					builder.append(" and total <= ?");
					paramsList.add(Integer.parseInt(courseType.getTotalEnd()));
				}
				// 2.4课程费用
				if (StringUtils.isNotBlank(courseType.getCourseCostStart())) {
					builder.append(" and courseCost >= ?");
					paramsList.add(Double.parseDouble(courseType.getCourseCostStart()));
				}
				if (StringUtils.isNotBlank(courseType.getCourseCostEnd())) {
					builder.append(" and courseCost <= ?");
					paramsList.add(Double.parseDouble(courseType.getCourseCostEnd()));
				}
				
		// 3 使用
		// 条件 , 格式：" and ..? and ..."
		String condition = builder.toString();
		// 实际参数
		Object[] params = paramsList.toArray();
		
		int totalRecord = this.courseTypeDao.getTotalRecord(condition,params);	
		PageBean<CrmCourseType> pageBean = new PageBean<CrmCourseType>(pageNum, pageSize, totalRecord);
		List<CrmCourseType> crmCourseTypes = this.courseTypeDao.findAll(condition,params,pageBean.getStartIndex(),pageBean.getPageSize());		
		
		pageBean.setData(crmCourseTypes);
		return pageBean;
	}

}
