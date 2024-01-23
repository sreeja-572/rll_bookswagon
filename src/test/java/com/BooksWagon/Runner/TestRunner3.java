package com.BooksWagon.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="C:\\Users\\P SREEJA\\Downloads\\bookswagon\\bookswagonprojectrequest\\src\\test\\java\\com\\BooksWagon\\features\\RequestABook.feature",
						
				glue= {"com.BooksWagon.StepDefinition","com.BooksWagon.Page","com.BooksWagon.Utilities"},
				dryRun=false,
						plugin={"pretty",
								"html:target/myreport2.html",
								  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
								  "timeline:test-output-thread/"}
)
public class TestRunner3 extends AbstractTestNGCucumberTests {

	
	
}