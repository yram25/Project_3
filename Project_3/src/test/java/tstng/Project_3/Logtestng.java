package tstng.Project_3;

import java.io.IOException;
//import java.sql.Driver;
//import java.time.Duration;
//import java.util.logging.LogManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

//import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
//import com.sun.tools.sjavac.Log;

//import io.github.bonigarcia.wdm.WebDriverManager;
import util_1.utilities;

public class Logtestng extends utilities{
	
	
 
  @Test
  public void verify_homepage()throws InterruptedException, IOException{
	  test=extent.createTest("verify_homepage").assignAuthor("ucef").assignCategory("smoke").assignDevice("windows");
	  //log.info("browser launching");
	 // driver=new ChromeDriver();
	 // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  //log.info("browser maximizing");
	  driver.manage().window().maximize();
	  driver.get("https://www.google.com");
	  String expectedtitle="google";
	 // log.info("title is collected");
	  String actualtitle=driver.getTitle();
	  if(actualtitle.equalsIgnoreCase(expectedtitle)) {
		  log.info("title is matched");
		  test.log(Status.PASS, MarkupHelper.createLabel("verify title", ExtentColor.GREEN));
	  }
	  else {
		  log.info("title verified is failed","expected="+expectedtitle+"but found="+actualtitle);
		  test.log(Status.FAIL, MarkupHelper.createLabel("verify title", ExtentColor.RED));
		  test.addScreenCaptureFromPath(Captureforss("failed"), "verify title");
	  }
  }  
			/*
			 * try {
			 * 
			 * } catch (IOException e) { // TODO Auto-generated catch block
			 * e.printStackTrace();
			 */
		//}
	//  test=extent.createTest("verify_homepage");
	//  log.info("browser launching");
 
  
  @Test
  public void login() {
	  test=extent.createTest("login features").assignAuthor("meriem").assignCategory("sanity").assignDevice("windows");
	  log.info("login execution start");
	  WebElement searchfield= driver.findElement(By.xpath("//textarea[@aria-label='Search']"));
	  searchfield.click();
	  searchfield.sendKeys("computer");
	    }
  
  
 
}
