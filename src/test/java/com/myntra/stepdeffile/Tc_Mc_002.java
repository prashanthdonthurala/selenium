package com.myntra.stepdeffile;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;

import com.myntra.generic.BaseClass;
import com.myntra.pom.HomeObjects;
import com.myntra.pom.LoginObjects;
import com.myntra.pom.MyntraCreditObjects;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Tc_Mc_002 extends BaseClass {
	
	HomeObjects h;
	LoginObjects l;
	MyntraCreditObjects m;
	
	@Given("^user url$")
	public void user_url() throws InterruptedException  {
		BaseClass.openBrowser("chrome");
	}

	@When("^enter un and pwd$")
	public void enter_un_and_pwd() throws InterruptedException, EncryptedDocumentException, IOException {
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

	@Then("^goto myntracredit link$")
	public void goto_myntracredit_link()  {
		h = new HomeObjects(driver);
		h.profile();

		m = new MyntraCreditObjects(driver);
		m.myntracreditbtn();
	}

	@Then("^click on topup$")
	public void click_on_topup() throws InterruptedException  {
		m.topup();
		Thread.sleep(5000);
	    String actual = driver.getTitle();
	    System.out.println(actual);
	    String exp = "Myntra Credit Top-up";
	    Assert.assertEquals(actual, exp);
	}

	@Then("^close it$")
	public void close_it() {
		BaseClass.closeBrowser();
	}
}
