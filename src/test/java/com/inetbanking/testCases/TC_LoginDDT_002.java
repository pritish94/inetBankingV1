package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilites.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException {

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("user name provided");
		lp.setPassword(pwd);
		logger.info("password provided");
        lp.clickSubmit();
		Thread.sleep(3000);

		if (isAlertPresent()) {
			driver.switchTo().alert().accept(); // close alert
			driver.switchTo().defaultContent();
			logger.warn("Login failed");
			Assert.assertTrue(false);
			
		} else {
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept(); // close logout alert
			driver.switchTo().defaultContent();

		}

	}

	public boolean isAlertPresent() { // user defined method created to check alert is present or not
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {

		String path = System.getProperty("user.dir") + "/src/test/java/com/inetbanking/testData/LoginData.xlsx";

		int rowCount = XLUtils.getRowCount(path, "Sheet1");
		int cellCount = XLUtils.getCellCount(path, "Sheet1", 1);

		String[][] loginData = new String[rowCount][cellCount];

		for (int i = 1; i <= rowCount; i++) {

			for (int j = 0; j < cellCount; j++) {
				loginData[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return loginData;
	}

}
