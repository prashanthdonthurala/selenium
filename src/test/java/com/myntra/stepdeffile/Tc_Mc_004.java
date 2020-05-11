package com.myntra.stepdeffile;

import org.testng.Assert;

import com.myntra.generic.BaseClass;
import com.myntra.pom.HomeObjects;
import com.myntra.pom.LoginObjects;
import com.myntra.pom.MyntraCreditObjects;
import com.myntra.pom.MyntraCreditTopup;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Tc_Mc_004 extends BaseClass{
	
	HomeObjects h;
	MyntraCreditObjects m;
	MyntraCreditTopup mt;
	LoginObjects l;
	@Given("^users with url$")
	public void users_with_url() throws Throwable {
		BaseClass.openBrowser("chrome");
	}

	@When("^enters the details to login$")
	public void enters_the_details_to_login() throws Throwable {
		h = new HomeObjects(driver);
		h.profile();
		
		l = new LoginObjects(driver);
		l.loginsignup();
		
		System.out.println("login via baseclass done");
		l.phonenumber();
		l.continuee();
		l.otp();
		l.clearEnterNumer();
		
    	String email = getExcelData("F:\\loginurl.xlsx.xlsx", "Sheet1", 1, 0);
		System.out.println(email);
		l.enterNumber(email);
		
		String password = getExcelData("F:\\loginurl.xlsx.xlsx","Sheet1", 1, 1);
		l.password(password);
		Thread.sleep(2000);
		
		l.loginToMyntra();
	Thread.sleep(5000);
	}
	@Then("^click on the topup$")
	public void click_on_the_topup() throws Throwable {
		h = new HomeObjects(driver);
		h.profile();
		m = new MyntraCreditObjects(driver);
		m.myntracreditbtn();
		m.topup();
	}

	@Then("^enter amount and click on topup buttom$")
	public void enter_amount_and_click_on_topup_buttom() throws Throwable {
		mt = new MyntraCreditTopup(driver);
		mt.amount();
		mt.topUp();
		Thread.sleep(5000);
	    String actual = driver.getTitle();
	    System.out.println(actual);
	    String exp = "PAYMENT";
	    Assert.assertEquals(actual, exp);
	}

	@Then("^closing the browser$")
	public void closing_the_browser() throws Throwable {
		BaseClass.closeBrowser();
	}
}
