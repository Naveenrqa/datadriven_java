package com.ac.base;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class Testbase
{

	public  static WebDriver driver;

	public static Properties Config = new Properties();

	public static Properties OR = new Properties();

	public static FileInputStream fis;

	@BeforeSuite
	public void setup() throws IOException
	{

		if(driver!=null)
		 {
			  FileInputStream fis = new FileInputStream("C:\\Users\\user\\eclipse-workspace\\datadrivenproject\\src\\test\\resources\\properties\\Config.properties");

				Config.load(fis);

		       FileInputStream fis1 = new FileInputStream("C:\\Users\\user\\eclipse-workspace\\datadrivenproject\\src\\test\\resources\\properties\\OR.properties");

		       OR.load(fis1);

				if(Config.getProperty("browser").equals("firefox"))
				{
					System.setProperty("webdriver.firefox.driver", System.getProperty("C:\\Users\\user\\eclipse-workspace\\datadrivenproject\\src\\test\\resources\\executables\\geckodriver.exe"));
					driver = new FirefoxDriver();
				}
				else if(Config.getProperty("browser").equals("chrome"))
				{
					System.setProperty("webdriver.Chrome.driver", System.getProperty("C:\\Users\\user\\eclipse-workspace\\datadrivenproject\\src\\test\\resources\\executables\\Chrome.exe"));
					driver = new ChromeDriver();
				}
				else if(Config.getProperty("browser").equals("IEDriverserver"))
				{
					System.setProperty("webdriver.IEDriverserver..driver", System.getProperty("C:\\Users\\user\\eclipse-workspace\\datadrivenproject\\src\\test\\resources\\executables\\IEDriverServer.exe"));
					driver = new InternetExplorerDriver();
				}
				driver.get(Config.getProperty("testurl"));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Integer.parseInt(System.getProperty("implicit.wait")), TimeUnit.SECONDS);
		 }
	}
	@AfterSuite
	public void teardown()
	{
		driver.quit();
	}

}

