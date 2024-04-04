package util_1;

//import org.testng.annotations.Test;

//import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

//import java.io.File;
import java.io.IOException;
//import java.util.Date;
//import java.util.logging.FileHandler;

//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
//import org.openqa.selenium.io.*;
public class utilities extends Commos {
	
	 @BeforeTest
	  public void beforeTest() {
		  //configurationreport();
		log.info("before-test start");

	  }

	  @AfterTest
	  public void afterTest() {
		  //extent.flush();
		  log.info("after-test start");
	  }

	            
	
	@Parameters({"browser", "website"})
	@BeforeClass
	  public  void beforeClass(String browser,String website) throws InterruptedException { 
			IBrowser (browser,website); 
			
	 }
	 
	@AfterClass
	  public void afterClass() throws IOException{
		 log.info("window going to close");
		 teardown();
		 }
	
	
	 
	
	 

}





	
 

	
