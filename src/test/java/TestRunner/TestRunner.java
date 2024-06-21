package TestRunner;
 
import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@@RunWith(Cucumber.class)
@CucumberOptions

	(features = ".//Features/hackathon.feature" ,

	glue = {"Hooks", "StepsDefinition"},

	plugin = {"pretty", "html:Reports/Cucumber/cucumberReport.html",

			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}	

	)

public class TestRunner {
 
}
