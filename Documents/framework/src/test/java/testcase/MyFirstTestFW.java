package testcase;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadXLSdata;

public class MyFirstTestFW extends BaseTest{
	@Test(dataProviderClass=ReadXLSdata.class,dataProvider="testdata")
	public static void LoginTest(String username , String password){
		driver.manage().window().maximize();
		driver.get("https://www.zoho.com/");//properties
		driver.findElement(By.linkText(loc.getProperty("signin_link"))).click(); //locators-properties
		driver.findElement(By.id(loc.getProperty("email_feild"))).sendKeys(username);
		driver.findElement(By.xpath(loc.getProperty("nxt_button"))).click();
		driver.findElement(By.xpath(loc.getProperty("password_feild"))).sendKeys(password);
		driver.findElement(By.xpath(loc.getProperty("submit_button"))).click();
		
		
		
	}
	//@DataProvider(name="testdata")
	//public Object[][] test(){
		//return new Object[][] {
			//{"sushma@gmail.com","sush"},
			//{"susgtrty@gmail.com","gyyh"},
			//{"susgtty@gmail.com","gyyhb"},
			//{"sushma.b@hcl.com","Asiangirl@123"}
		//};
	//}

}
