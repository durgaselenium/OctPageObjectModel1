package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class SearchTest extends BaseTest{

// BT(chrome+url)-> BC(login) -> @Test	
	
@BeforeClass
 public void searchSetUp() {
accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));		
}

@Test
public void serchTest() {
 searchResultsPage = accPage.doSearch("macbook");
 productInfoPage = searchResultsPage.selectProduct("MacBook Pro");
 String actHeader =  productInfoPage.getProductHeader();
 Assert.assertEquals(actHeader, "MacBook Pro");
	
}
}
