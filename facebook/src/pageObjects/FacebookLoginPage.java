package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FacebookLoginPage {

	 public static ChromeDriver driver ;
	

	
	static By createNewAccount = By.id("u_0_2_Mq");
	static By firstname = By.name("firstname");
	static By sureName = By.name("lastname");
	static By mobile = By.name("reg_email__");
	static By password = By.id("password_step_input");
	static By day = By.id("Day");
	static By month = By.id("Month");
	static By year = By.id("Year");
	static By male = By.id("u_a_3_dh");
	static By email = By.id("email");
	static By pass = By.id("pass");
	static By login = By.name("login");
	
	@BeforeMethod
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/macbookpro/Downloads/chromedriver");
		 driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
	}
	
	@DataProvider(name="TestData")
	public Object [][] getData(){
		Object [][] data = new Object[1][2];
		data[0][0] = "Please enter user name to login with";		
		data[0][1] = "Enter password of the user to login with ";

		return data;
				}
	
	
	@Test(dataProvider = "TestData")
	public  void login(String userName , String password) throws InterruptedException {
		

		
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys(userName);
		driver.findElement(pass).clear();
		driver.findElement(pass).sendKeys(password);	
		driver.findElement(login).click();
		driver.wait(50000);
		
	}
	
	@AfterClass
	public void closeDriver() {
		driver.quit();
	}
}
