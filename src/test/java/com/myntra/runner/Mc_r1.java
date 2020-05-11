package com.myntra.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = "./Featuresfile/myntra credit.feature", 
glue = { "com.myntra.stepdeffile" }, 
monochrome = true, 
dryRun = false, 
plugin = {"pretty:report/cucumber-htmlreport.text", 
		"json:report/cucumber-report.json",
		"html:report/cucumber-htmlreport" })

public class Mc_r1 extends AbstractTestNGCucumberTests {

}
