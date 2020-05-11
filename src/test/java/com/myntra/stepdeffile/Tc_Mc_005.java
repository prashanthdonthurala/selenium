package com.myntra.stepdeffile;

import org.testng.Assert;

import com.myntra.generic.BaseClass;
import com.myntra.pom.HomeObjects;
import com.myntra.pom.LoginObjects;
import com.myntra.pom.MyntraCreditObjects;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Tc_Mc_005 extends BaseClass{
	HomeObjects h;
	MyntraCreditObjects m;
	LoginObjects l;
	@Given("^user with the browser url$")
	public void user_with_the_browser_url() throws Throwable {
		BaseClass.openBrowser("chrome");
	}

	@When("^enters the login values$")
	public void enters_the_login_values() throws Throwable {
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

	@Then("^goto the myntracredit and click on t&c$")
	public void goto_the_myntracredit_and_click_on_t_c() throws Throwable {
		h = new HomeObjects(driver);
		h.profile();
		m = new MyntraCreditObjects(driver);
		m.myntracreditbtn();
		m.tclink();
		Thread.sleep(5000);
	    String actual = driver.getTitle();
	    System.out.println(actual);
	    String exp = "T&C";
	    Assert.assertEquals(actual, exp);
	}

	@Then("^closes browsr$")
	public void closes_browsr() throws Throwable {
		BaseClass.closeBrowser();
}

}