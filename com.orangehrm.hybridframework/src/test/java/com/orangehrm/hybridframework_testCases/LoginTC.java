package com.orangehrm.hybridframework_testCases;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.hybridframework_pageObject.LoginPage;
import com.orangehrm.hybridframework_testBase.TestBase;

public class LoginTC extends TestBase {
	
	
//	@Test
//	public void loginToOrangeHrm() throws InterruptedException   {
//		//System.out.println("loginToOrangeHrm Test Case");
//		LoginPage lp = new LoginPage(driver);
//		
//		lp.setUserName("Admin");
//		lp.setPassword("admin123");
//		lp.clickOnLoginBtn();
//		
//		if(driver.findElement(By.xpath("//a[@id='menu_dashboard_index']")).isDisplayed()) {
//			Assert.assertTrue(true);
//		}
//		
//		else {
//			Assert.assertTrue(false, "Dashboard page title not contains Orange text");
//		}
//		
//		
//				
//		}
//
//}
	
	
	
	
	
	@Test
	public void loginToOrangeHrmTC002()    {
		//System.out.println("loginToOrangeHrm Test Case");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(configDataProvider.getUsername());
		lp.setPassword(configDataProvider.getpwd());
		
		//lp.setUserName(configDataProvider.getKeyValue("username"));
		//lp.setPassword(configDataProvider.getKeyValue("password"));
		
		lp.clickOnLoginBtn();
		
		if (driver.getPageSource().contains("Dashboard")) {
		extentTest	= extentReport.createTest("Login Test");
		
			Assert.assertTrue(true);
			extentTest.info("Login success with given tset data");
		}
		
		else if(driver.getPageSource().contains("LOGIN Panel")) {
			
			extentTest	= extentReport.createTest("Login Test");

			String invalidCredentials=driver.findElement(By.xpath("//span[text()='Invalid credentials']")).getText();
			extentTest.info("Login failed with given tset data");
			Assert.assertTrue(false, invalidCredentials);
		}
	}
}
	
	
	
	
