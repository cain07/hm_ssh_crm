package com.cain.crm.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cain.crm.classes.domain.CrmClasses;
import com.cain.crm.classes.service.ClassesService;
import com.cain.crm.coursetype.domain.CrmCourseType;
import com.cain.crm.coursetype.service.CoursetypeService;
import com.cain.crm.department.domain.CrmDepartment;
import com.cain.crm.department.service.DepartmentService;
import com.cain.crm.post.domain.CrmPost;
import com.cain.crm.post.service.PostService;
import com.cain.crm.staff.domain.CrmStaff;
import com.cain.crm.staff.service.StaffService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext.xml")
public class testApp {
	
	@Autowired
	private StaffService staffService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private CoursetypeService coursetypeService;
	
	@Autowired
	private ClassesService classesService;
	
	@Test
	public void test01() {
		List<CrmStaff> staffs = staffService.findAllStaff();
		System.out.println(staffs.toString());
	}
	
	@Test
	public void test02() {
		CrmStaff staff = new CrmStaff();
		staff.setLoginName("rose");
		staff.setLoginPwd("1234");
		
		CrmStaff staffs = staffService.login(staff);
		System.out.println(staffs.toString());
	}
	
	@Test
	public void test03() {
		CrmStaff staffs = staffService.findbyStaffId("2c9091c14c78e58b014c78e7ecd90034");
		System.out.println(staffs.toString());
	}
	
	@Test
	public void test04() {
		List<CrmDepartment> departments = departmentService.findAll();
		System.out.println(departments.toString());
	}
	
	@Test
	public void test05() {
		CrmDepartment department = new CrmDepartment();
		department.setDepId("2c9091c14c78e58b014c78e67de10001");
		department.setDepName("java学院");
		List<CrmPost> list = postService.findAll(department);
		System.out.println(list.toString());
	}
	
	@Test
	public void test06() {
		List<CrmCourseType> departments = coursetypeService.findAll();
		System.out.println(departments.toString());
	}
	
	@Test
	public void test07() {
		List<CrmClasses> departments = classesService.findAll();
		System.out.println(departments.toString());
	}
}
