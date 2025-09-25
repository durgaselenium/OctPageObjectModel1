package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.CSVUtils;
import com.qa.opencart.utils.ExcelUtil;
import com.qa.opencart.utils.StringUtils;

public class RegisterPageTest extends BaseTest{

 //BT(chrome+login url) --> BC(move to register page) --> @Test
	
	@BeforeClass
	public void goToRegisterPage() {
	registerPage = loginPage.navigateToRegisterPage();	
	}
	
	public Object[][] getRegData(){
		return new Object[][] {
			{"raghava","automation","987878787777","raghava@123","yes"},
			{"anuradha","shaha","987878787766","anuradha@123","no"},
			{"vishu","automation","987878787755","vishu@123","yes"},
		};
	}
	
	@DataProvider
	public Object[][] getRegSheetData(){
		return ExcelUtil.getTestData("register");
	}
	
	@DataProvider
	public Object[][] getRegCSVData(){
		return CSVUtils.csvData("register");
	}
	
	@Test(dataProvider = "getRegCSVData")
	public void registerTest(String firstName,String lastName,String telephone,String password,String subscribe) {
	Assert.assertTrue(registerPage.userRegister(firstName, lastName, StringUtils.getRandomEMail(), telephone, password, subscribe));
	}
	
}
