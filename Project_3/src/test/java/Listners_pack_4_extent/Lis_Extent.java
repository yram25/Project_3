package Listners_pack_4_extent;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import util_1.utilities;

public class Lis_Extent extends utilities implements ITestListener {
	
	
	@Override
	public void onStart(ITestContext context) {
		//as in before-test
		log.info("on start listner, extent report configuration done");
		configurationreport();
	}

	@Override
	public void onFinish(ITestContext context) {
		//as in after-test
		log.info("on finish  listner, extent report configuration done");
		extent.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		 log.info("on test start, now executing:" +result.getName()); //test-method
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		this.driver=((utilities)result.getInstance()).driver;
		test=extent.createTest(result.getName());
		test.log(Status.PASS,MarkupHelper.createLabel("name of the pass method:"+result.getName(), ExtentColor.GREEN));
		try {
			test.addScreenCaptureFromPath(Captureforss("Allsuccess"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		this.driver=((utilities)result.getInstance()).driver;
		test=extent.createTest(result.getName());
		test.log(Status.SKIP,MarkupHelper.createLabel("name of the fail method:"+result.getName(), ExtentColor.YELLOW));
		try {
			test.addScreenCaptureFromPath(Captureforss("Allfail"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	

}
