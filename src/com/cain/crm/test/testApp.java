package com.cain.crm.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cain.crm.staff.domain.CrmStaff;
import com.cain.crm.staff.service.StaffService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext.xml")
public class testApp {
	
	@Autowired
	private StaffService staffService;
	
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
}
