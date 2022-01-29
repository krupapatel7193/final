package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class BaseClass {
	public static  WebDriver driver=null;;
	public static Properties pro;
	@BeforeSuite
	public static void Initialize() throws IOException{
		
		//load the property file 
		if(driver==null) {
	 pro = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
		pro.load(fis);
		String BrowserName = pro.getProperty("browser");
		String TestingUrl = pro.getProperty("url");
		
		if(BrowserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(BrowserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+ "src\\test\\resources\\executables\\IEDriverServer.exe");
			driver = new ChromeDriver();
		}
		else if(BrowserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ "C:\\Users\\krupap\\cucumber-work\\final\\src\\test\\resources\\executables\\geckodriver.exe");
			driver = new ChromeDriver();
			
		}
		driver.get(TestingUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		}
		
		
	}
	
	@AfterSuite
	public void tearDown() {
		if(driver!=null) {
			driver.close();
		}
	}
	
}