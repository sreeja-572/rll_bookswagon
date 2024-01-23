package com.BooksWagon.Page;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class RequestABookPage {

	public static WebDriver driver;

	
	@FindBy(xpath = "//span[@id='ctl00_lblUser']")
	WebElement myaccount;

	@FindBy(xpath = "//input[@id='ctl00_phBody_SignIn_txtEmail']")
	WebElement email;

	@FindBy(xpath = "//input[@id='ctl00_phBody_SignIn_txtPassword']")
	WebElement password;

	@FindBy(xpath = "//a[@id='ctl00_phBody_SignIn_btnLogin']")
	WebElement loginButton;

	@FindBy(linkText = "Request a Book")
	WebElement requestButton;
	
	@FindBy(xpath="//input[@id='ctl00_phBody_RequestBook_txtISBN']")
	WebElement ISBN;
	
	@FindBy(xpath="//input[@id='ctl00_phBody_RequestBook_txtTitle']")
	WebElement Title;
	
	@FindBy(xpath="//input[@id='ctl00_phBody_RequestBook_txtAuthor']")
	WebElement author;
	
	@FindBy(xpath="//*[@id='ctl00_phBody_RequestBook_txtPhone']")
	WebElement phone;
	
	@FindBy(xpath="//input[@id='ctl00_phBody_RequestBook_txtQty']")
	WebElement quantity;

	@FindBy(xpath="//input[@id='ctl00_phBody_RequestBook_imgbtnSave']")
	WebElement Submitbtn;
	
	
	
    //@FindBy(xpath="//input[@id='ctl00_phBody_RequestBook_txtEmailReq']")
    //WebElement mail;
	
    /*@FindBy(xpath="//input[@id='ctl00_phBody_RequestBook_btnVeiry']")
    WebElement verify;*/
	@FindBy(xpath="//label[@id='ctl00_phBody_RequestBook_lblsuccessmsg']")
	WebElement message;

	public RequestABookPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	public void navigateToURL(String url) {
		driver.get(url);
	}

	
	
	
	public void MyAccount() {
		myaccount.click();

	}
	public void EnterEmail(String userEmail) {
		email.sendKeys(userEmail);
	}

	public void EnterPassword(String userPassword) {
		password.sendKeys(userPassword);
	}

	public void ClickOnLoginButton() {
		loginButton.click();
	}
	
		

		
		public void click_RequestBook() {		
	    	requestButton.click();
	        
	    }
		public void enter_details(CharSequence isbn, String bookTitle, String Author, String Phone) throws InterruptedException {
			ISBN.sendKeys(isbn);
			Thread.sleep(1000);
			
			Title.sendKeys(bookTitle);
			Thread.sleep(1000);
		
			author.sendKeys(Author);
			Thread.sleep(1000);
			/*mail.sendKeys(Id);
			Thread.sleep(1000);*/
			phone.sendKeys(Phone);
			Thread.sleep(1000);
		}
		
		/*public void click_verify() {
			verify.click();
		}*/
		
		
		public void click_submit() {
			Submitbtn.click();
		}
		
		public String get_message() {
			return message.getText();
		}
        @After()
		public static void teardown(Scenario scenario) {
		if (scenario.isFailed()) {
            // Capture screenshot on test case failure
            try {
                File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String screenshotPath = "failure" +"_"+System.currentTimeMillis() + ".png";
                FileUtils.copyFile(screenshotFile, new File("./Screenshot/"+screenshotPath));
                System.out.println("Screenshot captured: " + screenshotPath);

                // Embed screenshot in the extent report
                byte[] screenshotBytes = FileUtils.readFileToByteArray(screenshotFile);
                scenario.attach(screenshotBytes, "image/png", "Failure Screenshot");


            } catch (IOException e) {
                e.printStackTrace();
            }
        }

		
					
		}
}
