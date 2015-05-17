/*
Bryan Cutkevin
Perfect World Automation Script Code Example

	This is a script that I wrote using Selenium Webdriver, Java, and TestNG. It performs the automated testing: 
	     -Loading the Perfect World Home page
*/

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import org.testng.Assert;
import org.testng.annotations.*;

public class PerfectWorldDemo
{
     public Properties OR = null;	
     
     @BeforeClass
     public void setUp() throws InterruptedException
     {
          
		  //load created Firefox profile
		  ProfilesIni allProfiles = new ProfilesIni();
		  FirefoxProfile profile = allProfiles.getProfile("PerfectWorldDemo");
		  profile.setAcceptUntrustedCertificates(true);
		  profile.setAssumeUntrustedCertificateIssuer(false);			
		  		  
		  //using Firefox driver
		  WebDriver driver = new FirefoxDriver(profile);		  
		  
		  driver.get("http://www.perfectworld.com/");	
		  driver.manage().window().maximize();		 
		  Thread.sleep(3000L);
		  
		  //set default timeout; if exceeds 10000ms, throw error for page timeout
		  driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);		
     }
	 
	 @Test
	 public void testClickRegisterLoginLink()
	 {
		  //click Registration/Login link
		  driver.findElement(By.xpath(OR.getProperty("registerLoginLink"))).click();
		  Thread.sleep(3000L);
	 }
		 
	 //Pt. 1 - create a new account 	  	 	  		  	
	 @Test
	 public void testClickRegisterNowButton()
	 {	
		  //click the "Register Now" button
		  driver.findElement(By.xpath(OR.getProperty("registerNowButton"))).click(); 	  
		  Thread.sleep(3000L);
	 }	  		  
	
	 @Test
	 public void testEnterUsernameField()
	 {
	      //create a User name
		  driver.findElement(By.xpath(OR.getProperty("userNameField"))).sendKeys("testname710138"); 	  
		  Thread.sleep(3000L);
	 }
	 

	 @Test
	 public void testClickEnterFourmField()
	 {
		  //create a Forum name
		  driver.findElement(By.xpath(OR.getProperty("forumNameField"))).sendKeys("testname71013fm8"); 	  
		  Thread.sleep(3000L);
	 }		  
	 
	 @Test
	 public void testEnterEmailAddressField()
	 {
		  //create Email Address
		  driver.findElement(By.xpath(OR.getProperty("emailAddressField"))).sendKeys("tstemail0710138@yahoo.com"); 	  
		  Thread.sleep(3000L);
	 }
		  
	 @Test
	 public void testEnterConfirmEmailAddressField()
	 {	  
		  //create Confirm Email Address
		  driver.findElement(By.xpath(OR.getProperty("confirmEmailAddressField"))).sendKeys("tstemail0710138@yahoo.com"); 	  
		  Thread.sleep(3000L);
	 }
		  
	 @Test
	 public void testEnterPasswordField()
	 {
		  //create Password
		  driver.findElement(By.xpath(OR.getProperty("passwordField"))).sendKeys("password1234"); 	  
		  Thread.sleep(3000L);
	 }
	 
	 @Test
	 public void testEnterConfirmPasswordField()
	 {
		  //create confirm Password
		  driver.findElement(By.xpath(OR.getProperty("confirmPasswordField"))).sendKeys("password1234"); 	  
		  Thread.sleep(3000L);
	 }
		  		  
	 @Test
	 public void testClickCreateAccountButton()
	 {	  
 		  //click Create Account Button
		  driver.findElement(By.xpath(OR.getProperty("createAccountButton"))).click(); 	  
		  Thread.sleep(5000L);
	 }
	 
	 //Pt. 2 Verify/Register page
	 @Test
	 public void testVerifyUsernameAppears()
	 {		
		  //verify created username appears
		  String testUserNameAppears = new String( "testname710137" );
	        if(  driver.findElement(By.xpath(OR.getProperty("verifyUserNameAppears"))).equals(testUserNameAppears))
	        {
	          System.out.println("Username successfully created");
	        }
	        else
	        {
	           System.out.println("Username was not successfully created");
	        }
	 }
	  
	 @Test
	 public void testVerifyEmailAppears()
  	 {
          //verify created email appears
		  String testEmailAddressAppears = new String( "tstemail0710137@yahoo.com" );
	        if(  driver.findElement(By.xpath(OR.getProperty("verifyEmailAppears"))).equals(testEmailAddressAppears))
	        {
	          System.out.println("email successfully created");
	        }
	        else
	        {
	           System.out.println("email was not successfully created");
	        }
  	 }
	  	 
	 @Test
	 public void testClickAccountVerifyButton()
	 {
	      //Click create Account button
	      driver.findElement(By.xpath(OR.getProperty("createAccountVerifyButton"))).click(); 	  
		  Thread.sleep(5000L);
	 }
		
	 //Pt.3 Email sent/Registration Page
	 @Test
	 public void testVerifyEmailSentMessageAppears()
	 {		  
		  //verify Email sent text appears
		  String testEmailSentTextAppears = new String( "Congratulations, your Perfect World account is almost ready for use! We have sent an email to the address you provided, and it should arrive shortly.");
	        if(  driver.findElement(By.xpath(OR.getProperty("emailSentPrompt"))).equals(testEmailSentTextAppears ))
	        {
	          System.out.println("Email sent message successfully appeared");
	        }
	        else
	        {
	           System.out.println("Email sent message did not successfully appear");
	        }
	 }
	
	 @AfterClass
	 public void closeBrowserWindow()
	 {
		 //driver.quit();
	 }
}
