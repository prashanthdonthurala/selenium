package com.myntra.stepdeffile;

import com.myntra.generic.BaseClass;
import com.myntra.pom.HomeObjects;
import com.myntra.pom.LoginObjects;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Tc_Men_001 extends BaseClass {
	HomeObjects h;
	LoginObjects l;
	
	@Given("^user requirements$")
	public void user_requirements() throws Throwable {
		BaseClass.openBrowser("chrome");
	}

	@When("^login user$")
	public void login_user() throws Throwable {
		h = new HomeObjects(driver);
		h.profile();
		l = new LoginObjects(driver);
		l.loginsignup();
		l.phonenumber();
		l.continuee();
		l.otp();
		l.clearEnterNumer();
		String email = getExcelData("F:\\loginurl.xlsx.xlsx", "Sheet1", 1, 0);
		l.enterNumber(email);
		
		String password = getExcelData("F:\\loginurl.xlsx.xlsx","Sheet1", 1, 1);
		l.password(password);
		Thread.sleep(2000);
		
		l.loginToMyntra();
	Thread.sleep(5000);
	}

	@Then("^perform on men$")
	public void perform_on_men() throws Throwable {
		h.men();
	}

	@Then("^close$")
	public void close() throws Throwable {
		BaseClass.closeBrowser();
	}

}
