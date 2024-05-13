package praticespakage;

import java.io.File;
import java.sql.DriverManager;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Samplereportest {
	ExtentReports report;
	@BeforeSuite
	public void configbs()
	{
		ExtentSparkReporter spark=new ExtentSparkReporter("./Advancereport/report.html");
		spark.config().setDocumentTitle("crm test suite name");
		spark.config().setReportName("crm report");
		spark.config().setTheme(Theme.DARK);
		
	 report=new ExtentReports();
	report.attachReporter(spark);
	report.setSystemInfo("os", "windows -10");
	report.setSystemInfo("browser", "chrome");
	}
	@AfterSuite
	public void configas()
	{
		report.flush();
	}
	
	
@Test
public void creatreporttest()
{
	
ExtentTest test = report.createTest("creatreporttest");
	
	
	test.log(Status.INFO,"login to app");
	test.log(Status.INFO,"navigate to contact page");
	test.log(Status.INFO,"create contact");
	if("HDFC".equals("HDFC"))
	{
		test.log(Status.PASS,"contact is create ");
	}
	else
	{
		test.log(Status.FAIL,"contact is not create");
	}
	
}
@Test
public void creatreportorgtest()
{
	
ExtentTest test = report.createTest("creatreporttest");
	
	
	test.log(Status.INFO,"login to app");
	test.log(Status.INFO,"navigate to contact page");
	test.log(Status.INFO,"create contact");
	if("HDFC".equals("HDFC"))
	{
		test.log(Status.PASS,"contact is create ");
	}
	else
	{
		test.log(Status.FAIL,"contact is not create");
	}
	
}
@Test
public void creatreportphonenumbertest()
{
	WebDriver driver=new ChromeDriver();
	WebDriverManager.chromedriver().setup();
	driver.get("http://localhost:8888");
	TakesScreenshot edriver=(TakesScreenshot)driver;
	 String file = edriver.getScreenshotAs(OutputType.BASE64);
	
	
	
ExtentTest test = report.createTest("creatreporttest");
	test.log(Status.INFO,"login to app");
	test.log(Status.INFO,"navigate to contact page");
	test.log(Status.INFO,"create contact");
	if("HDFC".equals("HDFC"))
	{
		test.log(Status.PASS,"contact is create ");
	}
	else
	{
		test.addScreenCaptureFromBase64String(file, "error file");
	}
	driver.close();

	
}
}
