package com.myntra.stepdeffile;

import org.testng.Assert;

import com.myntra.generic.BaseClass;
import com.myntra.pom.HomeObjects;
import com.myntra.pom.LoginObjects;
import com.myntra.pom.MyntraCreditObjects;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Tc_Mc_001 extends BaseClass{
	
	HomeObjects h;
	LoginObjects l;
	MyntraCreditObjects m;
	
	@Given("^user open chrome with url$")
	public void user_open_chrome_with_url() throws InterruptedException  {
	   BaseClass.openBrowser("chrome");
	}

	@When("^user enter username and password$")
	public void user_enter_username_and_password() throws Throwable {
		h = new HomeObjects(driver);
		h.profile();
		
		l = new LoginObjects(driver);
		l.loginsignup();
		
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

	@Then("^go to myntra credit$")
	public void go_to_myntra_credit() throws InterruptedException {

		h = new HomeObjects(driver);
		h.profile();
		
		
		m = new MyntraCreditObjects(driver);
		m.myntracreditbtn();
		 Thread.sleep(5000);
		    String actual = driver.getTitle();
		    System.out.println(actual);
		    String exp = "Myntra Credit";
		    Assert.assertEquals(actual, exp);
	}

	@Then("^close browser$")
	public void close_browser()  {
	    BaseClass.closeBrowser();
	}

}
