package base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	
	public static FileReader fr ;
	public static FileReader fr1 ;
	
	@BeforeTest
	public void setUp() throws IOException{
		if(driver==null){
			
			 fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
			fr1 = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\locators.properties");
			prop.load(fr);
			loc.load(fr1);
		}
	if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
	
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();//base
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("testurl");
	}else if(prop.getProperty("browser").equalsIgnoreCase("firefox")){
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("testurl");
		
		
	}else if(prop.getProperty("browser").equalsIgnoreCase("edge")){
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("testurl");
		
		
	}
	}
	
	
	@AfterTest
	public void tearDown(){
		driver.close();
		System.out.println("driver closed");
		
	}

}
