package util_1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
//import java.util.Date;
//import java.util.logging.LogManager;

import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
//import tstng.Project_3.Logtestng;

public class Commos {
	public WebDriver driver;
	String ud=System.getProperty("user.dir");
	public ExtentReports extent = new ExtentReports();
	public ExtentSparkReporter spark = new ExtentSparkReporter("result/"+System.currentTimeMillis() +"youcef.html");
	public Logger log=org.apache.logging.log4j.LogManager.getLogger(Commos.class);
	public ExtentTest test;
	
	
	
	

	
	
	
	 public  void IBrowser (String browser, String url) throws InterruptedException { 
			
	  		if (browser.equalsIgnoreCase("chrome")) {
	  		WebDriverManager.chromedriver().setup();
	  		log.info("lanching the driver");
		    driver=new ChromeDriver(); 
		    //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		    driver.manage().window().maximize();
		    log.info("maximizing the window");
		    Thread.sleep(3000);
		   
	  		}
		    else if (browser.equalsIgnoreCase("edge")) {
		    WebDriverManager.edgedriver().setup();
		    log.info("lanching the driver");
		    driver=new EdgeDriver(); 
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		    driver.manage().window().maximize();
		    log.info("maximizing the window");
		    Thread.sleep(3000);
		  
		    }
	 }
	 
	 public  void Screenshot(String foldername) throws IOException {
			
		  
			File HomepageSS=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File destinationpath=new File(ud+"\\Pictures\\"+foldername+"\\"+System.currentTimeMillis()+"home.jpg");
			try {
			org.openqa.selenium.io.FileHandler.copy(HomepageSS,destinationpath);
			}catch (IOException e) {
			e.printStackTrace();
			}
		 }
	 
	  
	  		 public String Captureforss (String foldername) throws IOException {
					
				  
					File HomepageSS=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					File destinationpath=new File(ud+"\\Pictures\\"+foldername+"\\"+System.currentTimeMillis()+"home.jpg");
					try {
					org.openqa.selenium.io.FileHandler.copy(HomepageSS,destinationpath);
					}catch (IOException e) {
					e.printStackTrace();
					}
					String absolutepathe=destinationpath.getAbsolutePath();
					return absolutepathe;
				 }
	  		 
	  		 public void teardown() {
	  			 driver.close();
	  		 } 
	  		
		 
	 public void waitfortitle (String pagetitle) {
		  WebDriverWait wait=new WebDriverWait(driver, Duration.ofHours(1));
		  wait.until(ExpectedConditions.titleContains(pagetitle));
	}
	 public void implicitywait() {
		  WebDriverWait waits=new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	 public void waitfortitle(String pagetitle, WebDriver driver) {
		 WebDriverWait wait=new WebDriverWait(driver, Duration.ofHours(1));
		 wait.until(ExpectedConditions.titleContains(pagetitle));
	 }
	public void waitforclickable(WebElement element, WebDriver driver) {
		  //WebElement bests=driver.findElement(By.linkText("Best Sellers"));
		  WebDriverWait wait=new WebDriverWait(driver, Duration.ofHours(1));
		  wait.until(ExpectedConditions.elementToBeClickable(element));	
	}
	public void implicitywaitt(WebDriver driver) {
		 WebDriverWait waits=new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	public void configurationreport () {
		extent.attachReporter(spark);
		extent.setSystemInfo("machine", "pc1");
		extent.setSystemInfo("Os", "windows");
		extent.setSystemInfo("browser", "chrome");
		extent.setSystemInfo("username", "youcef");
		
		//look change:
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("youcef report");
	}	
	
	
	
	
	}