package com.myntra.stepdeffile;

import org.testng.Assert;

import com.myntra.generic.BaseClass;
import com.myntra.pom.AddressObjects;
import com.myntra.pom.HomeObjects;
import com.myntra.pom.LoginObjects;
import com.myntra.pom.MyPersonalCareObjects;
import com.myntra.pom.PaymentObjects;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EndToEnd2 extends BaseClass{
	HomeObjects h;
	LoginObjects l;
	MyPersonalCareObjects mp;
	AddressObjects ad;
	PaymentObjects p;
	@Given("^user browser and url$")
	public void user_browser_and_url() throws Throwable {
		BaseClass.openBrowser("chrome");
	}

	@When("^login$")
	public void login() throws Throwable {
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

	@Then("^go to men and click on personalcare$")
	public void go_to_men_and_click_on_personalcare() throws Throwable {
		h = new HomeObjects(driver);
		h.men();
		mp = new MyPersonalCareObjects(driver);
		mp.personalpage();
		mp.product();
	}

	@Then("^add item to bag$")
	public void add_item_to_bag() throws Throwable {
		mp.bag();
		Thread.sleep(2000);
		mp.size();
		
	}

	@Then("^goto bag$")
	public void goto_bag() throws Throwable {
		h = new HomeObjects(driver);
		h.bag();
	}

	@Then("^click on place order button$")
	public void click_on_place_order_button() throws Throwable {
		ad = new AddressObjects(driver);
		ad.placeOrder();
		ad.selectAddress();
		Thread.sleep(10000);
	}

	@Then("^enter cvv and click paynow$")
	public void enter_cvv_and_click_paynow() throws Throwable {
		p = new PaymentObjects(driver);
		String cvv = getExcelData1("F:\\loginurl.xlsx.xlsx","Sheet1", 1, 4);
		p.cvv(cvv);
		p.paynow();
		Thread.sleep(5000);
	    String actual = driver.getTitle();
	    System.out.println(actual);
	    String exp = "SBI ACS";
	    Assert.assertEquals(actual, exp);
	}

	@Then("^shut the browser(\\d+)$")
	public void shut_the_browser(int arg1) throws Throwable {
		BaseClass.closeBrowser();
	}

}
