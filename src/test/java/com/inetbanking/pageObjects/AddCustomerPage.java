package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(how = How.LINK_TEXT, using = "New Customer")
	@CacheLookup
	WebElement lnkAddNewCustomer;

	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement txtCustomerName;

	@FindBy(how = How.NAME, using = "rad1")
	@CacheLookup
	WebElement rbGender;

	@FindBy(how = How.NAME, using = "dob")
	@CacheLookup
	WebElement txtdob;

	@FindBy(how = How.NAME, using = "addr")
	@CacheLookup
	WebElement txtAddress;

	@FindBy(how = How.NAME, using = "city")
	@CacheLookup
	WebElement txtCity;

	@FindBy(how = How.NAME, using = "state")
	@CacheLookup
	WebElement txtState;

	@FindBy(how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement txtPinNo;

	@FindBy(how = How.NAME, using = "telephoneno")
	@CacheLookup
	WebElement txtTelephoneNo;

	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement txtEmailID;

	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(how = How.NAME, using = "sub")
	@CacheLookup
	WebElement btnsubmit;

	public void clickAddNewCustomer() {
		lnkAddNewCustomer.click();
	}

	public void custName(String name) {
		txtCustomerName.sendKeys(name);
	}

	public void custGender(String gender) {
		rbGender.click();
	}

	public void custdob(String mm, String dd, String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}

	public void custAddress(String address) {
		txtAddress.sendKeys(address);
	}

	public void custCity(String city) {
		txtCity.sendKeys(city);
	}

	public void custState(String state) {
		txtState.sendKeys(state);
	}

	public void custPinNo(String pinNo) {
		txtPinNo.sendKeys(String.valueOf(pinNo));
	}

	public void custtelephoneNo(String telephoneno) {
		txtTelephoneNo.sendKeys(telephoneno);
	}

	public void custEmailID(String emailID) {
		txtEmailID.sendKeys(emailID);
	}

	public void custPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void custSubmit() {
		btnsubmit.click();
	}

}
