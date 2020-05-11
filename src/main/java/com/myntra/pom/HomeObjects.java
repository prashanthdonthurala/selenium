package com.myntra.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myntra.generic.BaseClass;

public class HomeObjects extends BaseClass {
	Actions a;
	@FindBy(xpath="//div[@class='desktop-user']")
	WebElement pf;
	
	public void profile() {
		a = new Actions(driver);
		a.moveToElement(pf).perform();
	}
	
	public HomeObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//men
	@FindBy(xpath="//a[@class='desktop-main'][contains(text(),'Men')]")
	WebElement menbtn;
	
	public void men() {
		a=new Actions(driver);
		a.moveToElement(menbtn).perform();
	}
	
	//topwear link
	@FindBy(xpath="//a[contains(text(),'Topwear')]")
	WebElement topwear;
	
	public void clickTopWear() {
		topwear.click();
	}
	
	//suits link
	@FindBy(xpath="//div[@class='desktop-navLinks']//div[1]//div[1]//div[1]//div[1]//div[1]//li[1]//ul[1]//li[9]//a[1]")
	WebElement suite;
	
	public void suitelink() {
		suite.click();
	}
	//bag icon
	@FindBy(xpath="//span[text()='Bag']")
	WebElement bagicon;
	
	public void bag() {
		bagicon.click();
	}
}
