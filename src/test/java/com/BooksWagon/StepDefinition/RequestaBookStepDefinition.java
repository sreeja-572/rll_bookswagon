package com.BooksWagon.StepDefinition;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.BooksWagon.Page.RequestABookPage;
import com.BooksWagon.Utilities.ExcelUtility;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RequestaBookStepDefinition {
	
	public static WebDriver driver;

	RequestABookPage rp;
	Logger logger = LogManager.getLogger(RequestaBookStepDefinition.class);

	Object[][] inputData;
	static int currentRow = 0;
	static int currentRow1 = 0;
	
	
	@Given("the URL of website")
	public void the_url_of_website() {
		// Initialize WebDriver
//    	System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");

		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		// Initialize LoginPage with the WebDriver
		rp = new RequestABookPage(driver);

		// Navigate to the URL
		rp.navigateToURL("https://www.bookswagon.com/");
	}

	
	@Then("click on my account")
	public void click_on_myaccount() {
		rp.MyAccount();
		 String expectedTitle = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
		  String actualTitle = driver.getTitle();
		  Assert.assertEquals(expectedTitle, actualTitle);
		   logger.info("clicked on my account");
	}

	@When("the User enter email as {string} on the login page")
	public void the_user_enter_email_as(String userEmail) throws EncryptedDocumentException, IOException {
		/*inputData = ExcelUtility.getTestData("Sheet1");
		String EmailId = (String) inputData[currentRow][0];*/
		rp.EnterEmail("9840766828");

	}


	@When("the User enter password as {string} on the login page")
	public void the_user_enter_password_as(String userPassword) throws EncryptedDocumentException, IOException {
		/*inputData = ExcelUtility.getTestData("Sheet1");
		String password = (String) inputData[currentRow][1];*/
		rp.EnterPassword("Book@123");

	}
	@And("the User clicks on the login button on the page")
	public void the_user_clicks_on_the_login_button() {
		rp.ClickOnLoginButton();
		   logger.info("login successful");

	}


	@When("The user clicks on Request a book Page")
	public void the_user_clicks_on_request_a_book_page() throws EncryptedDocumentException, IOException, InterruptedException {
		rp.click_RequestBook();
	   logger.info("Testing Request a Book Functionality");
	}

	@Then("enter the required data iSBN as {string} Title as {string} Author as {string}  Phone as {string}")
	public void enter_the_required_data_i_sbn_as_title_as_author_as_phone_as(String string, String string2, String string3, String string4) throws EncryptedDocumentException, IOException, InterruptedException {
	    rp = new RequestABookPage(driver);
	    inputData = ExcelUtility.getTestData("Sheet1");
		String isbn = (String) inputData[currentRow][0];
		   logger.info("enter isbn number");

		Thread.sleep(2000);
		String BookTitle = (String) inputData[currentRow][1];
		   logger.info("enter booktitle");

		Thread.sleep(2000);
		String Author = (String) inputData[currentRow][2];
		   logger.info("enter author name");

		Thread.sleep(2000);
		//String Id = (String) inputData[currentRow][3];

		String phone = (String) inputData[currentRow][3];
		   logger.info("enter phone number");

		Thread.sleep(2000);
	    rp.enter_details(isbn, BookTitle, Author, phone);
	    currentRow=currentRow+1;
	    
	}
	
	/*@And("click verify button")
	public void click_verify_button() {
		rp.click_verify();
	}*/

	@And("Click the submit button")
	public void click_the_submit_button() {
		   logger.info("click on submit button");

		rp.click_submit();
		
		
	}
	
	
		        
		

	@Then("request should be notify to them")
	public void request_should_be_notify_to_them() throws IOException{
		        
		
	

		  

		   logger.info("requested book successfully");

		
		String expected2 = "We have saved your requested books successfully into our system. We will intimate you as soon as book available.";
		String actual2 =rp.get_message();
		
				    
		    			Assert.assertEquals(actual2,expected2);


		        }
		 }
  
	        