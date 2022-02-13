package pageObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class facebook {
public static ChromeDriver driver ;
	

	
	
	static By email = By.id("email");
	static By pass = By.id("pass");
	static By login = By.name("login");
//	static By loggedIn = By.xpath("//*[@class='thodolrn ojvp67qx taijpn5t buofh1pr j83agx80 aovydwv3 bqdfd6uv']");
	static By loggedIn = By.xpath("//*[@class='d2edcug0 hpfvmrgz qv66sw1b c1et5uql oi732d6d ik7dh3pa ht8s03o8 a8c37x1j fe6kdd0r mau55g9w c8b282yb keod5gw0 nxhoafnm aigsh9s9 ns63r2gh hrzyx87i o0t2es00 f530mmz5 hnhda86s oo9gr5id']");
	@BeforeMethod
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "//Users//usamametwally//Downloads//chromedriver");
		 driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
	}
	
	@DataProvider(name="TestData")
	public Object [][] getData() throws InterruptedException{
		Object [][] data = null;
		data = ReadfromCSV() ;

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
	
	public static String[][] ReadfromCSV() throws InterruptedException {

	    String[] data= null;
	    String returnObj[][] = null; 
	    
	    String csvFile = "/Users/usamametwally/Downloads/TestData - Copy.csv";
	            
	    BufferedReader br = null;
	    String line = "";
	    String cvsSplitBy = ",";
	    ArrayList<String> content = new ArrayList<String>();

	    try {

	        br = new BufferedReader(new FileReader(csvFile));
	        int datalength = 0;
	        int listsize =0;;
	        
	        while ((line = br.readLine()) != null) {
	            content.add(line);
	        }
	        
	        listsize = content.size();
	        datalength = content.get(0).split(cvsSplitBy).length;
	        returnObj = new String[listsize][datalength];
	        
	        for (int i = 0; i<listsize; i++) {
	            
	            data = content.get(i).split(cvsSplitBy);
	            for (int j=0; j< datalength ; j++) {
	                returnObj[i][j] = data[j];
	                
	            }
	            
	        }
	        

	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        if (br != null) {
	            try {
	                br.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    return returnObj;

	}


}
