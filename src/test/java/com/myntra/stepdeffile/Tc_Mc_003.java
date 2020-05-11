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

public class Tc_Mc_003 extends BaseClass {
	HomeObjects h;
	LoginObjects l;
	MyntraCreditObjects m;
	MyntraCreditTopup mt;
	@Given("^user open browser with url$")
	public void user_open_browser_with_url() throws Throwable {
		BaseClass.openBrowser("chrome");
	}

	@When("^enter login details$")
	public void enter_login_details() throws Throwable {
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

	@Then("^clicks on topup$")
	public void clicks_on_topup() throws Throwable {
		h = new HomeObjects(driver);
		h.profile();
		m = new MyntraCreditObjects(driver);
		m.myntracreditbtn();
		Thread.sleep(1000);
		m.topup();
	}

	@Then("^click on amount button$")
	public void click_on_amount_button() throws Throwable {
		mt = new MyntraCreditTopup(driver);
		mt.amount();
		Thread.sleep(5000);
	    String actual = driver.getTitle();
	    System.out.println(actual);
	    String exp = "Myntra Credit Top-up";
	    Assert.assertEquals(actual, exp);
	
	}

	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
		BaseClass.closeBrowser();
	}

}
