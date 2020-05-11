package com.myntra.stepdeffile;

import org.testng.Assert;

import com.myntra.generic.BaseClass;
import com.myntra.pom.HomeObjects;
import com.myntra.pom.LoginObjects;
import com.myntra.pom.MyntraCreditObjects;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Tc_Mc_006 extends BaseClass {
	HomeObjects h;
	MyntraCreditObjects m;
	LoginObjects l;
	@Given("^user url browser$")
	public void user_url_browser() throws Throwable {
		BaseClass.openBrowser("chrome");
	}

	@When("^filling login values$")
	public void filling_login_values() throws Throwable {
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
	@Then("^gto myntra credit page and click on faq link$")
	public void gto_myntra_credit_page_and_click_on_faq_link() throws Throwable {
		h = new HomeObjects(driver);
		h.profile();
		m = new MyntraCreditObjects(driver);
		m.myntracreditbtn();
		m.faqlink();
		Thread.sleep(5000);
	    String actual = driver.getTitle();
	    System.out.println(actual);
	    String exp = "FAQS";
	    Assert.assertEquals(actual, exp);
	}

	@Then("^clos broser$")
	public void clos_broser() throws Throwable {
		BaseClass.closeBrowser();
}
}