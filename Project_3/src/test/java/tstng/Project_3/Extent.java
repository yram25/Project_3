package tstng.Project_3;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.sun.tools.sjavac.Log;

//import jdk.internal.org.jline.utils.Log;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Extent {
	ExtentReports extent = new ExtentReports();
	  ExtentSparkReporter spark = new ExtentSparkReporter("result/"+System.currentTimeMillis() +"youcef.html");//
  @Test
  public void navigate_to_homepage() {
	  ExtentTest test=extent.createTest("launch browser").assignAuthor("youcef").assignCategory("smoke").assignDevice("windows");
	// Log.info("navigate to home page");
	  //to go to the url
	  test.info("user successfully land on homepage");
	  //to validate page title:
	  test.pass("page title pass");
	  
  }
  @Test
  public void test1() {
	  ExtentTest test=extent.createTest("login fucnctionality").assignAuthor("ahmed").assignCategory("regression").assignDevice("mac");
	  //go to login page
	  //click on login field and type email and password
	  //click on login btn
	  //wait for alert
	  //verify login successfully 
	  test.pass("user successfully logged in ");
	  
  }
  @Test
  public void test2() {
	  ExtentTest test=extent.createTest("registration").assignAuthor("merime").assignCategory("sanity").assignDevice("linux");
	  
	  test.fail("user successfully logged in ");
	  
  }
  @BeforeTest
  public void beforeTest() {
	  
	 extent.attachReporter(spark);

  }

  @AfterTest
  public void afterTest() {
	  extent.flush();
  }

}
