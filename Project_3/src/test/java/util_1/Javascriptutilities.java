package util_1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.devtools.v120.browser.Browser;
import org.openqa.selenium.edge.EdgeDriver;
//import org.testng.internal.AbstractParallelWorker.Arguments;

public class Javascriptutilities {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		IBrowser("chrome","https://www.ebay.com/");
		Thread.sleep(3000);
		WebElement motor=driver.findElement(By.linkText("Motors"));
		flash(motor, driver);
	}
	
	public static void IBrowser(String browser ,String website) throws InterruptedException {
		
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("Webdriver.chrome.driver","C:\\Users\\joseph\\eclipse-workspace\\YoucefProject\\Project_testNg\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			Thread.sleep(2000);
			driver.get(website);
		}
		else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("Webdriver.edge.driver","C:\\Users\\joseph\\eclipse-workspace\\YoucefProject\\Project_testNg\\Drivers\\msedgedriver.exe");
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			Thread.sleep(2000);
			driver.get(website);
		}
	}
	
	public static void scrollintoview(WebDriver driver, WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeAsyncScript("arguments[0].scrollintoView(true);", element);
	}
	
	public static void scrolldown(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeAsyncScript("window.scrorllTo(0,document.body.scrollHeight)");
	}
	
	public static void changecolor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeAsyncScript("arguments[0].style.backgroundColor='"+color+"'", element);
		try {
			Thread.sleep(2000);
		}
		catch(Exception e) {
			e.printStackTrace();
			}
	}
	public static void flash(WebElement element, WebDriver driver) {
		String bgcolor=element.getCssValue("backgroundColor");
		System.out.println(bgcolor);
		for(int i=0;i<30;i++) {
			changecolor(bgcolor, element, driver);
		}
	}
	
	public static void draw (WebElement element, WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeAsyncScript("arguments[0].style.border='3px solid red'", element);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
