package com.myntra.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressObjects {
	
	public AddressObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//click on place order
	@FindBy(xpath="//div[text()='Place Order']")
	WebElement buy;
	
	public void placeOrder() {
		buy.click();
	}
	
	//click on continue button
	@FindBy(xpath="//div[@id='placeOrderButton']")
	WebElement address;
	
	public void selectAddress() {
		address.click();
	}
}
