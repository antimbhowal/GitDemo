package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base{
	
	public static Logger log=LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	
	public void intialize() throws IOException
	{
		driver=initializeDriver();
		
	}
	
	@Test(dataProvider="getData")
	
	public void basePageNavigation(String Username, String Password, String text) throws IOException
	{
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		LandingPage l=new LandingPage(driver);
		l.getLogin().click();
		
		LoginPage lp=new LoginPage(driver);
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		lp.getLogin().click();
		log.info(text);
		
	}
	
	@DataProvider
	
	public Object[][] getData()
	{
		Object[][] data=new Object[2][3];
		data[0][0]="nonrestricteduser@gmail.com";
		data[0][1]="123456";
		data[0][2]="non-restricteduser";
		
		
		data[1][0]="restricteduser@gmail.com";
		data[1][1]="123456";
		data[1][2]="restricteduser";
		
		
		return data;
	}
	
	@AfterTest
	
	public void teardown()
	{
		driver.close();
		driver=null;
	}

}
