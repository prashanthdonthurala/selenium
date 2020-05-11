package com.myntra.stepdeffile;

import com.myntra.generic.BaseClass;
import com.myntra.pom.HomeObjects;

import cucumber.api.java.en.Then;

public class Tc_Men_002 extends BaseClass {
	HomeObjects h;
	@Then("^perform on men and click on topwear$")
	public void perform_on_men_and_click_on_topwear() throws Throwable {
		h = new HomeObjects(driver);
		h.profile();
		h.men();
		h.clickTopWear();
	}

}
