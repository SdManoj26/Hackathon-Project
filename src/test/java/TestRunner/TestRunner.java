package TestRunner;
 

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@Test
@CucumberOptions

	(features = ".//Features/hackathon.feature" ,

	glue = {"Hooks", "StepsDefinition"},

	plugin = {"pretty", "html:Reports/Cucumber/cucumberReport.html",

			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}	

	)

public class TestRunner extends AbstractTestNGCucumberTests {
 
}