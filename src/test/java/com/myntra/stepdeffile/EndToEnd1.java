package com.myntra.stepdeffile;

import org.testng.Assert;

import com.myntra.generic.BaseClass;
import com.myntra.pom.HomeObjects;
import com.myntra.pom.LoginObjects;
import com.myntra.pom.MyntraCreditObjects;
import com.myntra.pom.MyntraCreditTopup;
import com.myntra.pom.PaymentObjects;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EndToEnd1 extends BaseClass {
	
	HomeObjects h;
	MyntraCreditObjects m;
	MyntraCreditTopup mt;
	PaymentObjects p;
	LoginObjects l;
	@Given("^user url and browser$")
	public void user_url_and_browser() throws Throwable {
		BaseClass.openBrowser("chrome");
	}

	@When("^goto login page$")
	public void goto_login_page() throws Throwable {
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

	@Then("^go to myntra credit page and click on topup$")
	public void go_to_myntra_credit_page_and_click_on_topup() throws Throwable {
		h = new HomeObjects(driver);
		h.profile();
		m = new MyntraCreditObjects(driver);
		m.myntracreditbtn();
		m.topup();
		
		
	}

	@Then("^select amount and click on topup button$")
	public void select_amount_and_click_on_topup_button() throws Throwable {
		mt = new MyntraCreditTopup(driver);
		mt.amount();
		mt.topUp();
		Thread.sleep(10000);
	}

	@Then("^enter cvv for saved card and click on paynow$")
	public void enter_cvv_for_saved_card_and_click_on_paynow() throws Throwable {
		p = new PaymentObjects(driver);
		String cvv = getExcelData1("F:\\loginurl.xlsx.xlsx","Sheet1", 1, 4);
		p.cvv(cvv);
		p.paynow();
		Thread.sleep(5000);
	    String actual = driver.getTitle();
	    System.out.println(actual);
	    String exp = "Payment Gateway India, Online Payment Gateway, PayUbiz India, Payment Gateway Solutions";
	    Assert.assertEquals(actual, exp);
	}

	@Then("^shut browser$")
	public void shut_browser() throws Throwable {
		BaseClass.closeBrowser();
	}


}
