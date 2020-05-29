package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {

		LoginPage lp = new LoginPage(driver);

		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Password is provided");
		lp.clickSubmit();

		Thread.sleep(3000);

		AddCustomerPage addcust = new AddCustomerPage(driver);

		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("scroll(0,400)");

		addcust.clickAddNewCustomer();
		logger.info("providing customer details...");
		addcust.custName("Pritish");
		addcust.custGender("male");
		addcust.custdob("15", "o6", "1995");

		Thread.sleep(5000);

		addcust.custAddress("INDIA");
		addcust.custCity("Banglore");
		addcust.custState("Karnataka");
		addcust.custPinNo("560017");
		addcust.custtelephoneNo("8018195139");
		addcust.custEmailID(randomeString() + "@gmail.com");
		addcust.custPassword("abcdef");
		addcust.custSubmit();

		Thread.sleep(3000);

		logger.info("validation started...");

		if (driver.getPageSource().contains("Customer Registered Successfully!!!")) {
			logger.info("test case passed...");
			Assert.assertTrue(true);
		} else {
			captureScreen(driver, "addNewCustomer");
			logger.warn("test case failed...");
			Assert.assertTrue(false);
		}

	}

}
